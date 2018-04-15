package com.listener.normal.impl;

import com.listener.normal.Listener;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>description:</p>
 *
 * @author 竹
 *         on 2018/4/15.
 */
@Slf4j
public class CustomListener1 implements Listener {
    @Override
    public void init() {
        log.debug("init CustomListener1");
    }

    @Override
    public void start() {
        log.debug("start CustomListener1");
    }
}
