package com.dynamic.proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *
 * @author 竹
 * date 2017/7/25
 */
@Slf4j
public class InvocationHandlerTask  implements InvocationHandler {
    private Object object;

    public InvocationHandlerTask(Object object){
        this.object = object;
    }

    private void before(Object proxy){
        log.debug("proxy =  {}",proxy.getClass().getName());
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before(proxy);
        return method.invoke(object,args);
    }
}
