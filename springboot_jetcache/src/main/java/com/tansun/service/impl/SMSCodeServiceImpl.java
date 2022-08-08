package com.tansun.service.impl;


import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.tansun.CodeUtil.CodeUtil;
import com.tansun.pojo.SMSCode;
import com.tansun.service.SMSCodeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

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
    @CreateCache(name = "jetcache_", expire = 20, timeUnit = TimeUnit.SECONDS,cacheType = CacheType.REMOTE)
    private Cache<String, String> Remotejetchche;
    @CreateCache(area = "sms",name = "jetcache_", expire = 10, timeUnit = TimeUnit.SECONDS)
    private Cache<String, String> Remotejetchche2;
    @CreateCache(name = "jetcache_", expire = 20, timeUnit = TimeUnit.SECONDS,cacheType = CacheType.LOCAL)
    private Cache<String, String> Localjetchche;
    @Override
    public String SendToTel(String Tel) {
        String CacheCode = codeUtil.GenernateCode(Tel);
        Localjetchche.put(Tel, CacheCode);
        return CacheCode;
    }

    @Override
    public Boolean CheckCode(SMSCode smsCode) {
        String code = Localjetchche.get(smsCode.getPhoneNumber());
        return smsCode.getCheckCode().equals(code);

    }
}
