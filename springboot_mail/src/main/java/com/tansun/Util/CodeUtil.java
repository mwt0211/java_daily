package com.tansun.Util;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * program: java_daily
 * Created with IntelliJ IDEA.
 * Description:
 * User: mwt
 * Date: 2022/8/4 16:26
 */
@Component
public class CodeUtil {
    private static  final  String []patch={"00000","0000","000","00","0",""};
    public String GenernateCode(String tel){
        int hashCode = tel.hashCode();
        int encryption=19960112;//加密密码
        long result = hashCode ^ encryption;
        long NowTime = System.currentTimeMillis();
        result= NowTime^result;
        long CheckCode=result%1000000;
        CheckCode=   CheckCode<0?-CheckCode:CheckCode;
       String code= CheckCode+"";
        int length = code.length();

        return patch[length-1]+code ;
    }
    @Cacheable(value = "sms", key = "#Tel")
    public String GetCacheCode(String Tel) {
        return null;
    }

//    public static void main(String[] args) {
//        String genernateCode = new CodeUtil().GenernateCode("17533889964");
//        System.out.println("genernateCode = " + genernateCode);
//    }
}
