package com.cs.cofr;

import java.util.ArrayList;
import java.util.List;

/**
 * 过滤器管理者
 * @author 竹
 *
 */
public class FilterChain implements Filter {
	private static int index = 0;
	List<Filter> filters = new ArrayList<>();
	
	public FilterChain addFilterLast(Filter filter) {
		this.filters.add(filter);
		return this;
	}
	
	public void doFilter(Request request, Response response, FilterChain fc) {
		
		if(index  ==  this.filters.size()) return ;
		
		//将控制权交给过滤器管理者
		Filter f = this.filters.get(index);
		index++;
		f.doFilter(request, response, fc);
	}

}
