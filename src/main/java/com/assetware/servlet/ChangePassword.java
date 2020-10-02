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
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(ChangePassword.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassword() {
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String newPass = request.getParameter("newPass");
		String repeatPass = request.getParameter("repeatNewPass");
		
		logger.debug(() -> username + " " + password);
		
		if (!(newPass!= null && repeatPass != null && newPass.equals(repeatPass))) {
			String msg = "failed. mismatch";
			response.sendRedirect("./ChangePassword?msg=" + URLEncoder.encode(msg, "UTF-8"));
		} else {
			AWUserService service = AWUserService.getInstance();
			int rowsAffected = service.changePassword(username, newPass);
			
			//logger.info(() -> "User:" + user);
			
			if (rowsAffected == 0) {
				String msg = "failed";
				response.sendRedirect("./ChangePassword?msg=" + URLEncoder.encode(msg, "UTF-8"));
			} 

			if (rowsAffected == 1){
				HttpSession session = request.getSession(true);
				session.invalidate();
				response.sendRedirect("./Login");
			}
		}
		
		
	}

}
