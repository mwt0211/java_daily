package com.tansun.service.impl;

import com.tansun.service.MsgService;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * program: java_daily
 * Created with IntelliJ IDEA.
 * Description:
 * User: mwt
 * Date: 2022/8/4 14:28
 */
@Service
public class MsgServiceImpl implements MsgService {
   private HashMap<String,String> cache= new HashMap<String,String>();
    @Override
    public String get(String tel) {
        //取手机号后六位作为验证码
        String CacheCode = tel.substring(tel.length() - 6);
        System.out.println("CacheCode = " + CacheCode);
        cache.put(tel,CacheCode);
        return CacheCode;
    }

    @Override
    public Boolean Check(String tel, String Checknumber) {
        String CacheCode = cache.get(tel);
        if(CacheCode.equals(Checknumber)){
            return true;
        }
        return false;
    }
}
