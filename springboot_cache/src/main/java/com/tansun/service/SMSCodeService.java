package com.tansun.service;

import com.tansun.pojo.SMSCode;

/**
 * program: java_daily
 * Created with IntelliJ IDEA.
 * Description:
 * User: mwt
 * Date: 2022/8/4 16:10
 */
public interface SMSCodeService {
    public String SendToTel(String Tel);
    public Boolean CheckCode(SMSCode smsCode);
}
