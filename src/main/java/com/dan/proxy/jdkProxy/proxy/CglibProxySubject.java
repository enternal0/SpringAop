package com.dan.proxy.jdkProxy.proxy;

import com.dan.proxy.jdkProxy.common.Log;
import com.dan.proxy.jdkProxy.common.SecurityCheck;
import com.dan.proxy.jdkProxy.common.Time;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxySubject implements MethodInterceptor {

    private Object target;
    private Log log;
    private SecurityCheck securityCheck;
    private Time time;

    public CglibProxySubject(Object target, Log log, SecurityCheck securityCheck, Time time) {
        this.target = target;
        this.log = log;
        this.securityCheck = securityCheck;
        this.time = time;
    }


    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        log.log();
        securityCheck.security();
        long start=time.time();
        Object obj=methodProxy.invoke(o,objects);
       long end= time.time();
        System.out.println("时间差是->"+(end-start));
        return obj;
    }
}
