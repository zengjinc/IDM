<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<!-- tree style -->
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script type="text/javascript" src="js/loading.js"></script>
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<title>组织单位</title>
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
			<%@ include file="ounav.jsp"%>
			<!-- 主体右 -->
			<div class="col-md-10 subject">
				<div class="row">
					<div class="col-md-3">
						<div class="tree well">
							<ul>
								<li><span><i class="icon-folder-open"></i>组织单位</span>
									<ul>
										<li>
											<span><i class="icon-leaf"></i>子节点</span>
											<ul>
												<li><span><i class="icon-leaf"></i>子节点</span></li>
											</ul>	
										</li>
									</ul>
									<ul>
										<li><span><i class="icon-leaf"></i>子节点</span></li>
									</ul>
									<ul>
										<li><span><i class="icon-leaf"></i>子节点</span></li>
									</ul>
								</li>
							</ul>
						</div>
					</div>
					<div class="col-md-9">
						<div class="row">
							<div class="col-md-5">
								<div class="input-group">
									<span class="input-group-addon">组织单位标识</span> <input id="date_start" name="date" type="text" class="form-control" placeholder="" required oninvalid="setCustomValidity('required')"
										oninput="setCustomValidity('')">
								</div>
							</div>
							<div class="col-md-5 col-md-offset-1">
								<div class="input-group">
									<span class="input-group-addon">组织单位名称</span> <input id="date_end" name="date2" type="text" class="form-control" placeholder="" required oninvalid="setCustomValidity('required')"
										oninput="setCustomValidity('')">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-5">
								<div class="input-group">
									<span class="input-group-addon">部门经理</span> <input id="date_start" name="date" type="text" class="form-control" placeholder="" required oninvalid="setCustomValidity('required')"
										oninput="setCustomValidity('')">
								</div>
							</div>
							<div class="col-md-5 col-md-offset-1">
								<div class="input-group">
									<span class="input-group-addon">描述</span> <input id="date_end" name="date2" type="text" class="form-control" placeholder="" required oninvalid="setCustomValidity('required')"
										oninput="setCustomValidity('')">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-5">
								<div class="input-group">
									<span class="input-group-addon">创建时间</span> <input id="date_start" name="date" type="text" class="form-control" placeholder="" required oninvalid="setCustomValidity('required')"
										oninput="setCustomValidity('')">
								</div>
							</div>
							<div class="col-md-5 col-md-offset-1">
								<div class="input-group">
									<span class="input-group-addon">修改时间</span> <input id="date_end" name="date2" type="text" class="form-control" placeholder="" required oninvalid="setCustomValidity('required')"
										oninput="setCustomValidity('')">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-5">
								<div class="input-group">
									<span class="input-group-addon">创建者</span> <input id="date_start" name="date" type="text" class="form-control" placeholder="" required oninvalid="setCustomValidity('required')"
										oninput="setCustomValidity('')">
								</div>
							</div>
							<div class="col-md-5 col-md-offset-1">
								<div class="input-group">
									<span class="input-group-addon">修改者</span> <input id="date_end" name="date2" type="text" class="form-control" placeholder="" required oninvalid="setCustomValidity('required')"
										oninput="setCustomValidity('')">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-5">
								<div class="input-group">
									<span class="input-group-addon">父组织单位</span> <input id="date_start" name="date" type="text" class="form-control" placeholder="" required oninvalid="setCustomValidity('required')"
										oninput="setCustomValidity('')">
								</div>
							</div>
						</div>
						<ul id="myTab" class="nav nav-tabs">
							<li class="active"><a href="#home" data-toggle="tab">属性</a></li>
							<li><a href="#ios" data-toggle="tab">用户</a></li>
						</ul>
						<div id="myTabContent" class="tab-content">
							<div class="tab-pane fade in active" id="home">
								<p>组织单位自定义属性</p>
							</div>
							<div class="tab-pane fade" id="ios">
								<div class="row">
									<div class="col-md-12">
										<form method="POST" class="form-inline" action="" name="form">
											<div class="form-group">
												<input id="" name="userUUID" type="text" class="form-control" placeholder="用户标识">
											</div>
											<div class="form-group">
												<button type="submit" class="btn btn-primary">查询</button>
											</div>
										</form>
									</div>
								</div>
								<hr>
								<table class="table table-bordered table-hover table-striped">
									<caption>查询用户结果</caption>
									<thead>
										<tr>
											<th>用户标识</th>
											<th>用户名称</th>
											<th>用户状态</th>
											<th>查看</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>test</td>
											<td>test</td>
											<td>test</td>
											<td><a href="">用户</a>&nbsp;&nbsp;<a href="">账号</a>&nbsp;&nbsp;<a href="">权限</a></td>
										</tr>
										<tr>
											<td>test</td>
											<td>test</td>
											<td>test</td>
											<td><a href="">用户</a>&nbsp;&nbsp;<a href="">账号</a>&nbsp;&nbsp;<a href="">权限</a></td>
										</tr>
									</tbody>
								</table>
								<div class="center-block">
									<ul class="pagination">
										<li><a href="#">&laquo;</a></li>
										<li><a href="#">1</a></li>
										<li><a href="#">2</a></li>
										<li><a href="#">3</a></li>
										<li><a href="#">4</a></li>
										<li><a href="#">5</a></li>
										<li><a href="#">&raquo;</a></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="center-block">
							<button class="btn btn-primary">编&nbsp;&nbsp;辑</button>
							<button class="btn btn-primary">创建子组织单位</button>
							<button class="btn btn-primary">删&nbsp;&nbsp;除</button>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery-2.2.4.min.js"></script>
	<script src="js/jquery.cookie.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.js"></script>
	<!-- initial page -->
	<script src="js/init.js?version=<%=Math.random()%>"></script>
	<script type="text/javascript">
		$(function() {
			$('.tree li:has(ul)').addClass('parent_li').find(' > span').attr(
					'title', 'Collapse this branch');
			$('.tree li.parent_li > span').on(
					'click',
					function(e) {
						var children = $(this).parent('li.parent_li').find(
								' > ul > li');
						if (children.is(":visible")) {
							children.hide('fast');
							$(this).attr('title', 'Expand this branch').find(
									' > i').addClass('icon-plus-sign')
									.removeClass('icon-minus-sign');
						} else {
							children.show('fast');
							$(this).attr('title', 'Collapse this branch').find(
									' > i').addClass('icon-minus-sign')
									.removeClass('icon-plus-sign');
						}
						e.stopPropagation();
					});
		});
	</script>
</body>
</html>