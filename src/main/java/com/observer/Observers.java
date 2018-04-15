package com.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 在观察者中间人，包含了所有的观察者，事件发生后或者状态改变后自动的去通知所有的观察者
 * @author 竹
 *
 */
public class Observers {
	
	private  List<EventObserver> lists ;
	private EventType currentEvent; 
	
	public Observers() {
		 lists = new ArrayList<>();
		 currentEvent = EventType.SHANGKE;
	}
	
	public void addObserver(EventObserver eventObserver) {
		lists.add(eventObserver);
	}
	
	public void removeObserver(EventObserver eventObserver) {
		lists.remove(eventObserver);
	}
	
	private void notifyAllObservers() {
		for(EventObserver observer : lists) {
			observer.notifyObserver(currentEvent);
		}
	}
	
	
	public  void eventHappen(){
		EventType [] eventType = EventType.values();
		currentEvent = eventType[(currentEvent.ordinal() + 1) % eventType.length]; //下一个事件
		System.out.println("事件改变为" + currentEvent);
		notifyAllObservers();
	}
	
}
