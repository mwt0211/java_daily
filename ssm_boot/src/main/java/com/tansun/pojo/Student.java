package com.tansun.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("student")
public class Student {
    @TableField(value = "id")
    private Integer id;
    @TableField(value = "name")
    private String name;
    @TableField(value = "age")
    private Integer age;
    @TableField(value = "sex")
    private String sex;
    @TableField(value = "address")
    private String address;
    @TableField(value = "math")
    private Integer math;
    @TableField(value = "english")
    private Integer english;
}
