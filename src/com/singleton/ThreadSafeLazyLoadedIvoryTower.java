package com.singleton;
/**
 * 规范版本懒加载，更加的规范
 * @author 竹
 *
 */
public class ThreadSafeLazyLoadedIvoryTower {
	private static ThreadSafeLazyLoadedIvoryTower threadSafeLazyLoadedIvoryTower = null;
	
	private ThreadSafeLazyLoadedIvoryTower(){
		
		 if (threadSafeLazyLoadedIvoryTower != null) {
		      throw new IllegalStateException("Already initialized.");
		    }
	}
	/**
	 * 中间的种种操作全都考虑到了多线程并发问题
	 * A线程可能会初始化B线程中的一些东西
	 * @return
	 */
	 public static ThreadSafeLazyLoadedIvoryTower getInstance() { 
		 ThreadSafeLazyLoadedIvoryTower result = threadSafeLazyLoadedIvoryTower;
		 //检查是不是已经被初始化，如果已经被初始化了直接返回
		 if(result == null) {
			 //没有被初始化，但是不能确保在此期间是否有线程对此进行初始化，所以要对接下来的代码尽行加锁操作
			 synchronized (ThreadSafeLazyLoadedIvoryTower.class) {
				 //再次分配一个实例检查是否被其他线程初始化，如果已经被初始化了那么直接返回就可以了
				result = threadSafeLazyLoadedIvoryTower;
				if(result == null) {
					result = threadSafeLazyLoadedIvoryTower = 
							new ThreadSafeLazyLoadedIvoryTower();
				 }
				 
			}
			 
		 }
		 return result;
	}
	
	
}
