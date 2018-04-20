<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
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
<!-- custom style -->
<link href="css/custom.css?version=<%=Math.random()%>" rel="stylesheet">
<script type="text/javascript" src="js/loading.js"></script>
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<title>用户详情</title>
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
			<%@ include file="identitynav.jsp"%>
			<!-- 主体右 -->
			<div class="col-md-10 subject">
				<div class="row">
					<div class="col-md-4">
						<div class="input-group">
							<span class="input-group-addon">用户标识</span> <input id="user_id" name="user_id" value="${user['userId']}" data-value="${user['userUuid']}" type="text" class="form-control" placeholder="">
						</div>
					</div>
					<div class="col-md-4 col-md-offset-2">
						<div class="input-group">
							<span class="input-group-addon">用户名称</span> <input id="user_name" name="user_name" value="${user['userName']}" type="text" class="form-control" placeholder="">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="input-group">
							<span class="input-group-addon">组织单位</span> <input id="user_ou" name="user_ou" value="" type="text" class="form-control" placeholder="">
						</div>
					</div>
					<div class="col-md-4 col-md-offset-2">
						<div class="input-group">
							<span class="input-group-addon">用户状态</span> <input id="user_status" name="user_status" value="${user['userStatus']}" type="text" class="form-control" placeholder="" readonly="readonly">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="input-group">
							<span class="input-group-addon">员工标识</span> <input id="user_employeeid" name="user_employeeid" value="${user['userEmployeeId']}" type="text" class="form-control" placeholder="">
						</div>
					</div>
					<div class="col-md-4 col-md-offset-2">
						<div class="input-group">
							<span class="input-group-addon">电话号码</span> <input id="user_phonenumber" name="user_phonenumber" value="${user['userPhonenumber']}" type="text" class="form-control" placeholder="">
						</div>
					</div>
				</div>
				<div class="row">
<!-- 					<div class="col-md-4"> -->
<!-- 						<div class="input-group"> -->
<%-- 							<span class="input-group-addon">用户类型</span> <input id="user_type" name="user_type" value="${user['userType']}" type="text" class="form-control" placeholder=""> --%>
<!-- 						</div> -->
<!-- 					</div> -->
					<div class="col-md-4">
						<div class="input-group">
							<span class="input-group-addon">电子邮箱</span> <input id="user_email" name="user_email" value="${user['userEmail']}" type="text" class="form-control" placeholder="">
						</div>
					</div>
				</div>

				<ul id="myTab" class="nav nav-tabs">
<!-- 					<li><a href="#home" data-toggle="tab"> 平台角色 </a></li> -->
					<li class="active"><a href="#ios" data-toggle="tab">岗位</a></li>
				</ul>
				<div id="myTabContent" class="tab-content" style="min-height:50vh;">
<!-- 					<div class="tab-pane fade" id="home"> -->
<!-- 						<p>平台角色</p> -->
<!-- 					</div> -->
					<div class="tab-pane fade in active" id="ios">
<!-- 						<p>岗位</p> -->
						<textarea id="user_bizrole" style="width:100%; height:250px;font-size:20px;">${userBizRoleList}</textarea>
<%-- 							<c:forEach items="${userBizRoleList}" var="bizRole"> --%>
<%-- 								${bizRole['bizRoleId']}(${bizRole['bizRoleName']}) --%>
<%-- 							</c:forEach> --%>
						
					</div>
				</div>
				
				<div class="row">
					<div class="center-block">
					      <button class="btn btn-primary" id="save_user_btn">保&nbsp;&nbsp;存</button>
					      <a class="btn btn-primary" href="toidentity/user.action">取&nbsp;&nbsp;消</a>
				    </div>
				</div>

			</div>
		</div>
		<!-- 模态框：选择岗位 -->
		<div class="modal fade" id="select_bizrole" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">选择岗位</h4>
					</div>
					<!-- modal 主体-->
					<div class="modal-body">
						<form class="form-horizontal center-block" id="select_bizrole_form" role="form">
<!-- 							<div class="form-group"> -->
<!-- 								<label class="col-md-4"><input type="checkbox">请打勾</label> -->
<!-- 								<label class="col-md-4"><input type="checkbox">请打勾</label> -->
<!-- 								<label class="col-md-4"><input type="checkbox">请打勾</label> -->
<!-- 							</div>			 -->
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<a type="button" class="btn btn-primary" data-dismiss="modal" id="select_bizrole_confirm">确认</a> 
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="../commonscript.jsp" %>
	<!-- user -->
	<script src="js/user.js?version=<%=Math.random()%>"></script>
</body>
</html>