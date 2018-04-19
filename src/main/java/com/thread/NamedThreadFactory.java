package com.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>thread factory</p>
 *
 * @author zhu
 */
public class NamedThreadFactory implements ThreadFactory {
    private static AtomicInteger tag = new AtomicInteger(1);
    /**
     * thread prefix
     */
    private String prefix = "chen-";

    /**
     * thread priority, default is 5
     */
    private int priority = 5;

    /**
     * thread ==> is daemon , default is true
     */
    private boolean daemon = true;
    private ThreadGroup threadGroup;

    public NamedThreadFactory(String prefix,boolean daemon){
        this.prefix = prefix + "-thread-" +tag+"-";
        SecurityManager securityManager = System.getSecurityManager();
        this.threadGroup = (securityManager == null)?Thread.currentThread().getThreadGroup():securityManager.getThreadGroup();
        this.daemon=daemon;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(threadGroup,r,prefix);
        thread.setDaemon(daemon);
        thread.setPriority(priority);
        return thread;
    }
}
