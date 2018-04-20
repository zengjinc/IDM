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
<link href="css/bootstrap-select.min.css" rel="stylesheet">
<!-- custom style -->
<link href="css/custom.css?version=<%=Math.random()%>" rel="stylesheet">
<script type="text/javascript" src="js/loading.js"></script>
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<title>授权策略</title>
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
							<span class="input-group-addon">授权策略标识</span> <input id="etm_pol_id" type="text" class="form-control">
						</div>
					</div>
					<div class="col-md-5 col-md-offset-1">
						<div class="input-group">
							<span class="input-group-addon">授权策略名称</span> <input id="etm_pol_name" type="text" class="form-control">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-5">
						<div class="input-group">
							<span class="input-group-addon">授权策略描述</span> <input id="etm_pol_desc" type="text" class="form-control">
						</div>
					</div>
				</div>
				<ul id="myTab" class="nav nav-tabs">
					<li class="active"><a href="#home" data-toggle="tab">规则</a></li>
				</ul>
				<div id="myTabContent" class="tab-content" style="min-height:50vh;">
					<div class="tab-pane fade in active" id="home">
						<table class="table table-striped" id="entitlement_table">
							<thead>
								<tr>
									<th>限制条件</th>
									<th>分配权限</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
							</tbody>
							<tfoot>
								<tr>
									<td style="vertical-align:middle;">
									<label for="biz_role">岗位</label><br>
									<select multiple="multiple" id="biz_role" class="selectpicker"  data-live-search="true"  title="">
										<option value="11">1</option>
									</select>
									
<!-- 									<input id="date_end" name="date2" type="text" class="form-control" placeholder="组织单位"/> -->
									</td>
									<td style="vertical-align:middle;"><textarea class="form-control" rows="5" id="entitlement_textarea">xxxResource->xxxRole</textarea></td>
									<td style="vertical-align:middle;"><button class="btn btn-primary" id="add_pol_btn">添&nbsp;&nbsp;加</button></td>
								</tr>
							</tfoot>
						</table>
					</div>
				</div>
				<div class="center-block">
					<button class="btn btn-primary" id="save_entitlement_btn">保&nbsp;&nbsp;存</button>
					<a class="btn btn-primary" href="topolicy/entitlement.action">取&nbsp;&nbsp;消</a>
				</div>
			</div>
		</div>
		<!-- 模态框，选择资源和角色 -->
		<div class="modal fade" id="entitlement_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">授权</h4>
					</div>
					<!-- modal 主体-->
					<div class="modal-body">
						<!-- 显示所有非信任资源的下拉框 ： 通过下拉框改变事件获取选中值 $('.selectpicker').on('changed.bs.select',function(e){	});-->
						<div class="center-block">
							<label for="resource_sel">资源 : </label>
							<select multiple="multiple" id="resource_sel" class="selectpicker"  data-live-search="true"  title="资源">
								<option value="11">1</option>
								<option value="22">2</option>
							</select>
						</div>
						<!-- tab2 -->
						<ul id="myTab2" class="nav nav-tabs">
							<li class="active" id="tab_resource"><a href="#resource_tab" data-toggle="tab">资源</a></li>
							<li id="tab_role"><a href="#role_tab" data-toggle="tab">角色</a></li>
						</ul>
						<div id="myTabContent2" class="tab-content">
							<div class="tab-pane fade in active" id="resource_tab">
								<table class="table table-bordered table-hover table-striped" id="resource_tab_table">
									<caption id="search_result">&nbsp;</caption>
									<thead>
										<tr>
											<th>资源标识</th>
											<th>资源名称</th>
											<th>所分配角色</th>
											<th>操作</th>	<!--  分配 -->
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>1</td>
											<td>1</td>
											<td>1</td>
											<td><button class="btn btn-primary select_role">选择角色</button></td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="tab-pane fade" id="role_tab">
								<table class="table table-bordered table-hover table-striped" id="role_tab_table">
									<caption id="search_result">&nbsp;</caption>
									<thead>
										<tr>
											<th>角色标识</th>
											<th>角色名称</th>
											<th>操作</th>	
										</tr>
									</thead>
									<tbody>
									</tbody>
								</table>
							</div>
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
						<button type="button" class="btn btn-primary" data-dismiss="modal" id="entitlement_modal_confirm">确认</button> 
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="../commonscript.jsp" %>
	<script type="text/javascript" src="js/bootstrap-select.min.js"></script>
	<script type="text/javascript">
		$(function(){
			//显示模态框
			$("#entitlement_textarea").focus(function(){
				$('#entitlement_modal').modal('show');
			})
			
			//添加授权策略
			$("#add_pol_btn").click(function(){
				var bizRole = $("#biz_role").val();
				var etm = $("#entitlement_textarea").text();
				
				$("#entitlement_table").append("<tr><td><label>"+bizRole+"</label></td><td><label>"+etm+"</label></td><td><button class='btn btn-primary remove_etm'>删&nbsp;&nbsp;除</td></tr>");
				
			})
			
			//选择角色
			$(".container").on('click','.select_role',function(){
				// 通过名称选取标签页
				$('#myTab2 a[href="#role_tab"]').tab('show');
			})
			
			//获取选中的资源
			$('#resource_sel').on('changed.bs.select',function(e){
				var value = $(this).val();
				console.log(value);
			});
		})
	</script>
</body>
</html>