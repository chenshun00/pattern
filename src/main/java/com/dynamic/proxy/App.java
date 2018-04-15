package com.dynamic.proxy;

import java.lang.reflect.InvocationHandler;

/**
 * Created by 竹 on 2017/7/25.
 * Spring中基于接口实现的代理和cglib实现的代理
 */
public class App {
    public static void main(String [] args){
        Run run = new Plain();
        ClassLoader classLoader = run.getClass().getClassLoader();
        InvocationHandler handler = new InvocationHandlerTask(run);
        Run target = (Run) Proxy.newProxy(classLoader,run.getClass().getInterfaces(),handler);
        target.run();
    }
}
