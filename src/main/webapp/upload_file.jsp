<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>上传文件</title>
	<link rel="stylesheet" type="text/css" href="css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="css/htmleaf-demo.css">
	<link href="css/styles.imageuploader.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="htmleaf-container">
		<header class="htmleaf-header">
			<h1>请上传文件</span></h1>
			<div class="htmleaf-links">
				<a class="htmleaf-icon icon-htmleaf-home-outline" href="http://www.htmleaf.com/" title="jQueryä¹å®¶" target="_blank"><span> jQueryä¹å®¶</span></a>
				<a class="htmleaf-icon icon-htmleaf-arrow-forward-outline" href="http://www.htmleaf.com/jQuery/Form/201801244947.html" title="è¿åä¸è½½é¡µ" target="_blank"><span> è¿åä¸è½½é¡µ</span></a>
			</div>
		</header>
		<section role="main" class="l-main" style="margin-top:50px;margin-bottom:50px;">
		      <header class="site-header">
		          <h1 class="site-title l-site-title" style="font-size:1.2em;">文件上传</h1>
		      </header>
		      <div class="uploader__box js-uploader__box l-center-box">
		          <form action="fileupload" method="POST"  enctype="multipart/form-data">
		              <div class="uploader__contents">
		                  <label class="button button--secondary" for="fileinput">请将文件拖曳至此上传</label>
		                  <input id="fileinput" class="uploader__file-input" type="file" multiple value="Select Files">
		              </div>
		              <input class="button button--big-bottom" type="submit" value="上传已选择的文件">
		          </form>
		      </div>
		  </section>
		
	</div>
	
	
	<script>window.jQuery || document.write('<script src="js/jquery-1.11.0.min.js"><\/script>')</script>
	<script src="js/jquery.imageuploader.js"></script>
	<script type="text/javascript">
		(function(){
	            var options = {};
	            $('.js-uploader__box').uploader({
	            	'selectButtonCopy':'请选择所需上传的文件',
	            	'instructionsCopy':'你可以选择或拖拽多个文件',
	            	'submitButtonCopy':'上传选择的文件',
	            	'furtherInstructionsCopy':'你可以选择或拖拽更多的文件',
	            	'secondarySelectButtonCopy':'选择更多的文件'
	            });
	        }());
	</script>
</body>
</html>