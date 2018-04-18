/*
 * function
 */
//利用正则表达式获取url中的参数
function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}

function updateAccountAttr() {
	// 清空账户属性下拉框
	$("#account_attr").empty();
	// 获取属性值、填充下拉框
	fill_attr("account_attr");	
}

function fill_attr(attr_def_table) {
	$("#" + attr_def_table + " tr").each(
			function() {
				var showname = $(this).children("td:eq(2)").text();
				if (showname != "") {
					$("#accountdetail_select").append(
							"<option value='" + showname + "'>" + showname
									+ "</option>");
				}
			})
}

//填充账号属性下拉框
function fill_attr_mapping(){
	$("#account_attr").empty();
	$("#attrdef_table tr").each(
			function() {
				var targetname = $(this).children("td:eq(1)").text();
				var showname = $(this).children("td:eq(2)").text();
				if (showname != "") {
					$("#account_attr").append(
							"<option value='" + targetname + "'>" + showname
									+ "</option>");
				}
			})
//	var account_uuid = $("#account_uuid").val();
//	var account_id = $("#account_id").val();
//	var account_ou_uuid = $("#account_ou_uuid").val();
//	var account_createtime = $("#account_createtime").val();
//	var account_modifytime = $("#account_modifytime").val();
//	var account_status = $("#account_status").val();
//	var account_lock = $("#account_lock").val();
//	if(account_uuid != ""){
//		$("#account_attr").append(
//				"<option value='" + account_uuid + "'>" + account_uuid
//						+ "</option>");
//	}
//	if(account_id != ""){
//		$("#account_attr").append(
//				"<option value='" + account_id + "'>" + account_id
//						+ "</option>");
//	}
//	if(account_ou_uuid != ""){
//		$("#account_attr").append(
//				"<option value='" + account_ou_uuid + "'>" + account_ou_uuid
//						+ "</option>");
//	}
//	if(account_createtime != ""){
//		$("#account_attr").append(
//				"<option value='" + account_createtime + "'>" + account_createtime
//						+ "</option>");
//	}
//	if(account_modifytime != ""){
//		$("#account_attr").append(
//				"<option value='" + account_modifytime + "'>" + account_modifytime
//						+ "</option>");
//	}
//	if(account_status != ""){
//		$("#account_attr").append(
//				"<option value='" + account_status + "'>" + account_status
//						+ "</option>");
//	}
//	if(account_lock != ""){
//		$("#account_attr").append(
//				"<option value='" + account_lock + "'>" + account_lock
//						+ "</option>");
//	}
}

// 目标资源回收的账号拥有者匹配规则 下拉框填充
function fill_account_attr() {
	// 清空下拉框
	$("#account_owner_assign_sel").empty();
	// 获取账号属性的值，填充到对应的下拉框
	$("#user_account_attr_mapping_table tr").each(
			function() {
				var account_attr = $(this).children("td:eq(1)").text();
				if (account_attr != "") {
					$("#account_owner_assign_sel").append(
							"<option value='" + account_attr + "'>"
									+ account_attr + "</option>");
				}
			})
}

/*
 * jquery
 */
$(function() {
	//全局属性
	var obj_attrdef_tr; // 编辑属性定义的时候对应的tr
	var obj_role_attrdef_tr; // 编辑属性定义的时候对应的tr（角色）
	var obj_ou_attrdef_tr; // 编辑属性定义的时候对应的tr（组织单位）
	var obj_attrdetail; // 选择属性详细资料时候对应的对象
	var obj_role_attrdetail // 选择属性详细资料时候对应的对象（角色）
	var obj_ou_attrdetail // 选择属性详细资料时候对应的对象（组织单位）
	var resuuid = GetQueryString('resuuid');//资源uuid
	
	if(resuuid != null && resuuid != "" && resuuid != "null"){
		$.ajax({
			type : 'post',
			url : 'toresource/getresource.action',
			contentType : 'application/json;charset=utf-8',// 指定为json类型
			dataType : 'json', // 服务器响应类型
			data : JSON.stringify(resuuid), // JSON.stringify(jdbc),
			success : function(resource) {// 返回json结果
				var resId = resource.resId;
				var resName = resource.resName;
				var resDesc = resource.resDesc;
				var resTrust = resource.resTrust;
				//json
				var resJsonAttr = JSON.parse(resource.resJsonAttr);
				
				//base information
				$("#resource_id").val(resId);
				$("#resource_name").val(resName);
				$("#resource_desc").val(resDesc);
//				$("#owner_account").val(resId);
//				$("#resource_ou").val(resId);
				if(resTrust == "1"){
					$("#resource_trust").val("true");
				}else{
					$("#resource_trust").val("false");
				}
				
				//config
				var configJson = resJsonAttr.configJson;
				$("#jdbc_drive").val(configJson.jdbc_drive);
				$("#jdbc_url").val(configJson.jdbc_url);
				$("#jdbc_username").val(configJson.jdbc_username);
				$("#jdbc_pwd").val(configJson.jdbc_pwd);
				//acct
				var acctJson = resJsonAttr.acctJson;
				$("#user_table").val(acctJson.user_table);
				$("#user_uuidgener_sel").val(acctJson.user_uuidgener_sel);
				$("#uuidgener_text").val(acctJson.uuidgener_text);
				$("#pwd_table").val(acctJson.pwd_table);
				$("#pwd_col").val(acctJson.pwd_col);
				$("#pwd_rel").val(acctJson.pwd_rel);
				$("#pwd_encoding_text").val(acctJson.pwd_encoding_text);
				
				var acct_attr_def = acctJson.acct_attr_def;
				for (var i = 0; i < acct_attr_def.length; i++) {
					var tempJson = acct_attr_def[i];
					//获取json中的值
					var target_name = tempJson.target_name;
					var show_name = tempJson.show_name;
					var data_type = tempJson.data_type;
					var min = tempJson.min;
					var max = tempJson.max;
					var required = tempJson.required;
					var editable = tempJson.editable;
					//添加到表格中
					$("#attrdef_table")
					.append(
							"<tr class='acct_tr'><td><input type='checkbox' class='account_chk'/></td><td>"
									+ target_name
									+ "</td>><td>"
									+ show_name
									+ "</td>><td>"
									+ data_type
									+ "</td>><td>"
									+ min
									+ "</td>><td>"
									+ max
									+ "</td>><td>"
									+ required
									+ "</td>><td>"
									+ editable
									+ "</td><td><button class='btn btn-primary attrdef_edit' data-toggle='modal' data-target='#attrdef_modal'>编&nbsp;&nbsp;辑</button></td></tr>");
					
				}
				
				$("#account_uuid").val(acctJson.account_uuid);
				$("#account_id").val(acctJson.account_id);
				$("#account_ou_uuid").val(acctJson.account_ou_uuid);
				$("#account_createtime").val(acctJson.account_createtime);
				$("#account_modifytime").val(acctJson.account_modifytime);
				$("#account_status").val(acctJson.account_status);
				$("#account_lock").val(acctJson.account_lock);
				
				$("#account_status_enable").val(acctJson.account_status_enable);
				$("#account_status_disable").val(acctJson.account_status_disable);
				$("#account_lock_lock").val(acctJson.account_lock_lock);
				$("#account_lock_unlock").val(acctJson.account_lock_unlock);
				
				//刷新属性账号下拉框
				fill_attr_mapping();
				
				var acct_attr_mapping = acctJson.acct_attr_mapping;
				for (var i = 0; i < acct_attr_mapping.length; i++) {
					var tempJson = acct_attr_mapping[i];
					var user_attr = tempJson.user_attr;
					var acct_attr = tempJson.acct_attr;
					
					$("#user_account_attr_mapping_table")
					.append(
							"<tr class='acct_attr_mapping_tr'><td>"
									+ user_attr
									+ "</td><td>"
									+ acct_attr
									+ "</td><td><button class='btn btn-primary attr_mapping_del_button'>删&nbsp;&nbsp;除</button></td></tr>");
					
				}
				
				// 刷新账号匹配规则下拉框
				fill_account_attr();
				
				var acct_assign_rule = acctJson.acct_assign_rule;
				for (var i = 0; i < acct_assign_rule.length; i++) {
					var temp = acct_assign_rule[i];
					$("#mapping_rule_table")
					.append(
							"<tr class='acct_assign_rule_tr'><td>"
									+ temp
									+ "</td><td><button class='btn btn-primary mappinga_rule_del_btn'>删&nbsp;&nbsp;除</button></td></tr>");
				}
				
				//role
				var roleJson = resJsonAttr.roleJson;
				$("#role_tablename").val(roleJson.role_tablename);
				$("#role_rel_tablename").val(roleJson.role_rel_tablename);
				$("#role_rel_uuid").val(roleJson.role_rel_uuid);
				$("#role_user_col").val(roleJson.role_user_col);
				$("#role_col").val(roleJson.role_col);
				$("#role_uuidgener_sel").val(roleJson.role_uuidgener_sel);
				$("#role_uuidgener_text").val(roleJson.role_uuidgener_text);
				
				var role_attr_def = roleJson.role_attr_def;
				for (var i = 0; i < role_attr_def.length; i++) {
					var tempJson = role_attr_def[i];
					//获取json中的值
					var target_name = tempJson.target_name;
					var show_name = tempJson.show_name;
					var data_type = tempJson.data_type;
					var min = tempJson.min;
					var max = tempJson.max;
					var required = tempJson.required;
					var editable = tempJson.editable;

					$("#role_attrdef_table")
					.append(
							"<tr class='role_tr'><td><input type='checkbox' class='role_chk'/></td><td>"
									+ target_name
									+ "</td>><td>"
									+ show_name
									+ "</td>><td>"
									+ data_type
									+ "</td>><td>"
									+ min
									+ "</td>><td>"
									+ max
									+ "</td>><td>"
									+ required
									+ "</td>><td>"
									+ editable
									+ "</td><td><button class='btn btn-primary role_attrdef_edit' data-toggle='modal' data-target='#attrdef_modal'>编&nbsp;&nbsp;辑</button></td></tr>");
				}
				
				$("#role_uuid").val(roleJson.role_uuid);
				$("#role_id").val(roleJson.role_id);
				$("#role_name").val(roleJson.role_name);
				$("#role_name2").val(roleJson.role_name2);
				
				//ou
				var ouJson = resJsonAttr.ouJson;
				$("#ou_tablename").val(ouJson.ou_tablename);
				
				var ou_attr_def = ouJson.ou_attr_def;
				for (var i = 0; i < ou_attr_def.length; i++) {
					var tempJson = ou_attr_def[i];
					//获取json中的值
					var target_name = tempJson.target_name;
					var show_name = tempJson.show_name;
					var data_type = tempJson.data_type;
					var min = tempJson.min;
					var max = tempJson.max;
					var required = tempJson.required;
					var editable = tempJson.editable;
					
					$("#ou_attrdef_table")
					.append(
							"<tr class='ou_tr'><td><input type='checkbox' class='ou_chk'/></td><td>"
									+ target_name
									+ "</td>><td>"
									+ show_name
									+ "</td>><td>"
									+ data_type
									+ "</td>><td>"
									+ min
									+ "</td>><td>"
									+ max
									+ "</td>><td>"
									+ required
									+ "</td>><td>"
									+ editable
									+ "</td><td><button class='btn btn-primary ou_attrdef_edit' data-toggle='modal' data-target='#attrdef_modal'>编&nbsp;&nbsp;辑</button></td></tr>");
				}
				
				$("#ou_uuid").val(ouJson.ou_uuid);
				$("#ou_id").val(ouJson.ou_id);
				$("#ou_distinguished_name").val(ouJson.ou_distinguished_name);
				$("#ou_name").val(ouJson.ou_name);
				$("#ou_name2").val(ouJson.ou_name2);
				$("#ou_uuid").val(ouJson.ou_uuid);
				$("#ou_parent_uuid").val(ouJson.ou_parent_uuid);
			},
			error : function(information) {
				$.notify({
					icon : 'glyphicon glyphicon-danger-sign',
					title : '<strong>出错了</strong>',
					message : information.result
				}, {
					type : 'danger', // danger warning info success
					mouse_over : 'pause',
				});
				
			}
		});
	}else{
		$("#uuidgener_text").val('import com.ssm.utils.CommonUtil;\n\nreturn CommonUtil.generateUUID();');
		$("#pwd_encoding_text").val('import org.apache.commons.codec.digest.DigestUtils;\n\nlogger.info(\"Password encoding.\");\nreturn DigestUtils.sha256Hex(password+salt);\nlogger.info(\"Password encoding succeed\");');
	}
	
	// 点击测试连接的时候出发ajax
	$("#jdbc_test").click(function() {
		var jdbc_drive = $("#jdbc_drive").val();
		var jdbc_url = $("#jdbc_url").val();
		var jdbc_username = $("#jdbc_username").val();
		var jdbc_pwd = $("#jdbc_pwd").val();

		var jdbc = JSON.stringify({
			"jdbc_drive" : jdbc_drive,
			"jdbc_url" : jdbc_url,
			"jdbc_username" : jdbc_username,
			"jdbc_pwd" : jdbc_pwd
		});
		// var user = "test";

		$.ajax({
			type : 'post',
			url : 'toresource/testconnection.action',
			contentType : 'application/json;charset=utf-8',// 指定为json类型
			dataType : 'json', // 服务器响应类型
			data : jdbc, // JSON.stringify(jdbc),
			success : function(information) {// 返回json结果
				var result = information.result;
				if (result.indexOf("success") >= 0) {
					$.notify({
						icon : 'glyphicon glyphicon-success-sign',
						title : '<strong>测试结果</strong>',
						message : "成功",
						allow_dismiss : false
					// url: 'https://github.com/mouse0270/bootstrap-notify',
					// target: '_blank'
					}, {
						type : 'success', // danger warning info success
						mouse_over : 'pause'
					});
				} else {
					$.notify({
						icon : 'glyphicon glyphicon-danger-sign',
						title : '<strong>测试结果</strong>',
						message : result
					}, {
						type : 'warning', // danger warning info success
						mouse_over : 'pause',
					});
				}

			},
			error : function(information) {
				$.notify({
					icon : 'glyphicon glyphicon-danger-sign',
					title : '<strong>出错了</strong>',
					message : information.result
				}, {
					type : 'danger', // danger warning info success
					mouse_over : 'pause',
				});
			}
		});
	})

	// 保存资源的所有信息
	$("#btn_resource_save").click(function() {
		var resourceJson = {};
		var otherTab = {};
		
		resourceJson['resUuid'] = resuuid;
		
		// resource 基本信息
		var resource_id = $("#resource_id").val();
		var resource_name = $("#resource_name").val();
		var resource_desc = $("#resource_desc").val();
		var resource_type = $("#resource_type").val();
		var owner_account = $("#owner_account").val();
		var owner_ou = $("#owner_ou").val();
		var resource_trust = $("#resource_trust").val();

		var resourceBaseJson = {
			"resource_id" : resource_id,
			"resource_name" : resource_name,
			"resource_desc" : resource_desc,
			"resource_type" : resource_type,
			"owner_account" : owner_account,
			"owner_ou" : owner_ou,
			"resource_trust" : resource_trust
		}
		
		//base
		resourceJson['baseJson'] = resourceBaseJson;
		
		// 配置
		var jdbc_drive = $("#jdbc_drive").val();
		var jdbc_url = $("#jdbc_url").val();
		var jdbc_username = $("#jdbc_username").val();
		var jdbc_pwd = $("#jdbc_pwd").val();

		var configJson = {
			"jdbc_drive" : jdbc_drive,
			"jdbc_url" : jdbc_url,
			"jdbc_username" : jdbc_username,
			"jdbc_pwd" : jdbc_pwd
		}
		
		//添加配置信息到 otherJson
		otherTab['configJson'] = configJson;
		
		// 账号架构
		var acctJson = {};
		
		var user_table = $("#user_table").val();
		var user_uuidgener_sel = $("#user_uuidgener_sel").val();
		var uuidgener_text = $("#uuidgener_text").val();
		
		var pwd_table = $("#pwd_table").val();
		var pwd_col = $("#pwd_col").val();
		var pwd_rel = $("#pwd_rel").val();
		var pwd_encoding_text = $("#pwd_encoding_text").val();
		
		acctJson['user_table'] = user_table;
		acctJson['user_uuidgener_sel'] = user_uuidgener_sel;
		acctJson['uuidgener_text'] = uuidgener_text;
		acctJson['pwd_table'] = pwd_table;
		acctJson['pwd_col'] = pwd_col;
		acctJson['pwd_rel'] = pwd_rel;
		acctJson['pwd_encoding_text'] = pwd_encoding_text;
		
		var acct_attr_def = new Array();
		$(".acct_tr").each(function(){
			var target_name = $(this).children().eq(1).text();
			var show_name = $(this).children().eq(2).text();
			var data_type = $(this).children().eq(3).text();
			var min = $(this).children().eq(4).text();
			var max = $(this).children().eq(5).text();
			var required = $(this).children().eq(6).text();
			var editable = $(this).children().eq(7).text();
			var acct_tr_json = {
				"target_name" : target_name,	
				"show_name" : show_name,	
				"data_type" : data_type,	
				"min" : min,	
				"max" : max,	
				"required" : required,	
				"editable" : editable
			}
			acct_attr_def.push(acct_tr_json);
		})
		
		acctJson['acct_attr_def'] = acct_attr_def;
		
		var account_uuid = $("#account_uuid").val();
		var account_id = $("#account_id").val();
		var account_ou_uuid = $("#account_ou_uuid").val();
		var account_createtime = $("#account_createtime").val();
		var account_modifytime = $("#account_modifytime").val();
		var account_status = $("#account_status").val();
		var account_lock = $("#account_lock").val();
		
		var account_status_enable = $("#account_status_enable").val();
		var account_status_disable = $("#account_status_disable").val();
		var account_lock_lock = $("#account_lock_lock").val();
		var account_lock_unlock = $("#account_lock_unlock").val();
		
		acctJson['account_uuid'] = account_uuid;
		acctJson['account_id'] = account_id;
		acctJson['account_ou_uuid'] = account_ou_uuid;
		acctJson['account_createtime'] = account_createtime;
		acctJson['account_modifytime'] = account_modifytime;
		acctJson['account_status'] = account_status;
		acctJson['account_lock'] = account_lock;
		acctJson['account_status_enable'] = account_status_enable;
		acctJson['account_status_disable'] = account_status_disable;
		acctJson['account_lock_lock'] = account_lock_lock;
		acctJson['account_lock_unlock'] = account_lock_unlock;
		
		var acct_attr_mapping = new Array();
		$(".acct_attr_mapping_tr").each(function(){
			var user_attr = $(this).children().eq(0).text();
			var acct_attr = $(this).children().eq(1).text();
			var attr_mapping_tr_json = {
				"user_attr" : user_attr,	
				"acct_attr" : acct_attr
			}
			acct_attr_mapping.push(attr_mapping_tr_json);
		})
		
		acctJson['acct_attr_mapping'] = acct_attr_mapping;
		
		var acct_assign_rule = new Array();
		$(".acct_assign_rule_tr").each(function(){
			var assign_rule = $(this).children().eq(0).text();
			acct_assign_rule.push(assign_rule);
		})
		
		acctJson['acct_assign_rule'] = acct_assign_rule;
		otherTab['acctJson'] = acctJson;
		
		// 角色架构
		var roleJson = {};
		
		var role_tablename = $("#role_tablename").val();
		var role_rel_tablename = $("#role_rel_tablename").val();
		var role_rel_uuid = $("#role_rel_uuid").val();
		var role_user_col = $("#role_user_col").val();
		var role_col = $("#role_col").val();
		var role_uuidgener_sel = $("#role_uuidgener_sel").val();
		var role_uuidgener_text = $("#role_uuidgener_text").val();
		
		roleJson['role_tablename'] =  role_tablename;
		roleJson['role_rel_tablename'] = role_rel_tablename;
		roleJson['role_rel_uuid'] =  role_rel_uuid;
		roleJson['role_user_col'] =  role_user_col;
		roleJson['role_col'] =  role_col;
		roleJson['role_uuidgener_sel'] =  role_uuidgener_sel;
		roleJson['role_uuidgener_text'] =  role_uuidgener_text;
		
		var role_attr_def = new Array();
		$(".role_tr").each(function(){
			var target_name = $(this).children().eq(1).text();
			var show_name = $(this).children().eq(2).text();
			var data_type = $(this).children().eq(3).text();
			var min = $(this).children().eq(4).text();
			var max = $(this).children().eq(5).text();
			var required = $(this).children().eq(6).text();
			var editable = $(this).children().eq(7).text();
			var acct_tr_json = {
				"target_name" : target_name,	
				"show_name" : show_name,	
				"data_type" : data_type,	
				"min" : min,	
				"max" : max,	
				"required" : required,	
				"editable" : editable
			}
			role_attr_def.push(acct_tr_json);
		})
		
		roleJson['role_attr_def'] = role_attr_def;
		
		var role_uuid = $("#role_uuid").val();
		var role_id = $("#role_id").val();
		var role_name = $("#role_name").val();
		var role_name2 = $("#role_name2").val();
		
		roleJson['role_uuid'] = role_uuid;
		roleJson['role_id'] = role_id;
		roleJson['role_name'] = role_name;
		roleJson['role_name2'] = role_name2;
		
		otherTab['roleJson'] = roleJson;
		
		// 组织单位架构
		var ouJson = {};
		
		var ou_tablename = $("#ou_tablename").val();
		
		ouJson['ou_tablename'] = ou_tablename;
		
		//ou_tr
		var ou_attr_def = new Array();
		$(".ou_tr").each(function(){
			var target_name = $(this).children().eq(1).text();
			var show_name = $(this).children().eq(2).text();
			var data_type = $(this).children().eq(3).text();
			var min = $(this).children().eq(4).text();
			var max = $(this).children().eq(5).text();
			var required = $(this).children().eq(6).text();
			var editable = $(this).children().eq(7).text();
			var acct_tr_json = {
				"target_name" : target_name,	
				"show_name" : show_name,	
				"data_type" : data_type,	
				"min" : min,	
				"max" : max,	
				"required" : required,	
				"editable" : editable
			}
			ou_attr_def.push(acct_tr_json);
		})
		
		ouJson['ou_attr_def'] = ou_attr_def;
		
		var ou_uuid = $("#ou_uuid").val();
		var ou_id = $("#ou_id").val();
		var ou_distinguished_name = $("#ou_distinguished_name").val();
		var ou_name = $("#ou_name").val();
		var ou_name2 = $("#ou_name2").val();
		var ou_parent_uuid = $("#ou_parent_uuid").val();
		
		ouJson['ou_uuid'] = ou_uuid;
		ouJson['ou_id'] = ou_id;
		ouJson['ou_distinguished_name'] = ou_distinguished_name;
		ouJson['ou_name'] = ou_name;
		ouJson['ou_name2'] = ou_name2;
		ouJson['ou_parent_uuid'] = ou_parent_uuid;
		
		otherTab['ouJson'] = ouJson;
		
		resourceJson['attrJson'] = otherTab;
		
		// 发送到后台
		$.ajax({
			type : 'post',
			url : 'toresource/saveresource.action',
			contentType : 'application/json;charset=utf-8',// 指定为json类型
			dataType : 'json', // 服务器响应类型
			data : JSON.stringify(resourceJson), // JSON.stringify(jdbc),
			success : function(information) {// 返回json结果
				if(information.result.indexOf("success") >= 0){
					$.notify({
						icon : 'glyphicon glyphicon-success-sign',
						title : '<strong>保存资源结果</strong>',
						message : "成功",
						allow_dismiss : false
						// url: 'https://github.com/mouse0270/bootstrap-notify',
						// target: '_blank'
					}, {
						type : 'success', // danger warning info success
						mouse_over : 'pause'
					});
					setTimeout(function(){window.location.href='toresource/resource.action'}, 2000);
				}else{
					$.notify({
						icon : 'glyphicon glyphicon-success-sign',
						title : '<strong>创建资源结果</strong>',
						message : "失败",
						allow_dismiss : false
						// url: 'https://github.com/mouse0270/bootstrap-notify',
						// target: '_blank'
					}, {
						type : 'warning', // danger warning info success
						mouse_over : 'pause'
					});
				}
			},
			error : function() {
				$.notify({
					icon : 'glyphicon glyphicon-success-sign',
					title : '<strong>创建资源结果</strong>',
					message : "失败，发生未知异常",
					allow_dismiss : false
					// url: 'https://github.com/mouse0270/bootstrap-notify',
					// target: '_blank'
				}, {
					type : 'danger', // danger warning info success
					mouse_over : 'pause'
				});
			}
		});

	})

	// 是否为信任资源
	$("#resource_trust").change(function() {
		var flag = $("#resource_trust").val();
		if (flag == "false") {
			$("#ou_nav").hide();
		} else {
			$("#ou_nav").show();
		}
	})

	// 当触发模态框的隐藏事件时
	$('#attrdef_modal').on('hide.bs.modal', function() {
		// 清空模态框数据
		$("#attrdef_targetname").val("");
		$("#attrdef_showname").val("");
		$("#attrdef_datatype").val("string");
		$("#attrdef_min").val("");
		$("#attrdef_max").val("");
		$("#attrdef_required").val("false");
		$("#attrdef_editable").val("true");
		// 显示默认的确认按钮
		$("#attrdef_modal_confirm").css("display", "inline-block");
		$("#role_attrdef_modal_confirm").css("display", "none");
		$("#ou_attrdef_modal_confirm").css("display", "none");
		$("#attrdef_modal_confirm_modify").css("display", "none");
		$("#role_attrdef_modal_confirm_modify").css("display", "none");
		$("#ou_attrdef_modal_confirm_modify").css("display", "none");
	})

	// 当触发模态框的隐藏事件时
	$('#accountdetail_modal').on('hide.bs.modal', function() {
		// 清空下拉框
		$("#accountdetail_select").empty();
		$("#accountdetail_select").append("<option value=''>-</option>");
		// 还原默认按钮
		$("#accountdetail_modal_confirm").css("display", "inline-block");
		$("#role_accountdetail_modal_confirm").css("display", "none");
		$("#ou_accountdetail_modal_confirm").css("display", "none");
	})

	// 测试连接按钮
	$("#jdbc_test").click(function() {
		var drive = $("#jdbc_drive").val();
		var url = $("#jdbc_url").val();
		var username = $("#jdbc_username").val();
		var pwd = $("#jdbc_pwd").val();

		// console.log("drive : " + drive);
		// console.log("url :" + url);
		// console.log("username : " + username);
		// console.log("pdw : " + pwd);
	})

	// 模态框，增加属性定义按钮
	$("#attrdef_modal_confirm")
			.click(
					function() {
						// 获取输入的值
						var targetname = $("#attrdef_targetname").val();
						var showname = $("#attrdef_showname").val();
						var datatype = $("#attrdef_datatype").val();
						var min = $("#attrdef_min").val();
						var max = $("#attrdef_max").val();
						var required = $("#attrdef_required").val();
						var editable = $("#attrdef_editable").val();

						// 在属性定义表格中增加一行
						$("#attrdef_table")
								.append(
										"<tr class='acct_tr'><td><input type='checkbox' class='account_chk'/></td><td>"
												+ targetname
												+ "</td>><td>"
												+ showname
												+ "</td>><td>"
												+ datatype
												+ "</td>><td>"
												+ min
												+ "</td>><td>"
												+ max
												+ "</td>><td>"
												+ required
												+ "</td>><td>"
												+ editable
												+ "</td><td><button class='btn btn-primary attrdef_edit' data-toggle='modal' data-target='#attrdef_modal'>编&nbsp;&nbsp;辑</button></td></tr>");

						/*
						 * $("#attrdef_targetname").val("");
						 * $("#attrdef_showname").val("");
						 * $("#attrdef_datatype").val("string");
						 * $("#attrdef_min").val(""); $("#attrdef_max").val("");
						 * $("#attrdef_required").val("false");
						 * $("#attrdef_editable").val("true");
						 */

						// 更新账号属性
						updateAccountAttr();
						//更新用户属性映射
						fill_attr_mapping();
					})

	// 模态框，增加属性定义按钮(角色)
	$("#role_attrdef_modal_confirm")
			.click(
					function() {
						// 获取输入的值
						var targetname = $("#attrdef_targetname").val();
						var showname = $("#attrdef_showname").val();
						var datatype = $("#attrdef_datatype").val();
						var min = $("#attrdef_min").val();
						var max = $("#attrdef_max").val();
						var required = $("#attrdef_required").val();
						var editable = $("#attrdef_editable").val();

						// 在属性定义表格中增加一行
						$("#role_attrdef_table")
								.append(
										"<tr class='role_tr'><td><input type='checkbox' class='role_chk'/></td><td>"
												+ targetname
												+ "</td>><td>"
												+ showname
												+ "</td>><td>"
												+ datatype
												+ "</td>><td>"
												+ min
												+ "</td>><td>"
												+ max
												+ "</td>><td>"
												+ required
												+ "</td>><td>"
												+ editable
												+ "</td><td><button class='btn btn-primary role_attrdef_edit' data-toggle='modal' data-target='#attrdef_modal'>编&nbsp;&nbsp;辑</button></td></tr>");

					})

	// 模态框，增加属性定义按钮(组织单位)
	$("#ou_attrdef_modal_confirm")
			.click(
					function() {
						// 获取输入的值
						var targetname = $("#attrdef_targetname").val();
						var showname = $("#attrdef_showname").val();
						var datatype = $("#attrdef_datatype").val();
						var min = $("#attrdef_min").val();
						var max = $("#attrdef_max").val();
						var required = $("#attrdef_required").val();
						var editable = $("#attrdef_editable").val();

						// 在属性定义表格中增加一行
						$("#ou_attrdef_table")
								.append(
										"<tr class='ou_tr'><td><input type='checkbox' class='ou_chk'/></td><td>"
												+ targetname
												+ "</td>><td>"
												+ showname
												+ "</td>><td>"
												+ datatype
												+ "</td>><td>"
												+ min
												+ "</td>><td>"
												+ max
												+ "</td>><td>"
												+ required
												+ "</td>><td>"
												+ editable
												+ "</td><td><button class='btn btn-primary ou_attrdef_edit' data-toggle='modal' data-target='#attrdef_modal'>编&nbsp;&nbsp;辑</button></td></tr>");

					})

	// 属性定义编辑按钮
	$(".container").on("click", ".attrdef_edit", function() {
		// 获取同行元素的值
		var targetname = $(this).parent().parent().children().eq(1).text();
		var showname = $(this).parent().parent().children().eq(2).text();
		var datatype = $(this).parent().parent().children().eq(3).text();
		var min = $(this).parent().parent().children().eq(4).text();
		var max = $(this).parent().parent().children().eq(5).text();
		var required = $(this).parent().parent().children().eq(6).text();
		var editable = $(this).parent().parent().children().eq(7).text();
		obj_attrdef_tr = $(this).parent().parent();

		// 设置模态框中的值
		$("#attrdef_targetname").val(targetname);
		$("#attrdef_showname").val(showname);
		$("#attrdef_datatype").val(datatype);
		$("#attrdef_min").val(min);
		$("#attrdef_max").val(max);
		$("#attrdef_required").val(required);
		$("#attrdef_editable").val(editable);

		// 更改模态框的按钮
		$("#attrdef_modal_confirm").css("display", "none");
		$("#attrdef_modal_confirm_modify").css("display", "inline-block");
	})

	// 属性定义编辑按钮(角色)
	$(".container").on("click", ".role_attrdef_edit", function() {
		// 获取同行元素的值
		var targetname = $(this).parent().parent().children().eq(1).text();
		var showname = $(this).parent().parent().children().eq(2).text();
		var datatype = $(this).parent().parent().children().eq(3).text();
		var min = $(this).parent().parent().children().eq(4).text();
		var max = $(this).parent().parent().children().eq(5).text();
		var required = $(this).parent().parent().children().eq(6).text();
		var editable = $(this).parent().parent().children().eq(7).text();
		obj_role_attrdef_tr = $(this).parent().parent();

		// 设置模态框中的值
		$("#attrdef_targetname").val(targetname);
		$("#attrdef_showname").val(showname);
		$("#attrdef_datatype").val(datatype);
		$("#attrdef_min").val(min);
		$("#attrdef_max").val(max);
		$("#attrdef_required").val(required);
		$("#attrdef_editable").val(editable);

		// 更改模态框的按钮
		$("#attrdef_modal_confirm").css("display", "none");
		$("#role_attrdef_modal_confirm_modify").css("display", "inline-block");
	})

	// 属性定义编辑按钮(组织单位)
	$(".container").on("click", ".ou_attrdef_edit", function() {
		// 获取同行元素的值
		var targetname = $(this).parent().parent().children().eq(1).text();
		var showname = $(this).parent().parent().children().eq(2).text();
		var datatype = $(this).parent().parent().children().eq(3).text();
		var min = $(this).parent().parent().children().eq(4).text();
		var max = $(this).parent().parent().children().eq(5).text();
		var required = $(this).parent().parent().children().eq(6).text();
		var editable = $(this).parent().parent().children().eq(7).text();
		obj_ou_attrdef_tr = $(this).parent().parent();

		// 设置模态框中的值
		$("#attrdef_targetname").val(targetname);
		$("#attrdef_showname").val(showname);
		$("#attrdef_datatype").val(datatype);
		$("#attrdef_min").val(min);
		$("#attrdef_max").val(max);
		$("#attrdef_required").val(required);
		$("#attrdef_editable").val(editable);

		// 更改模态框的按钮
		$("#attrdef_modal_confirm").css("display", "none");
		$("#ou_attrdef_modal_confirm_modify").css("display", "inline-block");
	})

	// 编辑属性定义
	$("#attrdef_modal_confirm_modify").click(function() {
		// 获取更改后的值
		var targetname1 = $("#attrdef_targetname").val();
		var showname1 = $("#attrdef_showname").val();
		var datatype1 = $("#attrdef_datatype").val();
		var min1 = $("#attrdef_min").val();
		var max1 = $("#attrdef_max").val();
		var required1 = $("#attrdef_required").val();
		var editable1 = $("#attrdef_editable").val();

		// console.log("targetname1 : " + targetname1);
		// console.log("showname1 : " + showname1);
		// console.log("obj : " + obj_attrdef_tr);

		// 更新更改后的值
		obj_attrdef_tr.children().eq(1).text(targetname1);
		obj_attrdef_tr.children().eq(2).text(showname1);
		obj_attrdef_tr.children().eq(3).text(datatype1);
		obj_attrdef_tr.children().eq(4).text(min1);
		obj_attrdef_tr.children().eq(5).text(max1);
		obj_attrdef_tr.children().eq(6).text(required1);
		obj_attrdef_tr.children().eq(7).text(editable1);

		// 清空模态框数据
		/*
		 * $("#attrdef_targetname").val(""); $("#attrdef_showname").val("");
		 * $("#attrdef_datatype").val("string"); $("#attrdef_min").val("");
		 * $("#attrdef_max").val(""); $("#attrdef_required").val("false");
		 * $("#attrdef_editable").val("true");
		 */
		// 还原模态框按钮
		/*
		 * $("#attrdef_modal_confirm").css("display", "inline-block");
		 * $("#attrdef_modal_confirm_modify").css("display", "none");
		 */

		// 更新账号属性
		updateAccountAttr();
	})

	// 编辑属性定义（角色）
	$("#role_attrdef_modal_confirm_modify").click(function() {
		// 获取更改后的值
		var targetname1 = $("#attrdef_targetname").val();
		var showname1 = $("#attrdef_showname").val();
		var datatype1 = $("#attrdef_datatype").val();
		var min1 = $("#attrdef_min").val();
		var max1 = $("#attrdef_max").val();
		var required1 = $("#attrdef_required").val();
		var editable1 = $("#attrdef_editable").val();

		// console.log("targetname1 : " + targetname1);
		// console.log("showname1 : " + showname1);
		// console.log("obj : " + obj_attrdef_tr);

		// 更新更改后的值
		obj_role_attrdef_tr.children().eq(1).text(targetname1);
		obj_role_attrdef_tr.children().eq(2).text(showname1);
		obj_role_attrdef_tr.children().eq(3).text(datatype1);
		obj_role_attrdef_tr.children().eq(4).text(min1);
		obj_role_attrdef_tr.children().eq(5).text(max1);
		obj_role_attrdef_tr.children().eq(6).text(required1);
		obj_role_attrdef_tr.children().eq(7).text(editable1);
	})

	// 编辑属性定义（组织单位）
	$("#ou_attrdef_modal_confirm_modify").click(function() {
		// 获取更改后的值
		var targetname1 = $("#attrdef_targetname").val();
		var showname1 = $("#attrdef_showname").val();
		var datatype1 = $("#attrdef_datatype").val();
		var min1 = $("#attrdef_min").val();
		var max1 = $("#attrdef_max").val();
		var required1 = $("#attrdef_required").val();
		var editable1 = $("#attrdef_editable").val();

		// console.log("targetname1 : " + targetname1);
		// console.log("showname1 : " + showname1);
		// console.log("obj : " + obj_attrdef_tr);

		// 更新更改后的值
		obj_ou_attrdef_tr.children().eq(1).text(targetname1);
		obj_ou_attrdef_tr.children().eq(2).text(showname1);
		obj_ou_attrdef_tr.children().eq(3).text(datatype1);
		obj_ou_attrdef_tr.children().eq(4).text(min1);
		obj_ou_attrdef_tr.children().eq(5).text(max1);
		obj_ou_attrdef_tr.children().eq(6).text(required1);
		obj_ou_attrdef_tr.children().eq(7).text(editable1);
	})

	// 全选checkbox
	$("#account_chk_all").change(function() {
		if ($(this).is(':checked')) {
			$(".account_chk").prop("checked", true);
		} else {
			$(".account_chk").prop("checked", false);
		}
	})

	// 全选checkbox（角色）
	$("#role_chk_all").change(function() {
		if ($(this).is(':checked')) {
			$(".role_chk").prop("checked", true);
		} else {
			$(".role_chk").prop("checked", false);
		}
	})

	// 全选checkbox（组织单位）
	$("#ou_chk_all").change(function() {
		if ($(this).is(':checked')) {
			$(".ou_chk").prop("checked", true);
		} else {
			$(".ou_chk").prop("checked", false);
		}
	})

	// 删除属性定义
	$("#account_btn_del_attrdef").click(function() {
		$(".account_chk").each(function() {
			if ($(this).is(':checked')) {
				$(this).parent().parent().remove();
			}
		})

		$("#account_chk_all").prop("checked", false);

		// 更新账号属性
		updateAccountAttr();
		//更新用户属性映射
		fill_attr_mapping();
	})

	// 删除属性定义（角色）
	$("#role_btn_del_attrdef").click(function() {
		$(".role_chk").each(function() {
			if ($(this).is(':checked')) {
				$(this).parent().parent().remove();
			}
		})

		$("#role_chk_all").prop("checked", false);
	})

	// 删除属性定义（组织单位）
	$("#ou_btn_del_attrdef").click(function() {
		$(".ou_chk").each(function() {
			if ($(this).is(':checked')) {
				$(this).parent().parent().remove();
			}
		})

		$("#ou_chk_all").prop("checked", false);
	})

	// 添加属性定义之前清空模态框
	/*
	 * $("#account_btn_add_attrdef").click(function() { // 清空模态框数据
	 * $("#attrdef_targetname").val(""); $("#attrdef_showname").val("");
	 * $("#attrdef_datatype").val("string"); $("#attrdef_min").val("");
	 * $("#attrdef_max").val(""); $("#attrdef_required").val("false");
	 * $("#attrdef_editable").val("true"); })
	 */

	// 添加属性定义（角色 ）
	$("#role_btn_add_attrdef").click(function() {
		// 更改模态框的按钮，显示另一个按钮
		$("#attrdef_modal_confirm").css("display", "none");
		$("#role_attrdef_modal_confirm").css("display", "inline-block");
	})

	// 添加属性定义（组织单位 ）
	$("#ou_btn_add_attrdef").click(function() {
		// 更改模态框的按钮，显示另一个按钮
		$("#attrdef_modal_confirm").css("display", "none");
		$("#ou_attrdef_modal_confirm").css("display", "inline-block");
	})
	// 属性详细资料输入框获得焦点的时候显示模态框
	$(
			"#account_uuid,#account_id,#account_ou_uuid,#account_createtime,#account_modifytime,#account_status,#account_lock")
			.focus(function() {
				obj_attrdetail = $(this);
				// 获取属性定义、填充模态框中的下拉框
				fill_attr("attrdef_table");
				// 显示模态框
				$('#accountdetail_modal').modal('show');

			});

	// 属性详细资料输入框获得焦点的时候显示模态框（角色）
	$("#role_uuid,#role_id,#role_name,#role_name2").focus(function() {
		// 更改默认显示按钮
		$("#role_accountdetail_modal_confirm").css("display", "inline-block");
		$("#accountdetail_modal_confirm").css("display", "none");
		obj_role_attrdetail = $(this);
		// 获取属性定义、填充模态框中的下拉框
		fill_attr("role_attrdef_table");
		// 显示模态框
		$('#accountdetail_modal').modal('show');

	});

	// 属性详细资料输入框获得焦点的时候显示模态框（组织单位）
	$(
			"#ou_uuid,#ou_id,#ou_distinguished_name,#ou_name,#ou_name2,#ou_parent_uuid")
			.focus(
					function() {
						// 更改默认显示按钮
						$("#ou_accountdetail_modal_confirm").css("display",
								"inline-block");
						$("#accountdetail_modal_confirm")
								.css("display", "none");
						obj_ou_attrdetail = $(this);
						// 获取属性定义、填充模态框中的下拉框
						fill_attr("ou_attrdef_table");
						// 显示模态框
						$('#accountdetail_modal').modal('show');

					});

	// 填充属性详细资料
	$("#accountdetail_modal_confirm").click(function() {
		// 获取选中的值并填到对应的输入框中
		var selected_value = $('#accountdetail_select').val();
		// console.log("selected_value : " + selected_value);
		// 更改输入框的值
		obj_attrdetail.val(selected_value);
		//刷新用户属性映射
//		fill_attr_mapping();
	})

	// 填充属性详细资料（角色）
	$("#role_accountdetail_modal_confirm").click(function() {
		// 获取选中的值并填到对应的输入框中
		var selected_value = $('#accountdetail_select').val();
		// console.log("selected_value : " + selected_value);
		// 更改输入框的值
		obj_role_attrdetail.val(selected_value);
	})

	// 填充属性详细资料（组织单位）
	$("#ou_accountdetail_modal_confirm").click(function() {
		// 获取选中的值并填到对应的输入框中
		var selected_value = $('#accountdetail_select').val();
		// console.log("selected_value : " + selected_value);
		// 更改输入框的值
		obj_ou_attrdetail.val(selected_value);
	})

	$("#account_btn_add_mapping")	
			.click(
					function() {
						var userattr = $("#attr_mapping").val();
						var accountattr = $("#account_attr").val();
						// console.log(userattr);
						// console.log(accountattr);
						$("#user_account_attr_mapping_table")
								.append(
										"<tr class='acct_attr_mapping_tr'><td>"
												+ userattr
												+ "</td><td>"
												+ accountattr
												+ "</td><td><button class='btn btn-primary attr_mapping_del_button'>删&nbsp;&nbsp;除</button></td></tr>");
						// 刷新账号匹配规则下拉框
						fill_account_attr();
					})

	$(".container").on("click", ".attr_mapping_del_button", function() {
		$(this).parent().parent().remove();
		// 刷新账号匹配规则下拉框
		fill_account_attr();
	})

	$("#account_btn_add_assignrule")
			.click(
					function() {
						var mappingrule = $("#account_owner_assign_sel").val();
						$("#mapping_rule_table")
								.append(
										"<tr class='acct_assign_rule_tr'><td>"
												+ mappingrule
												+ "</td><td><button class='btn btn-primary mappinga_rule_del_btn'>删&nbsp;&nbsp;除</button></td></tr>");
					})

	$(".container").on("click", ".mappinga_rule_del_btn", function() {
		$(this).parent().parent().remove();
	})
	
})
