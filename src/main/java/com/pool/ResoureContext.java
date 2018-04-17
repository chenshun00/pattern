package com.pool;

import com.sun.org.apache.bcel.internal.classfile.Unknown;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * <p>description:资源上下文</p>
 *
 * @author 竹
 *         on 2018/4/16.
 */
@Slf4j
public class ResoureContext<T> {

    private static Integer SIZE = 50;
    private Semaphore semaphore = new Semaphore(SIZE);

    private List<T> sources = new ArrayList<>(SIZE);


    private static class ResoureContextHolder<T> {
        private static <T> ResoureContext me(Class<T> t) {
            return new ResoureContext(t);
        }
    }

    public T acquire() {
        T t = null;
        try {
            log.debug("池中存留对象 {}",sources.size());
            t = sources.get(0);
            sources.remove(0);
            semaphore.acquire(1);
        } catch (Exception e) {
            semaphore.release(1);
            log.error("获取缓存对象发生异常:" + e.getMessage());
        }
        if (t == null) {
            throw new IllegalArgumentException("请稍后再试!,重复出现请反馈!");
        }
        return t;
    }

    public void release(T t) {
        try {
            sources.add(t);
        } finally {
            semaphore.release(1);
        }
    }

    private ResoureContext(Class<T> source) {
        for (int i = 0; i < SIZE; i++) {
            T t = newTclass(source);
            log.info("实例化 {}", t);
            sources.add(t);
        }
    }

    private T newTclass(Class<T> clazz) {
        T a = null;
        try {
            a = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return a;

    }

    public static <T> ResoureContext me(Class<T> clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException("初始化不能为空");
        }
        return ResoureContextHolder.me(clazz);
    }

}
