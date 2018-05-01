package com.dynamic.proxy;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.InvocationHandler;

/**
 *
 * @author 竹
 * date 2017/7/25
 */
public class Proxy {

    @Setter
    @Getter
    private Object target;

    public Proxy(Object target){
        this.target = target;
    }

    public static Object newProxy(ClassLoader loader,Class<?>[] interfaces, InvocationHandler h){
        return java.lang.reflect.Proxy.newProxyInstance(loader,interfaces,h);
    }

}
