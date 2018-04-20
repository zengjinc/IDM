<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<!-- custom style -->
<link href="css/custom.css?version=<%=Math.random()%>" rel="stylesheet">
<link href="css/animate.css?version=<%=Math.random()%>" rel="stylesheet">
<script type="text/javascript" src="js/loading.js"></script>
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<title>用户详情</title>
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
			<%@ include file="resourcenav.jsp"%>
			<!-- 主体右 -->
			<div class="col-md-10 subject">
				<div class="row">
					<div class="col-md-4">
						<div class="input-group">
							<span class="input-group-addon">资源标识</span> <input id="resource_id" type="text" class="form-control" placeholder="">
						</div>
					</div>
					<div class="col-md-4 col-md-offset-2">
						<div class="input-group">
							<span class="input-group-addon">资源名称</span> <input id="resource_name" type="text" class="form-control" placeholder="">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="input-group">
							<span class="input-group-addon">资源描述</span> <input id="resource_desc" type="text" class="form-control" placeholder="">
						</div>
					</div>
					<div class="col-md-4 col-md-offset-2">
						<div class="input-group">
							<span class="input-group-addon">资源类型</span> <input id="resource_type" value="jdbcConnector" type="text" class="form-control" placeholder="" readonly="readonly">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="input-group">
							<span class="input-group-addon">归属账号</span> <input id="owner_account" type="text" class="form-control" placeholder="">
						</div>
					</div>
					<div class="col-md-4 col-md-offset-2">
						<div class="input-group">
							<span class="input-group-addon">归属组织单位</span> <input id="owner_ou" type="text" class="form-control" placeholder="">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="input-group">
							<span class="input-group-addon">信任资源</span> <select class="form-control" id="resource_trust">
								<option value="true">是</option>
								<option value="false">否</option>
							</select>
						</div>
					</div>
				</div>

				<ul id="myTab" class="nav nav-tabs">
					<li class="active" id="tab_config"><a href="#config" data-toggle="tab">配置</a></li>
					<li id="tab_acct"><a href="#account" data-toggle="tab">账号架构</a></li>
					<li id="tab_role"><a href="#role" data-toggle="tab">基本角色架构</a></li>
					<li id="ou_nav"><a href="#orgunit" data-toggle="tab">组织单位架构</a></li>
					<li id="ou_nav"><a href="#accounts" data-toggle="tab">账号</a></li>
				</ul>
				<div id="myTabContent" class="tab-content">
					<div class="tab-pane fade in active" id="config">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>名称</th>
									<th>内容</th>
									<th>描述</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>JDBC驱动类</td>
									<td><input id="jdbc_drive" type="text" class="form-control" value="com.mysql.jdbc.Driver" /></td>
									<td>MSSQL: com.microsoft.sqlserver.jdbc.SQLServerDriver（2005版本及以后） <br /> Oracle: oracle.jdbc.driver.OracleDriver <br /> MySql:
										com.mysql.jdbc.Driver</td>
								</tr>
								<tr>
									<td style="vertical-align: middle;">JDBC URL</td>
									<td style="vertical-align: middle;"><input id="jdbc_url" type="text" class="form-control" value="jdbc:mysql://localhost:3306/graduation_project" /></td>
									<td style="vertical-align: middle;">MSSQL: jdbc:sqlserver:// &lt;SERVER_NAME&gt;:&lt;PORT&gt; <br /> OracleThin: jdbc:oracle:thin:@&lt;HOST&gt;:&lt;PORT&gt;:&lt;SID&gt; <br /> MySql:
										jdbc:mysql://&lt;HOST&gt;:&lt;PORT&gt;/&lt;DB&gt;
									</td>
								</tr>
								<tr>
									<td>JDBC用户名</td>
									<td><input id="jdbc_username" type="text" class="form-control" /></td>
									<td></td>
								</tr>
								<tr>
									<td>JDBC密码</td>
									<td><input id="jdbc_pwd" type="password" class="form-control" /></td>
									<td></td>
								</tr>
								<tr>
									<td><button class="btn btn-primary" id="jdbc_test">测试连接</button></td>
									<td></td>
									<td></td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="tab-pane fade" id="account">
						<!-- 账号 -->
						<table class="table table-striped">
							<thead>
								<tr>
									<th colspan="3">用户</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>用户表名称</td>
									<td><input id="user_table" type="text" class="form-control" /></td>
									<td></td>
								</tr>
								<tr>
									<td style="vertical-align: middle;">UUID生成器类型</td>
									<td style="vertical-align: middle;"><select class="form-control" id="user_uuidgener_sel">
											<option value="Static">Static</option>
											<option value="SQL">SQL</option>
											<option value="Auto Increment">Auto Increment</option>
									</select></td>
									<td style="vertical-align: middle;">静态：身份管理系统将生成UUID。<br> SQL生成器：使用SQL生成UUID。<br> 自动递增：数据库根据身份列生成UUID。
									</td>
								</tr>
								<tr>
									<td style="vertical-align: middle;">用户UUID生产器脚本</td>
									<td style="vertical-align: middle;">	
									<textarea class="form-control" rows="8" id="uuidgener_text"></textarea></td>
									<td style="vertical-align: middle;">使用所提供的脚本来生成UUID。 <br> @返回UUID
									</td>
								</tr>
							</tbody>
						</table>
						<!-- 密码 -->
						<table class="table table-striped">
							<thead>
								<tr>
									<th colspan="3">密码</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>用户密码表名称</td>
									<td><input id="pwd_table" type="text" class="form-control" /></td>
									<td></td>
								</tr>
								<tr>
									<td style="vertical-align: middle;">用户密码列</td>
									<td style="vertical-align: middle;"><input id="pwd_col" type="text" class="form-control" /></td>
									<td style="vertical-align: middle;"></td>
								</tr>
								<tr>
									<td style="vertical-align: middle;">用户密码连接列</td>
									<td style="vertical-align: middle;"><input id="pwd_rel" type="text" class="form-control" /></td>
									<td style="vertical-align: middle;"></td>
								</tr>
								<tr>
									<td style="vertical-align: middle;">用户密码编码脚本&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
									<td style="vertical-align: middle;"><textarea class="form-control" rows="8" id="pwd_encoding_text"></textarea></td>
									<td style="vertical-align: middle;">使用所提供的脚本来生成编码密码。<br>@返回已编码的密码
									</td>
								</tr>
							</tbody>
						</table>
						<!-- 属性定义 -->
						<table class="table table-striped" id="attrdef_table">
							<thead>
								<tr>
									<th colspan="10">属性定义</th>
								</tr>
								<tr>
									<th><input type="checkbox" id="account_chk_all" /></th>
									<th>目标名称</th>
									<th>显示名称</th>
									<th>数据类型</th>
									<th>最小值/长度</th>
									<th>最大值/长度</th>
									<th>是必需的</th>
									<th>可编辑的</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
						<div class="row">
							<div class="center-block">
								<button class="btn btn-primary" id="account_btn_add_attrdef" data-toggle="modal" data-target="#attrdef_modal">添&nbsp;&nbsp;加</button>
								<button class="btn btn-primary" id="account_btn_del_attrdef">删&nbsp;&nbsp;除</button>
							</div>
						</div>
						<!-- 属性详细资料 -->
						<table class="table table-striped">
							<thead>
								<tr>
									<th colspan="4">属性详细资料</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>唯一标识符</td>
									<td><input id="account_uuid" type="text" class="form-control" /></td>
									<td>身份属性</td>
									<td><input id="account_id" type="text" class="form-control" /></td>
								</tr>
								<tr>
									<td>组织单位唯一标识符</td>
									<td><input id="account_ou_uuid" type="text" class="form-control" /></td>
									<td>创建时间属性</td>
									<td><input id="account_createtime" type="text" class="form-control" /></td>
								</tr>
								<tr>
									<td>修改时间属性</td>
									<td><input id="account_modifytime" type="text" class="form-control" /></td>
									<td>状态属性</td>
									<td><input id="account_status" type="text" class="form-control" /></td>
								</tr>
								<tr>
									<td>锁定标识属性</td>
									<td><input id="account_lock" type="text" class="form-control" /></td>
									<td></td>
									<td></td>
								</tr>
							</tbody>
						</table>
						<table class="table table-striped">
							<thead>
								<tr>
									<th colspan="2">状态属性值</th>
									<th colspan="2">锁定标识属性值</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>已启用/激活</td>
									<td><input id="account_status_enable" value="1" type="text" class="form-control" /></td>
									<td>已锁定</td>
									<td><input id="account_lock_lock" type="text" value="0" class="form-control" /></td>
								</tr>
								<tr>
									<td>已禁用</td>
									<td><input id="account_status_disable" type="text" class="form-control" /></td>
									<td>已解锁</td>
									<td><input id="account_lock_unlock" type="text" class="form-control" /></td>
								</tr>
							</tbody>
						</table>
						<!-- 属性映射 -->
						<table class="table table-striped" id="user_account_attr_mapping_table">
							<thead>
								<tr>
									<th colspan="3">用户属性映射</th>
								</tr>
								<tr>
									<th>用户属性</th>
									<th>账号属性</th>
									<th>操作</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th><select id="attr_mapping">
											<option value="user_id">用户标识</option>
											<option value="user_name">用户名称</option>
<!-- 											<option value="user_ou">组织单位</option> -->
											<option value="user_status">用户状态</option>
<!-- 											<option value="user_type">用户类型</option> -->
<!-- 											<option value="user_bengin_time">开始时间</option> -->
<!-- 											<option value="user_end_time">结束时间</option> -->
											<option value="user_email">电子邮箱</option>
											<option value="user_employee_id">员工标识</option>
											<option value="user_phonenumber">电话号码</option>
									</select></th>
									<th><select id="account_attr"></select></td>
									<th><button class="btn btn-primary" id="account_btn_add_mapping">添&nbsp;&nbsp;加</button></td>
								</tr>
							</tfoot>
							<tbody>
								
							</tbody>
						</table>
						<!-- 目标资源回收的账号拥有者匹配规则 -->
						<table class="table table-striped" id="mapping_rule_table">
							<thead>
								<tr>
									<th colspan="2">目标资源回收的账号拥有者匹配规则</th>
								</tr>
								<tr>
									<th>规则（账号属性）</th>
									<th>操作</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th><select id="account_owner_assign_sel"></select></th>
									<th><button class="btn btn-primary" id="account_btn_add_assignrule">添&nbsp;&nbsp;加</button></th>
								</tr>
							
							</tfoot>
							<tbody>
							</tbody>
						</table>
					</div>
					<div class="tab-pane fade" id="role">
						<!-- 角色 -->
						<table class="table table-striped" id="role_table">
							<thead>
								<tr>
									<th colspan="3">基本角色</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>角色表名称</td>
									<td><input id="role_tablename" type="text" class="form-control" /></td>
									<td></td>
								</tr>
								<tr>
									<td>关系表名称</td>
									<td><input id="role_rel_tablename" type="text" class="form-control" /></td>
									<td></td>
								</tr>
								<tr>
									<td>关系表UUID</td>
									<td><input id="role_rel_uuid" type="text" class="form-control" /></td>
									<td></td>
								</tr>
								<tr>
									<td>用户列</td>
									<td><input id="role_user_col" type="text" class="form-control" /></td>
									<td></td>
								</tr>
								<tr>
									<td>角色列</td>
									<td><input id="role_col" type="text" class="form-control" /></td>
									<td></td>
								</tr>
								<tr>
									<td style="vertical-align: middle;">UUID生成器类型</td>
									<td style="vertical-align: middle;"><select class="form-control" id="role_uuidgener_sel">
											<option value="Static">Static</option>
											<option value="SQL">SQL</option>
											<option value="Auto Increment">Auto Increment</option>
									</select></td>
									<td style="vertical-align: middle;">静态：UIM将生成UUID。<br> SQL生成器：使用SQL生成UUID。<br> 自动递增：数据库根据身份列生成UUID。
									</td>
								</tr>
								<tr>
									<td style="vertical-align: middle;">关系UUID生成器脚本</td>
									<td style="vertical-align: middle;"><textarea class="form-control" rows="8" id="role_uuidgener_text"></textarea></td>
									<td style="vertical-align: middle;">使用所提供的脚本来生成UUID。<br>@param logger org.apache.log4j.Logger<br>@返回UUID
									</td>
								</tr>
							</tbody>
						</table>
						<!-- 属性定义 -->
						<table class="table table-striped" id="role_attrdef_table">
							<thead>
								<tr>
									<th colspan="10">属性定义</th>
								</tr>
								<tr>
									<th><input type="checkbox" id="role_chk_all" /></th>
									<th>目标名称</th>
									<th>显示名称</th>
									<th>数据类型</th>
									<th>最小值/长度</th>
									<th>最大值/长度</th>
									<th>是必需的</th>
									<th>可编辑的</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
						<div class="row">
							<div class="center-block">
								<button class="btn btn-primary" id="role_btn_add_attrdef" data-toggle="modal" data-target="#attrdef_modal">添&nbsp;&nbsp;加</button>
								<button class="btn btn-primary" id="role_btn_del_attrdef">删&nbsp;&nbsp;除</button>
							</div>
						</div>
						<!-- 属性详细资料 -->
						<table class="table table-striped" id="role_attr_detail_table">
							<thead>
								<tr>
									<th colspan="4">属性详细资料</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>唯一标识符</td>
									<td><input id="role_uuid" type="text" class="form-control" /></td>
									<td>身份属性</td>
									<td><input id="role_id" type="text" class="form-control" /></td>
								</tr>
								<tr>
									<td>名称属性</td>
									<td><input id="role_name" type="text" class="form-control" /></td>
									<td>第二名称属性</td>
									<td><input id="role_name2" type="text" class="form-control" /></td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="tab-pane fade" id="orgunit">
						<!-- 组织单位 -->
						<table class="table table-striped" id="ou_table">
							<thead>
								<tr>
									<th colspan="3">组织单位</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>组织单位表名称</td>
									<td><input id="ou_tablename" type="text" class="form-control" /></td>
									<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
								</tr>
								<tr>
							</tbody>
						</table>
						<!-- 属性定义 -->
						<table class="table table-striped" id="ou_attrdef_table">
							<thead>
								<tr>
									<th colspan="10">属性定义</th>
								</tr>
								<tr>
									<th><input type="checkbox" id="ou_chk_all" /></th>
									<th>目标名称</th>
									<th>显示名称</th>
									<th>数据类型</th>
									<th>最小值/长度</th>
									<th>最大值/长度</th>
									<th>是必需的</th>
									<th>可编辑的</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
						<div class="row">
							<div class="center-block">
								<button class="btn btn-primary" id="ou_btn_add_attrdef" data-toggle="modal" data-target="#attrdef_modal">添&nbsp;&nbsp;加</button>
								<button class="btn btn-primary" id="ou_btn_del_attrdef">删&nbsp;&nbsp;除</button>
							</div>
						</div>
						<!-- 属性详细资料 -->
						<table class="table table-striped">
							<thead>
								<tr>
									<th colspan="4">属性详细资料</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>唯一标识符</td>
									<td><input id="ou_uuid" type="text" class="form-control" /></td>
									<td>身份属性</td>
									<td><input id="ou_id" type="text" class="form-control" /></td>
								</tr>
								<tr>
									<td>识别名称属性</td>
									<td><input id="ou_distinguished_name" type="text" class="form-control" /></td>
									<td>名称属性</td>
									<td><input id="ou_name" type="text" class="form-control" /></td>
								</tr>
								<tr>
									<td>第二名称属性</td>
									<td><input id="ou_name2" type="text" class="form-control" /></td>
									<td>父组织单位唯一识别符属性</td>
									<td><input id="ou_parent_uuid" type="text" class="form-control" /></td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="tab-pane fade" id="accounts">
						<!-- 账号：通过定时任务回收回来的账号 -->
						<p>通过定时任务回收回来的账号</p>
					</div>
				</div>

				<div class="row">
					<div class="center-block">
						<a class="btn btn-primary" id="btn_resource_save">保&nbsp;&nbsp;存</a> <a class="btn btn-primary" href="toresource/resource.action">取&nbsp;&nbsp;消</a>
					</div>
				</div>

			</div>
		</div>
		<!-- 模态框（Modal） 添加属性定义 -->
		<div class="modal fade" id="attrdef_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">属性定义</h4>
					</div>
					<!-- modal 主体-->
					<div class="modal-body">
						<form class="form-horizontal center-block" role="form">
							<div class="form-group">
								<label for="userUuid" class="col-md-3 control-label">目标名称</label>
								<div class="col-md-5">
									<input type="text" id="attrdef_targetname" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label for="userUuid" class="col-md-3 control-label">显示名称</label>
								<div class="col-md-5">
									<input type="text" id="attrdef_showname" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label for="userUuid" class="col-md-3 control-label">数据类型</label>
								<div class="col-md-5">
									<select class="form-control" id="attrdef_datatype">
										<option value="string">string</option>
										<option value="int">int</option>
										<option value="boolean">boolean</option>
										<option value="time">time</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="userUuid" class="col-md-3 control-label">最小值/长度</label>
								<div class="col-md-5">
									<input type="text" id="attrdef_min" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label for="userUuid" class="col-md-3 control-label">最大值/长度</label>
								<div class="col-md-5">
									<input type="text" id="attrdef_max" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label for="userUuid" class="col-md-3 control-label">必需的</label>
								<div class="col-md-5">
									<select class="form-control" id="attrdef_required">
										<option value="false">false</option>
										<option value="true">true</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="userUuid" class="col-md-3 control-label">可编辑的</label>
								<div class="col-md-5">
									<select class="form-control" id="attrdef_editable">
										<option value="true">true</option>
										<option value="false">false</option>
									</select>
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<a type="button" class="btn btn-primary" data-dismiss="modal" id="attrdef_modal_confirm">确认</a> 
						<a type="button" class="btn btn-primary" data-dismiss="modal" id="role_attrdef_modal_confirm" style="display: none;">确认</a> 
						<a type="button" class="btn btn-primary" data-dismiss="modal" id="ou_attrdef_modal_confirm" style="display: none;">确认</a> 
						<a type="button" class="btn btn-primary" data-dismiss="modal" id="attrdef_modal_confirm_modify" style="display: none;">确认修改</a>
						<a type="button" class="btn btn-primary" data-dismiss="modal" id="role_attrdef_modal_confirm_modify" style="display: none;">确认修改</a>
						<a type="button" class="btn btn-primary" data-dismiss="modal" id="ou_attrdef_modal_confirm_modify" style="display: none;">确认修改</a>
					</div>
				</div>
			</div>
		</div>
		<!-- 模态框（Modal） 属性详细资料 -->
		<div class="modal fade" id="accountdetail_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">属性详细资料</h4>
					</div>
					<!-- modal 主体-->
					<div class="modal-body">
						<form class="form-horizontal center-block" role="form">
							<div class="form-group">
								<label for="accountdetail_select" class="col-md-3 control-label">选择对应属性</label>
								<div class="col-md-5">
									<select id="accountdetail_select" class="form-control">
										<option value="">-</option>
									</select>
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<a type="button" class="btn btn-primary" data-dismiss="modal" id="accountdetail_modal_confirm">确认</a> 
						<a type="button" class="btn btn-primary" data-dismiss="modal" id="role_accountdetail_modal_confirm" style="display:none;">确认</a> 
						<a type="button" class="btn btn-primary" data-dismiss="modal" id="ou_accountdetail_modal_confirm" style="display:none;">确认</a> 
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="../commonscript.jsp" %>
	<script src="js/resource.js?version=<%=Math.random()%>"></script>
	<script type="text/javascript">
		$(function() {
			$('#myTab a:first').tab('show');//初始化显示哪个tab  

			$('#myTab a').click(function(e) {
				e.preventDefault();//阻止a链接的跳转行为  
				$(this).tab('show');//显示当前选中的链接及关联的content 
				var id = $(this).parent().attr("id");
				if(id == "tab_acct"){
					setTimeout(function() {
						$("#myScrollspy").height("100px");
						var height = $(".container").height();
						$("#myScrollspy").height(height * 0.9);
					}, 500);
				}else{
					setTimeout(function() {
						$("#myScrollspy").height("100px");
						var height = $(".container").height();
						$("#myScrollspy").height(height * 0.8);
					}, 500);
				}

			})
		})
	</script>
</body>
</html>