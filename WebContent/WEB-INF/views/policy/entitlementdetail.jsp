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
<!-- 										<option value="11">1</option> -->
									</select>
									
<!-- 									<input id="date_end" name="date2" type="text" class="form-control" placeholder="组织单位"/> -->
									</td>
									<td style="vertical-align:middle;"><textarea class="form-control" rows="5" id="entitlement_textarea"></textarea></td>
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
							<select multiple="multiple" id="resource_sel" class="selectpicker"  data-live-search="true"  title="资源"></select>
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
			var etmPolUuid = GetQueryString("etmpoluuid");
			
			if(etmPolUuid != null){
				var jsonStr = {"etmPolUuid" : etmPolUuid};
				 $.ajax({
						type : 'post',
						url : 'topolicy/getpolicybyuuid.action',
						contentType : 'application/json;charset=utf-8',
	 					data : JSON.stringify(jsonStr),
						dataType : 'text',
						success : function(result){
							var data = JSON.parse(result);
							
							$("#etm_pol_id").val(data.polId);
							$("#etm_pol_name").val(data.polName);
							$("#etm_pol_desc").val(data.polDesc);
							
							var entitlement = JSON.parse(data.polJsonStr);
							
// 							console.log(entitlement);
							
							for (var i = 0; i < entitlement.length; i++) {
								
								//重新写两个函数用来做 ajax 请求
								var bizrole = getBizRole(entitlement[i].bizRole);//返回 bizRole 组合
								var resAndRole = getResourceAndRole(entitlement[i].entitlement);	//返回 xxx-->xxx 组合
								
	
								var resAndRoleStr = "";
								for (var k = 0; k < resAndRole.length; k++) {
									resAndRoleStr += resAndRole[k];
								}
								
								$("#entitlement_table").append("<tr class='my_tr1'><td data-value='"+entitlement[i].bizRole+"'>"+bizrole+"</td><td data-value='"+entitlement[i].entitlement+"'>"+resAndRoleStr+"</td><td><button class='btn btn-primary remove_etm'>删&nbsp;&nbsp;除</button></td></tr>");
								
							}
							
						}
					});
			}
			
			//保存当前授权策略
			$("#save_entitlement_btn").click(function(){
				var etmPolId = $("#etm_pol_id").val();
				var etmPolName = $("#etm_pol_name").val();
				var etmPolDesc = $("#etm_pol_desc").val();
				
				var etmArr = new Array();
				$("#entitlement_table").find("tbody").children().each(function(){
					var bizRole = $(this).children("td:eq(0)").attr('data-value');
					var entitlement = $(this).children("td:eq(1)").attr('data-value');
					
					var etmJson = {"bizRole" : bizRole, "entitlement" : entitlement};
					
					etmArr.push(etmJson);
				})
				
// 				console.log(etmArr);
				
				var jsonStr = {"etmPolUuid" : etmPolUuid,"etmPolId" : etmPolId, "etmPolName" : etmPolName, "etmPolDesc" : etmPolDesc, "etmArr" : etmArr};
				
				 $.ajax({
						type : 'post',
						url : 'topolicy/saveetmpolicy.action',
						contentType : 'application/json;charset=utf-8',
	 					data : JSON.stringify(jsonStr),
						dataType : 'text',
						success : function(information){
							if(information.indexOf("success") >= 0){
								$.notify({
									icon : 'glyphicon glyphicon-success-sign',
									title : '<strong>保存授权策略结果</strong>',
									message : "成功",
									allow_dismiss : false
									// url: 'https://github.com/mouse0270/bootstrap-notify',
									// target: '_blank'
								}, {
									z_index : 1051,
									type : 'success', // danger warning info success
									mouse_over : 'pause'
								});
								setTimeout(function(){window.location.href='topolicy/entitlement.action'}, 2000);
							}else{
								$.notify({
									icon : 'glyphicon glyphicon-success-sign',
									title : '<strong>保存授权策略结果：出错！</strong>',
									message : information,
									allow_dismiss : false
								}, {
									z_index : 1051,
									type : 'warning', // danger warning info success
									mouse_over : 'pause'
								});
							}
						}
					});
				
			})
			
			//页面加载完成时加载所有的岗位
			 window.onload = function(){  
				 $.ajax({
						type : 'post',
						url : 'toconfig/listallbizrole.action',
						contentType : 'application/json;charset=utf-8',
//	 					data : JSON.stringify(jsonStr),
						dataType : 'json',
						success : function(result){
							for (var i = 0; i < result.length; i++) {
							$("#biz_role").append("<option value='"+result[i].bizRoleUuid+"'>"+result[i].bizRoleName+"</option>");
							}
							// 刷新下拉框，重新渲染 
					        $('#biz_role').selectpicker('refresh');  
					        $('#biz_role').selectpicker('render');  
						}
					});
	         }
			
			//显示模态框
			$("#entitlement_textarea").focus(function(){
				$('#entitlement_modal').modal('show');
			})
			
			//模态框显示事件,获取所有非信任资源
			$('#entitlement_modal').on('show.bs.modal', function() {
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
							z_index : 1051,
							type : 'danger', // danger warning info success
							mouse_over : 'pause',
						});
					}
				});
			})
			//模态框隐藏事件
			$('#entitlement_modal').on('hide.bs.modal', function() {
				$("#resource_sel").empty();
				$("#resource_tab_table tr:not(:first)").empty();
				$("#role_tab_table tr:not(:first)").empty();
			})
			
			//添加授权策略
			$("#add_pol_btn").click(function(){
				var bizRoleUuid = $("#biz_role").val();
				var etm = $("#entitlement_textarea").val();
				var etmValue = $("#entitlement_textarea").attr('data-value');
				console.log(etm);
				var bizRoleName;
				$("#biz_role").find("option:selected").each(function(){
					if(bizRoleName == null || bizRoleName == ""){
						bizRoleName = $(this).text();
					}else{
						bizRoleName += "," + $(this).text();
					}				
				})
				
				var flag = false;
				$(".my_tr1").each(function(){
					var oldDataValue = $(this).children("td:eq(0)").attr('data-value');
					
					if(bizRoleUuid == oldDataValue){
						flag = true;
						$(this).children("td:eq(1)").text(etm);
						$(this).children("td:eq(1)").attr('data-value',etmValue);
					}
				})
				
				if(!flag){
					$("#entitlement_table").append("<tr class='my_tr1'><td data-value='"+bizRoleUuid+"'>"+bizRoleName+"</td><td data-value='"+etmValue+"'>"+etm+"</td><td><button class='btn btn-primary remove_etm'>删&nbsp;&nbsp;除</td></tr>");
				}
				
			})
			
			//选择角色
			var tr;
			$(".container").on('click','.select_role',function(){
				$("#role_tab_table tr:not(:first)").empty();				
				
				tr = $(this).parent().parent();
				var resUuid = tr.children("td:eq(0)").attr('data-value');
				var roles = tr.children("td:eq(2)").text();
				var roleArr = new Array();
				if(roles != ""){
					roleArr = roles.split(",");
// 					console.log(roleArr);
				}
				
				var jsonStr = {	"resUuid" : resUuid,"roleArr" : roleArr }
				
				$.ajax({
					type : 'post',
					url : 'topolicy/getitrolebyresuuid.action',
					contentType : 'application/json;charset=utf-8',// 指定为json类型
					dataType : 'json', // 服务器响应类型
					data : JSON.stringify(jsonStr),
					success : function(itroleList) {// 返回json结果
						
						for (var i = 0; i < itroleList.length; i++) {
							$("#role_tab_table").append("<tr><td data-value='"+itroleList[i].itroleUuid+"'>"+itroleList[i].itroleId+"</td><td>"+itroleList[i].itroleName+"</td><td><button class='btn btn-primary assign_role'>分&nbsp;&nbsp;配</button></td></tr>");
						}
						
					},
					error : function(information) {
						$.notify({
							icon : 'glyphicon glyphicon-danger-sign',
							title : '<strong>出错了</strong>',
							message : information
						}, {
							z_index : 1051,
							type : 'danger', // danger warning info success
							mouse_over : 'pause',
						});
					}
				});
				
				
				$('#myTab2 a[href="#role_tab"]').tab('show');
			})
			
			//分配角色
			$(".container").on('click','.assign_role',function(){
				$(this).prop('disabled', true);
				
				var roleId = $(this).parent().parent().children("td:eq(0)").text();
				var roleUuid = $(this).parent().parent().children("td:eq(0)").attr('data-value');
				
				var roles = tr.children("td:eq(2)").text();
				var rolesValue = tr.children("td:eq(2)").attr('data-value');
				
				if(roles != ""){
					tr.children("td:eq(2)").text(roles + "," + roleId);
					tr.children("td:eq(2)").attr('data-value',rolesValue + "," + roleUuid);
				}else{
					tr.children("td:eq(2)").text(roleId);
					tr.children("td:eq(2)").attr('data-value',roleUuid);
				}
			})
			
			//获取选中的资源
			$('#resource_sel').on('changed.bs.select',function(e){
				$("#resource_tab_table tr:not(:first)").empty();
				var value = $(this).val();
				$.ajax({
					type : 'post',
					url : 'topolicy/getresourcebyresuuid.action',
					contentType : 'application/json;charset=utf-8',// 指定为json类型
					dataType : 'json', // 服务器响应类型
					data : JSON.stringify(value),
					success : function(resourceList) {// 返回json结果
						for (var i = 0; i < resourceList.length; i++) {
							$("#resource_tab_table").append("<tr class='my_tr'><td data-value='"+resourceList[i].resUuid+"'>"+resourceList[i].resId+"</td><td>"+resourceList[i].resName+"</td><td></td><td><button class='btn btn-primary select_role'>选择角色</button></td></tr>");
						}
					},
					error : function(information) {
						$.notify({
							icon : 'glyphicon glyphicon-danger-sign',
							title : '<strong>出错了</strong>',
							message : information
						}, {
							z_index : 1051,
							type : 'danger', // danger warning info success
							mouse_over : 'pause',
						});
					}
				});
				
				$('#myTab2 a[href="#resource_tab"]').tab('show');
			});
			
			//模态框确认按钮
			$("#entitlement_modal_confirm").click(function(){
				
				$("#entitlement_textarea").val('');
				
				$(".my_tr").each(function(){
					
					if($(this).children().length > 0){
						var resource = $(this).children("td:eq(0)").text();
						var resourceUuid = $(this).children("td:eq(0)").attr('data-value');
						
						var roles = $(this).children("td:eq(2)").text();
						var rolesValue = $(this).children("td:eq(2)").attr('data-value');
						
						
						if(roles != null && roles != ""){
							
							var value = $("#entitlement_textarea").val();
							if(value != null && value != "" && value != undefined){
								
								$("#entitlement_textarea").val(value + resource + "-->" + roles + ";\n");
							}else{
								
								$("#entitlement_textarea").val(resource + "-->" + roles + ";\n");
							}
							
							var dataValue = $("#entitlement_textarea").attr('data-value');
							
							if(dataValue != null && dataValue != "" && dataValue != undefined){
								
								$("#entitlement_textarea").attr('data-value',dataValue + resourceUuid + "-->" + rolesValue + ";");
								
							}else{
								
								$("#entitlement_textarea").attr('data-value',resourceUuid + "-->" + rolesValue + ";");
							}
						}else{
							
							var value = $("#entitlement_textarea").val();
							
							if(value != null && value != "" && value != undefined){
								
								$("#entitlement_textarea").val(value + resource + ";\n");
							}else{
								
								$("#entitlement_textarea").val(resource + ";\n");
							}
							
							
							var dataValue = $("#entitlement_textarea").attr('data-value');
							
							if(dataValue != null && dataValue != "" && dataValue != undefined){
								
								$("#entitlement_textarea").attr('data-value',resourceUuid + ";");
							}else{
								
								$("#entitlement_textarea").attr('data-value',resourceUuid + ";");
							}
							
						}
					}
					
					
				})
			})
			
			//删除授权策略
			$(".container").on('click','.remove_etm',function(){
				$(this).parent().parent().remove();
			})
		})
		
		function getBizRole(bizRoleString){
			var bizRoleArr;
			if(bizRoleString.indexOf(",") >= 0){
				bizRoleArr = bizRoleString.split(',');
			}else{
				bizRoleArr = bizRoleString;
			}
			
			var data;
			
			$.ajax({
				type : 'post',
				url : 'topolicy/getBizrole.action',
				contentType : 'application/json;charset=utf-8',
				data : JSON.stringify(bizRoleArr),
				dataType : 'json',
				async : false,
				success : function(result){
					for (var i = 0; i < result.length; i++) {
						if(result[i] != null){
							if(data != undefined){
								data += "," + result[i].bizRoleId;
							}else{
								
								data = result[i].bizRoleId;
							}
						}
					}
				}
			});
			 
			return data;
		}
		
		function getResourceAndRole(resourceAndRolString){
			//// 53f9980fd98747ce889e00cfa40388ce;b9fce523af834989a97acdd2c991787c-->3debf1be7b9940ceb62d149561afd267,107e80b2c938466ea3cb16e20ec47e86;
// 			console.log("getResourceAndRole : " + resourceAndRolString);	
			
			var resAndRoleArr = resourceAndRolString.split(';');
			
			var data = new Array();
			
			var resource;
			var roleArr;
			var resId;
			var roleId;
			
			for (var i = 0; i < resAndRoleArr.length && resAndRoleArr[i].length > 0; i++) {
				
				if(resAndRoleArr[i].indexOf("-->") >= 0){
					resource = resAndRoleArr[i].split('-->')[0];
					
					resId = getResource(resource);	//返回resource
					
					
	 				roleArr = resAndRoleArr[i].split('-->')[1];
	 				roleId = getRole(roleArr);	//返回 role 组合
	 				
					data.push(resId + "-->" + roleId + ";");
	 				
				}else{
					resId = getResource(resAndRoleArr[i]);	//返回resource
					
					data.push(resId + ";");
				}
				
				
			}
			
			return data;
			
		}
		
		function getRole(roleString){
			
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
// 					console.log("result : " + result);
					for (var i = 0; i < result.length; i++) {
						if(result[i] != null){
							if(data != undefined){
								data += "," + result[i].itroleId;
							}else{
								
								data = result[i].itroleId;
							}
						}
					}
				}
			});
			
			return data;
		}
		
		function getResource(resource){
			var resId;
			 $.ajax({
					type : 'post',
					url : 'toresource/getresource.action',
					contentType : 'application/json;charset=utf-8',
					data : JSON.stringify(resource),
					dataType : 'json',
					async : false,
					success : function(result){
// 						var data = JSON.parse(result);
// 						resId = data.resId;
						resId = result.resId;
					}
				});
			return resId;
		}
		
		
	</script>
</body>
</html>