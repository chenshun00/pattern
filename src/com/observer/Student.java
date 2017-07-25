package com.observer;


public class Student implements EventObserver {
	
	
	@Override
	public void notifyObserver(EventType type) {
		System.out.println("student 当前事件为  :" +type);
	}
	
	

}
