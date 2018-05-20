$(function(){
	var bizRoleUuid=GetQueryString("bizroleuuid");
	
	if(bizRoleUuid != null){
		var jsonStr = {"bizRoleUuid":bizRoleUuid};
		console.log(1);
		$.ajax({
			type : 'post',
			url : 'toconfig/getbizrole.action',
			contentType : 'application/json;charset=utf-8',// 指定为发送类型json类型
			data : JSON.stringify(jsonStr),
			dataType : 'json', // 服务器响应类型
			success : function(result) {// 返回json结果
				$("#bizrole_id").val(result.bizRoleId);
				$("#bizrole_name").val(result.bizRoleName);
				$("#bizrole_desc").val(result.bizRoleDesc);
			}
		});
	}
	
	$("#save_bizrole_btn").click(function(){
		var validate = $('#form1').data('bootstrapValidator').validate();
		
		if(validate.isValid()){ 
			var bizRoleId = $("#bizrole_id").val();
			var bizRoleName = $("#bizrole_name").val();
			var bizRoleDesc = $("#bizrole_desc").val();
			var jsonStr = {
					"bizRoleId" : bizRoleId,
					"bizRoleName" : bizRoleName,
					"bizRoleDesc" : bizRoleDesc,
					"bizRoleUuid" : bizRoleUuid
			}
			
			$.ajax({
				type : 'post',
				url : 'toconfig/savebizrole.action',
				contentType : 'application/json;charset=utf-8',// 指定为json类型
				dataType : 'text', // 服务器响应类型
				data : JSON.stringify(jsonStr),
				success : function(information) {// 返回json结果
					if(information.indexOf("success") >= 0){
						$.notify({
							icon : 'glyphicon glyphicon-success-sign',
							title : '<strong>保存岗位结果</strong>',
							message : "成功",
							allow_dismiss : false
							// url: 'https://github.com/mouse0270/bootstrap-notify',
							// target: '_blank'
						}, {
							z_index : 1051,
							type : 'success', // danger warning info success
							mouse_over : 'pause'
						});
						setTimeout(function(){window.location.href='toconfig/bizrole.action'}, 2000);
					}else{
						$.notify({
							icon : 'glyphicon glyphicon-success-sign',
							title : '<strong>创建岗位结果</strong>',
							message : information,
							allow_dismiss : false
						}, {
							z_index : 1051,
							type : 'warning', // danger warning info success
							mouse_over : 'pause'
						});
					}
				}
			});
		}
	})
})