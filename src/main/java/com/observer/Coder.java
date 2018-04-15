package com.observer;

public class Coder implements EventObserver {

	@Override
	public void notifyObserver(EventType type) {
		System.out.println("coder 当前事件为 ：" +type);
	}

}
