package com.tansun;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;

@SpringBootTest
class SpringBootRedisApplicationTests {
@Autowired
private RedisTemplate redisTemplate;

    @Test
    void set() {
        //Set类型
        SetOperations ops = redisTemplate.opsForSet();
        ops.add("name","李四");
        //String类型
        ValueOperations ops1 = redisTemplate.opsForValue();
        ops1.set("age",18);
        //Hash类型
        HashOperations ops2 = redisTemplate.opsForHash();
        ops2.put("group","java","初级工程师");
        ops2.put("group","java1","中级工程师");
        ops2.put("group","java2","高级工程师");
    }

    @Test
    void get() {

        ValueOperations ops1 = redisTemplate.opsForValue();
        System.out.println("ops1.get(\"age\") = " + ops1.get("age"));
        HashOperations ops = redisTemplate.opsForHash();
        Object o = ops.get("group", "java1");
        System.out.println("o = " + o);
    }

}
