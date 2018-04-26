$(function(){
	 	var Uuid = GetQueryString('useruuid');
//	 	console.log(Uuid);
	 	
	 	if(Uuid != null){
	 		
	 		var jsonStr = {"userUuid" : Uuid};
	 		$.ajax({
				type : 'post',
				url : 'toidentity/getUserInfo.action',
				contentType : 'application/json;charset=utf-8',
				data : JSON.stringify(jsonStr),
				dataType : 'json',
				async : false,
				success : function(resultMap){
					
					$("#user_id").attr('data-value',resultMap.user.userUuid);
					$("#user_id").val(resultMap.user.userId);
					$("#user_name").val(resultMap.user.userName);
					$("#user_status").val(resultMap.user.userStatus);
					$("#user_email").val(resultMap.user.userEmail);
					$("#user_employeeid").val(resultMap.user.userEmployeeId);
					$("#user_phonenumber").val(resultMap.user.userPhonenumber);
					
					$("#user_bizrole").val(resultMap.userBizRoleList);
					
				}
			});
	 	}
	
		var status = $("#user_status").val();
		if(status == '1'){
			$("#user_status").val("已激活");
		}
		if(status == '0'){
			$("#user_status").val("已禁用");
		}
		
		$("#user_bizrole").focus(function(){
			$('#select_bizrole').modal('show');
		})
		
		var initUserUuid = $("#user_id").attr('data-value');
//		console.log(initUserUuid);
		if(initUserUuid == ""){
			$("#user_bizrole").hide();
		}
		
		//模态框显示事件
		$('#select_bizrole').on('show.bs.modal', function () {
			$.ajax({
				type : 'post',
				url : 'toconfig/listallbizrole.action',
				contentType : 'application/json;charset=utf-8',
				dataType : 'json',
				success : function(result){
// 					console.log(result);
					for (var i = 0; i < result.length; i+=3) {
						var str = "<div class='form-group'>";
												
						for(var j = 0;j < 3 && j + i < result.length;j++){
							str += "<label class='col-md-4'  data-value='"+result[i+j].bizRoleName+"'><input type='checkbox' class='check'  data-value='"+result[i+j].bizRoleUuid+"'>"+result[i+j].bizRoleId+"</label>";
						}
						
						str += "</div>";
						
						$("#select_bizrole_form").append(str);
					}
				}
			});
			
		})
		
		//模态框隐藏事件
		$('#select_bizrole').on('show.bs.modal', function () {
			//清空
			$("#select_bizrole_form").empty();
		})
		
		//获取选中的岗位
		$("#select_bizrole_confirm").click(function(){
			$("#user_bizrole").empty();
			var arr = new Array();
			
			$(".check").each(function() {
				if ($(this).is(':checked')) {
					var label = $(this).parent();
					var bizRoleId = label.text();
					var bizRoleName = label.attr('data-value');
					var showValue = bizRoleId + "("+bizRoleName+");\n";
					$("#user_bizrole").append(showValue);
					var bizRoleUuid = $(this).attr('data-value');
					arr.push(bizRoleUuid);
				}
			})
			
			var userUuid = $("#user_id").attr('data-value');
			var jsonStr = {
				"bizRoleArr" : arr,
				"userUuid" : userUuid
			}
			
			$.ajax({
				type : 'post',
				url : 'toidentity/userbizrole.action',
				contentType : 'application/json;charset=utf-8',
				dataType : 'text',
				data : JSON.stringify(jsonStr),
				success : function(information){
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
					}else{
						$.notify({
							icon : 'glyphicon glyphicon-success-sign',
							title : '<strong>保存岗位结果</strong>',
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
		})
		
		//保存用户
		$("#save_user_btn").click(function(){
			var userUuid = $("#user_id").attr('data-value');	var userId = $("#user_id").val();
			var userName = $("#user_name").val();				var userStatus = $("#user_status").val();
			var userEmail = $("#user_email").val();				//var userType = $("#user_type").attr('value');		
			var userEmployeeId = $("#user_employeeid").val();	var userPhoneNumber = $("#user_phonenumber").val();
			
			if(userStatus == "已激活"){
				userStatus = 1;
			}else{
				userStatus = 0;
			}
			
			var jsonStr = {
					"userUuid" :  userUuid, "userId" :  userId,	"userName" :  userName,
					"userStatus" :  userStatus,	"userEmail" :  userEmail,
					"userEmployeeId" :  userEmployeeId,	"userPhoneNumber" : userPhoneNumber 
			}
			
			$.ajax({
				type : 'post',
				url : 'toidentity/saveuser.action',
				contentType : 'application/json;charset=utf-8',
				data : JSON.stringify(jsonStr),
				dataType : 'text',
				success : function(result){
					if(result.indexOf("success") >= 0){
						$.notify({
							icon : 'glyphicon glyphicon-success-sign',
							title : '<strong>保存用户结果</strong>',
							message : "成功",
							allow_dismiss : false
							// url: 'https://github.com/mouse0270/bootstrap-notify',
							// target: '_blank'
						}, {
							z_index : 1051,
							type : 'success', // danger warning info success
							mouse_over : 'pause'
						});
						setTimeout(function(){window.location.href='toidentity/user.action'}, 2000);
					}else{
						$.notify({
							icon : 'glyphicon glyphicon-success-sign',
							title : '<strong>保存用户结果结果</strong>',
							message : result,
							allow_dismiss : false
						}, {
							z_index : 1051,
							type : 'warning', // danger warning info success
							mouse_over : 'pause'
						});
					}
				}
			});
			
			
		})
	})