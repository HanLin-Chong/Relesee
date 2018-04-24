package com.relesee.controller;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.relesee.contant.Contant;
import com.relesee.toasthelper.ToastHelper;


/**
 * 
 * @author jinfeng
 * @since 2018.4.23
 * 文件下载的控制器
 *
 */
@Controller
@RequestMapping("/load")
public class DownloadController {
	
	private String FILE_BASE_URL = Contant.FILE_BASE_RUL;
	
	private Log logger = LogFactory.getLog(DownloadController.class);
	/**
	 * 
	 * @param req req param 需要文件的文件名
	 * @param resp
	 * @throws IOException 
	 */
	@RequestMapping("/download")
	public void DownLoad(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		String fileName = req.getParameter("filename");
		//文件的真实路径
		String realPath = req.getServletContext().getRealPath("uploadfiles");
		//获取文件
		String filePath = realPath+"//"+fileName;
		resp.setCharacterEncoding("utf-8");
		File file = new File(filePath);
		int fileLength = (int) file.length();
		logger.info("文件路径"+filePath);
		InputStream in = null;
		OutputStream out = null;
		
		//判断文件是否存在
		if(fileLength!=0){
			resp.setContentType("application/force-download");
			resp.addHeader("Content-Disposition", "attachment;fileName="
					+new String(fileName.getBytes("utf-8"), "ISO8859-1"));
			try{
				// 打开文件的下载流
				in = new FileInputStream(filePath);
				out = resp.getOutputStream();
				byte[] b = new byte[2048];
				int length;
				//循环写入输出
				while((length = in.read(b)) > 0){
					out.write(b,0,length);
				}
				out.close();
				in.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}else{
		//TODO 在这里写找不到文件的具体操作
		resp.getWriter().write(ToastHelper.getErrorToastMessage("文件不存在"));
		logger.debug("找不到文件");
	}
}
		
}
