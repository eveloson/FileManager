package com.file.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	/*
	 * 正常请求之前被调用
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
//		session.setAttribute("username", new String("")); //模拟登陆
		Integer user_id = (Integer) session.getAttribute("user_id");
		if(user_id!=null){
			System.out.println(">>>>> 用户已登录！");
			return true ;
		}
		response.sendRedirect(request.getContextPath() + "/user/login.do");
		return false;
	}
	
	/*
	 * 当preHandle返回true时才会被调用
	 * 		在正常请求之后被调用，在被转发到视图之前被调用
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView modelAndView)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	/*
	 * 当preHandle返回true时才会被调用
	 * 		正常请求执行完成后被调用
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
}
