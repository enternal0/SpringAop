package com.dan.test;

import com.dan.proxy.jdkProxy.Apply;
import com.dan.proxy.jdkProxy.RealSubject;
import com.dan.proxy.jdkProxy.common.Log;
import com.dan.proxy.jdkProxy.common.SecurityCheck;
import com.dan.proxy.jdkProxy.common.Time;
import com.dan.proxy.jdkProxy.proxy.CglibProxySubject;
import org.springframework.cglib.proxy.Enhancer;

public class CglibProxySubjectApplication{
    public static Log log=new Log();
    public static Time time=new Time();
    public static SecurityCheck securityCheck=new SecurityCheck();
    public static void main(String[] args) {
        Apply obj=new RealSubject();
        Apply proxy= (Apply) Enhancer.create(obj.getClass(),new CglibProxySubject(obj,log,securityCheck,time));
        proxy.pay();
    }

}
