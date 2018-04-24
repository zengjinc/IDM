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
<title>角色冲突策略详情</title>
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
							<span class="input-group-addon">角色冲突策略标识</span> <input id="roleconflict_pol_id" type="text" class="form-control">
						</div>
					</div>
					<div class="col-md-5 col-md-offset-1">
						<div class="input-group">
							<span class="input-group-addon">角色冲突策略名称</span> <input id="roleconflict_pol_name" type="text" class="form-control">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-5">
						<div class="input-group">
							<span class="input-group-addon">角色冲突策略描述</span> <input id="roleconflict_pol_desc" type="text" class="form-control">
						</div>
					</div>
				</div>
				<ul id="myTab" class="nav nav-tabs">
					<li class="active"><a href="#home" data-toggle="tab">规则</a></li>
				</ul>
				<div id="myTabContent" class="tab-content" style="min-height:50vh;">
					<div class="tab-pane fade in active" id="home">
						<table class="table table-striped" id="role_conflict_table">
							<thead>
								<tr>
									<th>角色</th>
									<th>最大允许数量</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody></tbody>
							<tfoot>
								<tr>
									<td style="vertical-align:middle;"><textarea class="form-control" rows="5" id="role_textarea" data-value=""></textarea></td>	<!-- xxxResource->xxxRole&#10;xxxResource->xxxRole -->
									<td style="vertical-align:middle;"><input id="max_num" type="text" class="form-control" /></td>
									<td style="vertical-align:middle;"><button class="btn btn-primary" id="add_roleconflict_pol">添&nbsp;&nbsp;加</button></td>
								</tr>
							</tfoot>
						</table>
					</div>
				</div>
				<div class="center-block">
					<button class="btn btn-primary" id="save_role_conflict_btn">保&nbsp;&nbsp;存</button>
					<a class="btn btn-primary" href="topolicy/roleconflict.action">取&nbsp;&nbsp;消</a>
				</div>
			</div>
		</div>
		<!-- 模态框 选择对应资源的角色 -->
		<div class="modal fade" id="roleconflict_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">选择角色</h4>
					</div>
					<!-- modal 主体-->
					<div class="modal-body">
						<!-- 显示所有非信任资源的下拉框 ： 通过下拉框改变事件获取选中值 $('.selectpicker').on('changed.bs.select',function(e){	});-->
						<div class="center-block">
							<label for="resource_sel">资源 : </label>
							<select id="resource_sel" class="selectpicker"  data-live-search="true"  title="资源"></select>
						</div>
						<!-- tab2 -->
						<ul id="myTab2" class="nav nav-tabs">
							<li class="active" id="tab_role"><a href="#role_tab" data-toggle="tab">角色</a></li>
						</ul>
						<div id="myTabContent2" class="tab-content">
							<div class="tab-pane fade in active" id="role_tab">
								<table class="table table-bordered table-hover table-striped" id="role_tab_table">
									<caption id="search_result">&nbsp;</caption>
									<thead>
										<tr>
											<th><input type="checkbox" class="check_all"/></th>
											<th>角色标识</th>
											<th>角色名称</th>
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
						<button type="button" class="btn btn-primary" data-dismiss="modal" id="roleconflict_modal_confirm">确认</button> 
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="../commonscript.jsp" %>
	<script type="text/javascript" src="js/bootstrap-select.min.js"></script>
	<script type="text/javascript">
		$(function(){
			
			var policyUuid = GetQueryString("policyuuid");
			
			if(policyUuid != null){
				var jsonStr = {"etmPolUuid" : policyUuid};
				 $.ajax({
						type : 'post',
						url : 'topolicy/getpolicybyuuid.action',
						contentType : 'application/json;charset=utf-8',
	 					data : JSON.stringify(jsonStr),
						dataType : 'json',
						success : function(result){
							
							$("#roleconflict_pol_id").val(result.polId);
							$("#roleconflict_pol_name").val(result.polName);
							$("#roleconflict_pol_desc").val(result.polDesc);
							
							var roleconflict = JSON.parse(result.polJsonStr);
							
// 							console.log(roleconflict);
							
							for (var i = 0; i < roleconflict.length; i++) {
								console.log(roleconflict[i].itroles);
								console.log(roleconflict[i].maxNum);
								
								var itRoles = getItRole(roleconflict[i].itroles);
								console.log(itRoles);
								
								$("#role_conflict_table").append("<tr><td data-value='"+roleconflict[i].itroles+"'>"+itRoles+"</td><td>"+roleconflict[i].maxNum+"</td><td><button class='btn btn-primary remove_role_conflict'>删&nbsp;&nbsp;除</button></td></tr>");
								
							}
							
						}
					});
			}
			
			$("#role_textarea").focus(function(){
				$('#roleconflict_modal').modal('show');
			})
			
			//模态框显示事件,获取所有非信任资源
			$('#roleconflict_modal').on('show.bs.modal', function() {
				$.ajax({
					type : 'post',
					url : 'toidentity/getnontrustresource.action',
					contentType : 'application/json;charset=utf-8',// 指定为json类型
					dataType : 'json', // 服务器响应类型
					// data : JSON.stringify(jdbc),
					success : function(resourceList) {// 返回json结果
						for (var i = 0; i < resourceList.length; i++) {
							$("#resource_sel").append("<option value='"+resourceList[i].resUuid+"'>"+resourceList[i].resId+"</option>");
							
						}
						// 刷新下拉框，重新渲染 
				        $('#resource_sel').selectpicker('refresh');  
				        $('#resource_sel').selectpicker('render');  
					},
					error : function(information) {
						$.notify({
							icon : 'glyphicon glyphicon-danger-sign',
							title : '<strong>出错了</strong>',
							message : information
						}, {
							type : 'danger', // danger warning info success
							mouse_over : 'pause',
						});
					}
				});
			})
			
			//模态框隐藏事件
			$('#roleconflict_modal').on('hide.bs.modal', function() {
				$("#resource_sel").empty();
				$("#role_tab_table tr:not(:first)").empty();
			})
			
			//获取选中的资源的角色
			$('#resource_sel').on('changed.bs.select',function(e){
				$("#role_tab_table tr:not(:first)").empty();
				var value = $(this).val();
				$.ajax({
					type : 'post',
					url : 'topolicy/getitrolebyresuuid2.action',
					contentType : 'application/json;charset=utf-8',// 指定为json类型
					dataType : 'json', // 服务器响应类型
					data : JSON.stringify(value),
					success : function(resourceList) {// 返回json结果
						for (var i = 0; i < resourceList.length; i++) {
							
							$("#role_tab_table").append("<tr><td><input type='checkbox' class='check'></td><td data-value='"+resourceList[i].itroleUuid+"'>"+resourceList[i].itroleId+"</td><td>"+resourceList[i].itroleName+"</td></tr>");
							
						}
					},
					error : function(information) {
						$.notify({
							icon : 'glyphicon glyphicon-danger-sign',
							title : '<strong>出错了</strong>',
							message : information
						}, {
							type : 'danger', // danger warning info success
							mouse_over : 'pause',
						});
					}
				});
				
			});
		})
		
		//模态框确认按钮
		$("#roleconflict_modal_confirm").click(function(){
// 			var resUuid = $("#resource_sel").val();
			$("#role_textarea").val('');
			$("#role_textarea").attr('data-value','');

			var resId = $("#resource_sel").find("option:selected").text();
			
			$(".check").each(function() {
				if ($(this).is(':checked')) {
					var tr = $(this).parent().parent();
					var itroleId = tr.children("td:eq(1)").text();
					var itroleUuid = tr.children("td:eq(1)").attr('data-value');
					
					var value = $("#role_textarea").val();
					if(value.length > 0){
						$("#role_textarea").val(value + itroleId + "(" + resId + ");\n");
					}else{
						$("#role_textarea").val(itroleId + "(" + resId + ");\n");
					}
					
					var data = $("#role_textarea").attr('data-value');
					if(data.length > 0){
						$("#role_textarea").attr('data-value',data + "," + itroleUuid);
					}else{
						$("#role_textarea").attr('data-value',itroleUuid);
					}
					
					$(this).prop("checked", false);
				}
			})
			$(".check_all").prop("checked", false);
		})
		
		//全选
		$(".check_all").change(function(){
			if ($(this).is(':checked')) {
				$(".check").prop("checked", true);
			} else {
				$(".check").prop("checked", false);
			}
		});
		
		//添加策略项
		$("#add_roleconflict_pol").click(function(){
			var value = $("#role_textarea").val();
			var dataValue = $("#role_textarea").attr('data-value');
			var maxNum = $("#max_num").val();
			
			$("#role_conflict_table").append("<tr class='my_tr'><td data-value='"+dataValue+"'>"+value+"</td><td>"+maxNum+"</td><td><button class='btn btn-primary remove_role_conflict'>删&nbsp;&nbsp;除</button></td></tr>");
			
		})
		
		$(".container").on('click','.remove_role_conflict',function(){
			$(this).parent().parent().remove();
		})
		
		//保存角色冲突策略
		$("#save_role_conflict_btn").click(function(){
			var policyId = $("#roleconflict_pol_id").val();
			var policyName = $("#roleconflict_pol_name").val();
			var policyDesc = $("#roleconflict_pol_desc").val();
			
			var polArr = new Array();
				
			$(".my_tr").each(function(){
				var itroles = $(this).children("td:eq(0)").attr('data-value');
				var maxNum = $(this).children("td:eq(1)").text();
				
				var polJson = {"itroles" : itroles, "maxNum" : maxNum};
				
				polArr.push(polJson);
			})
			
			var policyUuid = GetQueryString("policyuuid");
			var jsonStr = {"policyUuid" : policyUuid, "policyId" : policyId, "policyName" : policyName, "policyDesc" : policyDesc, "polArr" : polArr};
			
			$.ajax({
				type : 'post',
				url : 'topolicy/saveroleconflictpolicy.action',
				contentType : 'application/json;charset=utf-8',
					data : JSON.stringify(jsonStr),
				dataType : 'text',
				success : function(information){
					if(information.indexOf("success") >= 0){
						$.notify({
							icon : 'glyphicon glyphicon-success-sign',
							title : '<strong>保存角色冲突策略结果</strong>',
							message : "成功",
							allow_dismiss : false
							// url: 'https://github.com/mouse0270/bootstrap-notify',
							// target: '_blank'
						}, {
							type : 'success', // danger warning info success
							mouse_over : 'pause'
						});
						setTimeout(function(){window.location.href='topolicy/roleconflict.action'}, 2000);
					}else{
						$.notify({
							icon : 'glyphicon glyphicon-success-sign',
							title : '<strong>保存角色冲突策略结果：出错！</strong>',
							message : information,
							allow_dismiss : false
						}, {
							type : 'warning', // danger warning info success
							mouse_over : 'pause'
						});
					}
				}
			});
			
		})
		function getItRole(roleString){
			
			var roleArr;
			
			if(roleString.indexOf(",") >= 0){
				
				roleArr = roleString.split(',');
			}else{
				
				roleArr = roleString;
			}
			
			var data;
			
			$.ajax({
				type : 'post',
				url : 'topolicy/getRole.action',
				contentType : 'application/json;charset=utf-8',
				data : JSON.stringify(roleArr),
				dataType : 'json',
				async : false,
				success : function(result){
	//					console.log("result : " + result);
					for (var i = 0; i < result.length; i++) {
						if(result[i] != null){
							if(data != undefined){
								data +=result[i].itroleId;
								
								var resource = getResource(result[i].itroleResUuid);
								
								data += resource + ";";
							}else{
								
								data = result[i].itroleId;
								
								var resource = getResource(result[i].itroleResUuid);
								
								data += resource + ";";
							}
						}
					}
				}
			});
			
			return data;
		}
		
		function getResource(resUuid){
			var data = "";
			
			var jsonStr = {"resUuid" : resUuid};
			$.ajax({
				type : 'post',
				url : 'topolicy/getResource.action',
				contentType : 'application/json;charset=utf-8',
				data : JSON.stringify(jsonStr),
				dataType : 'json',
				async : false,
				success : function(result){
					data = "(" + result.resId + ")";
				}
			});
			return data;
		}
	</script>
</body>
</html>