package com.tansun.Controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tansun.pojo.Student;
import com.tansun.service.IStuService;
import com.tansun.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * program: ssm_boot
 * Created with IntelliJ IDEA.
 * Description:
 * User: mwt
 * Date: 2022/7/28 10:12
 */
@RestController
@RequestMapping("/Stu")
@Slf4j
public class StuController {
    @Autowired
    private IStuService iStuService;
    //开启日志追加
 // private static final Logger log=  LoggerFactory.getLogger(StuController.class);
    //查询所有
    @GetMapping("/all")
    public Response getAll() {
        List<Student> list = iStuService.list();
        Response response = new Response();
//     模拟异常:
//        if(true)throw new RuntimeException();
        if(!StringUtils.isEmpty(list)){
            response.setFlag(true);
            response.setData(list);
        }
        return response;

    }

    //根据ID查询
    @GetMapping("/{id}")
    public Response getById(@PathVariable Integer id) {
        Student student = iStuService.getById(id);
        Response response = new Response();
        if(!StringUtils.isEmpty(student)){
            response.setFlag(true);
            response.setData(student);
            System.out.println("response = " + response);
            System.out.println("增加热部署");
            System.out.println("增加热部署");
//            try {
//                //模拟异常
//                int i=    1/0;
//            } catch (Exception e) {
//                e.printStackTrace();
//                log.info("info",e);
//            }
            log.info("调用出错",response.getMsg());
        }
        return response;
    }

    //添加记录
    @PostMapping("/insert")
    public Response insert(@RequestBody Student student) {
        Response response = new Response();
        boolean save = iStuService.save(student);
        response.setFlag(save);
        response.setData(student);
        return response;
    }

    //根据ID删除
    @DeleteMapping("{id}")
    public Response delete(@PathVariable Integer id) {
        Response response = new Response(iStuService.removeById(id));

        return response;
    }

    //分页查询
    @GetMapping("/page/{currentPage}/{Size}")
    public Response getPage(@PathVariable Integer currentPage, @PathVariable Integer Size) {
        IPage<Student> page = iStuService.getPage(currentPage, Size);
        //避免出现currrentPage和Size出现不合理的数据
        //如果当前页码值大于最大页码值,则将页码最大值赋给当前页码
        if(currentPage > page.getPages()){
            page = iStuService.getPage((int)page.getPages(), Size);
            System.out.println("currentPage = " + currentPage);
        }
        if(currentPage<1){
            page = iStuService.getPage(1, Size);
        }

        Response response = new Response();
        if(!StringUtils.isEmpty(page)){
            response.setFlag(true);
            response.setData(page);
        }
        return response;
    }
}
