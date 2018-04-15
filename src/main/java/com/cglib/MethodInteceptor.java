package com.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by 竹
 * on 2017/10/15.
 */
public class MethodInteceptor implements  MethodInterceptor{
    private void before(){
        System.out.println("###before");
    }
    private void after(){
        System.out.println("###after");
    }
    @Override
    public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object o = methodProxy.invokeSuper(object, objects);
        after();
        return o;
    }
}
