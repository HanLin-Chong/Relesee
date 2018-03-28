package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author JinFeng
 * 此Controller为文件上传的控制器，文件上传统一使用这个控制器，其中的，同时都在upload下，ajax为异步请求的上传方式
 */
@Controller
@RequestMapping("upload/")
public class FileUploadController {
	private static final Log logger = LogFactory.getLog(FileUploadController.class);
	@RequestMapping("ajax/singlefile")
	/*
	 * 使用ContentType为返回的数据进行编码的处理，防止出现乱码
	 */
	public void singleFileUpload(@RequestParam("file")  MultipartFile file ,HttpServletRequest request,HttpServletResponse response){
		response.setContentType("application/json;charset=UTF-8");
		String filename = request.getParameter("description");
		System.out.print("文件描述"+filename);
		String realPath = request.getServletContext().getRealPath("uploadfiles");
	
		/*
		 * 获取文件自己本身文件名
		 */
		String fileName = file.getOriginalFilename();
		File targetFile = new File(realPath,fileName);
		if(!targetFile.exists()){
			targetFile.mkdirs();
		try{
			file.transferTo(targetFile);
			logger.info("文件已上传成功");
		}catch(Exception e){
		 e.printStackTrace();
		}
		}
		try {
			response.getWriter().write("文件已上传成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
