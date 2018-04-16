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
        GlobalContext instance = GlobalContext.getInstance();
        instance.startListener();
    }
}
