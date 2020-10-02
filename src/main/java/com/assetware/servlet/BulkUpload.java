package com.assetware.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.assetware.beans.Asset;
import com.assetware.service.AssetService;
import com.assetware.service.BulkUploadService;
import com.assetware.utils.ServletUtils;

/**
 * Servlet implementation class BulkUpload
 */
@WebServlet("/BulkUpload")
@MultipartConfig
public class BulkUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BulkUpload() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Asset> assets = new ArrayList<>();
		List<Part> fileParts = request.getParts().stream()
				.filter(part -> "files".equals(part.getName()))
				.collect(Collectors.toList()); // Retrieves <input type="file" name="file" multiple="true">
		List<String> filenames = new ArrayList<>();
		for (Part filePart : fileParts) {
			String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
			
			if("".equals(fileName)) {
				continue;
			}
			
			InputStream fileContent = filePart.getInputStream();

			filenames.add(fileName);

			if (fileName.endsWith("csv") || fileName.endsWith("CSV")) {
				assets = new BulkUploadService().csvToBean(fileContent);
			}
			
			assets.forEach(a -> {
				a.setCreatedBy(ServletUtils.getLoggedInUser(request));
				a.setRemark("Uploaded from file: " + fileName);
			});
			
		}
		
		AssetService service = AssetService.getInstance();
		try {
			service.create(assets);
			request.setAttribute("msg", "Assets upoaded successfully");
		} catch( Exception e) {
			request.setAttribute("msg", "Upload failed. Error: " + e.getMessage());
		}
		request.getRequestDispatcher("/upload.jsp").forward(request, response);
	}
	
	/* public List<Asset> beanBuilder(InputStream fileContent) {
	     CsvTransfer csvTransfer = new CsvTransfer();
	     ColumnPositionMappingStrategy ms = new ColumnPositionMappingStrategy();
	     ms.setType(Asset.class);
	 
	     Reader reader = new InputStreamReader(fileContent, "UTF-8");
	     
	     CsvToBean cb = new CsvToBeanBuilder(reader)
	       .withType(Asset.class)
	       .withMappingStrategy(ms)
	       .build();
	 
	    csvTransfer.setCsvList(cb.parse());
	    reader.close();
	    return csvTransfer.getCsvList();
	} */
	
	private List<Asset> readCsv(InputStream is) throws UnsupportedEncodingException {
		List<Asset> assets = new ArrayList<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
		
		List<String> assetLines = br.lines().filter(r-> !(r.isBlank() || r.isBlank())).collect(Collectors.toList());

		assetLines.stream().forEach(r -> System.out.println(r));
		System.out.println("-----");
		return assets;
	}

}
