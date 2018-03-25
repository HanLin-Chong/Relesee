package bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.CastUtil;
import util.CollectionUtil;
import util.StringUtil;
/*
 * 请求参数的对象
 */

public class Param {
	private List<FormParam> formParamList;
	private List<FileParam> fileParamList;
	
	public Param(List<FormParam> formParaList){
		this.formParamList = formParaList;
	}
	public Param(List<FormParam> formParamList, List<FileParam> fileParamList){
		this.formParamList = formParamList;
		this.fileParamList = fileParamList;
	}
	/*
	 * 获取请求参数的映射
	 */
	
	public Map<String , Object> getFieldMap(){
		Map<String,Object> fieldMap = new HashMap<String, Object>();
		if(CollectionUtil.isNotEmpty(formParamList)){
			for(FormParam formParam:formParamList){
				String fileName = formParam.getFieldName();
				Object fieldValue = formParam.getFieldValue();
				if(fieldMap.containsKey(fileName)){
					fieldValue = fieldMap.get(fileName) + StringUtil.SEPARATOR+fieldValue;
				}
				fieldMap.put(fileName, fieldValue);
			}
		}
		return fieldMap;
	}
	/*
	 * 获取上床文件的映射
	 */
	public Map<String, List<FileParam>> getFileMap(){
		Map<String, List<FileParam>> fileMap = new HashMap<String, List<FileParam>>();
		if(CollectionUtil.isNotEmpty(fileParamList)){
			for(FileParam fileParam : fileParamList){
				String fieldName = fileParam.getFieldName();
				List<FileParam> fileParamList;
				if(fileMap.containsKey(fieldName)){
					fileParamList = fileMap.get(fieldName);
				}else{
					fileParamList = new ArrayList<FileParam>();
				}
				fileParamList.add(fileParam);
				fileMap.put(fieldName,fileParamList);
			}		
		}
		return fileMap;
	}
	/*
	 * 获取所有的上传文件
	 */
	
	public List<FileParam> getFileList(String fileName){
		return this.getFileMap().get(fileName);
	}
	
	/*
	 *   获取唯一上传的文件
	 */
 	
	public FileParam getFile(String fieldName){
		List<FileParam> fileParamList = getFileList(fieldName);
		if(CollectionUtil.isEmpty(fileParamList) && fileParamList.size() == 1){
			return fileParamList.get(0);
		}
		return null;
		
	}
	/**
	 * 根据请求参数获取int类型的值
	 * @return
	 */
	public  boolean isEmpty(){
		return  CollectionUtil.isEmpty(formParamList) && CollectionUtil.isEmpty(fileParamList);
	}
	/*
	 *根据请求的参数名 获取doublel类型的参数值
	 *
	 */
	
	public double getDouble(String name){
		return CastUtil.castDouble(getFieldMap().get(name));
	}
	/**
	 * 根据参数名获取long型类型的参数
	 */
	
	public long getLong(String name){
		return CastUtil.castLong(getFieldMap().get(name));
	}
	public int getInt(String name){
		return CastUtil.castInt(getFieldMap().get(name));
	}
	/**
	 * 根据请求的参数获取Int类型 的值 
	 * @param name
	 * @return
	 */
	public boolean getBoolean(String name){
		return CastUtil.castBoolean(getFieldMap().get(name));
		
	}
}

