package com.assetware.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.assetware.constant.AppConstant;
import com.assetware.service.AssetService;

/**
 * Servlet implementation class SearchAssetLoader
 */
@WebServlet("/SearchAssetLoader")
public class SearchAssetLoader extends HttpServlet {
	
	private static final Logger logger = LogManager.getLogger(SearchAssetLoader.class);
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAssetLoader() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AssetService assetService = AssetService.getInstance();
		List<String> assetTypes = assetService.getAssetTypes();
		List<String> assetStatuses = assetService.getAssetStatuses();
		List<String> os = assetService.getOs();
		
		request.setAttribute("assetTypes", assetTypes);
		request.setAttribute("assetStatuses", assetStatuses);
		request.setAttribute("os", os);
		
		String searchType=request.getParameter(AppConstant.SEARCH_TYPE);
		
		String jspPage = "simpleSearch.jsp";
		
		logger.info("debug Search Type: {}",() -> searchType);
		
		if("advance".equalsIgnoreCase(searchType)) {
			jspPage = "advanceSearch.jsp";
		}
		
		request.getRequestDispatcher(jspPage).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
