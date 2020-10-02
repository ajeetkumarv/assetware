package com.assetware.servlet;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assetware.beans.Asset;
import com.assetware.mapper.AssetToCsvConverter;
import com.assetware.service.AssetService;

/**
 * Servlet implementation class DownloadData
 */
@WebServlet("/DownloadData")
public class DownloadData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String downloadFileType = "csv";
		
		if ("excel".equalsIgnoreCase(request.getParameter("type"))) {
			downloadFileType = "excel";
		}
		
		response.setContentType("text/csv");
        response.setHeader("Content-disposition", "attachment; filename=" + getFileName());
        OutputStream outputStream = response.getOutputStream();
        
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        
        if (downloadFileType.equals("csv")) {
        	AssetToCsvConverter toCsvConverter = new AssetToCsvConverter(searchAssets(request), writer);
        	toCsvConverter.convert();
        } else if (downloadFileType.equals("excel")) {
        	
        }
        
	}

	private List<Asset> searchAssets(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		Asset assetSearchObj = (Asset) session.getAttribute("assetSearchObj");
		
		AssetService service = AssetService.getInstance();
        List<Asset> searchFoundAssets = service.simpleSearch(assetSearchObj);
        
        return searchFoundAssets;
	}
	
	private String getFileName() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter downloadDateTime = DateTimeFormatter.ofPattern("dd-MM-yyyy-hh-mm-a");
		return "Assets-"+ now.format(downloadDateTime) + ".csv";
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
