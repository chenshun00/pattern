package com.observer.event;

import java.util.ArrayList;
import java.util.List;


interface ActionListener {
	public void ActionToWakenUp(ActionEvent wakenUpEvent);
}
/**
 * 观察的对象(当这个对象发生变化了的时候,所有监听这个对象的事件都会被触发)
 * 而我先前的理解是都派一个对象去观察这个被观察的对象,其实不然
 * @author 竹
 *
 */
class Child{
	private ActionEvent currentEvent =ActionEvent.SLEEP ;
	
	List<ActionListener> actionListeners = new ArrayList<>();	
	
	public void addLister(ActionListener actionListener) {
		actionListeners.add(actionListener);
	}
	
	public void wakeUp() {
		ActionEvent[] enumValues = ActionEvent.values();
		currentEvent = enumValues[(currentEvent.ordinal() + 1) % enumValues.length]; //下一个天气
		System.out.println("当前事件是 ： " +currentEvent);
		notifyAllLister();
	}

	private void notifyAllLister() {
		for(ActionListener actionListener : actionListeners) {
			actionListener.ActionToWakenUp(currentEvent);
		}
	}
}

class Dad implements ActionListener{

	@Override
	public void ActionToWakenUp(ActionEvent wakenUpEvent) {
		System.out.println("dad : "+wakenUpEvent);
	}
}

class Dog implements ActionListener{

	@Override
	public void ActionToWakenUp(ActionEvent wakenUpEvent) {
		System.out.println("dog : "+wakenUpEvent);
	}
	
}

/**
 * 由被观察对象去通知观察者(这里的孩子,上次的天气都是这样的)
 * @author 竹
 *
 */
public class Main {
	public static void main(String[] args) {
		Child child = new Child();
		child.addLister(new Dad());
		child.addLister(new Dog());
		
		child.wakeUp();
		child.wakeUp();
		child.wakeUp();
		child.wakeUp();
	}
}
