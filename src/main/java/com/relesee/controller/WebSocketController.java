package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.TextMessage;

import websocket.MyWebSocketHandler;

@Controller
@RequestMapping()
public class WebSocketController {
	private final org.apache.commons.logging.Log logger =LogFactory.getLog(WebSocketController.class);
	@Autowired private MyWebSocketHandler myWebSocketHandler;
	@RequestMapping("/test")
	public void sendMessage(HttpServletResponse resp){
		TextMessage message = new TextMessage("This is a test");
		try {
			logger.info("webSocket send message"+message.toString());
			myWebSocketHandler.sendMessageToTarget(message,"MSID_0000005");
			resp.getWriter().write(message.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
