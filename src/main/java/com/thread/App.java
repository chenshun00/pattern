package com.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {
    public static void main(String[] args) {
        NamedThreadFactory namedThreadFactory = new NamedThreadFactory("chen",true);
        NamedThreadPool namedThreadPool = new NamedThreadPool(namedThreadFactory);
        namedThreadPool.getThreadPoolExecutor().execute(new Task());
        namedThreadPool.getThreadPoolExecutor().execute(()->{
            log.info("lmbda start,name = {}",Thread.currentThread().getName());
            try {
                Thread.sleep(5*1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
