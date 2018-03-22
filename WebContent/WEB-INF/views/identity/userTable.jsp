<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form class="form-horizontal center-block" role="form">
		<div class="form-group">
			<label for="userUuid" class="col-md-5 control-label">用户标识</label>
			<div class="col-md-3">
				<input type="text" class="form-control" id="userUuid" placeholder="">
			</div>
		</div>
		<div class="form-group">
			<label for="userName" class="col-md-5 control-label">用户名称</label>
			<div class="col-md-3">
				<input type="text" class="form-control" id="userName" placeholder="">
			</div>
		</div>
		<div class="form-group">
			<label for="userOu" class="col-md-5 control-label">组织单位</label>
			<div class="col-md-3">
				<input type="text" class="form-control" id="userOu" placeholder="">
			</div>
		</div>
		<div class="form-group">
			<label for="userBizRole" class="col-md-5 control-label">岗位</label>
			<div class="col-md-3">
				<select class="form-control">
					<option>-</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="userStatus" class="col-md-5 control-label">状态</label>
			<div class="col-md-3">
				<select class="form-control">
					<option>-</option>
					<option>已激活</option>
					<option>已禁用</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="userType" class="col-md-5 control-label">用户类型</label>
			<div class="col-md-3">
				<select class="form-control">
					<option>-</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="userTrustResource" class="col-md-5 control-label">信任资源</label>
			<div class="col-md-3">
				<select class="form-control">
					<option>-</option>
					<option>是</option>
					<option>否</option>
				</select>
			</div>
		</div>

		<div class="form-group">
			<div class="col-md-12">
				<button type="submit" class="btn btn-primary">查&nbsp;&nbsp;询</button>
			</div>
		</div>
	</form>
	<hr>
	<table class="table table-bordered table-hover table-striped">
		<caption>查询用户结果</caption>
		<thead>
			<tr>
				<th><input type="checkbox" /></th>
				<th>用户标识</th>
				<th>用户名称</th>
				<th>用户状态</th>
				<th>组织单位</th>
				<th>用户类型</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><input type="checkbox" /></td>
				<td>test</td>
				<td>test</td>
				<td>test</td>
				<td>test</td>
				<td>test</td>
				<td><a href="toidentity/userdetail.action">查看</a></td>
			</tr>
			<tr>
				<td><input type="checkbox" /></td>
				<td>test</td>
				<td>test</td>
				<td>test</td>
				<td>test</td>
				<td>test</td>
				<td><a href="toidentity/userdetail.action">查看</a></td>
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
</body>
</html>