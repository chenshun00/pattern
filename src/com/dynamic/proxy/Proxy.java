package com.dynamic.proxy;

import java.lang.reflect.InvocationHandler;

/**
 * Created by 竹 on 2017/7/25.
 */
public class Proxy {

    private Object target;

    public Proxy(Object target){
        this.target = target;
    }

    public static Object newProxy(ClassLoader loader,Class<?>[] interfaces, InvocationHandler h){
        Run target = (Run)java.lang.reflect.Proxy.newProxyInstance(loader,interfaces,h);
        return target;
    }

}
