package com.dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *
 * @author 竹
 * date 2017/7/25
 */
public class InvocationHandlerTask  implements InvocationHandler {
    private Object object;

    public InvocationHandlerTask(Object object){
        this.object = object;
    }

    private void before(){
        System.out.println("开始前的前期工作");
        System.out.println("发生某件事");
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(object,args);
        after();
        return result;
    }
    private void after(){
        System.out.println("记录日志");
        System.out.println("结束后的清理工作");
    }
}
