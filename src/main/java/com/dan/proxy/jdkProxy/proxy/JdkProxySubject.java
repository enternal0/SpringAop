package com.dan.proxy.jdkProxy.proxy;

/**
 * 静态代理实现
 */
//public class JdkProxySubject implements Apply {
//
//    private Apply apply;
//    private Log log;
//    private SecurityCheck securityCheck;
//    private Time time;
//
//    public JdkProxySubject(Apply apply, Log log, SecurityCheck securityCheck, Time time) {
//        this.apply = apply;
//        this.log = log;
//        this.securityCheck = securityCheck;
//        this.time = time;
//    }
//
//    public void pay() {
//        securityCheck.security();
//        log.log();
//        long start = time.time();
//        this.apply.pay();
//        long end = time.time();
//        System.out.println("时间差为->"+(end-start));
//    }
//}

import com.dan.proxy.jdkProxy.common.Log;
import com.dan.proxy.jdkProxy.common.SecurityCheck;
import com.dan.proxy.jdkProxy.common.Time;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Jdk动态代理类的实现   只能实现接口代理
 */
public class JdkProxySubject implements InvocationHandler {
    //被代理对象
    private Object target;
    private Log log;
    private SecurityCheck securityCheck;
    private Time time;

    public JdkProxySubject(Object target, Log log, SecurityCheck securityCheck, Time time) {
        this.target = target;
        this.log = log;
        this.securityCheck = securityCheck;
        this.time = time;
    }

    //通过构造注入把被代理对象传进来
    public JdkProxySubject(Object target) {
        this.target = target;
    }

    //代理对象
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.log();
        securityCheck.security();
        long start = time.time();
        Object obj = method.invoke(target, args);
        long end = time.time();
        System.out.println("时间差为->"+(end-start));
        return obj;
    }
}
