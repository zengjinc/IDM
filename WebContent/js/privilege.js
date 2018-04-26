$(function(){
	// 当触发模态框的显示事件时
	$('#assign_itrole_modal').on('show.bs.modal', function() {
		// 向服务器获取非可信任资源列表，显示到页面上
		$.ajax({
			type : 'post',
			url : 'toidentity/getnontrustresource.action',
			contentType : 'application/json;charset=utf-8',// 指定为json类型
			dataType : 'json', // 服务器响应类型
			success : function(resourceList) {// 返回json结果
				for (var i = 0; i < resourceList.length; i++) {
					$("#resource_table").append("<tr><td data-value='"+resourceList[i].resUuid+"'>"+resourceList[i].resId+"</td><td>"+resourceList[i].resName+
							"</td><td><button class='btn btn-primary assign_privilege' data-value='"+resourceList[i].resUuid+"'>分&nbsp;&nbsp;配</button></td></tr>");
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
	})
	// 当触发模态框的隐藏事件时
	$('#assign_itrole_modal').on('hide.bs.modal', function() {
		$("#assigned_itrole_table tr:not(:first)").empty();
		$("#assignable_itrole_table tr:not(:first)").empty();
		$("#account_id_label").text('');
		$("#account_id_label").attr('data-value','');
		$("#res_id_label").text('');
		$("#res_id_label").attr('data-value','');
	})
	// 分配权限	获取对应资源的所有角色
	$(".container").on("click", ".assign", function() {
		var resUuid = $(this).parent().parent().children("td:eq(0)").attr('data-value');
		var acctUuid = $(this).parent().parent().children("td:eq(2)").attr('data-value');
		var acctId = $(this).parent().parent().children("td:eq(2)").text();
		var resId = $(this).parent().parent().children("td:eq(0)").text();
		$("#account_id_label").text(acctId);
		$("#account_id_label").attr('data-value',acctUuid);
		$("#res_id_label").text(resId);
		$("#res_id_label").attr('data-value',resUuid);
		var jsonStr = {
				"resUuid" : resUuid,
				"acctUuid" : acctUuid
		};
		//获取对应资源下的所有，并根据账户 uuid 分为已分配和可分配部分
		$.ajax({
			type : 'post',
			url : 'toidentity/getitrolebyresuuid.action',
			contentType : 'application/json;charset=utf-8',// 指定为json类型
			dataType : 'text', // 服务器响应类型
			data : JSON.stringify(jsonStr), // JSON.stringify(jdbc),
			success : function(itroleMap) {// 返回json结果
				var result = jQuery.parseJSON(itroleMap);
				var assignList = result.assigned;
				var assignableList = result.assignable;
				for (var i = 0; i < assignList.length; i++) {
					$("#assigned_itrole_table").append("<tr><td data-value='"+assignList[i].itroleUuid+"'>"+assignList[i].itroleId+"</td><td><button class='btn btn-primary unassign_privilege'>取&nbsp;&nbsp;消</button></td></tr>");
				}
				for (var i = 0; i < assignableList.length; i++) {
					$("#assignable_itrole_table").append("<tr><td data-value='"+assignableList[i].itroleUuid+"'>"+assignableList[i].itroleId+"</td><td><button class='btn btn-primary assign_privilege'>分&nbsp;&nbsp;配</button></td></tr>");
				}
			},
		});
	})
	// 分配角色
	$(".container").on("click", ".assign_privilege", function() {
		var tr = $(this).parent().parent();
		$(this).prop('disabled', true); 
		var acctUuid = 	$("#account_id_label").attr('data-value');
		var itroleUuid = $(this).parent().parent().children("td:eq(0)").attr('data-value');
		var itroleId = $(this).parent().parent().children("td:eq(0)").text();
		var resUuid = $("#res_id_label").attr('data-value');
		var jsonStr = {};
		jsonStr['acctUuid'] = acctUuid;
		jsonStr['itroleUuid'] = itroleUuid;
		jsonStr['resUuid'] = resUuid;
		
		$.ajax({
			type : 'post',
			url : 'toidentity/assignitrole.action',
			contentType : 'application/json;charset=utf-8',// 指定为json类型
			dataType : 'text', // 服务器响应类型
			data : JSON.stringify(jsonStr), // JSON.stringify(jdbc),
			success : function(information) {
				
				if(information == "success"){
					$("#itrole_hidden_table").append(tr);
					$("#assigned_itrole_table").append("<tr><td data-value='"+itroleUuid+"'>"+itroleId+"</td><td><button class='btn btn-primary unassign_privilege'>取&nbsp;&nbsp;消</button></td></tr>");
					//提示成功并添加到已分配表格中
					$.notify({
						icon : 'glyphicon glyphicon-danger-sign',
						title : '<strong>授权结果</strong>',
						message : information
					}, {
						z_index : 1051,
						type : 'success', // danger warning info success
						mouse_over : 'pause',
					});
				}else{
					//提示成功并添加到已分配表格中
					$.notify({
						icon : 'glyphicon glyphicon-danger-sign',
						title : '<strong>授权结果：角色冲突。</strong>',
						message : information
					}, {
						z_index : 1051,
						type : 'warning', // danger warning info success
						mouse_over : 'pause',
					});
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
					mouse_over : 'pause'
				});
			}
		});
	})
	// 取消分配角色
	$(".container").on("click", ".unassign_privilege", function() {
		var tr = $(this).parent().parent();
		$(this).prop('disabled', true); 
		var acctUuid = 	$("#account_id_label").attr('data-value');
		var itroleUuid = $(this).parent().parent().children("td:eq(0)").attr('data-value');
		var itroleId = $(this).parent().parent().children("td:eq(0)").text();
		var resUuid = $("#res_id_label").attr('data-value');
		var jsonStr = {};
		jsonStr['acctUuid'] = acctUuid;
		jsonStr['itroleUuid'] = itroleUuid;
		jsonStr['resUuid'] = resUuid;
		
		$.ajax({
			type : 'post',
			url : 'toidentity/unassignitrole.action',
			contentType : 'application/json;charset=utf-8',// 指定为json类型
			dataType : 'text', // 服务器响应类型
			data : JSON.stringify(jsonStr), // JSON.stringify(jdbc),
			success : function(information) {
				//提示成功并添加到已分配表格中
				$.notify({
					icon : 'glyphicon glyphicon-danger-sign',
					title : '<strong>授权结果</strong>',
					message : information
				}, {
					z_index : 1051,
					type : 'success', // danger warning info success
					mouse_over : 'pause',
				});
				if(information == "success"){
					$("#itrole_hidden_table").append(tr);
					$("#assignable_itrole_table").append("<tr><td data-value='"+itroleUuid+"'>"+itroleId+"</td><td><button class='btn btn-primary assign_privilege'>分&nbsp;&nbsp;配</button></td></tr>");
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
					mouse_over : 'pause'
				});
			}
		});
	})
})