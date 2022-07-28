package com.tansun.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * program: ssm_boot
 * Created with IntelliJ IDEA.
 * Description:
 * User: mwt
 * Date: 2022/7/28 13:52
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    private boolean flag;
    private Object data;
    private String msg;
    public Response(boolean flag){
        this.flag=flag;
    }
    public Response(boolean flag,Object data){
        this.flag=flag;
        this.data=data;
    }
    public Response(boolean flag,String msg){
        this.flag=flag;
        this.msg=msg;
    }
}
