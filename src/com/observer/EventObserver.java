package com.observer;

/**
 * 事件观察者，事件发生后通知一系列关注这个事件的吃瓜群众
 * eg:关注的主播开播了，通知你
 * @author 竹
 */
public interface EventObserver {
	
	void notifyObserver(EventType type);
	
}
