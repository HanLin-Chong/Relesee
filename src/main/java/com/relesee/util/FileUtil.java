package com.relesee.util;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 文件操作工具类
 *
 * @author JinFeng
 * @since 1.0.0
 */
public final class FileUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileUtil.class);

    /**
     * 获取真实文件名（自动去掉文件路径）
     */
    public static String getRealFileName(String fileName) {
        return FilenameUtils.getName(fileName);
    }

    /**
     * 创建文件
     */
    public static File createFile(String filePath) {
        File file;
        try {
            file = new File(filePath);
            File parentDir = file.getParentFile();
            if (!parentDir.exists()) {
                FileUtils.forceMkdir(parentDir);
            }
        } catch (Exception e) {
            LOGGER.error("create file failure", e);
            throw new RuntimeException(e);
        }
        return file;
    }
    
    /**
     *
     * @param filePath 要删除文件的路径
     * @return 删除成功返回true，失败返回false
     */
    public static boolean deleteFile(String filePath){
    	boolean flag = false;
    	File file = new File(filePath);
    	//判断文件是否存在，是否是文件类型
    	if(file.isFile()&& file.exists()){
    		file.delete();
    		flag = true;
    	}else{
    		flag = false;
    	}
    	return flag;
    }
}
