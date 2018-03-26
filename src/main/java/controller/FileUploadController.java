package controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.prism.impl.Disposer.Target;

import bean.FileDomain;

@Controller
public class FileUploadController {
	private static final Log logger = LogFactory.getLog(FileUploadController.class);
	
	@RequestMapping("uploadsinglefile")
	public void singleFileUpload(@ModelAttribute FileDomain fileDomain ,HttpServletRequest requset){
		String realPath = requset.getServletContext().getRealPath("uploadfiles");
		String fileName = fileDomain.getFile().getOriginalFilename();
		File targetFile = new File(realPath,fileName);
		if(!targetFile.exists()){
			targetFile.mkdirs();
		}
		
		try{
			fileDomain.getFile().transferTo(targetFile);
			logger.info("文件已上传成功");
		}catch(Exception e){
		 e.printStackTrace();
		}
	}
}
