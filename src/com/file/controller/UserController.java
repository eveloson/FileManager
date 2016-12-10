package com.file.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.file.service.UserService;
import com.file.utils.DateFormatUtil;
import com.file.vo.User;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	UserService userService;
	
	@RequestMapping(method = RequestMethod.GET ,value = "/login.do")
	public String login() {
		return "login";
	}
	@RequestMapping(method = RequestMethod.POST ,value = "/login.do")
	public String doLogin(User user,HttpServletRequest request) {
		User user2 = userService.getUserByUser(user);
		System.out.println(user2);
		if (user2 != null) {
			request.getSession().setAttribute("user_id", user.getUser_id());
			return "redirect:/doc/list.do";
		} else {
			return "login";
		}
		
	}
	@RequestMapping(method = RequestMethod.GET,value = "/reg.do")
	public String reg() {
		return "reg";
	}
	@RequestMapping(method = RequestMethod.POST,value = "/reg.do")
	public String doReg(String user_name,String user_pwd,String user_pwd2,String user_yzm,HttpServletRequest request) {
		User user = new User(user_name, user_pwd, DateFormatUtil.getTimeString());
		userService.addUserByUser(user);
		
		return "/doc/list.do";
	}
}
