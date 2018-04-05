<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
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
	<link href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
	<link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css" />
	<link rel="stylesheet" href="css/custom.css">
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
    <script src="js/iziToast.min.js" type="text/javascript"></script>
    <script src="js/ToastTrigger.js" type="text/javascript"></script>
    <style>
    	.label{
    		float:left;
    		margin-left:5px;
    	}
    </style>
    
  </head>
  
  <body>
	<div class="page-wrapper">
      <nav id="sidebar" class="sidebar-wrapper">
        <div class="sidebar-content">
          <a href="#" id="toggle-sidebar"><i class="fa fa-bars"></i></a>
          <div class="sidebar-brand">
              <a href="#">客户经理</a>
          </div>
          <div class="sidebar-header">
              <div class="user-pic">
                  <img class="img-responsive img-rounded" src="assets/img/user.jpg" alt="">
              </div>
              <div class="user-info">
                  <span class="user-name">姓名：名 <strong>姓</strong></span>
                  <span class="user-role">工号：</span>
                  <span class="user-role">机构号：</span>
                  <span class="user-role">手机号：</span>
                  <div class="user-status">                       
                      <a href="#"><span class="label label-success mylabelgroup">账号状态</span></a>
                      <a href="#"><span class="label label-primary mylabelgroup">客户经理</span></a>                        
                  </div>
              </div>
          </div><!-- sidebar-header  -->
          <div class="sidebar-search">
              <div>                   
                  <div class="input-group">                          
                      <input type="text" class="form-control search-menu" placeholder="在这里搜索">
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
                              <li><a href="#">已审核资料</a></li>
                              <li><a href="#">其它</a></li>
                              
                          </ul>
                      </div>
                  </li>                  
                  
                  
                  <!--  <li class="header-menu"><span>Simple menu</span></li>-->
                  <li><a href="#"><i class="fa fa-tv"></i><span>用户权限管理</span></a></li>                   
                  <li><a href="#"><i class="fa fa-photo"></i><span>已上传资料</span></a></li>
                  

              </ul>
             </div><!-- sidebar-menu  -->           
          </div><!-- sidebar-content  -->
   
          <div class="sidebar-footer">
              <a href="#"><i class="fa fa-bell"></i><span class="label label-warning notification">3</span></a>
              <a href="#"><i class="fa fa-envelope"></i><span class="label label-success notification">7</span></a>
              <a href="#"><i class="fa fa-gear"></i></a>
              <a href="#"><i class="fa fa-power-off"></i></a>
          </div>
      </nav><!-- sidebar-wrapper  -->
      <main class="page-content">
      <!-- body -->

          	<center>
	          	<!--<a href="#" class="trigger-success">Success</a>
	          	<li><a href="#" class="trigger-info" data-iziToast>Info</a></li>
				<li><a href="#" class="trigger-success" >Success</a></li>
				<li><a href="#" class="trigger-warning" >Warning</a></li>
				<li><a href="#" class="trigger-error">Error</a></li>
				<li><a href="#" class="trigger-custom1">Custom I</a></li>
				<li><a href="#" class="trigger-custom2">Custom II</a></li>
				<li class="trigger-success"></li>-->
				<button id="trigger">触发Toast</button>
			</center>
      <!-- /body -->
      </main><!-- page-content" -->
  </div><!-- page-wrapper -->  
  <script>
  //自定义class：.pageloder-trigger 所有点击需要切换页面的html元素，需要有“whichpage=""”属相
  	$(document).ready(function(){
  		
  		$(".pageloder-trigger").click(function(e){
  			var url=e.currentTarget.getAttribute("whichpage");
  			console.log(url);
  			$(".page-content").load(url);
  		});
		$("#trigger").click(function(){
			iziToast.show({
			    title: 'Hello World!',
			    message: 'I am a basic toast message!',
			    color:'blue',
			    layout:1
			});
		});
  	});
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
}); 
  	
  	*/
  </script>

  </body>
</html>
