package com.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * 将代理既然这样的话，那么我直接在启动的时候就将对象都替换了，不是美滋滋
 */
public class ProxyManager {

    /**
     *
     * @param targetClass targetClass will being represented
     * @param info a string , System.out
     * @param <T> type
     * @return a proxy object about targetClass
     */
    @SuppressWarnings("unchecked")
    public static <T> T createProxy(final Class<?> targetClass, String info) {
        //这里才是这个MethodInterceptor 具体实现的地方，我们要做的就是在这里进行一些处理
        return (T) Enhancer.create(targetClass, (MethodInterceptor) (obj, method, args, proxy) ->
                new Proxy(obj, method, args, proxy, info).doChain());
    }

    public static void main(String[] args) {
        RealSubject proxy = createProxy(RealSubject.class, "test");
        String name = proxy.getName();
        System.out.println(name);
        proxy.doService();
    }
}
