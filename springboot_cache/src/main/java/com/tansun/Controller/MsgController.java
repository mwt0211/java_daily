package com.tansun.Controller;

import com.tansun.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * program: java_daily
 * Created with IntelliJ IDEA.
 * Description:
 * User: mwt
 * Date: 2022/8/4 14:26
 */
@RestController
@RequestMapping("/msg")
public class MsgController {
    @Autowired
    private MsgService msgService;
    @GetMapping("/get/{tel}")
    public String get(@PathVariable("tel") String tel){
        String s = msgService.get(tel);
        return s;
    }
    @GetMapping("/check/{tel}/{code}")
    public Boolean Check(@PathVariable("tel") String tel,@PathVariable("code")String code){
        Boolean check = msgService.Check(tel, code);
        return check;
    }
}
