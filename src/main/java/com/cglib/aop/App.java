package com.cglib.aop;

import com.cglib.RealSubject;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * @author chenshun00@gmail.com
 * @since 2018/9/13
 */
public class App {
    public static void main(String[] args) {
        UserService userService = new UserService();
        RealSubject realSubject = new RealSubject();
        realSubject.setUserService(userService);
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(realSubject.getClass());
        enhancer.setCallback((MethodInterceptor) (obj, method, args1, proxy)
                -> proxy.invokeSuper(obj, args1));
        realSubject = (RealSubject) enhancer.create();
        System.out.println(realSubject.getClass().getSimpleName());
        realSubject.doService();
        System.out.println(realSubject.getUserService());
    }
}
