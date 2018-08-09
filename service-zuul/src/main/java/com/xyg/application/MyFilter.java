package com.xyg.application;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component(value="{com.xyg.*}")
public class MyFilter extends ZuulFilter {
	
	
	private static Logger log=LoggerFactory.getLogger(MyFilter.class);
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Object run() throws ZuulException {
		// TODO Auto-generated method stub
		 RequestContext ctx = RequestContext.getCurrentContext();
	        HttpServletRequest request = ctx.getRequest();
	        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
	        Object accessToken = request.getParameter("token");
	        if(accessToken == null) {
	            log.warn("token is empty");
	            ctx.setSendZuulResponse(false);
	            ctx.setResponseStatusCode(401);
	            try {
	                ctx.getResponse().getWriter().write("token is empty");
	            }catch (Exception e){}

	            return null;
	        }
	        log.info("ok");
	        return null;	 
	}
}
