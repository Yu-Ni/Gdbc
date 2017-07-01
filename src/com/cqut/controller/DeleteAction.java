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

@WebServlet("/deleteAction")
public class DeleteAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userid = request.getParameter("userid");
		UserService service = new UserServiceImpl();
		int result = service.deleteUserById(userid);
		if(result==0){
			request.setAttribute("info","Delete user fail!");
		}
		request.getRequestDispatcher("searchAction").forward(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
