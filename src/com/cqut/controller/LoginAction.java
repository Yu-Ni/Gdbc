package com.cqut.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cqut.model.services.UserService;
import com.cqut.model.services.impl.UserServiceImpl;
import com.cqut.pojo.UserInfo;

@WebServlet("/loginAction")
public class LoginAction extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			UserService service = new UserServiceImpl();
			UserInfo userinfo = service.validate(username,password);
			if(userinfo!=null){
				HttpSession session = request.getSession();
				session.setAttribute("realname",userinfo.getRealname());
				request.setAttribute("name",username);
				request.getRequestDispatcher("searchAction").forward(request,response);
			}else{
				request.setAttribute("info","You entered the account wrong,please input again!");
				request.getRequestDispatcher("/index.jsp").forward(request,response);
			}
	}

}
