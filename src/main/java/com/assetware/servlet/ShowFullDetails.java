package com.assetware.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assetware.beans.Asset;
import com.assetware.service.AssetService;

/**
 * Servlet implementation class ShowFullDetails
 */
@WebServlet("/ShowFullDetails")
public class ShowFullDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowFullDetails() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String serialNo = request.getParameter("serialNo");
		
		Asset asset = new Asset();
		asset.setSerialNo(serialNo);
		
		AssetService service = AssetService.getInstance();
		
		List<Asset> assetFound = service.simpleSearch(asset);
		List<Asset> assetAudit = service.getAudits(serialNo);
		
		if(assetFound != null && !assetFound.isEmpty()) {
			request.setAttribute("assets", assetFound);
		}
		
		if(assetAudit != null && !assetAudit.isEmpty()) {
			request.setAttribute("assetAudits", assetAudit);
		}
		
		
		request.getRequestDispatcher("fullDetails.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
