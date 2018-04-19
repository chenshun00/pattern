package com.thread;

import java.util.concurrent.*;

public class NamedThreadPool {

    private ThreadPoolExecutor threadPoolExecutor;

    /**
     * BlockingQueue is fix,if you want more choose
     * you can change it by a var
     * <code>
     *     a == 0? new SynchronousQueue<>() :
     *              (a > 0? new LinkedBlockingQueue<>():new LinkedBlockingQueue<>(128));
     * </code>
     */
    public NamedThreadPool(ThreadFactory threadFactory){
        threadPoolExecutor = new ThreadPoolExecutor(2,2,60L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(128),threadFactory, new ThreadPoolExecutor.AbortPolicy());
    }

    public ThreadPoolExecutor getThreadPoolExecutor() {
        return threadPoolExecutor;
    }
}
