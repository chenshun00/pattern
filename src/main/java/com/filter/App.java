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
        FilterManager manager = FilterManager.me().add(new Filter1()).add(new Filter2());

        FilterChain filterChain = new FilterChain(manager.getFilterList());
        Object o = filterChain.doNext("hello,Filter handler");
        System.out.println(o);
    }
}
