package com.listener.event;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>description:</p>
 *
 * @author 竹
 *         on 2018/4/15.
 */
public class ListenerManager {

    private static Map<EventType,List<Ilistener>> eventMap = new ConcurrentHashMap<>(8);




    public static void trigger(EventType eventType){
        eventMap.forEach((k,v)->{
            if (k.equals(eventType)){
                v.forEach(Ilistener::start);
            }
        });
    }


    public static void add(EventType eventType,Ilistener ilistener){
        checkParam(eventType,ilistener);
        List<Ilistener> list;
        if (eventMap.get(eventType)==null){
             list = new ArrayList<>(1);
        }else {
            list = eventMap.get(eventType);
        }
        list.add(ilistener);
        eventMap.put(eventType,list);
    }

    private static void checkParam(EventType eventType, Ilistener ilistener) {
        if (eventType==null || ilistener == null){
            throw new IllegalArgumentException("监听事件和监听器不能为空!");
        }
    }


}
