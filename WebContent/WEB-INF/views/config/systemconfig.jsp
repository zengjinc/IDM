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
<title>系统配置</title>
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
			<%@ include file="confignav.jsp"%>
			<!-- 主体右 -->
			<div class="col-md-10 subject">
				<div class="row">
					<div class="col-md-5">
						<div class="input-group">
							<span class="input-group-addon">系统配置标识</span> <input id="sysconfig_id" name="date" value="IDMConfiguration" type="text" class="form-control">
						</div>
					</div>
					<div class="col-md-5 col-md-offset-1">
						<div class="input-group">
							<span class="input-group-addon">系统配置名称</span><input id="sysconfig_name" name="date" value="IDMConfiguration" type="text" class="form-control">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-5">
						<div class="input-group">
							<span class="input-group-addon">系统配置描述</span> <input id="sysconfig_desc" name="date" value="IDM Configuration" type="text" class="form-control">
						</div>
					</div>
				</div>
				<ul id="myTab" class="nav nav-tabs">
					<li class="active"><a href="#home" data-toggle="tab">邮件</a></li>
					<li><a href="#template" data-toggle="tab">邮件模板</a></li>
				</ul>
				<div id="myTabContent" class="tab-content">
					<div class="tab-pane fade in active" id="home">
						<table class="table table-striped">
							<thead>
								<tr>
									<th colspan="3">SMTP服务器信息</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>主机</td>
									<td><input id="host" type="text" value="${host}" class="form-control" readonly="readonly"/></td>
									<td></td>
								</tr>
								<tr>
									<td>端口</td>
									<td><input id="port" type="text" value="${port}" class="form-control" readonly="readonly"/></td>
									<td></td>
								</tr>
								<tr>
									<td>安全通道</td>
									<td><select class="form-control" id="ssl" disabled="disabled">
											<c:if test="${ssl == false}">
											<option value="false">false</option>
											<option value="true">true</option>
											</c:if>
											<c:if test="${ssl == true}">
											<option value="true">true</option>
											<option value="false">false</option>
											</c:if>
										</select></td>
									<td>使用SMTP的SSL/ TLS连接到服务器</td>
								</tr>
								<tr>
									<td>启用STARTTLS</td>
									<td><select class="form-control" id="starttls" disabled="disabled">
											<c:if test="${startTls == false}">
											<option value="false">false</option>
											<option value="true">true</option>
											</c:if>
											<c:if test="${startTls == true}">
											<option value="true">true</option>
											<option value="false">false</option>
											</c:if>
										</select></td>
									<td>设为“true”则为SMTP启用STARTTLS。若已启用SMTPS ，则请禁用它。</td>
								</tr>
								<tr>
									<td>服务器是否需要验证</td>
									<td>
										<select class="form-control" id="auth" disabled="disabled">
											<c:if test="${auth == false}">
											<option value="false">false</option>
											<option value="true">true</option>
											</c:if>
											<c:if test="${auth == true}">
											<option value="true">true</option>
											<option value="false">false</option>
											</c:if>
										</select>
									</td>
									<td></td>
								</tr>
								<tr>
									<td>用户名</td>
									<td><input id="username" type="text" value="${username}" class="form-control" readonly="readonly"/></td>
									<td></td>
								</tr>
								<tr>
									<td>密码</td>
									<td><input id="pwd" type="password"  value="${password}" class="form-control" readonly="readonly"/></td>
									<td></td>
								</tr>
							</tbody>
						</table>
						<div class="center-block">
							<button class="btn btn-primary" id="save_email_btn" style="display:none;">保&nbsp;&nbsp;存</button>
							<button class="btn btn-primary" id="edit_email_btn">编&nbsp;&nbsp;辑</button>
						</div>
					</div>
					<div class="tab-pane fade" id="template">
						<table class="table table-bordered table-hover table-striped"
							id="res_table">
							<caption>&nbsp;</caption>
							<thead>
								<tr>
									<th>模板标识</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>授权账号 - 已完成</td>
									<td><button class="btn btn-primary view_template" data-value="etm_finish">查&nbsp;&nbsp;看</button></td>
								</tr>
								<tr>
									<td>授权账号 - 已取消</td>
									<td><button class="btn btn-primary view_template" data-value="etm_cancel">查&nbsp;&nbsp;看</button></td>
								</tr>
								<tr>
									<td>授权账号 - 已激活</td>
									<td><button class="btn btn-primary view_template" data-value="etm_enable">查&nbsp;&nbsp;看</button></td>
								</tr>
								<tr>
									<td>授权账号 - 已禁用</td>
									<td><button class="btn btn-primary view_template" data-value="etm_disable">查&nbsp;&nbsp;看</button></td>
								</tr>
								<tr>
									<td>账号 - 修改密码</td>
									<td><button class="btn btn-primary view_template" data-value="change_password">查&nbsp;&nbsp;看</button></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<!-- 模态框 查看模板 -->
		<div class="modal fade" id="view_template" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">邮件模板</h4>
					</div>
					<!-- modal 主体-->
					<div class="modal-body">
						<label class="control-label">模板主体</label>
						<textarea id="template_body" class="form-control" style="width:100%; height:300px;font-size:20px;">${userBizRoleList}</textarea>
						<div id="template_body_preview"></div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<a type="button" class="btn btn-primary" id="view_template_recovery_btn">恢复默认</a> 
						<a type="button" class="btn btn-primary" id="view_template_preview_btn">预&nbsp;&nbsp;览</a> 
						<a type="button" class="btn btn-primary" id="view_template_confirm_btn">确&nbsp;&nbsp;认</a> 
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="../commonscript.jsp" %>
	<script type="text/javascript">
		$(function(){
			$("#edit_email_btn").click(function(){
				$("select").each(function () {
					 $("#" + this.id).removeAttr("disabled");
					});
				$("#host").removeAttr("readonly");
				$("#port").removeAttr("readonly");
				$("#username").removeAttr("readonly");
				$("#pwd").removeAttr("readonly");
				
				$(this).hide();
				$("#save_email_btn").show();
			})
			
			$("#save_email_btn").click(function(){
				$("select").each(function () {
					 $("#" + this.id).attr("disabled",true);
					});
				$("#host").attr("readonly","readonly");
				$("#port").attr("readonly","readonly");
				$("#username").attr("readonly","readonly");
				$("#pwd").attr("readonly","readonly");
				
				$(this).hide();
				$("#edit_email_btn").show();
				
				var host = $("#host").val();
				var port = $("#port").val();
				var ssl = $("#ssl").val();
				var starttls = $("#starttls").val();
				var auth = $("#auth").val();
				var username = $("#username").val();
				var pwd = $("#pwd").val();
				
				var jsonStr = {"host" : host,"port" : port,"ssl" : ssl,"starttls" : starttls,"auth" : auth,"username" : username,"pwd" : pwd}
				
				$.ajax({
					type : 'post',
					url : 'toconfig/saveemail.action',
					contentType : 'application/json;charset=utf-8',
					data : JSON.stringify(jsonStr),
					dataType : 'text',
					success : function(result){
						if(result.indexOf("success") >= 0){
							$.notify({
								icon : 'glyphicon glyphicon-success-sign',
								title : '<strong>保存邮件配置结果</strong>',
								message : "成功",
								allow_dismiss : false
								// url: 'https://github.com/mouse0270/bootstrap-notify',
								// target: '_blank'
							}, {
								type : 'success', // danger warning info success
								mouse_over : 'pause'
							});
						}else{
							$.notify({
								icon : 'glyphicon glyphicon-success-sign',
								title : '<strong>保存邮件配置结果:未知错误</strong>',
								message : result,
								allow_dismiss : false
								// url: 'https://github.com/mouse0270/bootstrap-notify',
								// target: '_blank'
							}, {
								type : 'warning', // danger warning info success
								mouse_over : 'pause'
							});
						}
					}
				});
			})
			
			//查看邮件模板内容
			$(".view_template").click(function(){
				var template = $(this).attr('data-value');
				
				$("#view_template_confirm_btn").attr('data-value',template);
				
				var jsonStr = {"template" : template};
				
				$('#view_template').modal('show');
				
				$.ajax({
					type : 'post',
					url : 'toconfig/gettemplate.action',
					contentType : 'application/json;charset=utf-8',
					data : JSON.stringify(jsonStr),
					dataType : 'text',
					success : function(result){
						$("#template_body").val(result);
					}
				});
			})
			
			//模态框隐藏事件
			$('#view_template').on('hide.bs.modal', function () {
				$("#template_body").val('');
				$("#template_body_preview").html('');
			})
			
			//确认修改邮件模板
			$("#view_template_confirm_btn").click(function(){
				var template = $(this).attr('data-value');
				var templateBody = $("#template_body").val();
				
				var jsonStr = {"template" : template,"templateBody" : templateBody};
				
				
				$.ajax({
					type : 'post',
					url : 'toconfig/savetemplate.action',
					contentType : 'application/json;charset=utf-8',
					data : JSON.stringify(jsonStr),
					dataType : 'text',
					success : function(result){
						$('#view_template').modal('hide');
						if(result.indexOf("success") >= 0){
							$.notify({
								icon : 'glyphicon glyphicon-success-sign',
								title : '<strong>保存邮件模板结果</strong>',
								message : "成功",
								allow_dismiss : false
								// url: 'https://github.com/mouse0270/bootstrap-notify',
								// target: '_blank'
							}, {
								type : 'success', // danger warning info success
								mouse_over : 'pause'
							});
						}
					}
				});
			})
			 
			//预览模板
			$("#view_template_preview_btn").click(function(){
				$("#template_body_preview").html($("#template_body").val());
			})
			
			//恢复默认模板
			$("#view_template_recovery_btn").click(function(){
				var template = $("#view_template_confirm_btn").attr('data-value');
				if(template == "etm_finish"){
					var templateBody = '<html lang="utf-8">\n<body>\n<h3>你好，\$\{userName\}, 你已获得<font color="red"> \$\{resourceId\}</font> 的授权，信息如下!</h3><br>\n<h4><font color="red">账号：</font>\$\{loginId\}</h4>\n<h4><font color="red">密码：</font>\$\{password\}</h4><br>\n<h4>请在登录系统之后修改密码，谢谢！</h4>\n<h4>系统自动邮件，请勿回复。</h4>\n</body>\n</html>';
					$("#template_body").val(templateBody);
				}
				if(template == "etm_cancel"){
					var templateBody = '<html lang="utf-8">\n<body>\n<h3>你好，\$\{userName\}，你在 <font color="red">\$\{resourceId\}</font> 的授权已被收回，信息如下!</h3><br>\n<h4><font color="red">账号：</font>\$\{loginId\}</h4><br>\n<h4>如有需要，请与管理员联系，谢谢！</h4>\n<h4>系统自动邮件，请勿回复。</h4>\n</body>\n</html>';
					$("#template_body").val(templateBody);
				}
				if(template == "etm_enable"){
					var templateBody = '<html lang="utf-8">\n<body>\n<h3>你好，\$\{userName\}，你在 <font color="red">\$\{resourceId\}</font> 的授权已激活，信息如下!</h3><br>\n<h4><font color="red">账号：</font>\$\{loginId\}</h4><br>\n<h4>如有问题，请与管理员联系，谢谢！</h4>\n<h4>系统自动邮件，请勿回复。</h4>\n</body>\n</html>';
					$("#template_body").val(templateBody);
				}
				if(template == "etm_disable"){
					var templateBody = '<html lang="utf-8">\n<body>\n<h3>你好，\$\{userName\}, 你在 <font color="red">\$\{resourceId\}</font> 的授权已被禁用，信息如下!</h3><br>\n<h4><font color="red">账号：</font>\$\{loginId\}</h4><br>\n<h4>如有需要，请与管理员联系，谢谢！</h4>\n<h4>系统自动邮件，请勿回复。</h4>\n</body>\n</html>';
					$("#template_body").val(templateBody);
				}
				if(template == "change_password"){
					var templateBody = '<html lang="utf-8">\n<body>\n<h3>你好，\$\{userName\}，你在 <font color="red">\$\{resourceId\}</font> 的账号密码已修改，信息如下!</h3><br>\n<h4><font color="red">账号：</font> \$\{loginId\}</h4>\n<h4><font color="red">密码：</font> \$\{password\}</h4><br>\n<h4>请在登录系统之后修改密码，谢谢！</h4>\n<h4>系统自动邮件，请勿回复。</h4>\n	</body>\n</html>';
					$("#template_body").val(templateBody);
				}
			})
		})
	</script>
</body>
</html>