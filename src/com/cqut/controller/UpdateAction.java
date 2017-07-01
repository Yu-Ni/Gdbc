package com.cqut.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cqut.model.services.UserService;
import com.cqut.model.services.impl.UserServiceImpl;
import com.cqut.pojo.UserInfo;
import com.cqut.util.MD5;

@WebServlet("/updateAction")
public class UpdateAction extends HttpServlet {
	
	private static UserService service = new UserServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userid = request.getParameter("userid");
		UserInfo userinfo = service.getUserById(userid);
		if(userinfo != null){
			request.setAttribute("userinfo",userinfo);
			request.getRequestDispatcher("/update.jsp").forward(request,response);
		}else{
			request.setAttribute("info","No Found!");
			request.getRequestDispatcher("/success.jsp").forward(request,response);
		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("userid");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String realname = request.getParameter("realname");
		password = MD5.getMD5(password);
		
		UserInfo userinfo = new UserInfo(userid,username,password,realname);
		int result = service.updateUserInfo(userinfo);
		if(result==0){
			request.setAttribute("info","Update fail!");
		}
		
		request.getRequestDispatcher("/searchAction").forward(request,response);
	}

}
