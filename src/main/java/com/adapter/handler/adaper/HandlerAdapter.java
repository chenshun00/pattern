package com.adapter.handler.adaper;

import com.adapter.handler.mapping.HandlerMapping;

/**
 * @author 竹
 *         on 2018/4/15.
 */
public interface HandlerAdapter {

    Integer size();

    void remove(HandlerMapping handlerMapping);

    void add(String handlerName,HandlerMapping handlerMapping);

    /**
     * <p>{@code
     * return (handler instanceof MyHandler);
     * }
     * </p>
     */
    boolean supports(Object handler);

    HandlerMapping getHandler(String name);

}
