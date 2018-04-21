package com.async;

import lombok.Data;

import java.util.concurrent.CountDownLatch;

/**
 * <p>description:</p>
 *
 * @author 竹
 *         on 2018/4/21.
 */
@Data
public class Async {
    private GlobalContext me = GlobalContext.me();
    private String message;
    private CountDownLatch countDownLatch;

    public Async(){
        countDownLatch = new CountDownLatch(1);
    }

    public String init() throws InterruptedException {
        countDownLatch.await();
        return this.message;
    }


    public void done(String flag){
        countDownLatch.countDown();
        me.remmove(flag);
    }

}
