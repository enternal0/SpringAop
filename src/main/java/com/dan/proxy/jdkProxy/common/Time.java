package com.dan.proxy.jdkProxy.common;

/**
 * 时间类
 */
public class Time {
   public long time(){
       long ret=System.currentTimeMillis();
       System.out.println(ret);
       return ret;
   }
}
