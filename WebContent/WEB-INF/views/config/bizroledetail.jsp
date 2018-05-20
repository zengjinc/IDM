<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<!-- Bootstrap -->
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/bootstrapValidator.min.css" rel="stylesheet">
<!-- custom style -->
<link href="css/custom.css?version=<%=Math.random()%>" rel="stylesheet">
<script type="text/javascript" src="js/loading.js"></script>
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<title>用户属性定义详情</title>
</head>
<body>

	<div class="container">
		<!-- 导航栏  -->
		<%@ include file="../nav.jsp"%>
		<!-- 面包屑 -->
		<%@ include file="../breadcrumb.jsp"%>
		<!-- 主体 -->
		<div class="row">
			<!-- 主体左 -->
			<%@ include file="confignav.jsp"%>
			<!-- 主体右 -->
			<div class="col-md-10 subject">
				<form action="" id="form1">
					<div class="row">
						<div class="col-md-5 form-group">
							<div class="input-group">
								<span class="input-group-addon">岗位标识</span> <input id="bizrole_id" name="bizrole_id" type="text" class="form-control">
							</div>
						</div>
						<div class="col-md-5 col-md-offset-1 form-group">
							<div class="input-group">
								<span class="input-group-addon">岗位名称</span> 
								<input id="bizrole_name" name="bizrole_name" type="text" class="form-control">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-5 form-group">
							<div class="input-group">
								<span class="input-group-addon">岗位描述</span> <input id="bizrole_desc" name="bizrole_desc" type="text" class="form-control">
							</div>
						</div>
					</div>
				</form>
<!-- 				<ul id="myTab" class="nav nav-tabs"> -->
<!-- 					<li class="active"><a href="#home" data-toggle="tab">属性</a></li> -->
<!-- 				</ul> -->
<!-- 				<div id="myTabContent" class="tab-content"> -->
<!-- 					<div class="tab-pane fade in active" id="home"> -->
<!-- 						<table class="table table-striped"> -->
<!-- 							<thead> -->
<!-- 								<tr> -->
<!-- 									<th>属性名</th> -->
<!-- 									<th>内容</th> -->
<!-- 									<th>描述</th> -->
<!-- 								</tr> -->
<!-- 							</thead> -->
<!-- 							<tbody> -->
<!-- 							</tbody> -->
<!-- 						</table> -->
<!-- 						<button class="btn btn-primary">添加自定义属性</button> -->
<!-- 					</div> -->
<!-- 				</div> -->
				<div style="min-height:50vh;"></div>
				<div class="center-block">
					<button class="btn btn-primary" id="save_bizrole_btn">保&nbsp;&nbsp;存</button>
					<a class="btn btn-primary" href="toconfig/bizrole.action">取&nbsp;&nbsp;消</a>
				</div>
			</div>
		</div>
	</div>

	
	<%@ include file="../commonscript.jsp" %>
	<script src="js/configure.js?version=<%=Math.random()%>"></script>
	<script type="text/javascript">
		$(function(){
			
			$('#form1').bootstrapValidator({
				message: '验证失败',
				live : 'disabled',
				feedbackIcons: {
// 					valid: 'glyphicon glyphicon-ok',
// 					invalid: 'glyphicon glyphicon-remove',
// 					validating: 'glyphicon glyphicon-refresh'
				},
				fields: {
					bizrole_id: {
						message: '岗位信息验证失败',
						validators: {
							notEmpty: {
								message: '岗位标识不能为空'
							}
						}
					},
					bizrole_name: {
						message: '用户名验证失败',
						validators: {
							notEmpty: {
								message: '岗位名称不能为空'
							}
						}
					}
				}
			});

		});

	</script>
</body>
</html>