package com.tansun.serviceTest;

import com.tansun.service.IStuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * program: ssm_boot
 * Created with IntelliJ IDEA.
 * Description:
 * User: mwt
 * Date: 2022/7/28 10:45
 */
@SpringBootTest
public class IServiceTest {
    @Autowired
    private IStuService iStuService;
    @Test
    void testgetById(){
        iStuService.getById(4);

    }
}
