<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>角色冲突策略</title>
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
				<div class="col-md-12">
					<a class="btn btn-primary" href="topolicy/roleconflictdetail.action">创&nbsp;&nbsp;建</a>
				</div>
				<form class="form-horizontal center-block" role="form" method="post" action="topolicy/roleconflict.action">
					<div class="form-group">
						<label for="userUuid" class="col-md-5 control-label">角色冲突策略标识</label>
						<div class="col-md-3">
							<input type="text" class="form-control" id="policyId" name="polId" placeholder="">
						</div>
					</div>
					<div class="form-group">
						<label for="userName" class="col-md-5 control-label">角色冲突策略名称</label>
						<div class="col-md-3">
							<input type="text" class="form-control" id="policyName" name="polName" placeholder="">
						</div>
					</div>

					<div class="form-group">
						<div class="col-md-12">
							<button type="submit" class="btn btn-primary">查&nbsp;&nbsp;询</button>
						</div>
					</div>
				</form>
				<hr>
				<table class="table table-bordered table-hover table-striped">
					<caption>查询角色冲突策略结果</caption>
					<thead>
						<tr>
							<th>角色冲突策略标识</th>
							<th>角色冲突策略名称</th>
							<th>描述</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${roleconflictPolicyList}" var="roleconflictPolicy">
							<tr>
								<td>${roleconflictPolicy['polId']}</td>
								<td>${roleconflictPolicy['polName']}</td>
								<td>${roleconflictPolicy['polDesc']}</td>
								<td><a href="topolicy/roleconflictdetail.action?policyuuid=${roleconflictPolicy['polUuid']}">查看</a>&nbsp;&nbsp;
									<a href="topolicy/delroleconflictpolicy.action?policyuuid=${roleconflictPolicy['polUuid']}" onclick="return confirmRemove();">删除</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<!-- 控制分页的元素 用 class进行分页的话可以有上下两个分页导航，要求要在表格上面也有一个一样的ul -->
				<center>
					<ul class="pagination" id="pagination0"></ul>
				</center>
			</div>
		</div>
	</div>

	<%@ include file="../commonscript.jsp" %>
	<script type="text/javascript">
		function confirmRemove(){
			var msg = "是否删除该策略，操作不可逆";
			if(confirm(msg)){
				return true;
			}
			return false;
		}
	
		$(function(){
			$('#pagination0')
			.jqPaginator(
					{
						totalPages : parseInt('${roleconflictPolicyListPaginator.totalPages}'),
						visiblePages : 5,
						currentPage : parseInt('${roleconflictPolicyListPaginator.page}'),
						first : '<li class="prev"><a href="javascript:;">首页</a></li>',
						prev : '<li class="prev"><a href="javascript:;">上一页</a></li>',
						next : '<li class="next"><a href="javascript:;">下一页</a></li>',
						last : '<li class="prev"><a href="javascript:;">末页</a></li>',
						page : '<li class="page"><a href="javascript:;">{{page}}</a></li>',
						onPageChange : function(num, type) {
							if (type == "change") {
								location.href = "toidentity/roleconflict.action?page="
										+ num;
							}
						}
					});
		})
	</script>
</body>
</html>