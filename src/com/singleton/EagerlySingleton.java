package com.singleton;

/**
 * 饿汉式单例模式，在加载类的时候就已经的初始化了
 * 使用饿汉式是线程安全的，因为eagerlySingleton是在初始化就加载完成且不会被改变的
 * 也用过了hashcode的验证
 * @author 竹
 *
 */
public class EagerlySingleton {
	private final static EagerlySingleton eagerlySingleton = new EagerlySingleton();
	
	private EagerlySingleton() {}
	
	public static EagerlySingleton getInstance(){
		return eagerlySingleton;
	}
	
}
