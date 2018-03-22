<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 导入子导航栏 -->
	<%@ include file="../subnav.jsp" %>
	<script type="text/javascript" src="js/jquery-2.2.4.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$(".nav.nav-pills.nav-stacked").prepend("<li><a href='toconfig/platformrole.action'>平台角色</a></li>");
			$(".nav.nav-pills.nav-stacked").prepend("<li><a href='toconfig/bizrole.action'>岗位</a></li>");
			$(".nav.nav-pills.nav-stacked").prepend("<li><a href='toconfig/userattrdef.action'>用户属性定义</a></li>");
			$(".nav.nav-pills.nav-stacked").prepend("<li><a href='toconfig/attrtype.action'>属性类型</a></li>");
			$(".nav.nav-pills.nav-stacked").prepend("<li><a href='toconfig/systemconfig.action'>系统配置</a></li>");
		})
	</script>
</body>
</html>