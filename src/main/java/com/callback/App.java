package com.callback;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * description:主要是理解回调函数(匿名内部类/lambda表达式/自定义回调函数)在什么时候被调用
 * 如下所示，lambda表达式其实只是定义了回调的执行代码，具体的执行等到它被调用的时候才能去执行定义的
 * 回调代码，理解了这一点就能很好的理解为什么是这样的了，---> 个人观点
 * 具体使用:Spring(5.0.7.release版本) @Controller和@RequestMapping的解析使用到的回调有2处，
 * 理解了这里回调的执行顺序，那么理解Controller的处理就基本上不是问题了
 * </p>
 *
 * @author 竹
 * on 2018/4/21.
 */
@Slf4j
public class App {
    public static void main(String[] args) {
        doCallBack(() -> log.debug("do {}", "info"));
    }

    private static void doCallBack(ICallback callback) {
        log.debug("do something before callable:{}", "before");
        callback.call();
        log.debug("do something after callable:{}", "after");
    }
}
