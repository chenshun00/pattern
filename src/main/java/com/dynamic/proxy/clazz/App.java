package com.dynamic.proxy.clazz;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.stream.Stream;

/**
 * <p>description:a simple desc about RPC,Request filed, server deal </p>
 *
 * @author 竹
 *         on 2018/4/25.
 */
@Slf4j
public class App {
    static {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
    }
    public static void main(String[] args) throws Exception{
        //RPC ---> ClassName  methodName args, argsType
        //ClassName(from client's request)  ---> client is Interface,server is implement class
        String ClassName = "com.dynamic.proxy.clazz.test.ITestImpl";
        //methodName(the invoke method,form client's request)
        String methodName = "test";
        //parameterTypes(the parameter of the invoke method,from client'request)
        Class<?> parameterTypes = java.lang.String.class;
        //get interface instance(Spring's IOC)
        Class<?> aClass = Class.forName(ClassName);
        Object object = aClass.newInstance();
        //get method by reflecting
        Method method = aClass.getMethod(methodName,parameterTypes);
        //invoke and get result
        Object invoke = method.invoke(object,"chen");
        log.info("invoke = {}",invoke);
        // if RPC, return result to channel , by network to client.
    }
}