package com.async;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>description:</p>
 *
 * @author 竹
 *         on 2018/4/21.
 */
public class GlobalContext {

    private Map<String,Async> ASYNC_MAP;

    public void add(String flag,Async async){
        if (ASYNC_MAP.get(flag)==null){
            ASYNC_MAP.putIfAbsent(flag,async);
        }
    }

    public void remmove(String flag){
        assert flag != null;
        if (flag.length()>0){
            ASYNC_MAP.remove(flag);
        }
    }

    public Async get(String flag){
        assert flag != null;
        return ASYNC_MAP.getOrDefault(flag,null);
    }

    private GlobalContext(){
        ASYNC_MAP = new ConcurrentHashMap<>(16);
    }
    public static GlobalContext me(){
        return GlobalContextHolder.me();
    }
    private final static class GlobalContextHolder{
        private final static GlobalContext me = new GlobalContext();
        private static GlobalContext me(){
            return me;
        }
    }

}
