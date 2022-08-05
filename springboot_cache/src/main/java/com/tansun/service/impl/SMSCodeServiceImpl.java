package com.tansun.service.impl;

import com.tansun.Utils.CodeUtil;
import com.tansun.pojo.SMSCode;
import com.tansun.service.SMSCodeService;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

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



  /*  @Override
//    @Cacheable(value = "sms",key = "#Tel")
    @CachePut(value = "sms", key = "#Tel")
    public String SendToTel(String Tel) {
        String code = codeUtil.GenernateCode(Tel);
        System.out.println("code = " + code);
        return code;
    }

    @Override
    public Boolean CheckCode(SMSCode smsCode) {
        String code = smsCode.getCheckCode();
        String cacheCode = codeUtil.GetCacheCode(smsCode.getPhoneNumber());

        return code.equals(cacheCode);
    }*/

@Autowired
private MemcachedClient memcachedClient;
  //以下为SpringBoot整合Memcached的部分
  @Override
  public String SendToTel(String Tel) {
      String code = codeUtil.GenernateCode(Tel);
      try {
          memcachedClient.set(Tel,0,code);
      } catch (Exception e) {
          e.printStackTrace();
      }
      return code;
  }

    @Override
    public Boolean CheckCode(SMSCode smsCode) {
        String code = null;
        try {
            code = memcachedClient.get(smsCode.getPhoneNumber()).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return smsCode.getCheckCode().equals(code);
    }



}
