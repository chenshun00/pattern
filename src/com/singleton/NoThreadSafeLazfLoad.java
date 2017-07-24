package com.singleton;

public class NoThreadSafeLazfLoad {
	private static NoThreadSafeLazfLoad noThreadSafeLazfLoad = null;
	
	
	private NoThreadSafeLazfLoad(){
		if(noThreadSafeLazfLoad!=null) {
			try {
				throw new Exception("已经被初始化");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static NoThreadSafeLazfLoad getInstance() {
//		if(noThreadSafeLazfLoad == null) {
//			synchronized (NoThreadSafeLazfLoad.class) {
//				if(noThreadSafeLazfLoad == null) {
//					noThreadSafeLazfLoad = new NoThreadSafeLazfLoad();
//				}
//			}
//			noThreadSafeLazfLoad = ;
//		}
	return new NoThreadSafeLazfLoad();
	}
	
	
}
