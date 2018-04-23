package com.relesee.toasthelper;

import com.relesee.services.RankLinesService;
import com.relesee.util.ToastUtil;
/**
 * 
 * @author jinfeng
 * 想前段发送错误json格式的助手类
 */
public class ToastHelper {
	private final static String error = "错误";
	private final static String errorColor = "red";
	private final static String success = "操作成功";
	private final static String successColor = "green";
	
	public static  String getErrorToastMessage(String message){
		return ToastUtil.getToast(error, message, errorColor);
	}
	public static String getSuccessToastMessage(String message){
		return ToastUtil.getToast(success, message, successColor);
	}
}
