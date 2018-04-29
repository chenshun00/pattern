package com.cache;

import lombok.Data;
import lombok.NonNull;

import java.util.Map;
import java.util.concurrent.*;

/**
 * <p>
 *     description: cache center
 * </p>
 *
 * @author 竹
 *         on 2018/4/29.
 */
public class Pool<T> {
    public void add(@NonNull String key, @NonNull T t){
        this.add(key,t,TIME_OUT);
    }
    public void add(String key , T t,Long timeOut){
        Entry entry = new Entry();
        entry.setTimestamp(System.currentTimeMillis() + timeOut);
        entry.setValue(t);
        synchronized (CACHE_CENTER){
           CACHE_CENTER.putIfAbsent(key,entry);
        }
    }

    public void delete(@NonNull String key){
        synchronized (CACHE_CENTER){
            CACHE_CENTER.remove(key);
        }
    }

    public T get(String key){
        Entry entry = null;
        synchronized (CACHE_CENTER){
             entry = CACHE_CENTER.get(key);
        }
        if (entry == null){
            return null;
        }
        return entry.getTimestamp()<System.currentTimeMillis()?null:entry.getValue();
    }


    private Pool(){
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(()->{
            synchronized (CACHE_CENTER){
                CACHE_CENTER.forEach((key,value)->{
                    if (value.getTimestamp()<System.currentTimeMillis()){
                        CACHE_CENTER.remove(value);
                    }
                });
            }
        },15,15,TimeUnit.SECONDS);
    }

    private final Map<String,Entry>  CACHE_CENTER = new ConcurrentHashMap<>(16);
    private final static Long TIME_OUT = 600L;
    public static Pool me() {
        return poolHolder.me();
    }
    private final static class poolHolder{
        private final static Pool  POOL = new Pool();
        public static Pool me(){
            return POOL;
        }
    }
    @Data
    private class Entry{
        /**the expire time*/
        private Long timestamp;
        /**value*/
        private T value;
    }
}
