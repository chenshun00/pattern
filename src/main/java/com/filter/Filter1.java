package com.filter;

import lombok.extern.slf4j.Slf4j;

/**
 * @author chenshun00@gmail.com
 * @since 2018/12/5
 */
@Slf4j
public class Filter1 implements IFilter {

    @Override
    public Object handle(String message, FilterChain filterChain) {
        log.info(",message = {} ,first do something about message", message);
        return filterChain.doNext(message);
    }
}
