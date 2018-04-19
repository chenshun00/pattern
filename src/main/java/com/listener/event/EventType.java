package com.listener.event;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * <p>description:</p>
 *
 * @author 竹
 *         on 2018/4/15.
 */
public enum EventType{

    FIRST("监听事件1"),SECOND("监听事件2"),THIRD("监听事件3");


    public String getEventValue(String name){
        Optional<EventType> first = Stream.of(EventType.values())
                .filter(eventType -> eventType.desc.equals(name.trim()))
                .findFirst();
        EventType eventType = first.orElse(null);
        if (eventType==null){
            return "";
        }else {
            return eventType.desc;
        }
    }

    private String desc;

    EventType(String desc) {
        this.desc = desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getDesc() {
        return desc;
    }
    private boolean isBlank(String content){
        return content==null || content.length()==0;
    }
}
