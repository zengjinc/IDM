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
				<input type="text" class="form-control" id="userUuid" name="userUuid" placeholder="">
			</div>
		</div>
		<div class="form-group">
			<label for="userName" class="col-md-5 control-label">用户名称</label>
			<div class="col-md-3">
				<input type="text" class="form-control" id="userName" name="userName" placeholder="">
			</div>
		</div>
		<div class="form-group">
			<label for="userOu" class="col-md-5 control-label">组织单位</label>
			<div class="col-md-3">
				<input type="text" class="form-control" id="userOu" name="userOu" placeholder="">
			</div>
		</div>
		<div class="form-group">
			<label for="userBizRole" class="col-md-5 control-label">岗位</label>
			<div class="col-md-3">
				<select class="form-control" id="userBizRole" name="userBizRole">
					<option value="">-</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="userStatus" class="col-md-5 control-label">状态</label>
			<div class="col-md-3">
				<select class="form-control" id="userStatus" name="userStatus">
					<option>-</option>
					<option value="1">已激活</option>
					<option value="0">已禁用</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="userType" class="col-md-5 control-label">用户类型</label>
			<div class="col-md-3">
				<select class="form-control" id="userType" name="userType">
					<option>-</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="trust_res" class="col-md-5 control-label">信任资源</label>
			<div class="col-md-3">
				<select class="form-control" id="trust_res" name="trust_res">
					<option value="">-</option>
					<option value="true">是</option>
					<option value="false">否</option>
				</select>
			</div>
		</div>
		<div class="form-group" id="resources_div" style="display: none;">
			<label for="resources" class="col-md-5 control-label">资源</label>
			<div class="col-md-3">
				<select class="form-control" id="resources" name="resources">
					<option value="">-</option>
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
	<table class="table table-bordered table-hover table-striped" id="user_table">
		<caption id="search_result">查询用户结果</caption>
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
		</tbody>
	</table>
	<!-- 控制分页的元素 用 class进行分页的话可以有上下两个分页导航，要求要在表格上面也有一个一样的ul -->
	<center>
		<ul class="pagination" id="pagination0"></ul>
	</center>
</body>
</html>