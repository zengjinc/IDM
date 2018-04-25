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
<title>计划任务</title>
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
			<%@ include file="tasknav.jsp"%>
			<!-- 主体右 -->
			<div class="col-md-10 subject">
				<div class="col-md-12">
					<a class="btn btn-primary" href="totask/taskdetail.action">创&nbsp;&nbsp;建</a>
				</div>
				<form class="form-horizontal center-block" role="form" method="post" action="totask/searchtask.action">
					<div class="form-group">
						<label for="job_uuid" class="col-md-5 control-label">计划任务标识</label>
						<div class="col-md-3">
							<input type="text" class="form-control" id="scdId" name="scdId" placeholder="">
						</div>
					</div>
					<div class="form-group">
						<label for="job_type_sel" class="col-md-5 control-label">计划任务类型</label>
						<div class="col-md-3">
							<select class="form-control" id="scdJobType" name="scdJobType">
								<option value="">-</option>
								<option value="reconAccountScheduleJob">账号回收任务</option>
								<option value="reconRoleScheduleJob">角色回收任务</option>
								<option value="reconOUJob">组织单位回收任务</option>
								<option value="userSynchronisedScheduleJob">用户同步任务</option>
								<option value="assignAccountOwnerScheduleJob">账号拥有者分配任务</option>
<!-- 								<option value="">用户重新评估任务</option> -->
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
				<table class="table table-bordered table-hover table-striped" id="scdjob_table">
					<caption>查询计划任务结果</caption>
					<thead>
						<tr>
							<th>计划任务标识</th>
							<th>计划任务类型</th>
<!-- 							<th>Cron表达式</th> -->
							<th>计划任务状态</th>
							<th>计划任务描述</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${scdjboList}" var="scdjob">
							<tr>
								<td>${scdjob['scdId']}</td>
								<td>${scdjob['scdJobType']}</td>
<%-- 								<td>${scdjob['csdCron']}</td> --%>
								<c:if test="${scdjob['scdStatus'] == '1'}">
								<td>已激活</td>
								</c:if>
								<c:if test="${scdjob['scdStatus'] == '0'}">
								<td>已禁用</td>
								</c:if>
								<td>${scdjob['scdDesc']}</td>
								<td><a
									href="totask/taskdetail.action?scduuid=${scdjob['scdUuid']}">查看</a>
									<a
									href="totask/delettask.action?scduuid=${scdjob['scdUuid']}">删除</a>
									<c:if test="${scdjob['scdStatus'] == '1'}">
									<a href="totask/disabletask.action?scduuid=${scdjob['scdUuid']}">禁用</a>
									</c:if>
									<c:if test="${scdjob['scdStatus'] == '0'}">
									<a href="totask/enabletask.action?scduuid=${scdjob['scdUuid']}">激活</a>
									</c:if>
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
	</div>

	<%@ include file="../commonscript.jsp" %>
	<script type="text/javascript">
		$(function() {

			$('#pagination0')
					.jqPaginator(
							{
								totalPages : parseInt('${scdjboListPaginator.totalPages}'),	//${resourceListPaginator.totalPages}
								visiblePages : 5,
								currentPage : parseInt('${scdjboListPaginator.page}'),	//${resourceListPaginator.page}
								first : '<li class="prev"><a href="javascript:;">首页</a></li>',
								prev : '<li class="prev"><a href="javascript:;">上一页</a></li>',
								next : '<li class="next"><a href="javascript:;">下一页</a></li>',
								last : '<li class="prev"><a href="javascript:;">末页</a></li>',
								page : '<li class="page"><a href="javascript:;">{{page}}</a></li>',
								onPageChange : function(num, type) {
									if (type == "change") {
										location.href = "totask/task.action?page="
												+ num;
									}
								}
							});
		});
	</script>
</body>
</html>