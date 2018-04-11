//利用正则表达式获取url中的参数
function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}

Date.prototype.format = function (format) {  
    var o = {  
        "M+": this.getMonth() + 1,  
        "d+": this.getDate(),  
        "h+": this.getHours(),  
        "m+": this.getMinutes(),  
        "s+": this.getSeconds(),  
        "q+": Math.floor((this.getMonth() + 3) / 3),  
        "S": this.getMilliseconds()  
    }  
    if (/(y+)/.test(format)) {  
        format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));  
    }  
    for (var k in o) {  
        if (new RegExp("(" + k + ")").test(format)) {  
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));  
        }  
    }  
    return format;  
}

function getFormatDateByLong(long) {  
	if(long == 0){
		return "";
	}
    return getFormatDate(new Date(long), "yyyy-MM-dd hh:mm:ss");  
} 

function getFormatDate(date, pattern) {  
    if (date == undefined) {  
        date = new Date();  
    }  
    if (pattern == undefined) {  
        pattern = "yyyy-MM-dd hh:mm:ss";  
    }  
    return date.format(pattern);  
}  

function getResource(){
	var scd_job_type = $("#scd_job_type").val();
	
	var scd_job_type_json = {"scd_job_type":scd_job_type};
//	console.log(scd_job_type_json);
	
	//获取该任务对应的可用资源
	$.ajax({
		type : 'post',
		url : 'totask/getresourcebyscd.action',
		contentType : 'application/json;charset=utf-8',// 指定为json类型
		dataType : 'json', // 服务器响应类型
		data : JSON.stringify(scd_job_type_json), // JSON.stringify(jdbc),
		success : function(result) {// 返回json结果
//			console.log("success : " + result);
			$("#resource_uuid_sel").empty();
			for (var i = 0; i < result.length; i++) {
				$("#resource_uuid_sel").append("<option value='"+result[i].resId+"'>"+result[i].resId+"</option>");
			}
		},
		error : function(result) {
//			console.log("error : " + result);
		}
	});
}

$(function(){
	//全局变量
	var scduuid = GetQueryString('scduuid');//资源uuid
//	console.log(scduuid);
	
	
	if(scduuid != null && scduuid != "" && scduuid != "null"){
		$.ajax({
			type : 'post',
			async: false,
			url : 'totask/gettask.action',
			contentType : 'application/json;charset=utf-8',// 指定为json类型
			dataType : 'json', // 服务器响应类型
			data : JSON.stringify(scduuid), // JSON.stringify(jdbc),
			success : function(schedulejob) {// 返回json结果
				var scdId = schedulejob.scdId;
				var scdJobType = schedulejob.scdJobType;
				var scdCron = schedulejob.scdCron;
				var scdStatus = schedulejob.scdStatus;
				var scdLastRunTime = schedulejob.scdLastRunTime;
				var lastRunTime = getFormatDateByLong(Number(scdLastRunTime));
				var scdNextRunTime = schedulejob.scdNextRunTime;
				var nextRunTime = getFormatDateByLong(Number(scdNextRunTime));
				var scdDesc = schedulejob.scdDesc;
				//json
				var resJsonAttr = JSON.parse(schedulejob.scdJsonAttr);
//				console.log(resJsonAttr);
				
				$("#scd_job_id").val(scdId);
				$("#scd_job_type").val(scdJobType);
				$("#scd_job_cron").val(scdCron);
				if(scdStatus == "1"){
					$("#scd_job_status").val("已激活");
					$("#scd_job_status").attr("data-value","1");
				}else{
					$("#scd_job_status").val("已禁用");
					$("#scd_job_status").attr("data-value","0");
				}
				$("#scd_job_last_run_time").val(lastRunTime);
				$("#scd_job_next_run_time").val(nextRunTime);
				$("#scd_job_desc").val(scdDesc);
				
				//attr				错误：应该添加该类型可选的全部资源，并且将当前获取的资源选中
				var attrJson = resJsonAttr.attrJson;
				getResource();
				//等待ajax完成
				setTimeout(function(){$("#resource_uuid_sel").val(attrJson.resource_uuid_sel);}, 1000);
				
				
				//taskChain
				var taskchain = resJsonAttr.taskchainJson;
//				console.log("taskchain : " + taskchain);
				for (var i = 0; i < taskchain.length; i++) {
					var scdid = taskchain[i].scdJobId;
					$("#taskchain_table").append("<tr class='taskchain_tr'><td>"+scdid+"</td><td><button class='btn btn-primary taskchan_del'>删除</button></td></tr>");
					
				}
				
				//execution button
				$("#button_div").append("<button class='btn btn-primary' id='run_button'>立即运行</button>");

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
	}
	
	//获取任务链下拉框内容
	$.ajax({
		type : 'post',
		url : 'totask/gettaskchian.action',
		contentType : 'application/json;charset=utf-8',// 指定为json类型
		dataType : 'json', // 服务器响应类型
//		data : JSON.stringify(scduuid), // JSON.stringify(jdbc),
		success : function(schedulejobList) {// 返回json结果
//			console.log("get task chain : " + schedulejobList);
			for (var i = 0; i < schedulejobList.length; i++) {
				if(schedulejobList[i].scdUuid != scduuid){
					$("#schedule_uuid_sel").append("<option value='"+schedulejobList[i].scdId+"'>"+schedulejobList[i].scdId+"</option>");
				}
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
	
	
	$("#scd_job_type").change(function(){
		getResource();
	})
	
	$("#save_scd_btn").click(function(){
		var scd_job_json = {};
		
		scd_job_json['scduuid'] = scduuid;
		
		var scd_job_id = $("#scd_job_id").val();
		var scd_job_type = $("#scd_job_type").val();
		var scd_job_cron = $("#scd_job_cron").val();
//		var scd_job_status = $("#scd_job_status").val();
		var scd_job_status = $("#scd_job_status").attr("data-value");
		var scd_job_last_run_time = $("#scd_job_last_run_time").val();
		var scd_job_next_run_time = $("#scd_job_next_run_time").val();
		var scd_job_desc = $("#scd_job_desc").val();
		
		var scdJobBaseJson = {
				"scd_job_id" : scd_job_id,
				"scd_job_type" : scd_job_type,
				"scd_job_cron" : scd_job_cron,
				"scd_job_status" : scd_job_status,
				"scd_job_last_run_time" : scd_job_last_run_time,
				"scd_job_next_run_time" : scd_job_next_run_time,
				"scd_job_desc" : scd_job_desc
			}
		
		scd_job_json['scdJobBaseJson'] = scdJobBaseJson;

		
		var tabJson = {};
		
		var resource_uuid_sel = $("#resource_uuid_sel").val();
		var attrJson = {
				"resource_uuid_sel":resource_uuid_sel
		}
		tabJson['attrJson'] = attrJson;
		
		//taskchain_tr
		var taskchainJson = new Array();
		$(".taskchain_tr").each(function(){
			var scdJobId = $(this).children().eq(0).text();
			var acct_tr_json = {
				"scdJobId" : scdJobId	
			}
			taskchainJson.push(acct_tr_json);
		})
		
		tabJson['taskchainJson'] = taskchainJson;
		
		scd_job_json['tabJson'] = tabJson;
		
		// 发送到后台
		$.ajax({
			type : 'post',
			url : 'totask/savescdjob.action',
			contentType : 'application/json;charset=utf-8',// 指定为json类型
			dataType : 'json', // 服务器响应类型
			data : JSON.stringify(scd_job_json), // JSON.stringify(jdbc),
			success : function(information) {// 返回json结果
				if(information.result.indexOf("success") >= 0){
					$.notify({
						icon : 'glyphicon glyphicon-success-sign',
						title : '<strong>保存定时任务结果</strong>',
						message : "成功",
						allow_dismiss : false
						// url: 'https://github.com/mouse0270/bootstrap-notify',
						// target: '_blank'
					}, {
						type : 'success', // danger warning info success
						mouse_over : 'pause'
					});
					setTimeout(function(){window.location.href='totask/task.action'}, 2000);
				}else{
					$.notify({
						icon : 'glyphicon glyphicon-success-sign',
						title : '<strong>创建定时任务结果</strong>',
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
					title : '<strong>创建定时任务结果</strong>',
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
	
	$("#add_scd_chain_btn").click(function(){
		var scduuid = $("#schedule_uuid_sel").val();
		
		if(scduuid != ""){
			$("#taskchain_table").append("<tr class='taskchain_tr'><td>"+scduuid+"</td><td><button class='btn btn-primary taskchan_del'>删除</button></td></tr>");
		}
	})
	
	$(".container").on("click", ".taskchan_del", function() {
		$(this).parent().parent().remove();
	})
	
	$(".container").on("click", "#run_button", function() {
		// 发送到后台
		$.ajax({
			type : 'post',
			url : 'totask/runtask.action',
			contentType : 'application/json;charset=utf-8',// 指定为json类型
			dataType : 'text', // 服务器响应类型
			data : JSON.stringify(scduuid), // JSON.stringify(jdbc),
			success : function() {// 返回json结果
				console.log("请求发送成功");
			},
			error : function() {
				console.log("请求发送失败");
			}
		});
	})
	
})