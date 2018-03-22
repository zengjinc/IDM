<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
ul.nav-pills {
	width: 140px;
	margin-top: 20px;
	border-radius: 4px;
	border: 1px solid #ddd;
	box-shadow: 0 1px 4px rgba(0, 0, 0, 0.067);
}

ul.nav-pills li {
	margin: 0;
	border-top: 1px solid #ddd;
}

ul.nav-pills li:first-child {
	border-top: none;
}

ul.nav-pills li a {
	margin: 0;
	padding: 8px 16px;
	border-radius: 0;
}

ul.nav-pills li.active a, ul.nav-pills li.active a:hover {
	color: #fff;
	background: #0088cc;
	border: 1px solid #0088cc;
}

ul.nav-pills li:first-child a {
	border-radius: 4px 4px 0 0;
}

ul.nav-pills li:last-child a {
	border-radius: 0 0 4px 4px;
}

ul.nav-pills.affix {
	top: 30px; /* Set the top position of pinned element */
}

.affix {
	position: sticky;
}
</style>
</head>
<body>
	<div class="col-md-2" id="myScrollspy" style="background: #f2f2f2;">
		<ul class="nav nav-pills nav-stacked center-block" data-spy="affix" data-offset="125">
			<li><a href="javascript:scroll(0,0);">返回顶部</a></li>
		</ul>
	</div>
</body>
</html>