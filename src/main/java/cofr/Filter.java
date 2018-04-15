package com.cs.cofr;

/**
 * 多态
 * @author 竹
 *
 */
public interface Filter {
	void doFilter(Request request,Response response , FilterChain fc);
}
