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
	alert(this.attr+"测试方法");
	
}

//方法
wsOperation.prototype.receiveOffLine = function(){
	
}

//方法
wsOperation.prototype.receiveOnLine = function(){
	
}

var a=new wsOperation("haha");
a.send("", "");
wsOperation.prototype.send=function(){
	alert("重写方法");
};
a.send("haha");