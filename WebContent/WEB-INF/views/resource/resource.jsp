<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
<title>资源</title>
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
			<%@ include file="resourcenav.jsp"%>
			<!-- 主体右 -->
			<div class="col-md-10 subject">
				<div class="col-md-12">
					<button class="btn btn-primary" data-toggle="modal"
						data-target="#myModal">创&nbsp;&nbsp;建</button>
					<!-- 点击创建按钮的时候弹出模态框，选择后进入资源详情页面 -->
				</div>
				<form class="form-horizontal center-block" role="form" action="toresource/searchresource.action" method="post">
					<div class="form-group">
						<label for="resId" class="col-md-5 control-label">资源标识</label>
						<div class="col-md-3">
							<input type="text" class="form-control" id="resId" name="resId"
								placeholder="">
						</div>
					</div>
					<div class="form-group">
						<label for="resName" class="col-md-5 control-label">资源名称</label>
						<div class="col-md-3">
							<input type="text" class="form-control" id="resName" name="resName"
								placeholder="">
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-12">
							<button type="submit" class="btn btn-primary">查&nbsp;&nbsp;询</button>
						</div>
					</div>
				</form>
				<hr>
				<table class="table table-bordered table-hover table-striped"
					id="res_table">
					<caption>查询资源结果</caption>
					<thead>
						<tr>
							<th>资源标识</th>
							<th>资源名称</th>
							<th>资源描述</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${resourceList}" var="resource">
							<tr>
								<td>${resource['resId']}</td>
								<td>${resource['resName']}</td>
								<td>${resource['resDesc']}</td>
								<td><a
									href="toresource/resourcedetail.action?resuuid=${resource['resUuid']}">查看</a>
									<a
									href="toresource/deleteresource.action?resuuid=${resource['resUuid']}">删除</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<!-- 控制分页的元素 用 class进行分页的话可以有上下两个分页导航 -->
				<center>
					<ul class="pagination" id="pagination0"></ul>
				</center>

			</div>
		</div>
		<!-- 模态框（Modal） -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">创建资源</h4>
					</div>
					<!-- 					<div class="modal-body">在这里添加一些文本</div> -->
					<div class="modal-body">
						<form class="form-horizontal center-block" role="form">
							<div class="form-group">
								<label for="userUuid" class="col-md-3 control-label">资源标识</label>
								<div class="col-md-5">
									<!-- 									<input type="text" class="form-control" id="userUuid" placeholder=""> -->
									<select class="form-control">
										<option>JDBC连接器</option>
									</select>
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<a type="button" class="btn btn-primary"
							href="toresource/resourcedetail.action">下一步</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="../commonscript.jsp" %>
	<script type="text/javascript">
		$(function() {

			$('#pagination0')
					.jqPaginator(
							{
								totalPages : parseInt('${resourceListPaginator.totalPages}'),	//${resourceListPaginator.totalPages}
								visiblePages : 5,
								currentPage : parseInt('${resourceListPaginator.page}'),	//${resourceListPaginator.page}
								first : '<li class="prev"><a href="javascript:;">首页</a></li>',
								prev : '<li class="prev"><a href="javascript:;">上一页</a></li>',
								next : '<li class="next"><a href="javascript:;">下一页</a></li>',
								last : '<li class="prev"><a href="javascript:;">末页</a></li>',
								page : '<li class="page"><a href="javascript:;">{{page}}</a></li>',
								onPageChange : function(num, type) {
									if (type == "change") {
										location.href = "toresource/resource.action?page="
												+ num;
									}
								}
							});
		});
	</script>
</body>
</html>