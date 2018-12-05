package com.cglib;

import net.sf.cglib.proxy.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author 竹
 * on 2018/4/15.
 */
public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealSubject.class);
        enhancer.setNamingPolicy(new MyDefaultNamingPolicy());
//        enhancer.setCallback((MethodInterceptor) (obj, method, args1, proxy) -> {
//            System.out.println("前边");
//            try {
//                return proxy.invokeSuper(obj, args1);
//            } finally {
//                System.out.println("后边");
//            }
//        });
        //enhancer.setCallback(new DCallback()) 只是一个特殊的 enhancer.setCallbacks ，其实内部存在一个callbacks的数组
        //之后的调用会按照setCallbackFilter的过滤去选择callbacks数组下标中的一个，cglib提供了默认的实现，默认是0
        Callback[] callbacks = new Callback[]{new First(), new Second()};
        enhancer.setCallbacks(callbacks);
        //按照具体的情况调用哪一个拦截器
        enhancer.setCallbackFilter(method -> {
            //如果是1那么调用第二个，这里是按照下标去算的，如果
            return 0;
        });
        RealSubject realSubject = (RealSubject) enhancer.create();

        Field name = realSubject.getClass().getField("name");
        name.setAccessible(true);
        name.set(realSubject,"shun");

        System.out.println(realSubject.getClass().getName());
        System.out.println(realSubject.getName());
        realSubject.doService();
    }

    private static class First implements MethodInterceptor {
        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            System.out.println("first");
            return proxy.invokeSuper(obj, args);
        }
    }

    private static class Second implements MethodInterceptor {
        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            System.out.println("Second");
            return proxy.invokeSuper(obj, args);
        }
    }

}
