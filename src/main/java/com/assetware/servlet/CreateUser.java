package com.assetware.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assetware.beans.User;
import com.assetware.exception.UserDetailExistException;
import com.assetware.service.UserService;
import com.assetware.utils.ServletUtils;

/**
 * Servlet implementation class CreateUser
 */
@WebServlet("/CreateUser")
public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User user = ServletUtils.getUserInfoFromRequest(request);
		//user.setCreated_by("System");
		
		UserService userService = UserService.getInstance();
		try {
			userService.create(user);
			request.setAttribute("msg", "User created successfully");
		} catch (UserDetailExistException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/").forward(request, response);
		
	}

}
