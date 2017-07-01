package com.cqut.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.cqut.model.services.UserService;
import com.cqut.model.services.impl.UserServiceImpl;
import com.cqut.pojo.UserInfo;

@WebServlet("/registeerAction")
public class RegisterAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String realname = request.getParameter("realname");
		UserInfo userinfo = new UserInfo(username,password,realname);
		UserService service = new UserServiceImpl();
		int result = service.registerUser(userinfo);
		if(result>0){
			response.sendRedirect("./index.jsp");
		}else{
			request.setAttribute("info","Register fail,please operator again!");
			request.getRequestDispatcher("/index.jsp").forward(request,response);
		}
	}

}
