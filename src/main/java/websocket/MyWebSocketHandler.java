package websocket;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Timer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import bean.User;

@Component
public class MyWebSocketHandler implements WebSocketHandler{
	private final Log logger = LogFactory.getLog(MyWebSocketHandler.class);
	
	//用户保存用户对应session连接状态map
	public static final Map<String, WebSocketSession> userSocketSessionMap;
	
	static{
		userSocketSessionMap = new HashMap<String, WebSocketSession>();
	}
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		String userid =(String)session.getHandshakeAttributes().get("jspCode");
		/*
		 * 当用户登录时时，将用户的id与session记录下来，用作之后的通信
		 */
		System.out.println(userid);
		if(userSocketSessionMap.get(userid)== null){
			userSocketSessionMap.put(userid, session);
		}	
		TextMessage message=new TextMessage("Helllo This is a Test");
		this.handleMessage(session, message);
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		session.sendMessage(message);
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
			if(session.isOpen()){
				session.close();
			}
			Iterator<Entry<String, WebSocketSession>> is  = userSocketSessionMap.entrySet().iterator();
			while(is.hasNext()){
				Entry<String, WebSocketSession> entry =is.next();
				userSocketSessionMap.remove(entry.getKey());
				System.out.println("Socket回话已被移除"+entry.getKey());
				break;
			}
		
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.web.socket.WebSocketHandler#afterConnectionClosed(org.springframework.web.socket.WebSocketSession, org.springframework.web.socket.CloseStatus)
	 *	 当连接被关闭时，将用户的信息与session移除
	 */
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		System.out.println("WebSocket:"+session.getId()+"被关闭");
		Iterator<Entry<String, WebSocketSession>> it = userSocketSessionMap.entrySet().iterator();
		while(it.hasNext()){
			  Entry<String, WebSocketSession> entry =it.next();
			  userSocketSessionMap.remove(entry.getKey());  
              System.out.println("Socket会话已经移除:用户ID" + entry.getKey());  
              break;  
		}
	}

	@Override
	public boolean supportsPartialMessages() {

		return false;
	}
	
	/**
	 * 
	 */
	
	public void broadcast(final TextMessage message, String type) throws IOException{
		Iterator<Entry<String, WebSocketSession>> iter = userSocketSessionMap.entrySet().iterator();
		/*
		 * 开启多线程，向各个用户发送消息
		 */
		while(iter.hasNext()){
			final Entry<String, WebSocketSession> entry = iter.next();
			if(entry.getValue().isOpen() && entry.getKey().contains(type)){
				new Thread(new Runnable(){
					public void run(){
						try{
							entry.getValue().sendMessage(message);
						}catch(IOException e){
							e.printStackTrace();
						}
					}
				}).start();
			}
		}
	}
	/*
	 * 向指定的用户发送webSocket消息
	 * TODO 待补充消息的后台处理流程，包括发送消息的记录，无论发送成功与否
	 */
	public void sendMessageToTarget(final TextMessage message,String userid){
		if(userSocketSessionMap.containsKey(userid)){
			logger.info(message.toString()+" 消息已被转发至-->"+userid);
			WebSocketSession session = userSocketSessionMap.get(userid);
			try {

				session.sendMessage(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			logger.info("当前用户不在线，消息被搁置");
		}
	
	}
	
	public void sendMessageToJsp(final TextMessage message, String type) throws IOException{
		Iterator<Entry<String, WebSocketSession>> iter = userSocketSessionMap.entrySet().iterator();
		while(iter.hasNext()){	
			final Entry<String, WebSocketSession> entry = iter.next();
			if(entry.getValue().isOpen()){
				new Thread(new Runnable(){
					public void run(){
						try{
							if(entry.getValue().isOpen()){
								logger.info("向"+entry.getKey()+"发送消息");
								entry.getValue().sendMessage(message);
							}
						}catch(IOException e){
							e.printStackTrace();
						}
					}
					
				}).start();
			}
		}
	}
}
