package com.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author 竹
 *         on 2018/4/15.
 */
public class Main {
        public static void main(String[] args) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(RealSubject.class);
            enhancer.setCallback(new MethodInteceptor());
            ISubjectService o = (ISubjectService) enhancer.create();
            o.doService();
    }
}
