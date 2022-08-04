package com.tansun;

import com.alibaba.fastjson.JSON;
import com.tansun.dao.bookdao;
import com.tansun.pojo.Book;
import com.tansun.service.impl.IBookServiceimpl;

import org.apache.http.HttpHost;
import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;

import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.xcontent.XContentType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.client.RestClients;

import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.elasticsearch.client.indices.CreateIndexRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class SpringbootEsApplicationTests {
/*@Autowired
private ElasticsearchRestTemplate template;*/

//导入高级别的客户端
@Autowired
private com.tansun.dao.bookdao bookdao;
private static RestHighLevelClient client;

    @BeforeEach
    void setUp() {
        HttpHost host=HttpHost.create("http://localhost:9200");
        RestClientBuilder builder = RestClient.builder(host);
        client = new RestHighLevelClient(builder);
    }

    @AfterAll
    static void afterAll() throws IOException {
        client.close();
    }

    @Test
void testCreateESClient() throws IOException {
//1.创建HIGHLevelES客户端
    HttpHost host=HttpHost.create("http://localhost:9200");
    RestClientBuilder builder = RestClient.builder(host);
    client = new RestHighLevelClient(builder);
    client.close();

}
    @Test
    void testCreateESIndex() throws IOException {
        //创建索引
        CreateIndexRequest request=new CreateIndexRequest("book");
        //此处引用的包:import org.elasticsearch.client.indices.CreateIndexRequest;
        client.indices().create(request, RequestOptions.DEFAULT);
    }
    @Test
    //通过IK创建索引
    void testCreateESIndexByIk() throws IOException {
        //创建索引
        CreateIndexRequest request=new CreateIndexRequest("book");
        //设置请求中的参数
        String json="{\n" +
                "    \"mappings\":{\n" +
                "        \"properties\":{\n" +
                "            \"id\":{\n" +
                "                \"type\":\"keyword\"\n" +
                "            },\n" +
                "            \"name\":{\n" +
                "                \"type\":\"text\",\n" +
                "                \"analyzer\":\"ik_max_word\",\n" +
                "                \"copy_to\":\"all\"\n" +
                "            },\n" +
                "            \"description\":{\n" +
                "                 \"type\":\"text\",\n" +
                "                \"analyzer\":\"ik_max_word\",\n" +
                "                \"copy_to\":\"all\"\n" +
                "            },\n" +
                "            \"typeof\":{\n" +
                "                \"type\":\"keyword\"\n" +
                "            },\n" +
                "            \"all\":{\n" +
                "                     \"type\":\"text\",\n" +
                "                \"analyzer\":\"ik_max_word\"\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";
        request.source(json, XContentType.JSON);
        client.indices().create(request, RequestOptions.DEFAULT);
    }
    @Test
    //添加文档
    void tsetInsertDoc() throws IOException {
        Book book = bookdao.selectById(4);
        IndexRequest request=new IndexRequest("book").id(book.getId().toString());
        String bookjson= JSON.toJSONString(book);
        request.source(bookjson,XContentType.JSON);
        client.index(request,RequestOptions.DEFAULT);
    }
    @Test
    //批处理添加文档
    void testInsertAllDoc() throws IOException {
        List<Book> bookList = bookdao.selectList(null);
        BulkRequest bulkRequest=new BulkRequest();
        for (Book book : bookList) {
            IndexRequest request=new IndexRequest("book").id(book.getId().toString());

            String bookjson=JSON.toJSONString(book);
            request.source(bookjson,XContentType.JSON);
            bulkRequest.add(request);
        }
        client.bulk(bulkRequest,RequestOptions.DEFAULT);
    }
    @Test
    //按ID查询文档
    void TestQueryDocById() throws IOException {
        GetRequest request=new GetRequest("book","1");
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        System.out.println("response = " + response);
        //得到想要的具体数据
        String source = response.getSourceAsString();
        Book book = JSON.parseObject(source, Book.class);
        System.out.println("book = " + book);
    }
    @Test
    //查询所有
    void TestQueryDocGetAll() throws IOException {
        SearchRequest request=new SearchRequest("book");
        SearchResponse search = client.search(request, RequestOptions.DEFAULT);
        SearchHits hits = search.getHits();
        for (SearchHit hit : hits) {
            String source = hit.getSourceAsString();
//            System.out.println("hit.getSourceAsString() = " + hit.getSourceAsString());
            Book book = JSON.parseObject(source, Book.class);
            System.out.println("book = " + book);
        }
    }
    @Test
    //按条件查询
    void TestQueryByCondition() throws IOException {
        SearchRequest request=new SearchRequest("book");
        SearchSourceBuilder builder=new SearchSourceBuilder();
        builder.query(QueryBuilders.termQuery("name","Spring"));
        //此处引用的包:import org.elasticsearch.index.query.QueryBuilders;

        request.source(builder);
        SearchResponse search = client.search(request, RequestOptions.DEFAULT);
        SearchHits hits = search.getHits();
        for (SearchHit hit : hits) {
            String sourceAsString = hit.getSourceAsString();
            Book book = JSON.parseObject(sourceAsString, Book.class);
//            System.out.println("sourceAsString = " + sourceAsString);
            System.out.println("book = " + book);
        }


    }
    @Test
        //删除指定
    void TestDelByID() throws IOException {
        DeleteRequest request=new DeleteRequest("book","8");
        client.delete(request,RequestOptions.DEFAULT);
    }
    @Test
    void TestUpdateDoc() throws IOException {
        UpdateRequest request=new UpdateRequest("book","_doc","1");
        HashMap<String, Object> map = new HashMap<>();
        map.put("description","springboot1 非常好");
        map.put("name","七夕限定款");

        request.doc(map);
        client.update(request,RequestOptions.DEFAULT);
    }



}
