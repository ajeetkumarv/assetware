package com.assetware.servlet;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assetware.beans.User;
import com.assetware.service.MapAssetUserService;
import com.assetware.utils.ServletUtils;

/**
 * Servlet implementation class MapAssetUser
 */
@WebServlet("/DetachAssetUser")
public class DetachAssetUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetachAssetUser() {
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
	
		
		String empId = request.getParameter("empId");		
		String serialNo = request.getParameter("srNo");
		
		MapAssetUserService service = MapAssetUserService.getInstance();
		int rowsAffected = service.detachAssetUser(serialNo, empId, ServletUtils.getLoggedInUser(request), LocalDateTime.now());
		
		String msg = "Detached " + rowsAffected + " asset.";
		
		if (rowsAffected == 0) {
			msg = "No rows affected";
		} else if ( rowsAffected > 1) {
			msg = "Something unusual, " + rowsAffected + " rows updated";
		}
		
		response.getWriter().write("Detached " + serialNo + " from " + empId + " " + msg);
	}

}
