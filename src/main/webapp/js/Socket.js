/**
 *   用于与后台进行socket通信
 */


//websocket = new WebSocket("ws://");

//声明wsOperation对象
//构造方法
function wsOperation(path,userId){
	//this.attr=attr;
	//this.websocket = new WebSocket(path);
	//alert(attr+"构造方法");

    if ('WebSocket' in window) {  
        this.websocket = new WebSocket("ws://" + path + "wsMy?jspCode=" +userId);  
    } else if ('MozWebSocket' in window) {  
        this.websocket = new MozWebSocket("ws://" + path +  "wsMy?jspCode=" + userId);  
    } else {  
        this.websocket = new SockJS("http://" + path + "wsMy/sockjs?jspCode=" + userId);  
    }
/*
	this.websocket.onopen = function(event) {  

        show("WebSocket:已连接");  
        //show(event); 
    };  */
    this.websocket.onmessage = function(event) {  
        var data = event.data;  
        //console.log(event);
        msgProcessor(data);
        //console.log("WebSocket:收到一条消息-norm", data);  
        //show("WebSocket:收到一条消息"+data);  
    };  
    /*
    this.websocket.onerror = function(event) {  
    
    
    
    
        //console.log("WebSocket:发生错误 ");  
        //console.log(event);  
    };  
    this.websocket.onclose = function(event) {  
        //console.log("WebSocket:已关闭");  
        //console.log(event);  
    }  */
}

//方法
wsOperation.prototype.send = function(accepterid,text){

	$.ajax({
		url:"message/send",
		data:{accepterid:accepterid,text:text},
		async:false,method:"post",
		success:function(response){
			console.log(response);
		}
	})
}
/*
//方法
wsOperation.prototype.receiveOffLine = function(){
	
}

//方法
wsOperation.prototype.receiveOnLine = function(){
	
}
*/

//声明MessageCenter对象,此对象一个页面只能定义一个,否则会造成DOM错误
//构造方法
function MessageCenter(ViewContainerID,paginationID,msgJson){
	this.data = msgJson;
	this.length = this.data.length;
	this.pageSize = 5;
	this.pages = Math.ceil(this.length/this.pageSize);//总共有几页
	this.currentPage = 1;
	this.ViewContainerID = ViewContainerID;
	this.paginationID = paginationID;//bootstrappagination控件
	
	this.generatePagination();
	this.loadPage(1);
}
//方法
MessageCenter.prototype.pageChange = function(pageno){
	//pageno最小为1
	//alert(pageno);
	
	if(pageno<=0){
		alert("已经在第一页");
	}else if(pageno>this.pages){
		alert("已经在最后一页");
	}else{

		this.currentPage = pageno;
		this.loadPage(pageno);
		//this.generatePagination();
		//$(".pagenumberlist").css({"background-color":"#eee"});
		$(".pagenumberlist").each(function(index,e){
			if(index*1+1 == pageno){//如果是当前页
				
				e.firstChild.style.backgroundColor = "#337ab7";//背景
				e.firstChild.style.color = "#ffffff";//文件
			}else{//不是当前页
				e.firstChild.style.backgroundColor = "#fff";//背景
				e.firstChild.style.color = "#337ab7";//文件
				
			}
			console.log(index);
			console.log(e);
		});
	}
	
}
//方法
MessageCenter.prototype.loadPage = function(pageno){
	var list = "";
	if(pageno == this.pages){//若是最后一页
		var how_much_message_in_last_page = this.length%this.pageSize;
		if(how_much_message_in_last_page == 0){
			how_much_message_in_last_page = 5;
		}

		for(var i = (pageno-1)*this.pageSize; i<(pageno-1)*this.pageSize+how_much_message_in_last_page ;i++){
			
			list += '<a class="list-group-item" style="height:100px;overflow:hidden;cursor:pointer">';
			list += '	<div style="width:100%;height:30px">';
			list += '		<div class="pull-left" style="color:#0e96ca;cursor:pointer">'+this.data[i].senderid+'</div>';
			list += '		<div class="pull-right" style="color:#0e96ca;cursor:pointer">'+this.data[i].time+'</div>';
			list += '	</div>'
			list += '	<div style="height:50px;overflow:hidden;cursor:pointer">';
			list += this.data[i].text;
			list += '	</div>';
			list += "</a>";
		}
	
	
	}else{//若不是最后一页
		for(var i = (pageno-1)*this.pageSize;i < this.pageSize*pageno;i++){
				
			
			list += '<a class="list-group-item" style="height:100px;overflow:hidden;cursor:pointer">';
			list += '	<div style="width:100%;height:30px">';
			list += '		<div class="pull-left" style="color:#0e96ca;cursor:pointer">'+this.data[i].senderid+'</div>';
			list += '		<div class="pull-right" style="color:#0e96ca;cursor:pointer">'+this.data[i].time+'</div>';
			list += '	</div>'
			list += '	<div style="height:50px;overflow:hidden;cursor:pointer">';
			list += this.data[i].text;
			list += '	</div>';
			list += "</a>";

		}
	}
	$("#"+this.ViewContainerID).html(list);
}
MessageCenter.prototype.generatePagination = function(){
	
	var pagelist = "";
	pagelist += "<li id='message_previous_page_button'>";
	pagelist += '	<a aria-label="Previous">';
	pagelist += '		<span aria-hidden="true">&laquo;</span>';
	pagelist += "	</a>";
	pagelist += "</li>";


	for(var i = 0; i<this.pages; i++){

		pagelist+="<li class='pagenumberlist'><a>"+(i+1)*1+"</a></li>";
	}
	pagelist += '<li id="message_next_page_button">';
	pagelist += '	<a aria-label="Next">';
	pagelist += '		<span aria-hidden="true">&raquo;</span>';
	pagelist += '	</a>';
	pagelist += '</li>';
	$("#"+this.paginationID).html(pagelist);
	/*由于在这里绑定事件时不能使用this来更改对象的属性值，所以只能在调用的地方来绑定事件了，请将以下代码复制到调用的地方
	$(".pagenumberlist").click(function(e){
		//console.log(e.currentTarget.innerText);
		pageno_after_change = e.currentTarget.innerText;
	});
	$("#message_previous_page_button").click(function(){
		alert("previous");
	});
	$("#message_next_page_button").click(function(){
		alert("next");
	});
	*/
}


function show(t){
	$("body").append("<hr/>"+t);
	
}