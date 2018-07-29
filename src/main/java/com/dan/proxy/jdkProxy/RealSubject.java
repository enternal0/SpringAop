package com.dan.proxy.jdkProxy;

/**
 * 真实业务类实现接口
 */
public class RealSubject implements Apply {
    public void pay() {
        System.out.println("刷卡支付...");
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
