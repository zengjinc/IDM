<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<div class="row">
			<nav class="navbar navbar-default">
			  <div class="container-fluid">
			    <!-- Brand and toggle get grouped for better mobile display -->
			    <div class="navbar-header">
			      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
			        <span class="sr-only">Toggle navigation</span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			      </button>
			      <a class="navbar-brand" href="toidentity.action">身份管理系统</a>
			    </div>
			
			    <!-- Collect the nav links, forms, and other content for toggling -->
			    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			      <ul class="nav navbar-nav navbar-left">
			        <li><a href="toidentity.action">身份管理</a></li>
<!-- 			        <li><a href="toou.action">组织单位管理</a></li> -->
			        <li><a href="toresource.action">资源管理</a></li>
			        <li><a href="topolicy.action">策略管理</a></li>
			        <li><a href="totask.action">任务管理</a></li>
			        <li><a href="toconfig.action">系统设置</a></li>
			        
			      </ul>
			      <ul class="nav navbar-nav navbar-right">
			        <li><a href="#"id="toggle_nav" onclick="return false">隐藏导航</a></li>
			        <li><a href="#" onclick="return false" data-toggle="modal" data-target="#resert_user_password">修改密码</a></li>
			        <li><a href="logout.action" onclick="return logOutConfirm();">退出</a></li>
			      </ul>
			    </div><!-- /.navbar-collapse -->
			  </div><!-- /.container-fluid -->
			</nav>
		</div>
		
		<!-- 模态框 修改密码 -->
		<div class="modal fade" id="resert_user_password" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2" aria-hidden="true" data-backdrop="static">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel2">修改密码</h4>
					</div>
					<!-- modal 主体-->
					<div class="modal-body">
						<form class="form-horizontal center-block" id="reset_user_password_form" role="form">
							
							<div class="form-group">
								<label for="resId" class="col-md-3 control-label">原密码</label>
								<div class="col-md-5">
									<input type="password" class="form-control" id="old_user_pwd" name="old_pwd"
										placeholder="">
								</div>
							</div>
							<div class="form-group">
								<label for="resId" class="col-md-3 control-label">新密码</label>
								<div class="col-md-5">
									<input type="password" class="form-control" id="new_user_pwd" name="new_pwd"
										placeholder="">
								</div>
							</div>
							<div class="form-group">
								<label for="resId" class="col-md-3 control-label">确认密码</label>
								<div class="col-md-5">
									<input type="password" class="form-control" id="new_user_pwd2" name="new_pwd2"
										placeholder="">
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<a type="button" class="btn btn-primary" data-dismiss="modal" id="resert_user_password_confirm">确认</a> 
					</div>
				</div>
			</div>
		</div>
		
</body>
</html>