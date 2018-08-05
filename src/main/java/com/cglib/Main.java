package com.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * @author 竹
 *         on 2018/4/15.
 */
public class Main {
        public static void main(String[] args) {
            ISubjectService o = (ISubjectService) Enhancer.create(RealSubject.class, (MethodInterceptor) (obj, method, args1, proxy) ->
                    proxy.invokeSuper(obj, args1));
            o.doService();
    }
}
