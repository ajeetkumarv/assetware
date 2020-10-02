package com.assetware.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.javatuples.Pair;

import com.assetware.beans.Asset;
import com.assetware.service.AssetService;
import com.assetware.utils.ServletUtils;

/**
 * Servlet implementation class SearchAsset
 */
@WebServlet("/SearchAsset")
public class SearchAsset extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAsset() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String searchType=request.getParameter("searchType");
		Boolean newSearch = Boolean.valueOf(request.getParameter("newSearch"));
		
		HttpSession session = request.getSession(true);
		
		if (newSearch) {
			session.removeAttribute("assetSearchObj");
		}
		
		Asset asset = (Asset) session.getAttribute("assetSearchObj");
		
		List<Asset> assets = new ArrayList<>();
		
		if(asset == null) {
			// no search criteria available already in session
			session = request.getSession(true);
			
			Pair<Integer, Integer> page = getPaginationParameters(request);
			Pair<Asset, Map<String, String>> reqToObj = ServletUtils.getAssetInfoFromRequest(request);
			asset = reqToObj.getValue0();
		
			AssetService service = AssetService.getInstance();
			System.out.println("Page Id" + page.getValue0() + " " + page.getValue1());
			assets = service.simpleSearch(asset, page.getValue0(), page.getValue1());
			Integer totalRows = service.getTotalRowsInSearch(asset);
			
			session.setAttribute("assetSearchObj", asset);
			session.setAttribute("totalRows", totalRows);
			
			request.setAttribute("pageId", page.getValue0());
			request.setAttribute("recordsAtTime", page.getValue1());
			request.setAttribute("totalRows", totalRows);
			session.setAttribute("totalPages", Integer.valueOf(totalRows/page.getValue1())+1);
			session.setAttribute("searchCriteria", reqToObj.getValue1());
			
		} else {
			// search continuation for pagination
			Pair<Integer, Integer> page = getPaginationParameters(request);
			
			AssetService service = AssetService.getInstance();
			assets = service.simpleSearch(asset, page.getValue0(), page.getValue1());
			
			request.setAttribute("pageId", page.getValue0());
			request.setAttribute("recordsAtTime", page.getValue1());
			request.setAttribute("totalPages", session.getAttribute("totalPages"));
		}
		
		request.setAttribute("assets", assets);
		
		request.getRequestDispatcher("searchResult.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private Pair<Integer, Integer> getPaginationParameters(HttpServletRequest request) {
		Pair<Integer, Integer> pagination = new Pair<>(1, 10);
		
		try {
			Integer p1 = Integer.parseInt(request.getParameter("pageId"));
			Integer p2 = Integer.parseInt(request.getParameter("records"));
			
			pagination = new Pair<>(p1, p2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return pagination;
	}
	
	/* private static class Pair<T, U> {
		T p1;
		U p2;
		public Pair(T p1, U p2) {
			super();
			this.p1 = p1;
			this.p2 = p2;
		}
		
		
	} */
		
}
