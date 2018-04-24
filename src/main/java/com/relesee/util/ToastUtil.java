package com.relesee.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * 
 * @author jinfeng
 * @version 1.0.0
 *	json的模板类
 */
public class ToastUtil {
	static StringBuffer info;
	public static String getToast(String title, String message, String color){
		//定义json模板的title
		final String textTitle_1 = "title";
		final String textTitle_2 = "message";
		final String textTitle_3 = "color";
		// json的title
		List<String> titleList = new ArrayList<String>();
		// json的message
		List<String> messageList = new ArrayList<String>();
		titleList.add(textTitle_1);
		titleList.add(textTitle_2);
		titleList.add(textTitle_3);
		messageList.add(title);
		messageList.add(message);
		messageList.add(color);
		return getToastModel(titleList,messageList);
	}
	/**
	 * 
	 * @param titleList json数据的titleList
	 * @param messageList json数据对应titleList所要的之
	 * @return null 返回null表示生成json失败，titleList与messgaList的长度不匹配 无法形成
	 * 		对应的消息
	 */
	public static String getToastModel(List<String> titleList, List<String> messageList){
		StringBuffer info = new StringBuffer("[");
		if(titleList.size() != messageList.size()){
			return null;
		}else{
			Iterator<String> titleIter = titleList.iterator();
			Iterator<String> messageIter = messageList.iterator();
			info.append("{");
			//同时遍历两个list中的内容，匹配取出来对应的内容
			while(titleIter.hasNext() && messageIter.hasNext()){
				String title = (String)titleIter.next();
				String message = (String)messageIter.next();
				//判断是否是最后字符
				if(titleIter.hasNext()){
					info.append("\""+title+"\":"+"\""+message+"\",");
				}else{
					info.append("\""+title+"\":"+"\""+message+"\"}");
				}
			}
			info.append("]");
		}
		return info.toString();
	}
}	
