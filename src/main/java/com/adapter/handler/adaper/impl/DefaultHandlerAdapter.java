package com.adapter.handler.adaper.impl;

import com.adapter.handler.adaper.HandlerAdapter;
import com.adapter.handler.mapping.HandlerMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 竹
 *         on 2018/4/15.
 */
public class DefaultHandlerAdapter implements HandlerAdapter {

    private Map<String,HandlerMapping> map = new HashMap<>(16);

    @Override
    public Integer size() {
        return map.size();
    }

    @Override
    public void remove(HandlerMapping handlerMapping) {
       if (map.size()>0){
           map.values().removeIf(mapping -> map.containsValue(mapping));
       }
    }

    @Override
    public void add(String handlerName,HandlerMapping handlerMapping){
        if (map.containsValue(handlerMapping)){
            throw new IllegalArgumentException("重复添加!" + handlerMapping);
        }
        if (map.containsKey(handlerName)){
            throw new IllegalArgumentException("重复添加!" + handlerName);
        }
        map.put(handlerName,handlerMapping);
    }

    @Override
    public boolean supports(Object handler) {
        return handler instanceof HandlerMapping;
    }

    @Override
    public HandlerMapping getHandler(String name) {
        if (isBlank(name)) return null;
        return map.get(name);
    }

    private boolean isBlank(String content){
        return content==null || content.length()==0;
    }

}
