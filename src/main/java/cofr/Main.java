package com.cs.cofr;

public class Main {
	public static void main(String[] args) {
		
		FilterChain fc = new FilterChain();
		fc.addFilterLast(new HtmlHandler())
		   .addFilterLast(new SesitiveWorldHandler());
		
		Request request = new Request();
		request.setRequestStr(" 大家好 <html> , 'zz',netty学习者，线程爱好者");
		Response response = new Response();
		
		fc.doFilter(request, response, fc);
		
		System.out.println(request.getRequestStr());
		System.out.println(response.getRequestStr());
	
	}
}
