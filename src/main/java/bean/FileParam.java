package bean;

import java.io.InputStream;

public class FileParam {
	/*
	 * 封装文件的参数
	 */
	
	private String fieldName;
	private String fileName;
	private long fileSize;
	private String contentnType;
	private InputStream inputStream;
	
	public FileParam(String fieldName,String fileName,long fileSize,String contentType, InputStream inputStream){
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.contentnType = contentType;
		this.inputStream = inputStream;
		this.fieldName = fieldName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getContentnType() {
		return contentnType;
	}

	public void setContentnType(String contentnType) {
		this.contentnType = contentnType;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
}
