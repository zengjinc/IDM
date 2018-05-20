$(function() {
			var status = $("#user_status").val();
			if (status == '1') {
				$("#user_status").val("已激活");
			}
			if (status == '0') {
				$("#user_status").val("已禁用");
			}
			// 当触发模态框的显示事件时
			$('#assign_account_modal').on('show.bs.modal', function() {
				// 向服务器获取非可信任资源列表，显示到页面上
				$.ajax({
					type : 'post',
					url : 'toidentity/getnontrustresource.action',
					contentType : 'application/json;charset=utf-8',// 指定为json类型
					dataType : 'json', // 服务器响应类型
// data : jdbc, // JSON.stringify(jdbc),
					success : function(resourceList) {// 返回json结果
						for (var i = 0; i < resourceList.length; i++) {
							$("#resource_table").append("<tr><td data-value='"+resourceList[i].resUuid+"'>"+resourceList[i].resId+"</td><td>"+resourceList[i].resName+
									"</td><td><button class='btn btn-primary create_account' data-value='"+resourceList[i].resId+"' data-value2='"+resourceList[i].resUuid+"'>创&nbsp;&nbsp;建</button>&nbsp;&nbsp;&nbsp;&nbsp;" +
									"<button class='btn btn-primary assign_account' data-value='"+resourceList[i].resUuid+"'>分&nbsp;&nbsp;配</button></td></tr>");
							
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
			//模态框显示事件
			$('#resert_password').on('show.bs.modal', function() {
				$("#old_pwd").val('');
				$("#new_pwd").val('');
				$("#new_pwd2").val('');
			})
			// 当触发模态框的隐藏事件时
			$('#assign_account_modal').on('hide.bs.modal', function() {
				$("#resource_table tr:not(:first)").empty();
				$("#primary_account_table tr:not(:first)").empty();
				$("#secondary_account_table tr:not(:first)").empty();
				$("#create_account_confirm").css("display","none");
				$("#accountdetail_modal_confirm").css("display","inline-block");
				$("#myTab2").css("display","block");
				$("#myTabContent2").css("display","block");
				$("#myTab3").css("display","none");
				$("#myTabContent3").css("display","none");
			})
			// 创建账号
			$(".container").on("click", ".create_account", function() {
				$("#myTab2").css("display","none");
				$("#myTabContent2").css("display","none");
				$("#myTab3").css("display","block");
				$("#myTabContent3").css("display","block");
				$("#create_account_confirm").css("display","inline-block");
				$("#accountdetail_modal_confirm").css("display","none");
				
				var user_id = $("#user_id").val();
				var user_uuid = $("#user_id").attr('data-value');
				var resId = $(this).attr("data-value");
				var resUuid = $(this).attr("data-value2");
				$("#user_id_label").text(user_id);
				$("#user_id_label").attr('data-value',user_uuid);
				$("#resource_id_label").text(resId);
				$("#resource_id_label").attr('data-value',resUuid);
				// 获取资源中定义的属性
				$.ajax({
					type : 'post',
					url : 'toidentity/getacctattrbyresuuid.action',
					contentType : 'application/json;charset=utf-8',// 指定为json类型
					dataType : 'json', // 服务器响应类型
					data : JSON.stringify(resUuid), // JSON.stringify(jdbc),
					success : function(targetNameList) {// 返回json结果
						$("#acct_attr_form").empty();
						for (var i = 0; i < targetNameList.length; i++) {
							$("#acct_attr_form").append("<div class='form-group'><label class='col-md-2 control-label'>"+
									targetNameList[i]+"</label><div class='col-md-5'><input type='text' class='form-control addbyajax'" +
											" name='"+targetNameList[i]+"'></div></div>");
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
			// 搜索该资源下可分配账号
			$(".container").on("click", ".assign_account", function() {
				$("#myTab2").css("display","block");
				$("#myTabContent2").css("display","block");
				$("#myTab3").css("display","none");
				$("#myTabContent3").css("display","none");
				$("#create_account_confirm").css("display","none");
				$("#accountdetail_modal_confirm").css("display","inline-block");
				
				
				var resUuid = $(this).attr("data-value");
				$.ajax({
					type : 'post',
					url : 'toidentity/getaccountbyresuuid.action',
					contentType : 'application/json;charset=utf-8',// 指定为json类型
					dataType : 'json', // 服务器响应类型
					data : JSON.stringify(resUuid), // JSON.stringify(jdbc),
					success : function(accountList) {// 返回json结果
						$("#primary_account_table tr:not(:first)").empty();
						$("#secondary_account_table tr:not(:first)").empty();
						for (var i = 0; i < accountList.length; i++) {
							if(accountList[i].acctPrimary == '1'){
								$("#primary_account_table").append("<tr><td data-value='"+ accountList[i].acctResUuid +"'>"+accountList[i].acctLoginId+"</td>" +
										"<td><button class='btn btn-primary assign' data-value='"+accountList[i].acctTgtUuid+"'>分&nbsp;&nbsp;配</button></td></tr>");
							}
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
			// 分配账号
			$(".container").on("click", ".assign", function() {
				$(this).prop('disabled', true); 
				var userUuid = $("#user_id").attr("data-value");
				var acctUuid = $(this).attr("data-value");
				var resUuid = $(this).parent().parent().children("td:eq(0)").attr("data-value");
				var jsonStr = {};
				jsonStr['userUuid'] = userUuid;
				jsonStr['acctUuid'] = acctUuid;
				jsonStr['resUuid'] = resUuid;
				
				$.ajax({
					type : 'post',
					url : 'toidentity/entitlement.action',
					contentType : 'application/json;charset=utf-8',// 指定为json类型
					dataType : 'text', // 服务器响应类型
					data : JSON.stringify(jsonStr), // JSON.stringify(jdbc),
					success : function(information) {// 返回json结果
						$.notify({
							icon : 'glyphicon glyphicon-danger-sign',
							title : '<strong>授权结果</strong>',
							message : information
						}, {
							z_index : 1051,
							type : 'success', // danger warning info success
							mouse_over : 'pause',
						});
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
			
			// 分配完毕，刷新当前页面
			$("#accountdetail_modal_confirm").click(function(){
				window.location.reload();
			})
			
			//全选
			$(".check_all").change(function(){
				if ($(this).is(':checked')) {
					$(".check").prop("checked", true);
				} else {
					$(".check").prop("checked", false);
				}
			});
			
			//批量删除权限分配
			$("#delete_user_btn").click(function(){
				var jsonStr = {};
				var userUuid = $("#user_id").attr('data-value');
				jsonStr['userUuid'] = userUuid;
				var acctMsg = new Array();
				$(".check").each(function() {
					if ($(this).is(':checked')) {
						var tgtuuid = $(this).parent().parent().children("td:eq(3)").attr('data-value');
						var resuuid = $(this).parent().parent().children("td:eq(1)").attr('data-value');
						var temp = {
							"tgtuuid":tgtuuid,
							"resuuid":resuuid,
						}
						acctMsg.push(temp);
					}
				})
				jsonStr['acctMsg'] = acctMsg;
				
				if(acctMsg.length <= 0){
					$.notify("请先选择用户，再进行删除操作。");
				}else{
					
					var msg = "确认删除该账号吗？\n用户将失去该账号的使用权。";
					if(confirm()){
						//发送到后台
						$.ajax({
							async:false,
							type : 'post',
							url : 'toidentity/deleteentitlement.action',
							contentType : 'application/json;charset=utf-8',// 指定为json类型
							dataType : 'text', // 服务器响应类型
							data : JSON.stringify(jsonStr),
							success : function(resourceList) {// 返回json结果
								
							},
							error : function(information) {
								
							}
						});
						//刷新当前页面
						window.location.reload();
					}
				}
			})
			
			//批量禁用授权（更改授权状态）
			$("#disable_user_btn").click(function(){
				var jsonStr = {};
				var userUuid = $("#user_id").attr('data-value');
				jsonStr['userUuid'] = userUuid;
				var acctMsg = new Array();
				$(".check").each(function() {
					if ($(this).is(':checked')) {
						var tgtuuid = $(this).parent().parent().children("td:eq(3)").attr('data-value');
						var resuuid = $(this).parent().parent().children("td:eq(1)").attr('data-value');
						var temp = {
							"tgtuuid":tgtuuid,
							"resuuid":resuuid,
						}
						acctMsg.push(temp);
					}
				})
				jsonStr['acctMsg'] = acctMsg;
				
				if(acctMsg.length <= 0){
					$.notify("请先选择用户，再进行禁用操作。");
				}else{
					//发送到后台
					$.ajax({
						async:false,
						type : 'post',
						url : 'toidentity/disableentitlement.action',
						contentType : 'application/json;charset=utf-8',// 指定为json类型
						dataType : 'text', // 服务器响应类型
						data : JSON.stringify(jsonStr),
						success : function(resourceList) {// 返回json结果
							
						},
						error : function(information) {
							
						}
					});
					//刷新当前页面
					window.location.reload();
				}
				
			})
			
			//批量激活授权（更改授权状态）
			$("#enable_user_btn").click(function(){
				var jsonStr = {};
				var userUuid = $("#user_id").attr('data-value');
				jsonStr['userUuid'] = userUuid;
				var acctMsg = new Array();
				$(".check").each(function() {
					if ($(this).is(':checked')) {
						var tgtuuid = $(this).parent().parent().children("td:eq(3)").attr('data-value');
						var resuuid = $(this).parent().parent().children("td:eq(1)").attr('data-value');
						var temp = {
							"tgtuuid":tgtuuid,
							"resuuid":resuuid,
						}
						acctMsg.push(temp);
					}
				})
				jsonStr['acctMsg'] = acctMsg;
				
				if(acctMsg.length <= 0){
					$.notify("请先选择用户，再进行激活操作。");
				}else{
					//发送到后台
					$.ajax({
						async:false,
						type : 'post',
						url : 'toidentity/enableentitlement.action',
						contentType : 'application/json;charset=utf-8',// 指定为json类型
						dataType : 'text', // 服务器响应类型
						data : JSON.stringify(jsonStr),
						success : function(resourceList) {// 返回json结果
							
						},
						error : function(information) {
							
						}
					});
					//刷新当前页面
					window.location.reload();
				}
			})
			
			//查看账号属性
			$(".edit_account").click(function(){
				var tgtuuid = $(this).parent().parent().children("td:eq(3)").attr('data-value');
				var resUuid = $(this).parent().parent().children("td:eq(1)").attr('data-value');
				var userUuid = $("#user_id").attr('data-value');
				$("#res_uuid_hidden").val(resUuid);
				$("#acct_uuid_hidden").val(tgtuuid);
				$("#user_uuid_hidden").val(userUuid);
				
				//发送到后台获取数据
				$.ajax({
					type : 'post',
					url : 'toidentity/getacctattrbyacctuuid.action',
					contentType : 'application/json;charset=utf-8',// 指定为json类型
					dataType : 'json', // 服务器响应类型
					data : JSON.stringify(tgtuuid),
					success : function(accountAttributeList) {// 返回json结果
						$("#account_attribute_form").empty();
						for (var i = 0; i < accountAttributeList.length; i++) {
							$("#account_attribute_form").append("<div class='form-group'><label class='col-md-3 control-label'>" +
									accountAttributeList[i].acctAttrKey + "</label><div class='col-md-5'><input type='text' class='form-control acct_attr' " +
											"name='"+accountAttributeList[i].acctAttrKey+"' value='"+accountAttributeList[i].acctAttrVal+"' /></div></div>");
						}
					},
					error : function(information) {
						$.notify({
							icon : 'glyphicon glyphicon-danger-sign',
							title : '<strong>出错了</strong>',
							message : information
						}, {
							type : 'danger', // danger warning info success
							mouse_over : 'pause',
						});
					}
				});
			})
			
			//重设密码
			$(".reset_password").click(function(){
				var resUuid = $(this).parent().parent().children("td:eq(1)").attr("data-value");
				var acctUuid = $(this).parent().parent().children("td:eq(3)").attr("data-value");
				var userUuid = $("#user_id").attr("data-value");
				$("#res_uuid_hidden").val(resUuid);
				$("#acct_uuid_hidden").val(acctUuid);
				$("#user_uuid_hidden").val(userUuid);
			})
			
			//确认重设密码
			$("#resert_password_confirm").click(function(){
				var resUuid = $("#res_uuid_hidden").val();
				var acctUuid = $("#acct_uuid_hidden").val();
				var userUuid = $("#user_uuid_hidden").val();
				
//				var oldPwd = $("#old_pwd").val();
				var newPwd = $("#new_pwd").val();
				var newPwd2 = $("#new_pwd2").val();
				
				var jsonStr = {
					"resUuid" : resUuid,
					"acctUuid" : acctUuid,
					"userUuid" : userUuid,
//					"oldPwd" : oldPwd,
					"newPwd" : newPwd,
					"newPwd2" : newPwd2
				};
				
				$.ajax({
					type : 'post',
					url : 'toidentity/resetpassword.action',
					contentType : 'application/json;charset=utf-8',// 指定为json类型
					dataType : 'text', // 服务器响应类型
					data : JSON.stringify(jsonStr),
					success : function(information) {// 返回json结果
						if(information == "success"){
							$.notify({
								icon : 'glyphicon glyphicon-danger-sign',
								title : '<strong>重设密码</strong>',
								message : information
							}, {
								type : 'success', // danger warning info success
								mouse_over : 'pause',
							});
						}else{
							$.notify({
								icon : 'glyphicon glyphicon-danger-sign',
								title : '<strong>重设密码</strong>',
								message : information
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
							message : information
						}, {
							type : 'danger', // danger warning info success
							mouse_over : 'pause',
						});
					}
				});
			})
			
			//修改账号属性 确认
			$("#edit_account_confirm").click(function(){
				var resUuid = $("#res_uuid_hidden").val();
				var acctUuid = $("#acct_uuid_hidden").val();
				var userUuid = $("#user_uuid_hidden").val();
				
				//获取账号属性
				var arr = new Array();
				$(".acct_attr").each(function(){
					var attrKey = $(this).attr('name');
					var attrVal = $(this).val();
					var tempJson = {};
					tempJson[attrKey] = attrVal;
					arr.push(tempJson);
				})
				var jsonStr = {
					"resUuid" : resUuid,
					"acctUuid" : acctUuid,
					"userUuid" : userUuid,
				};
				jsonStr['acctAttr'] = arr;
				//发送到服务器，更新账号属性
				$.ajax({
					type : 'post',
					url : 'toidentity/updateaccountattribute.action',
					contentType : 'application/json;charset=utf-8',// 指定为json类型
					dataType : 'text', // 服务器响应类型
					data : JSON.stringify(jsonStr),
					success : function(information) {// 返回json结果
						console.log(information);
						if(information == "success"){
							//刷新当前页面
							window.location.reload();
						}else{
							$.notify({
								icon : 'glyphicon glyphicon-danger-sign',
								title : '<strong>更新账号属性</strong>',
								message : information
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
							message : information
						}, {
							type : 'danger', // danger warning info success
							mouse_over : 'pause',
						});
					}
				});
			})
			
			//创建对应资源中的账号
			$("#create_account_confirm").click(function(){
//				var resUuid = $("#res_uuid_hidden").val();
//				var acctUuid = $("#acct_uuid_hidden").val();
//				var userUuid = $("#user_uuid_hidden").val();
				
				//获取基本属性
				var userId=$("#user_id_label").text();
				var userUuid=$("#user_id_label").attr('data-value');
				var resId=$("#resource_id_label").text();
				var resUuid=$("#resource_id_label").attr("data-value");
				var acctId=$("#account_id").val();
				var acttPwd=$("#account_pwd").val();
				var acttPwd2=$("#account_pwd2").val();
				
				console.log("test : " + resUuid);
				
				//获取账号属性
				var arr = new Array();
				$(".addbyajax").each(function(){
					var attrKey = $(this).attr('name');
					var attrVal = $(this).val();
					var tempJson = {};
					tempJson[attrKey] = attrVal;
					arr.push(tempJson);
				})
				var jsonStr = {
					"userId" : userId,
					"userUuid" : userUuid,
					"resId" : resId,
					"resUuid" : resUuid,
					"acctId" : acctId,
					"acttPwd" : acttPwd,
					"acttPwd2" : acttPwd2
				};
				jsonStr['acctAttr'] = arr;
				
				//发送到服务器，更新账号属性
				$.ajax({
					type : 'post',
					url : 'toidentity/createaccount.action',
					contentType : 'application/json;charset=utf-8',// 指定为json类型
					dataType : 'text', // 服务器响应类型
					data : JSON.stringify(jsonStr),
					success : function(information) {// 返回json结果
						console.log(information);
						if(information == "success"){
							//刷新当前页面
							window.location.reload();
						}else{
							$.notify({
								icon : 'glyphicon glyphicon-danger-sign',
								title : '<strong>更新账号属性</strong>',
								message : information
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
							message : information
						}, {
							type : 'danger', // danger warning info success
							mouse_over : 'pause',
						});
					}
				});
				
			})
		})