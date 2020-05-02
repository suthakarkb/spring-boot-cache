package sample.data.jpa.interceptor;

//import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Component
public class CacheServiceInterceptor  extends HandlerInterceptorAdapter implements
HandlerInterceptor{
	
	private final Logger log = LoggerFactory.getLogger(CacheServiceInterceptor.class);
	
//	   @Override
//	   public boolean preHandle(
//	      HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//		  log.info("Inside: CacheServiceInterceptor.preHandle");
//	      return true;
//	   }	
//
//	   @Override
//	   public void postHandle(
//	      HttpServletRequest request, HttpServletResponse response, Object handler, 
//	      ModelAndView modelAndView) throws Exception {		   
//		  log.info("----> Inside: CacheServiceInterceptor.postHandle");
//	   }	

	   @Override
	   public boolean preHandle
	      (HttpServletRequest request, HttpServletResponse response, Object handler) 
	      throws Exception {
	       System.out.println("1. Pre Handle method is Calling");
		   log.info("Pre Handle method is Calling");
	      return true;
	   }
	   @Override
	   public void postHandle(HttpServletRequest request, HttpServletResponse response, 
	      Object handler, ModelAndView modelAndView) throws Exception {
		   System.out.println("2. Post Handle method is Calling");
		   log.info("Post Handle method is Calling");
	   }
	   @Override
	   public void afterCompletion
	      (HttpServletRequest request, HttpServletResponse response, Object 
	      handler, Exception exception) throws Exception {
		   System.out.println("3. Request and Response is completed");
		   log.info("Request and Response is completed");
	   }	
	
	   
}
