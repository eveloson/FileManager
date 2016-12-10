package com.file.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.file.utils.ValidateCode;

@Controller
public class YZMController {
	
	@RequestMapping("getyzm.do")
	public void getYZM(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 // 设置响应的类型格式为图片格式  
        response.setContentType("image/jpeg");  
        //禁止图像缓存。  
        response.setHeader("Pragma", "no-cache");  
        response.setHeader("Cache-Control", "no-cache");  
        response.setDateHeader("Expires", 0);  
         
        //获取session
        HttpSession session = request.getSession();  
        //创建一个验证码对象 并传入尺寸等信息
        ValidateCode vCode = new ValidateCode(120,40,4,50);  
        //将验证码的值绑定到session会话对象上
        session.setAttribute("yzm", vCode.getCode()); 
        //向客户端写出图片流
        try {
			vCode.write(response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
