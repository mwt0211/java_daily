package com.tansun.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * program: ssm_boot
 * Created with IntelliJ IDEA.
 * Description:
 * User: mwt
 * Date: 2022/7/28 15:02
 */
@RestControllerAdvice
public class ExceptionAdvice {
    //拦截所有的异常信息
    @ExceptionHandler
    public Response doException(Exception e){
        //记录日志
        //通知运维
        //通知开发
        e.printStackTrace();
        return new Response(false,"服务器异常"+e);
    }
}
