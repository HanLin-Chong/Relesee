package com.relesee.bean;

public class FormParam {
	private String fieldName;
	private Object fieldValue;
	
	public FormParam(String fileName,Object object){
		this.fieldName = fileName;
		this.fieldValue  = object;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Object getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(Object fieldValue) {
		this.fieldValue = fieldValue;
	}
	
}	
