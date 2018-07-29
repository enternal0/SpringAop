package com.dan.test;

import com.dan.proxy.jdkProxy.*;
import com.dan.proxy.jdkProxy.common.Log;
import com.dan.proxy.jdkProxy.common.SecurityCheck;
import com.dan.proxy.jdkProxy.common.Time;
import com.dan.proxy.jdkProxy.proxy.JdkProxySubject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class JdkProxySubjectApplication {
/**
 * 静态代理类测试
 */
//    public static void main(String[] args) {
//        Log log = new Log();
//        Time time = new Time();
//        SecurityCheck securityCheck = new SecurityCheck();
//        RealSubject realSubject = new RealSubject();
//        Apply apply = new JdkProxySubject(realSubject, log, securityCheck, time);
//        apply.pay();
//    }

    /**
     * 动态代理类测试
     *
     * @param args
     */
    public static void main(String[] args) {

        Apply target=new RealSubject();
        Log log=new Log();
        Time time=new Time();
        SecurityCheck securityCheck=new SecurityCheck();
        InvocationHandler handler=new JdkProxySubject(target,log,securityCheck,time);
        Apply proxy= (Apply) Proxy.newProxyInstance(target.getClass().getClassLoader(),new Class[]{Apply.class},handler);
        proxy.pay();
    }
}
