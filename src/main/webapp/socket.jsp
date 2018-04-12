 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'socket.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    This is my JSP page. <br>
  </body>
  <script>  
    var path = '<%=basePath%>';  
    path='localhost:8080/relesee/'
    var userId = 'lys';  
    if(userId==-1){  
        window.location.href="<%=basePath%>";  
    }  
    var jspCode = userId+"_AAA";  
    var websocket;  
    if ('WebSocket' in window) {  
        websocket = new WebSocket("ws://" + path + "wsMy?jspCode=" + jspCode);  
    } else if ('MozWebSocket' in window) {  
        websocket = new MozWebSocket("ws://" + path + "wsMy?jspCode=" + jspCode);  
    } else {  
        websocket = new SockJS("http://" + path + "wsMy/sockjs?jspCode=" + jspCode);  
    }  
    websocket.onopen = function(event) {  
        console.log("WebSocket:已连接");  
        console.log(event);  
    };  
    websocket.onmessage = function(event) {  
        var data = event.data;  
        console.log("WebSocket:收到一条消息-norm", data);  
        alert("WebSocket:收到一条消息"+data);  
    };  
    websocket.onerror = function(event) {  
        console.log("WebSocket:发生错误 ");  
        console.log(event);  
    };  
    websocket.onclose = function(event) {  
        console.log("WebSocket:已关闭");  
        console.log(event);  
    }  
</script>  
  
</html>
