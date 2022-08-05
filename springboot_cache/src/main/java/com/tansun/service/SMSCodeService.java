package com.tansun.service;

import com.tansun.pojo.SMSCode;
import net.rubyeye.xmemcached.exception.MemcachedException;

import java.util.concurrent.TimeoutException;

/**
 * program: java_daily
 * Created with IntelliJ IDEA.
 * Description:
 * User: mwt
 * Date: 2022/8/4 16:10
 */
public interface SMSCodeService {
    public String SendToTel(String Tel) throws InterruptedException, MemcachedException, TimeoutException;
    public Boolean CheckCode(SMSCode smsCode);
}
