package com.tansun.pojo;
import lombok.Builder;
import lombok.Data;

/**
 * program: ssm_boot
 * Created with IntelliJ IDEA.
 * Description:
 * User: mwt
 * Date: 2022/7/27 15:41
 */
@Data
@Builder

public class Student {

    private Integer id;

    private String name;

    private Integer age;

    private String sex;

    private String address;

    private Integer math;

    private Integer english;
}
