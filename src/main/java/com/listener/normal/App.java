package com.listener.normal;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>description:</p>
 *
 * @author 竹
 *         on 2018/4/15.
 */
@Slf4j
public class App {
    public static void main(String[] args) {
        log.debug("12 {}","chen");
        log.info("12 {}","chen");
        log.error("12 {}","chen");
        log.warn("12 {}","chen");
    }
}
