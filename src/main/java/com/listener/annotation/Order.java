package com.listener.annotation;

/**
 * <p>annotation for order</p>
 * @author zhu
 */
public @interface Order {
    /**
     * 100 > 10 , value ==> pri
     */
    int value() default 100;
}
