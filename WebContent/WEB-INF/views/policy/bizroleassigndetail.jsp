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
<!-- custom style -->
<link href="css/custom.css?version=<%=Math.random()%>" rel="stylesheet">
<script type="text/javascript" src="js/loading.js"></script>
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<title>岗位分配策略详情</title>
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
			<%@ include file="policynav.jsp"%>
			<!-- 主体右 -->
			<div class="col-md-10 subject">
				<div class="row">
					<div class="col-md-5">
						<div class="input-group">
							<span class="input-group-addon">岗位分配策略标识</span> <input id="date_start" name="date" type="text" class="form-control" placeholder="" required oninvalid="setCustomValidity('required')"
								oninput="setCustomValidity('')">
						</div>
					</div>
					<div class="col-md-5 col-md-offset-1">
						<div class="input-group">
							<span class="input-group-addon">岗位分配策略名称</span> <input id="date_end" name="date2" type="text" class="form-control" placeholder="" required oninvalid="setCustomValidity('required')"
								oninput="setCustomValidity('')">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-5">
						<div class="input-group">
							<span class="input-group-addon">岗位分配策略描述</span> <input id="date_start" name="date" type="text" class="form-control" placeholder="" required oninvalid="setCustomValidity('required')"
								oninput="setCustomValidity('')">
						</div>
					</div>
				</div>
				<ul id="myTab" class="nav nav-tabs">
					<li class="active"><a href="#home" data-toggle="tab">规则</a></li>
				</ul>
				<div id="myTabContent" class="tab-content">
					<div class="tab-pane fade in active" id="home">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>限制条件</th>
									<th>分配岗位</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td style="vertical-align:middle;">
										<form action="" class="form-inline">
											<select>
												<option>用户标识</option>
												<option>用户名称</option>
												<option>组织单位</option>
												<option>用户状态</option>
												<option>用户类型</option>
												<option>开始时间</option>
												<option>结束时间</option>
												<option>电子邮箱</option>
												<option>员工标识</option>
												<option>电话号码</option>
											</select> <select>
												<option>==</option>
												<option>!=</option>
												<option>&gt;</option>
												<option>&lt;</option>
											</select> <input id="date_end" name="date2" type="text" class="form-control" />

										</form>
									</td>
									<td><textarea class="form-control" rows="3"></textarea></td>
									<td style="vertical-align:middle;"><button class="btn btn-primary">添&nbsp;&nbsp;加</button></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<div class="center-block">
					<button class="btn btn-primary">编&nbsp;&nbsp;辑</button>
					<button class="btn btn-primary">删&nbsp;&nbsp;除</button>
				</div>
			</div>
		</div>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery-2.2.4.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.js"></script>
	<!-- initial page -->
	<script src="js/init.js?version=<%=Math.random()%>"></script>
</body>
</html>