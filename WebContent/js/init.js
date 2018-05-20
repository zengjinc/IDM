function fixNavigation() {
	// 修改附导航栏的高度
	var height = $(".container").height();
	// var height = $(".subject").height();
	$("#myScrollspy").height(height * 0.8);
	// console.log("fix navigation height : " + height);
}

//获取url中的参数
function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}

function logOutConfirm(){
	 var msg = "您真的退出系统吗？\n请确认！";
	 if (confirm(msg)){ 
	 	return true; 
	 }else{ 
	 	return false; 
	 } 
}

$(function() {
	//模态框显示事件
	$('#resert_user_password').on('show.bs.modal', function() {
		$("#old_user_pwd").val('');
		$("#new_user_pwd").val('');
		$("#new_user_pwd2").val('');
	})
	
	//确认修改密码
	$("#resert_user_password_confirm").click(function(){
		var oldPassword = $("#old_user_pwd").val();
		var newPassword = $("#new_user_pwd").val();
		var newPassword2 = $("#new_user_pwd2").val();
		
		var jsonStr = {"oldPassword" : oldPassword,"newPassword" : newPassword,"newPassword2" : newPassword2};
		
		$.ajax({
			type : 'post',
			url : 'changepassword.action',
			contentType : 'application/json;charset=utf-8',
			dataType : 'text',
			data : JSON.stringify(jsonStr),
			success : function(information){
				if(information.indexOf("success") >= 0){
					//清空cookie
					$.cookie("rmbMe", "false", { expires: -1 }); // 删除 cookie
			        $.cookie("userName", '', { expires: -1 });
			        $.cookie("pwd", '', { expires: -1 });
					$.notify({
						icon : 'glyphicon glyphicon-success-sign',
						title : '<strong>修改密码结果</strong>',
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
						title : '<strong>修改密码结果 ： 失败。</strong>',
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
	
	// 导航栏点击变色
	var nav = $(".nav.navbar-nav.navbar-left");
	var pageUrl = window.location.href;
	var aArray = nav.children("li").children("a");
	// console.log("pageUrl:"+pageUrl);
	for (var i = 0; i < aArray.length; i++) {
		// 高亮当前栏目，如果为子栏目时，则匹配 href 亮父栏目
		// console.log("url" + i + ":" + aArray[i].href);
		var url = aArray[i].href.split(".")[0];
		// console.log("url" + i + ":" + url)
		if (pageUrl.substring(0, url.length) == url) {
			$(aArray[i]).parent().addClass("active");
		}
	}
	// 附导航栏
	var subNav = $(".nav.nav-pills.nav-stacked");
	var bArray = subNav.children("li").children("a");
	// console.log("pageUrl:" + pageUrl);
	for (var i = 0; i < bArray.length; i++) {
		// console.log("arrayUrl:" + bArray[i].href);
		var url = bArray[i].href.split(".")[0];
		// console.log(url);
		if (pageUrl.substring(0, url.length) == url) {
			$(bArray[i]).parent().addClass("active");
		}
	}

	// 修改附导航栏的高度
	fixNavigation();
	// var height = $(".container").height();
	// var height = $(".subject").height();
	// $("#myScrollspy").height(height*0.8);

	// 设置面包屑导航

	var navActive = $(".nav.navbar-nav").children(".active");
	var navText = navActive.text();
	var navHref = navActive.children("a").attr("href");

	var subNav = $(".nav.nav-pills.nav-stacked").children(".active");
	var subNavText = subNav.text();

	$(".breadcrumb").append(
			"<li><a href='" + navHref + "'>" + navText + "</a></li>");
	$(".breadcrumb").append("<li>" + subNavText + "</li>");

	$("#toggle_nav").click(function() {
		var display = $("#myScrollspy").css("display");
		if(display == "block"){
			$.cookie('display', 'none',{ path: '/' });
			$("#toggle_nav").text("显示导航");
//			$("#myScrollspy").css("display","none");
			$("#myScrollspy").animate({width:'toggle'},350);
			$(".subject").removeClass("col-md-10");
			$(".subject").addClass("col-md-12");
		}else{
			$.cookie('display', 'block',{ path: '/' });
			$("#toggle_nav").text("隐藏导航");
//			$("#myScrollspy").css("display","block");
			$("#myScrollspy").animate({width:'toggle'},350);
			$(".subject").removeClass("col-md-12");
			$(".subject").addClass("col-md-10");
		}
	})
	
	var display = $.cookie('display');
	if(display == "none"){
		$("#toggle_nav").text("显示导航");
		$("#myScrollspy").css("display","none");
		$(".subject").removeClass("col-md-10");
		$(".subject").addClass("col-md-12");
	}else{
		$("#toggle_nav").text("隐藏导航");
		$("#myScrollspy").css("display","block");
		$(".subject").removeClass("col-md-12");
		$(".subject").addClass("col-md-10");
	}
})