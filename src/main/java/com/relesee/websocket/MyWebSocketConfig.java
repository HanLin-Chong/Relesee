package com.relesee.websocket;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Component
@EnableWebMvc
@EnableWebSocket
public class MyWebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer{

		@Resource
		MyWebSocketHandler handler;
		@Override
		public void registerWebSocketHandlers(WebSocketHandlerRegistry registry){
			System.out.println("注册WebSocet");
		     registry.addHandler(handler, "/wsMy").addInterceptors(new HandShake());  
		     registry.addHandler(handler, "/wsMy/sockjs").addInterceptors(new HandShake()).withSockJS();  
		}
}
