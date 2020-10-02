package com.assetware.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import com.assetware.beans.Asset;
import com.assetware.service.AssetService;
import com.assetware.utils.AppUtils;
import com.assetware.utils.ServletUtils;

import static com.assetware.utils.ServletUtils.getLoggedInUser;

/**
 * Servlet implementation class CreateAsset
 */
@WebServlet("/SaveAsset")
@MultipartConfig
public class SaveAsset extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final Logger logger = LogManager.getLogger(SaveAsset.class);
	
    public SaveAsset() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Asset asset = ServletUtils.getAssetInfoFromRequest(request).getValue0();
		String currentRequestAssetChecksum = AppUtils.checksum(asset);
		String savedChecksum = (String) request.getParameter("assetHash");
		
		logger.info(() -> currentRequestAssetChecksum + " " + savedChecksum);
		System.out.println(currentRequestAssetChecksum + " from page: \n" + savedChecksum);
		
		String msg = savedChecksum == null ? "Asset created successfully" : "Asset updated successfully";
		
		boolean formDataNew = true;
		
		if ("".contentEquals(savedChecksum)) {
			formDataNew = true;
		} else if (!currentRequestAssetChecksum.equalsIgnoreCase(savedChecksum)) {
			formDataNew = false;
			asset.setUpdatedOn(LocalDateTime.now());
		}
		
		asset.setCreatedBy(getLoggedInUser(request));
		asset.setUpdatedBy(getLoggedInUser(request));
		List<String> filenames = saveAttachments(asset.getSerialNo(), request);
		asset.setAttachmentFileNames(filenames);
		
		AssetService assetService = AssetService.getInstance();
		assetService.create(asset, formDataNew);
		
		request.setAttribute("msg", msg);
		
		request.getRequestDispatcher("/").forward(request, response);
		
	}
	
	private List<String> saveAttachments(String srNo, HttpServletRequest request) throws IOException, ServletException {
		//Get all the parts from request and write it to the file on server
		
		//String baseLocation="/Users/ajeet/Programmer/Workspace/AssetwareFiles";
		String baseLocation = getServletContext().getInitParameter("attachment_dir");
		
		String location = null;
		File fileSaveDir = new File(baseLocation + "/" + srNo);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }
        
        location = fileSaveDir.getAbsolutePath();
		
		List<Part> fileParts = request.getParts().stream()
				.filter(part -> "filename".equals(part.getName()))
				.collect(Collectors.toList()); // Retrieves <input type="file" name="file" multiple="true">
		List<String> filenames = new ArrayList<>();
		for (Part filePart : fileParts) {
			String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
			
			if("".equals(fileName)) {
				continue;
			}
			
			InputStream fileContent = filePart.getInputStream();

			File targetFile = new File(location + "/" + fileName);

			java.nio.file.Files.copy(fileContent, targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

			IOUtils.closeQuietly(fileContent);
			
			filenames.add(fileName);

		}
		
		return filenames;
	}

}
