package com.thread;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Task implements Runnable {
    @Override
    public void run() {
        log.info("normal task,name = {}",Thread.currentThread().getName());
    }
}
