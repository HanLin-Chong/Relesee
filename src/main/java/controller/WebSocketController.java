package controller;

import java.io.IOException;

import org.apache.commons.logging.LogFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.TextMessage;

import websocket.MyWebSocketHandler;

@Controller
@RequestMapping()
public class WebSocketController {
	private final org.apache.commons.logging.Log logger =LogFactory.getLog(WebSocketController.class);
	  @Bean//这个注解会从Spring容器拿出Bean
	    public MyWebSocketHandler myWebSocketHandler() {
	        return new MyWebSocketHandler();
	    }	
	
	@RequestMapping("/test")
	public String sendMessage(){
		TextMessage message = new TextMessage("This is a test");
		try {
			logger.debug("webSocket send message"+message.toString());
			myWebSocketHandler().sendMessageToJsp(message,"" );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "socket.jsp";
	}
}
