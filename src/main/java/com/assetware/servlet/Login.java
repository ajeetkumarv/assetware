package com.assetware.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.assetware.beans.AWUser;
import com.assetware.service.AWUserService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LogManager.getLogger(Login.class);
       
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		logger.debug(() -> username + " " + password);
		
		AWUserService service = AWUserService.getInstance();
		AWUser user = service.login(username, password);
		
		logger.info(() -> "User:" + user);
		
		if (user == null) {
			String msg = "failed";
			response.sendRedirect("./Login?msg=" + URLEncoder.encode(msg, "UTF-8"));
		} else {
			HttpSession session = request.getSession(true);
			session.setMaxInactiveInterval(10*60);
			session.setAttribute("user", user);
			response.sendRedirect("./index.jsp");
		}
	}

}
