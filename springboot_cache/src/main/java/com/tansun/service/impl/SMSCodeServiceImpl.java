package com.tansun.service.impl;

import com.tansun.Utils.CodeUtil;
import com.tansun.pojo.SMSCode;
import com.tansun.service.SMSCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * program: java_daily
 * Created with IntelliJ IDEA.
 * Description:
 * User: mwt
 * Date: 2022/8/4 16:11
 */
@Service
public class SMSCodeServiceImpl implements SMSCodeService {
    @Autowired
    private CodeUtil codeUtil;
    @Override
//    @Cacheable(value = "sms",key = "#Tel")
    @CachePut(value = "sms",key = "#Tel")
    public String SendToTel(String Tel) {
        String code = codeUtil.GenernateCode(Tel);
        System.out.println("code = " + code);
        return code;
    }

    @Override
    public Boolean CheckCode(SMSCode smsCode) {
        return null;
    }


}
