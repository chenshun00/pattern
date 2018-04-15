package com.listener.event;

/**
 * <p>description:</p>
 *
 * @author 竹
 *         on 2018/4/15.
 */
public class App {
    public static void main(String[] args) {
        ListenerManager.add(EventType.FIRST,()-> System.out.println("监听事件1"));

        ListenerManager.add(EventType.SECOND,()-> System.out.println("监听事件1"));

        ListenerManager.add(EventType.THIRD,()-> System.out.println("监听事件1"));

        ListenerManager.add(EventType.FIRST,()-> System.out.println("监听事件11"));

        ListenerManager.trigger(EventType.FIRST);

    }
}
