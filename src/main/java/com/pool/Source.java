package com.pool;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>description:</p>
 *
 * @author 竹
 *         on 2018/4/17.
 */
@Slf4j
public class Source {

    public Source() {
        try {
            log.info("模拟对象初始化消耗");
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 执行方法.参数可以自定义
     */
    public void exec() {
        log.info("执行Source中的exec方法 , {}" ,this);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
