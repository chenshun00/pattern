package com.async;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>description:异步处理</p>
 *
 * @author 竹
 *         on 2018/4/21.
 */
@Slf4j
public class App {
    private final static String FLAG = "FLAG";
    public static void main(String[] args) throws InterruptedException {
        Async async =  new Async();
        GlobalContext me = GlobalContext.me();
        me.add(FLAG,async);
        new Thread(()->{
            log.debug("模拟异步处理开始");
            try {
                Thread.sleep(10*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("模拟异步处理结束");
            Async message = me.get(FLAG);
            message.setMessage("hello async");
            message.done(FLAG);
            log.info("异步处理完成");
        }).start();
        log.info("123");
        log.debug("异步返回信息:{}" , async.init());
    }
}
