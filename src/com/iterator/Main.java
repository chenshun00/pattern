package com.Iterator;

public class Main {
	public static void main(String[] args) {
		List<String> list = new SimulateLinkList<>();
		
		for (int i = 0; i < 10; i++) {
			list.put("hah"+i);
		}
		System.out.println();
		
		Iterator<String> iter = list.iterator();
		
		while (iter.hasNext()) {
			String str = iter.next();
			System.out.print(str + " ");
		}
	}

}
