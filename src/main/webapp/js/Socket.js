/**
 *   用于与后台进行socket通信
 */
var websocket;

//websocket = new WebSocket("ws://");

//声明wsOperation对象
//构造方法
function wsOperation(attr){
	this.attr=attr;
	
	//alert(attr+"构造方法");
}

//方法
wsOperation.prototype.send = function(sendto,content){
	$.ajax{
		url:"",
		data:{},
		async:false,method:"post",
		success:function(){
			
		}
	}
	
}

//方法
wsOperation.prototype.receiveOffLine = function(){
	
}

//方法
wsOperation.prototype.receiveOnLine = function(){
	
}

