package com.listener.normal;


import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>description:</p>
 *
 * @author 竹
 *         on 2018/4/15.
 */
@Slf4j
public class ListenerManager {

    public void trigger() {
        listeners.forEach(Listener::start);
    }

    public void triggerInit() {
        listeners.forEach(Listener::init);
    }

    public ListenerManager register(Listener listener) {
        check(listener);
        listeners.add(listener);
        return this;
    }

    private void check(Listener listener) {
        if (listener == null) {
            log.error("listen 不能为空!");
            throw new IllegalArgumentException("监听器不能为空！");
        }
        if (listeners.contains(listener)) {
            log.warn("{} 已经解析，跳过重复解析!");
        }
    }

    private List<Listener> listeners = new ArrayList<>();

    private static class ListenerManagerHolder {
        private static ListenerManager me() {
            return new ListenerManager();
        }
    }

    private ListenerManager() {
    }

    public static ListenerManager me() {
        return ListenerManagerHolder.me();
    }
}
