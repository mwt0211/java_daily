package com.tansun.Controller;

import com.tansun.pojo.SMSCode;
import com.tansun.service.SMSCodeService;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeoutException;


/**
 * program: java_daily
 * Created with IntelliJ IDEA.
 * Description:
 * User: mwt
 * Date: 2022/8/4 16:14
 */
@RestController
@RequestMapping("/sms")
public class SMSController {
    @Autowired
    private SMSCodeService smsCodeService;
    @GetMapping("/{tel}")
    public String getCode(@PathVariable("tel")  String Tel) throws InterruptedException, MemcachedException, TimeoutException {
        String code = smsCodeService.SendToTel(Tel);
        return code;
    }
    @PostMapping("/check")
    public Boolean CheckCode( SMSCode smsCode){
        return smsCodeService.CheckCode(smsCode);
    }
}
