package com.pool;

/**
 * <p>description:缓池池</p>
 *
 * @author 竹
 *         on 2018/4/15.
 */
public class App {
    public static void main(String[] args) {
        ResoureContext me = ResoureContext.me(Source.class);
        for (int i = 0; i < 20; i++) {
          new Thread(() -> {
              Source acquire = (Source) me.acquire();
              acquire.exec();
              me.release(acquire);
          }).start();
        }
    }
}
