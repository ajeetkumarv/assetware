package com.assetware.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FetchImage
 */
@WebServlet("/FetchImage")
public class FetchImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchImage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	//String baseLocation="/Users/ajeet/Programmer/Workspace/AssetwareFiles";
    	String baseLocation=getServletContext().getInitParameter("attachment_dir");

    	ServletContext cntx= request.getServletContext();
    	String filename = request.getParameter("file");          
    	String srNo = request.getParameter("sr");          
    	String mime = cntx.getMimeType(filename);
    	if (mime == null) {
    		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    		return;
    	}

    	response.setContentType(mime);
    	File file =  new File(baseLocation + "/" + srNo + "/" +filename);
    	response.setContentLength((int)file.length());
    	FileInputStream fis = new FileInputStream(file);
    	BufferedInputStream bis = new BufferedInputStream(fis);             
    	BufferedOutputStream output = new BufferedOutputStream(response.getOutputStream());
    	for (int data; (data = bis.read()) > -1;) {
    		output.write(data);
    	}      
    	output.close();
    	bis.close();
    	fis.close();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
