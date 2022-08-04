package com.tansun.service;

/**
 * program: java_daily
 * Created with IntelliJ IDEA.
 * Description:
 * User: mwt
 * Date: 2022/8/4 14:26
 */
public interface MsgService {
    public String get(String tel);
    public Boolean Check(String tel,String Checknumber);
}
