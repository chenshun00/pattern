package com.cache;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *     description: how to design a cache,wo can improve is by desigin two Map
 *     first is write ,second is read ====》 master/slave
 * </p>
 *
 * @author 竹
 *         on 2018/4/29.
 */
@Slf4j
public class App {
    public static void main(String[] args) {
        String first = "123";
        String second = "456";
        Pool me = Pool.me();
        me.add(first,"hello",600000000L);
        me.add(second,"wudi",15000000000000L);
        try {
            Thread.sleep(20*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info(" first = {}",me.get(first));
        log.info(" second = {}",me.get(second));
    }
}
