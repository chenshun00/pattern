package com.observer;
/**
 * 观察者模式是指一个事件or一个状态改变的时候，就会自动的去通知所有的观察者
 * @author 竹
 */
public class App {
	public static void main(String[] args) {
		Observers observers = new Observers();
		//添加观察者
		observers.addObserver(new Coder());
		observers.addObserver(new Student());
		//事件发生
		observers.eventHappen();
		observers.eventHappen();
		observers.eventHappen();
		observers.eventHappen();
		observers.eventHappen();
		
	}
}
