package com.cglib;

import lombok.Data;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class Proxy {
    private Object target;
    private Method method;
    private Object[] args;
    private MethodProxy methodProxy;
    private String info;

    public Proxy(Object target, Method method, Object[] args, MethodProxy methodProxy, String info) {
        this.target = target;
        this.method = method;
        this.args = args;
        this.methodProxy = methodProxy;
        this.info = info;
    }

    /**
     * the proxy objects , we define a aspectj class , the specific class can implement or extend that,
     * in <link> doChain() </link> we can run this proxy List before run target method and after.
     */
    private List<Object> proxyList = new ArrayList<>(Arrays.asList("1", "2", "3"));
    /**
     * index , run proxy step by step
     */
    private int index = 0;
    /**
     * proxyList's count
     */
    private int all = proxyList.size();


    /**
     * execute a proxy list , we can define some advise that represent a aspectj
     *
     * @return proxy object
     * @throws Throwable exception will be throwed
     */
    public Object doChain() throws Throwable {

        for (; index < all; index++)
            //first , run all proxy object
            System.out.println(proxyList.get(index).toString());


        System.out.println("before run target method:" + this.info);
        //then , run target method
        Object o = methodProxy.invokeSuper(target, args);
        System.out.println("after run target method:" + this.info);
        //finally , return proxy object
        return o;
    }

}
