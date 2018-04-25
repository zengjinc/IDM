<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<!-- font-awesome -->
<link href="css/font-awesome.min.css" rel="stylesheet">
<script type="text/javascript" src="js/loading.js"></script>
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<title>登录</title>

<style>
      html, body {
          margin: 0;
          padding: 0;
          width: 100%;
          height: 100%;
          overflow: hidden;
          background: black;
          background:linear-gradient(to bottom, #17202c 0%, #644e3f 100%);
	/*background: radial-gradient(ellipse at bottom, #1b2735 0%, #090a0f 100%);	*/
  }

      #main-canvas {
          width: 100%;
          height: 100%;
      }

      .filter {
          width: 100%;
          height: 100%;
          position: absolute;
          top: 0;
          left: 0;
          background: #6f42c1;
          animation: colorChange 30s ease-in-out infinite;
          animation-fill-mode: both;
          mix-blend-mode: overlay;
      }

      @keyframes colorChange {
          0%, 100% {
              opacity: 0;
          }
          50% {
              opacity: .7;
          }
      }


	.form{background: rgba(255,255,255,0.2);width:400px;margin:120px auto;}
	/*阴影*/
	.fa{display: inline-block;top: 27px;left: 6px;position: relative;color: #ccc;}
	input[type="text"],input[type="password"]{padding-left:26px;}
	.checkbox{padding-left:21px;}
</style>
</head>

<body>

	<canvas id="canvas"></canvas>
	<div class="container" style="position:absolute; top:0; left:0;width:100%;height:100%;">
		<div class="form row">
			<div class="form-horizontal col-md-offset-3" id="login_form">
				<h3 class="form-title"><font color="white">登录</font></h3>
				<div class="col-md-9">
					<div class="form-group">
						<i class="fa fa-user fa-lg"></i>
						<input class="form-control required" type="text" placeholder="用户名" id="username" autofocus="autofocus" maxlength="20"/>
					</div>
					<div class="form-group">
							<i class="fa fa-lock fa-lg"></i>
							<input class="form-control required" type="password" placeholder="密码" id="password"/>
					</div>
					<div class="form-group">
						<label class="checkbox">
							<input type="checkbox" id="remember"/><font color="white">记住我</font>
						</label>
					</div>
					<div class="form-group col-md-offset-9">
						<button id="submit" class="btn btn-success pull-right" name="submit">登&nbsp;&nbsp;录</button>
					</div>
				</div>
			</div>
		</div>
	</div>

    <script src="js/canvasStar.js"></script>
    <script>
        var CanvasStar = new CanvasStar;
        CanvasStar.init();
    </script>
  
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery-2.2.4.min.js"></script>
	<script src="js/jquery.cookie.js"></script>
	
	<!-- bootstrap.js -->
	<script src="js/bootstrap.js"></script>
	
	<!-- bootstrap notify -->
	<script src="js/bootstrap-notify.js?version=<%=Math.random()%>"></script>
	
	<!-- initial page -->
	<script src="js/init.js?version=<%=Math.random()%>"></script>
	
	<!-- jqPaginator分页 -->
	<script src="js/jqPaginator.js?version=<%=Math.random()%>"></script>
	
	<script type="text/javascript">
		
	
		$(function(){
			document.onkeydown = function(e){ 
				var ev = document.all ? window.event : e; 
				
				if(ev.keyCode==13) { 
					$('#submit').click();
				}
			
			} 
			
			var cookieRmbMe = $.cookie('rmbMe');
			var cookieUserName = $.cookie('userName');
			var cookiePwd = $.cookie('pwd');
			
			if(cookieRmbMe != undefined && cookieRmbMe != "false"){
				$("#username").val(cookieUserName);
				$("#password").val(cookiePwd);
				$("#remember").prop("checked", true);
			}
			
			
			$("#submit").click(function(){
				var userName = $("#username").val();
				var pwd = $("#password").val();
				var remMe = $("#remember").is(':checked');
				
				console.log("remMe : " + remMe);
				
				if(!remMe){
					
					$.cookie("rmbMe", "false", { expires: -1 }); // 删除 cookie
			        $.cookie("userName", '', { expires: -1 });
			        $.cookie("pwd", '', { expires: -1 });
					
					var result = login(userName,pwd);
					
					if(result.result.indexOf("success") >= 0){
						window.location.href='toidentity/user.action';
					}else{
						$.notify({
							icon : 'glyphicon glyphicon-danger-sign',
							title : '<strong>登录失败</strong>',
							message : result.result
						}, {
							type : 'warning', // danger warning info success
							mouse_over : 'pause',
						});
					}
					
					
					
				}else{
					//判断 cookie 中有没有值
					var cookieRmbMe = $.cookie('rmbMe');
					var cookieUserName = $.cookie('userName');
					var cookiePwd = $.cookie('pwd');
					
					console.log("cookieUserName : " + cookieUserName);
					console.log("cookiePwd : " + cookiePwd);
					
					if(cookieUserName == undefined || cookieUserName == ""){
						//cookie 中没有对应的值
						var result = login(userName,pwd);
						
						if(result.result.indexOf("success") >= 0){
							var encPwd = result.encPwd;
							
							$.cookie("rmbMe", "true", { expires: 7 });
							$.cookie("userName", userName, { expires: 7 });
							$.cookie("pwd", encPwd, { expires: 7 });
							
							window.location.href='toidentity/user.action';
						}else{
							$.notify({
								icon : 'glyphicon glyphicon-danger-sign',
								title : '<strong>登录失败</strong>',
								message : result.result
							}, {
								type : 'warning', // danger warning info success
								mouse_over : 'pause',
							});
						}
					}else{
						
						var userName1 = $("#username").val();
						var pwd1 = $("#password").val();
						
						var returnResult = loginByCookie(userName1,pwd1);
						
						if(returnResult.indexOf("success") >= 0){
							window.location.href='toidentity/user.action';
						}else{
							$.notify({
								icon : 'glyphicon glyphicon-danger-sign',
								title : '<strong>登录失败</strong>',
								message : result
							}, {
								type : 'warning', // danger warning info success
								mouse_over : 'pause',
							});
						}
						
					}
					
				}
				
			})
			
			$("#remember").click(function(){
				var flag = $(this).is(':checked');
				if(!flag){
					$("#password").val('');	
				}
			})
			
		})
		
		function login(userName,pwd){
				var data;
				
				var jsonStr = {"userName" : userName, "pwd" : pwd};
				$.ajax({
					type : 'post',
					url : 'login.action',
					contentType : 'application/json;charset=utf-8',
					data : JSON.stringify(jsonStr),
					dataType : 'json',
					async : false,
					success : function(result){
						data = result;
					},
					error : function(result){
						$.notify({
							icon : 'glyphicon glyphicon-danger-sign',
							title : '<strong>登录失败</strong>',
							message : "未知错误"
						}, {
							type : 'danger', // danger warning info success
							mouse_over : 'pause',
						});
					}
				});
				
				return data;
			}
			
			function loginByCookie(userName,pwd){
				var data = "";
				
				var jsonStr = {"userName" : userName, "pwd" : pwd};
				
				$.ajax({
					type : 'post',
					url : 'cookielogin.action',
					contentType : 'application/json;charset=utf-8',
					data : JSON.stringify(jsonStr),
					dataType : 'text',
					async : false,
					success : function(result){
						data = result;
					},
 					error : function(result){
 						console.log("error : " + result);
 						$.notify({
 							icon : 'glyphicon glyphicon-danger-sign',
 							title : '<strong>登录失败</strong>',
 							message : "未知错误"
 						}, {
 							type : 'danger', // danger warning info success
 							mouse_over : 'pause',
 						});
 					}
				});	
				
				return data;
				
			}
	</script>
	
</body>
</html>