package controller;

import java.io.File;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import bean.FileDomain;
import domain.MultiFileDomain;

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
	public void singleFileUpload(FileDomain fileDomain, HttpServletRequest request,HttpServletResponse response){
		response.setContentType("application/json;charset=UTF-8");
		MultipartFile file = fileDomain.getFile();
		String realPath = request.getServletContext().getRealPath("uploadfiles");
		
		logger.debug("文件已上传成功--文件描述为"+fileDomain.getDescription());
		/*
		 * 获取文件自己本身文件名
		 */
		System.out.println("文件描述"+fileDomain.getDescription());
		String fileName = file.getOriginalFilename();
		File targetFile = new File(realPath,fileName);
		if(!targetFile.exists()){
			targetFile.mkdirs();
		try{
			file.transferTo(targetFile);
			logger.info("文件已上传成功");
			/**
			 * TODO  在这里添加有关上传文件的相关数据库操作  将文件的相对路径保存至数据库
			 */
			
		}catch(Exception e){
		 e.printStackTrace();
		}
		}
		try {
			response.getWriter().write("文件已上传成功");
		} catch (IOException e) {
			// 
			e.printStackTrace();
		}
	}
	@RequestMapping("ajax/multifile")
	public void multifileupload(MultiFileDomain multiFileDoamin, HttpServletRequest request,HttpServletResponse response){
		String realPath = request.getServletContext().getRealPath("uploadfiles");
		File targetDir = new File(realPath);
		if(!targetDir.exists()){
			targetDir.mkdir();
		}
		List<MultipartFile> files = (List<MultipartFile>) multiFileDoamin.getFiles();
		for(int i=0;i<files.size();i++){
			MultipartFile  file = files.get(i);
			String filename = file.getOriginalFilename();
			File targetFile = new File(realPath,filename);
			try{
				file.transferTo(targetFile);
			}catch(Exception e){
				e.printStackTrace();
			}
			logger.info("文件上传成功");
			StringBuffer buff = new StringBuffer("[");
			buff.append("{\"title\":"+"\"文件上传\",");
			buff.append("\"message\":"+"\"文件上传成功\"}]");
			System.out.println(buff.toString());
			try {
				response.getWriter().write(buff.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
