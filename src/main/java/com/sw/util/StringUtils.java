package com.sw.util;

public class StringUtils {
    //截取最后一位
    public static  String substrLast(String s){
        String result ="";
        //一定要写result = ，否则s截取完了之后，s本身是不变化的
        result = s.substring(0,s.length()-1);

        return  result;
    }

}
