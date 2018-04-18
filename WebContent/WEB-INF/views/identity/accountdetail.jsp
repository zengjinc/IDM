<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
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
							<span class="input-group-addon">用户标识</span> <input id="user_id" name="user_id" value="${user['userId']}" data-value="${user['userUuid']}" type="text" class="form-control"
								placeholder="" readonly="readonly">
						</div>
					</div>
					<div class="col-md-4 col-md-offset-2">
						<div class="input-group">
							<span class="input-group-addon">用户名称</span> <input id="user_name" name="user_name" value="${user['userName']}" type="text" class="form-control"
								placeholder="" readonly="readonly">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="input-group">
							<span class="input-group-addon">组织单位</span> <input id="user_ou" name="user_ou" value="" type="text" class="form-control" placeholder="" readonly="readonly">
						</div>
					</div>
					<div class="col-md-4 col-md-offset-2">
						<div class="input-group">
							<span class="input-group-addon">用户状态</span> <input id="user_status" name="user_status" value="${user['userStatus']}" type="text"
								class="form-control" placeholder="" readonly="readonly">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="input-group">
							<span class="input-group-addon">用户类型</span> <input id="user_type" name="user_type" value="${user['userType']}" type="text" class="form-control"
								placeholder="" readonly="readonly">
						</div>
					</div>
					<div class="col-md-4 col-md-offset-2">
						<div class="input-group">
							<span class="input-group-addon">电子邮箱</span> <input id="user_email" name="user_email" value="${user['userEmail']}" type="text"
								class="form-control" placeholder="" readonly="readonly">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="input-group">
							<span class="input-group-addon">员工标识</span> <input id="user_employeeid" name="user_employeeid" value="${user['userEmployeeId']}" type="text"
								class="form-control" placeholder="" readonly="readonly">
						</div>
					</div>
					<div class="col-md-4 col-md-offset-2">
						<div class="input-group">
							<span class="input-group-addon">电话号码</span> <input id="user_phonenumber" name="user_phonenumber" value="${user['userPhonenumber']}" type="text"
								class="form-control" placeholder="" readonly="readonly">
						</div>
					</div>
				</div>

				<ul id="myTab" class="nav nav-tabs">
					<li class="active"><a href="#home" data-toggle="tab"> 账号 </a></li>
					<!-- 					<li><a href="#ios" data-toggle="tab">岗位</a></li> -->
				</ul>
				<div id="myTabContent" class="tab-content">
					<div class="tab-pane fade in active" id="home" style="margin-top:15px;min-height:50vh;">
						<div class="center-block">
							<button class="btn btn-primary" id="enable_user_btn">激&nbsp;&nbsp;活</button>
							<button class="btn btn-primary" id="disable_user_btn">禁&nbsp;&nbsp;用</button>
							<button class="btn btn-primary" id="delete_user_btn">删&nbsp;&nbsp;除</button>
						</div>
						<table class="table table-bordered table-hover table-striped" id="user_table">
							<caption id="search_result">&nbsp;</caption>
							<thead>
								<tr>
									<th><input type="checkbox" class="check_all"/></th>
									<th>资源标识</th>
									<th>资源名称</th>
									<th>账号登录名称</th>
									<th>授权状态</th>
									<th>操作</th>	<!-- 查看	编辑		重设密码 -->
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${entitlementList}" var="entitlementTo">
									<tr>
										<td><input type="checkbox" class="check"/></td>
										<td data-value="${entitlementTo['resUuid']}">${entitlementTo['resId']}</td>	
										<td>${entitlementTo['resName']}</td>
										<td data-value="${entitlementTo['acctTgtUuid']}">${entitlementTo['acctLoginId']}</td>
										<c:if test="${entitlementTo['acctStatus'] == 0}">
										<td>已禁用</td>
										</c:if>
										<c:if test="${entitlementTo['acctStatus'] == 1}">
										<td>已激活</td>
										</c:if>
										<td>
											<button class="btn btn-primary edit_account" data-toggle="modal" data-target="#edit_account">编&nbsp;&nbsp;辑</button>&nbsp;&nbsp;
											<button class="btn btn-primary reset_password" data-toggle="modal" data-target="#resert_password">重设密码</button>	
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

				<div class="row">
					<div class="center-block">
						<button class="btn btn-primary" data-toggle="modal" data-target="#assign_account_modal">分配账号</button>	<!-- 全部操作在模态框中进行 -->
						<a class="btn btn-primary" href="toidentity/account.action">取&nbsp;&nbsp;消</a>
					</div>
				</div>

			</div>
		</div>
		<!-- 模态框（Modal） 分配账号 -->
		<div class="modal fade" id="assign_account_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">分配账号</h4>
					</div>
					<!-- modal 主体-->
					<div class="modal-body">
						<!-- 显示所有非信任资源的表格 -->
						<table class="table table-bordered table-hover table-striped" id="resource_table">
							<caption id="search_result">&nbsp;</caption>
							<thead>
								<tr>
<!-- 									<th><input type="checkbox" /></th> -->
									<th>资源标识</th>
									<th>资源名称</th>
									<th>操作</th>	<!-- 创建   分配 -->
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
						
						<!-- tab2 -->
						<ul id="myTab2" class="nav nav-tabs">
							<li class="active" id="tab_primary"><a href="#primary_account" data-toggle="tab">账号</a></li>
<!-- 							<li id="tab_secondary"><a href="#secondary_account" data-toggle="tab">次账号</a></li> -->
						</ul>
						<div id="myTabContent2" class="tab-content">
							<div class="tab-pane fade in active" id="primary_account">
								<!-- 显示资源对应的可分配账号	： 主账号	 -->
								<table class="table table-bordered table-hover table-striped" id="primary_account_table">
									<caption id="search_result">&nbsp;</caption>
									<thead>
										<tr>
											<th>账号标识</th>
											<th>操作</th>	<!--  分配 -->
										</tr>
									</thead>
									<tbody>
									</tbody>
								</table>
							</div>
<!-- 							<div class="tab-pane fade" id="secondary_account"> -->
<!-- 								显示资源对应的可分配账号	： 次账号	 -->
<!-- 								<table class="table table-bordered table-hover table-striped" id="secondary_account_table"> -->
<%-- 									<caption id="search_result">&nbsp;</caption> --%>
<!-- 									<thead> -->
<!-- 										<tr> -->
<!-- 											<th>账号标识</th> -->
<!-- 											<th>操作</th>	分配 -->
<!-- 										</tr> -->
<!-- 									</thead> -->
<!-- 									<tbody> -->
<!-- 									</tbody> -->
<!-- 								</table> -->
<!-- 							</div> -->
						</div>
						<!-- tab3 -->
						<ul id="myTab3" class="nav nav-tabs" style="display:none;">
							<li class="active" id="tab_basic"><a href="#basic_attribute" data-toggle="tab">属性</a></li>
						</ul>
						<div id="myTabContent3" class="tab-content" style="display:none;">
							<div class="tab-pane fade in active" id="basic_attribute">
								<!-- 基本属性 -->
								<table class="table table-striped">
									<thead>
										<tr>
											<th>基本属性</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>
												<form class="form-horizontal" role="form">
													<div class="form-group">
														<label for="user_id" class="col-md-2 control-label">用户标识</label>
														<div class="col-md-5">
<!-- 															<input type="text" class="form-control" id="user_id" name="user_id" placeholder=""> -->
															<label class="control-label" id="user_id_label"></label>
														</div>
													</div>
													<div class="form-group">
														<label for="resource_id" class="col-md-2 control-label">资源标识</label>
														<div class="col-md-5">
<!-- 															<input type="text" class="form-control" id="resource_id" name="resource_id" placeholder=""> -->
															<label class="control-label" id="resource_id_label"></label>
														</div>
													</div>
													<div class="form-group">
														<label for="account_id" class="col-md-2 control-label">账号标识</label>
														<div class="col-md-5">
															<input type="text" class="form-control" id="account_id" name="account_id" placeholder="">
														</div>
													</div>
<!-- 													<div class="form-group"> -->
<!-- 														<label for="account_type" class="col-md-2 control-label">账户类型</label> -->
<!-- 														<div class="col-md-5"> -->
<!-- 															<select class="form-control" id="account_type" name="account_type"> -->
<!-- 																<option value="1">主账户</option> -->
<!-- 																<option value="0">次账户</option> -->
<!-- 															</select> -->
<!-- 														</div> -->
<!-- 													</div> -->
													<div class="form-group">
														<label for="account_pwd" class="col-md-2 control-label">密码</label>
														<div class="col-md-5">
															<input type="password" class="form-control" id="account_pwd" name="account_pwd">
														</div>
													</div>
													<div class="form-group">
														<label for="account_pwd2" class="col-md-2 control-label">确认密码</label>
														<div class="col-md-5">
															<input type="password" class="form-control" id="account_pwd2" name="account_pwd2">
														</div>
													</div>
												</form>
											</td>
										</tr>
									</tbody>
								</table>
								<!-- 账号属性 -->
								<table class="table table-striped">
									<thead>
										<tr>
											<th>账号属性</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>
												<form class="form-horizontal" role="form" id="acct_attr_form">
													
												</form>
											</td>
										</tr>
									</tbody>
								</table>
								
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<a type="button" class="btn btn-primary" data-dismiss="modal" id="accountdetail_modal_confirm">确认</a> 
						<a type="button" class="btn btn-primary" id="create_account_confirm" style="display:none;">创建</a> 
					</div>
				</div>
			</div>
		</div>
		<!-- 模态框 重设密码 -->
		<div class="modal fade" id="resert_password" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">重设密码</h4>
					</div>
					<!-- modal 主体-->
					<div class="modal-body">
						<form class="form-horizontal center-block" id="reset_password_form" role="form">
							<input type="hidden" id="res_uuid_hidden" value=""/>
							<input type="hidden" id="acct_uuid_hidden" value=""/>
							<input type="hidden" id="user_uuid_hidden" value=""/>
							
							<div class="form-group">
								<label for="resId" class="col-md-3 control-label">原密码</label>
								<div class="col-md-5">
									<input type="password" class="form-control" id="old_pwd" name="old_pwd"
										placeholder="">
								</div>
							</div>
							<div class="form-group">
								<label for="resId" class="col-md-3 control-label">新密码</label>
								<div class="col-md-5">
									<input type="password" class="form-control" id="new_pwd" name="new_pwd"
										placeholder="">
								</div>
							</div>
							<div class="form-group">
								<label for="resId" class="col-md-3 control-label">确认密码</label>
								<div class="col-md-5">
									<input type="password" class="form-control" id="new_pwd2" name="new_pwd2"
										placeholder="">
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<a type="button" class="btn btn-primary" data-dismiss="modal" id="resert_password_confirm">确认</a> 
					</div>
				</div>
			</div>
		</div>
		
		<!-- 模态框 编辑账号属性 -->
		<div class="modal fade" id="edit_account" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">编辑账号属性</h4>
					</div>
					<!-- modal 主体-->
					<div class="modal-body">
						<form class="form-horizontal center-block" id="account_attribute_form" role="form">
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<a type="button" class="btn btn-primary" data-dismiss="modal" id="edit_account_confirm">确认</a> 
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
	<script src="js/bootstrap-notify.js?version=<%=Math.random()%>"></script>
	<!-- initial page -->
	<script src="js/init.js?version=<%=Math.random()%>"></script>
	<!-- jqPaginator分页 -->
	<script src="js/jqPaginator.js?version=<%=Math.random()%>"></script>
	<!-- account.js -->
	<script src="js/account.js?version=<%=Math.random()%>"></script>
	<script type="text/javascript">
		$(function() {
			var useraccountuuid = GetQueryString('useraccountuuid');
			$("#resources_div").css("display", "block");
			$("#search_result").text("查询账号结果");
			$('#pagination0')
					.jqPaginator(
							{
								totalPages : parseInt('${entitlementListPaginator.totalPages}'),
								visiblePages : 5,
								currentPage : parseInt('${entitlementListPaginator.page}'),
								first : '<li class="prev"><a href="javascript:;">首页</a></li>',
								prev : '<li class="prev"><a href="javascript:;">上一页</a></li>',
								next : '<li class="next"><a href="javascript:;">下一页</a></li>',
								last : '<li class="prev"><a href="javascript:;">末页</a></li>',
								page : '<li class="page"><a href="javascript:;">{{page}}</a></li>',
								onPageChange : function(num, type) {
									if (type == "change") {
										location.href = "toidentity/accountdetail.action?useraccountuuid="+useraccountuuid+"&page="
												+ num;
									}
								}
							});
		})
	</script>
</body>
</html>