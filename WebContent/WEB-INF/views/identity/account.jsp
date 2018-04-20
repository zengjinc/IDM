<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<title>账号</title>
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
				<!-- 用户、账号、权限公共部分 -->
				<%-- 				<%@ include file="userTable.jsp" %> --%>
				<form class="form-horizontal center-block" role="form"  action="toidentity/userquery.action" method="post">
					<div class="form-group">
						<label for="userUuid" class="col-md-5 control-label">用户标识</label>
						<div class="col-md-3">
							<input type="text" class="form-control" id="userUuid" name="userId" placeholder="">
						</div>
					</div>
					<div class="form-group">
						<label for="userName" class="col-md-5 control-label">用户名称</label>
						<div class="col-md-3">
							<input type="text" class="form-control" id="userName" name="userName" placeholder="">
						</div>
					</div>
<!-- 					<div class="form-group"> -->
<!-- 						<label for="userOu" class="col-md-5 control-label">组织单位</label> -->
<!-- 						<div class="col-md-3"> -->
<!-- 							<input type="text" class="form-control" id="userOu" name="userOu" placeholder=""> -->
<!-- 						</div> -->
<!-- 					</div> -->
					<div class="form-group">
						<label for="userBizRole" class="col-md-5 control-label">岗位</label>
						<div class="col-md-3">
							<select class="form-control" id="userBizRole" name="userBizRole">
								<option value="">-</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="userStatus" class="col-md-5 control-label">状态</label>
						<div class="col-md-3">
							<select class="form-control" id="userStatus" name="userStatus">
								<option value="">-</option>
								<option value="1">已激活</option>
								<option value="0">已禁用</option>
							</select>
						</div>
					</div>
<!-- 					<div class="form-group"> -->
<!-- 						<label for="userType" class="col-md-5 control-label">用户类型</label> -->
<!-- 						<div class="col-md-3"> -->
<!-- 							<select class="form-control" id="userType" name="userType"> -->
<!-- 								<option>-</option> -->
<!-- 							</select> -->
<!-- 						</div> -->
<!-- 					</div> -->
					<div class="form-group">
						<label for="trust_res" class="col-md-5 control-label">信任资源</label>
						<div class="col-md-3">
							<select class="form-control" id="trustResource" name="trustResource">
								<option value="">-</option>
								<option value="1">是</option>
								<option value="0">否</option>
							</select>
						</div>
					</div>
					<div class="form-group" id="resources_div" style="display: none;">
						<label for="resources" class="col-md-5 control-label">资源</label>
						<div class="col-md-3">
							<select class="form-control" id="resources" name="resources">
								<option value="">-</option>
							</select>
						</div>
					</div>


					<div class="form-group">
						<div class="col-md-12">
							<button type="submit" class="btn btn-primary">查&nbsp;&nbsp;询</button>
						</div>
					</div>
				</form>
				<hr>
				<table class="table table-bordered table-hover table-striped" id="user_table">
					<caption id="search_result">查询用户结果</caption>
					<thead>
						<tr>
							<!-- 							<th><input type="checkbox" /></th> -->
							<th>用户标识</th>
							<th>用户名称</th>
							<th>用户状态</th>
							<th>组织单位</th>
							<th>用户类型</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${userList}" var="user">
							<tr>
								<td>${user['userId']}</td>
								<td>${user['userName']}</td>
								<c:if test="${user['userStatus'] == '1'}">
								<td>已激活</td>
								</c:if>
								<c:if test="${user['userStatus'] == '0'}">
								<td>已禁用</td>
								</c:if>
								<td></td>
								<td>${user['userType']}</td>
								<td><a href="toidentity/accountdetail.action?useraccountuuid=${user['userUuid']}">查看</a></td>
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
		$(function() {
			$("#resources_div").css("display", "block");
			$("#search_result").text("查询账号结果");
			$('#pagination0')
					.jqPaginator(
							{
								totalPages : parseInt('${userListPaginator.totalPages}'), //${resourceListPaginator.totalPages}
								visiblePages : 5,
								currentPage : parseInt('${userListPaginator.page}'), //${resourceListPaginator.page}
								first : '<li class="prev"><a href="javascript:;">首页</a></li>',
								prev : '<li class="prev"><a href="javascript:;">上一页</a></li>',
								next : '<li class="next"><a href="javascript:;">下一页</a></li>',
								last : '<li class="prev"><a href="javascript:;">末页</a></li>',
								page : '<li class="page"><a href="javascript:;">{{page}}</a></li>',
								onPageChange : function(num, type) {
									if (type == "change") {
										location.href = "toidentity/account.action?page="
												+ num;
									}
								}
							});
		})
	</script>
</body>
</html>