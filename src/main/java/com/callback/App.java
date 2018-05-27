package com.callback;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>description:</p>
 *
 * @author 竹
 *         on 2018/4/21.
 */
@Slf4j
public class App {
    public static void main(String[] args) {
        doCallBack(new ICallback() {
            @Override
            public void call() {
                execute();
                log.info("call ...");
            }
            @Override
            public void execute() {
                log.info("execute ...");
            }
        });
    }
    private static void doCallBack(ICallback callback){
        callback.call();
    }
}
