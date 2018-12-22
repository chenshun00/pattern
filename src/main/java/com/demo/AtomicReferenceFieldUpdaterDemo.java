package com.demo;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * AtomicReferenceFieldUpdater 原子更新字段
 *
 * @author chenshun00@gmail.com
 * @since 2018/12/22
 */
public class AtomicReferenceFieldUpdaterDemo {
    private final static AtomicReferenceFieldUpdater<AtomicReferenceFieldUpdaterDemo, String>
            string_update = AtomicReferenceFieldUpdater.newUpdater(AtomicReferenceFieldUpdaterDemo.class, String.class,
            "test");

    private volatile String test;

    public static void main(String[] args) {
        AtomicReferenceFieldUpdaterDemo demo = new AtomicReferenceFieldUpdaterDemo();
        boolean chen = string_update.compareAndSet(demo, null, "chen");
        System.out.println(chen);
        System.out.println(demo.test);
    }
}
