package com.tansun.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * program: java_daily
 * Created with IntelliJ IDEA.
 * Description:
 * User: mwt
 * Date: 2022/8/4 16:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SMSCode implements Serializable {
//    @Size(min = 11,max = 11,message = "手机号必须为11位")
    private String phoneNumber;
    private String CheckCode;
}
