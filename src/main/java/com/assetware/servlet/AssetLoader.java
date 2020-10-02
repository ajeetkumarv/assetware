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

import com.assetware.beans.Asset;
import com.assetware.beans.AssetUserMapData;
import com.assetware.beans.Change;
import com.assetware.service.AssetService;
import com.assetware.service.ChangeDetector;
import com.assetware.service.MapAssetUserService;
import com.assetware.utils.AppUtils;

/**
 * Servlet implementation class CreateAssetLoader
 */
@WebServlet("/AssetLoader")
public class AssetLoader extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(AssetLoader.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssetLoader() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AssetService assetService = AssetService.getInstance();
		
		List<String> assetTypes = assetService.getAssetTypes();
		List<String> assetStatuses = assetService.getAssetStatuses();
		List<String> departments = assetService.getDepartments();
		List<String> os = assetService.getOs();
		
		request.setAttribute("assetTypes", assetTypes);
		request.setAttribute("assetStatuses", assetStatuses);
		request.setAttribute("departments", departments);
		request.setAttribute("os", os);
		
		String srNo = request.getParameter("srNo");
		
		if (srNo != null) {
			Asset assetSearchObj = new Asset();
			assetSearchObj.setSerialNo(srNo);
			
			AssetService as = AssetService.getInstance();
			List<Asset> foundAsset = as.simpleSearch(assetSearchObj);
			
			if (!foundAsset.isEmpty()) {
				Asset asset = foundAsset.get(0);
				String assetHash = AppUtils.checksum(asset);
				List<Asset> assetHistory = as.simpleSearchAudit(assetSearchObj);
				
				ChangeDetector changeDetector = new ChangeDetector(assetHistory, asset);
				List<Change> changeData = changeDetector.extractChanges();
				MapAssetUserService mapAssetUserService = MapAssetUserService.getInstance();
				List<AssetUserMapData> userHistory = mapAssetUserService.getUserHistory(srNo);
				
				request.setAttribute("a", asset);
				request.setAttribute("ah", assetHistory);
				request.setAttribute("changeData", changeData);
				request.setAttribute("assetHash", assetHash);
				request.setAttribute("userHis", userHistory);
				
				request.getRequestDispatcher("assetDetails.jsp").forward(request, response);
			} else {
				logger.warn(() -> "No asset with serial no: " + srNo);
				request.setAttribute("msg", "No asset with serial no: " + srNo);
				request.getRequestDispatcher("simpleSearch.jsp").forward(request, response);;
			}
		} else {
			request.getRequestDispatcher("assetDetails.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
