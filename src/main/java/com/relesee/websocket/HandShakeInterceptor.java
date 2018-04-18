package websocket;

import java.util.Map;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

public class HandShakeInterceptor extends HttpSessionHandshakeInterceptor{

	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse resp,WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception{
			System.out.println("this is before shake");
			return super.beforeHandshake(request, resp, wsHandler, attributes);
	}
	
	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse resp, WebSocketHandler wsHandler, Exception ex){
		System.out.println("This is after Handshake");
		super.afterHandshake(request, resp, wsHandler,ex);
	}
}
