package com.cs.cofr;

public class SesitiveWorldHandler  implements Filter  {
	
	@Override
	public void doFilter(Request request, Response response, FilterChain chain) {
		request.requestStr = request.getRequestStr().replace("sb", " ")
				 .replace("zz", "**") + "---SesitiveFilter()";
				chain.doFilter(request, response, chain);
				response.responseStr += "---SesitiveFilter()";
	}
	
}
