package com.filter;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>description:main class</p>
 *
 * @author 竹
 *         on 2018/4/17.
 */
@Slf4j
public class App {
    public static void main(String[] args) {
        FilterManager manager = FilterManager.me()
                .add((ch,filterChain) ->{
                    log.info(",message = {} ,first do something about message",ch);
                    if (ch.length()>=5){
                        log.error("handled by first");
                        return;
                    }
                    filterChain.doNext(ch);
                }).add((message,filterChain) -> {
                    log.info("message = {}，second,do something about message",message);
                    filterChain.doNext(message);
                });
//                .addFirst(()->log.info("first++ filter(handler)"));

        FilterChain filterChain = new FilterChain(manager.getFilterList());
        filterChain.doNext("hello,Filter handler");
    }
}
