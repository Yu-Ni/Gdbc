package com.cqut.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cqut.model.services.UserService;
import com.cqut.model.services.impl.UserServiceImpl;
import com.cqut.pojo.UserInfo;

@WebServlet("/searchAction")
public class SearchAction extends HttpServlet {
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String input=request.getParameter("input");
		UserService service = new UserServiceImpl();
		if(input == null){
			input = "";
		}
		List<UserInfo> list = service.queryStudents(input);
		if(list.size()>0){
			request.setAttribute("list",list);
		}
		
		request.getRequestDispatcher("/success.jsp").forward(request,response);
	}
}
