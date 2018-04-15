package com.adapter;

import com.adapter.handler.adaper.HandlerAdapter;
import com.adapter.handler.adaper.impl.DefaultHandlerAdapter;
import com.adapter.handler.mapping.HandlerMapping;
import com.adapter.handler.mapping.impl.Handler1;
import com.adapter.handler.mapping.impl.Handler2;
import com.adapter.handler.mapping.impl.Handler3;

/**
 * @author 竹
 *         on 2018/4/15.
 */
public class App {
    public static void main(String[] args) {
        HandlerAdapter adapter = new DefaultHandlerAdapter();

        HandlerMapping mapping1 = new Handler1();
        HandlerMapping mapping2 = new Handler2();
        HandlerMapping mapping3 = new Handler3();

        adapter.add("handler1",mapping1);
        adapter.add("handler2",mapping2);
        adapter.add("handler3",mapping3);

        System.out.println(adapter.size());

        adapter.getHandler("handler1").handler();
        adapter.getHandler("handler2").handler();
        adapter.getHandler("handler3").handler();
    }
}
