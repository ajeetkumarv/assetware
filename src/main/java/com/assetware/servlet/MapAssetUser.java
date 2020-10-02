package com.assetware.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assetware.beans.User;
import com.assetware.exception.UserDetailExistException;
import com.assetware.service.MapAssetUserService;
import com.assetware.service.UserService;
import com.assetware.utils.ServletUtils;

/**
 * Servlet implementation class MapAssetUser
 */
@WebServlet("/MapAssetUser")
public class MapAssetUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MapAssetUser() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String loggedInUser = ServletUtils.getLoggedInUser(request);
		
		User user = ServletUtils.getUserInfoFromRequest(request);
		user.setCreatedBy(loggedInUser);
		
		String serialNo = request.getParameter("srNo");
		
		MapAssetUserService service = MapAssetUserService.getInstance();
		service.mapAssetUser(serialNo, user.getEmpId(), loggedInUser);
		
		UserService userService = UserService.getInstance();
		try {
			userService.create(user);
		} catch (UserDetailExistException e) {
			e.printStackTrace();
		}
		
		response.getWriter().write("Mapped " + serialNo + " to " + user.getEmpId());
	}

}
