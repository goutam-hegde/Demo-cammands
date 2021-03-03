package com.mindtree.ajaxandservletcodechallenge.Servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mindtree.ajaxandservletcodechallenge.service.Service;
import com.mindtree.ajaxandservletcodechallenge.service.ServiceImpl;

public class ApiResponseServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ApiResponseServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		doGet(request, response);

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		String json = request.getParameter("data");

		Service logic = new ServiceImpl();

		String responseMessage = logic.parseJsonData(json);

		if (responseMessage.equals("success")) {
			response.getWriter().write("success!!! data added to database");
		} else {
			response.getWriter().write("failure. Could not add data to database");
		}

	}

}
