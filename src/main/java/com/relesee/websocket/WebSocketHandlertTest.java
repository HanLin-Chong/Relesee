package com.relesee.websocket;

import java.util.Map;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.server.HandshakeInterceptor;

public class WebSocketHandlertTest implements HandshakeInterceptor{

	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
			org.springframework.web.socket.WebSocketHandler wsHandler, Map<String, Object> attributes)
					throws Exception {
		String jspCode = ((ServletServerHttpRequest) request).getServletRequest().getParameter("userid");
	//获取jsp页面的标识，标记指定的用户	
		if(jspCode!=null){
			attributes.put("jspCode", jspCode);
		}else{
			return false;
		}
		return true;
	}

	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response,
			org.springframework.web.socket.WebSocketHandler wsHandler, Exception exception) {
			
	}


}
