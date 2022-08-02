package com.tansun.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tansun.pojo.Student;

/**
 * program: ssm_boot
 * Created with IntelliJ IDEA.
 * Description:
 * User: mwt
 * Date: 2022/7/28 10:40
 */
public interface IStuService extends IService<Student> {
    IPage<Student> getPage(Integer current, Integer Size);
}
