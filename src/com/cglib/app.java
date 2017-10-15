package com.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * Created by 竹 on 2017/10/15.
 */
public class App {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealSubject.class);
        enhancer.setCallback(new MethodInteceptor());
        SubjectService o = (SubjectService) enhancer.create();
        o.doService();


    }
}
