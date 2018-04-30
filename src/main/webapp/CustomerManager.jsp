<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.relesee.bean.User" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	System.out.println(basePath);
	User user = (User) session.getAttribute("user");
	if(user != null){
	
	
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<!-- !!!!!!!!!!!!!!!!!!!!!!!!   特别注意    !!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
	<!-- 
		   子页面禁止引用其它任何位置，任何形式的jquery文件（包括联网引用的也不行）,
		   否则父页面bootstrap会失效报错，只能引用本地的js/jquery-1.11.0.min.js 
	-->
    <!-- !!!!!!!!!!!!!!!!!!!!!!!!   /特别注意  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
    <title>index</title>
    <meta charset="utf-8">

    
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
	<!-- AmazeUI 
	<link rel="stylesheet" type="text/css" href="css/amazeui.min.css"/>-->

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
	
	<link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css" />
	<link rel="stylesheet" href="css/custom.css">
	<!-- iziToast -->
	<link rel="stylesheet" href="css/iziToast.min.css">
	 
	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-1.11.0.min.js"></script>

    <script>window.jQuery || document.write('<script src="js/jquery-1.11.0.min.js"><\/script>')</script>
    <!-- AmazeUI 
	<script type="text/javascript" src="js/amazeui.min.js"></script> -->

    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
    <script src="js/custom.js"></script>
    <!-- iziToast -->
    <script src="js/iziToast.min.js" type="text/javascript"></script>
    
    <!-- sock对象 -->
    <script src="js/Socket.js" type="text/javascript"></script>
    <style>
    	/*调整用户信息下的两个label*/
    	.label{
    		float:left;
    		margin-left:5px;
    	}
    </style>
    
  </head>
  
  <body>
	<div class="page-wrapper">
      <nav id="sidebar" class="sidebar-wrapper" style="z-index:999">
        <div class="sidebar-content">
          <a href="#" id="toggle-sidebar"><i class="fa fa-bars"></i></a>
          <div class="sidebar-brand">
              <a href="#">客户经理</a>
          </div>
          <div class="sidebar-header">
              <div class="user-pic">
                  <img class="img-responsive img-rounded" src="img/<%= user.getHeadphoto() %>" alt="">
              </div>
              <div class="user-info">
                  <span class="user-name">姓名：<%= user.getUsername() %></span><!-- 名 <strong>姓</strong> -->
                  <span class="user-role">工号：<%= user.getUserid() %></span>
                  <span class="user-role">机构号：<%= user.getDeptid() %></span>
                  <span class="user-role">手机号：<%= user.getPhone() %></span>
                  <div class="user-status">                       
                      <a href="#"><span class="label label-success mylabelgroup">账号状态：<%= user.getUserstate() %></span></a>
                                           
                  </div>
              </div>
          </div><!-- sidebar-header  -->
          <div class="sidebar-search">
              <div>                   
                  <div class="input-group">                          
                      <input type="text" class="form-control search-menu" placeholder="搜索功能暂未开放">
                      <span class="input-group-addon"><i class="fa fa-search"></i></span>
                  </div>
              </div>                    
          </div><!-- sidebar-search  -->
          <div class="sidebar-menu">
              <ul>
                  <li class="header-menu"><span>业务处理</span></li>
                  <li class="sidebar-dropdown">

                      <a  href="#" ><i class="fa fa-file"></i><span>资料管理</span><span class="label label-danger">New</span></a>
                      <div class="sidebar-submenu">
                          <ul>
                              <li class="pageloder-trigger" whichpage="fileupload.html"><a href="#">上传资料 <span class="label label-success">10</span></a> </li>
                              
                              <li class="pageloder-trigger" whichpage="AuditState.html"><a href="#">查看审核状态</a></li>
                              
                          </ul>
                      </div>
                  </li>                  
                  
                  
                  <!--  <li class="header-menu"><span>Simple menu</span></li>
                  <li><a href="#"><i class="fa fa-tv"></i><span>用户权限管理</span></a></li>                   
                  <li><a href="#"><i class="fa fa-photo"></i><span>已上传资料</span></a></li>
                  -->

              </ul>
             </div><!-- sidebar-menu  -->           
          </div><!-- sidebar-content  -->
   
          <div class="sidebar-footer">
              <a id="notifications-trigger" title="消息中心" ><i class="fa fa-bell"></i><span class="label label-warning notification">3</span></a>
              <a class="pageloder-trigger" whichpage="draft.html" title="操作日志"><i class="glyphicon glyphicon-list-alt"></i><span class="label label-success notification">7</span></a>
              
              <a title="退出当前账号"><i class="fa fa-power-off"></i></a>
          </div>
      </nav><!-- sidebar-wrapper  -->
      <main class="page-content">
      

          	<center>
	          	<!--<a href="#" class="trigger-success">Success</a>
	          	<li><a href="#" class="trigger-info" data-iziToast>Info</a></li>
				<li><a href="#" class="trigger-success" >Success</a></li>
				<li><a href="#" class="trigger-warning" >Warning</a></li>
				<li><a href="#" class="trigger-error">Error</a></li>
				<li><a href="#" class="trigger-custom1">Custom I</a></li>
				<li><a href="#" class="trigger-custom2">Custom II</a></li>
				<li class="trigger-success"></li>-->
				<button id="trigger" data-toggle="tooltip" data-placement="bottom" title="haha">触发Toast</button>
			
			
			</center>

      </main><!-- page-content" -->
  </div><!-- page-wrapper -->  
  
  
  <!-- Button trigger modal -->


<!-- 消息模态框 -->
	<div class="modal fade bs-example-modal-lg" id="notifications-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog modal-lg" role="document">
	    <div class="modal-content">
	      	<div class="modal-header">
	        	<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        	<h4 class="modal-title" id="myModalLabel">消息中心</h4>
	      	</div>
	      	<div class="modal-body">
	      		<ul id="listview" class="list-group">
			  	空
				</ul>
	      	</div>
	      	
	      	<div class="modal-footer">
	      		
				  <ul id="pg" class="pagination" style="cursor:pointer;margin:15px 0px;padding:0px;float:left">
				    <li>
				      <a  aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				    </li>
				    <li><a href="#">1</a></li>
				    <li><a href="#">2</a></li>
				    <li><a href="#">3</a></li>
				    <li><a href="#">4</a></li>
				    <li><a href="#">5</a></li>
				    <li>
				      <a href="#" aria-label="Next">
				        <span aria-hidden="true">&raquo;</span>
				      </a>
				    </li>
				  </ul>

	        	  <button style="margin:20px 0px;" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        	  <button style="margin:20px 0px;" type="button" class="btn btn-primary">全部标为已读</button>
	        	
	      	</div>
	    </div>
	  </div>
	</div>
  
  
  
  <script>
  //自定义class：.pageloder-trigger 所有点击需要切换页面的html元素，需要有“whichpage=""”属相
  	$(document).ready(function(){
  		//与服务器建立socket连接
  		
  		var uid = "<%=user.getUserid() %>";
  		var basepath = "<%=basePath %>";
  		//console.log(basepath);
  		basepath = basepath.substring(7);
  		//console.log(basepath);
  		var wso = new wsOperation(basepath,uid);
  		//请求离线消息
  		$.ajax({
  			url:"message/get_history_message",
  			data:{id:uid},
  			async:false,method:"post",
  			success:function(data){

  				data = JSON.parse(data);
  				var msgcenter = new MessageCenter("listview","pg",data);
			  	$(".pagenumberlist").click(function(e){
					msgcenter.pageChange(e.currentTarget.innerText);
				});
				$("#message_previous_page_button").click(function(){
					msgcenter.pageChange((msgcenter.currentPage-1)*1);
				});
				$("#message_next_page_button").click(function(){
					msgcenter.pageChange((msgcenter.currentPage*1+1)*1);
				});
				$(".list-group-item").each(function(index,e){
					console.log(index,e);
					$(e).click(function(){
						//alert(index);
						console.log(msgcenter.data[index]);
					});
				});
  				iziToast.show({
				    title: '离线消息',
				    message: '您有离线消息未阅读,关闭此提示后将为您打开消息中心',
				    color:'yellow',
				    layout:1,
				    position:'topRight',
				    timeout:10000,
				    onClose: function () {
				    	$("#notifications-modal").modal('show');
				    }
				});
  			}
  		}); 
  		 
  		
  		//所有pageloder-trigger类，只要添加whichpage属性就可实现加载该页面
  		$(".pageloder-trigger").click(function(e){
  			var url=e.currentTarget.getAttribute("whichpage");
  			console.log(url);
  			$(".page-content").load(url);
  		});
  		
  		//点初始界面上的按钮弹出toast，到时候记得删掉
		$("#trigger").click(function(){
			iziToast.show({
			    title: '你好',
			    message: '这是测试toast',
			    color:'blue',
			    layout:1,
			    onClose: function () {
			    	
			    }
			});
		});
		
		$("#notifications-trigger").click(function(e){
			
			$("#notifications-modal").modal('show');//or hide
		});
		
		//默认500mm=0.5秒后跳出左侧栏
		setTimeout(function(){
			$(".page-wrapper").toggleClass("toggled");
		},500)
		
  	});
  	//onmessage回调此函数
  	function msgProcessor(data){
  		console.log(data);
  	}
  	/*
  	iziToast.show({
    class: '',
    title: '',
    message: '',
    color: '', // blue, red, green, yellow
    icon: '',
    iconText: '',
    iconColor: '',
    image: '',
    imageWidth: 50,
    layout: 1,
    balloon: false,
    close: true,
    rtl: false,
    position: 'bottomRight', // bottomRight, bottomLeft, topRight, topLeft, topCenter, bottomCenter, center
    target: '',
    timeout: 5000,
    pauseOnHover: true,
    resetOnHover: false,
    progressBar: true,
    progressBarColor: '',
    animateInside: true,
    buttons: {},
    transitionIn: 'fadeInUp',
    transitionOut: 'fadeOut',
    transitionInMobile: 'fadeInUp',
    transitionOutMobile: 'fadeOutDown',
    onOpen: function () {},
    onClose: function () {}
    
    
}); */
  	
  	
  </script>

  </body>
</html>

<% 
	}
%>