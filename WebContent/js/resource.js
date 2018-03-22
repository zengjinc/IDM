/*
 * function
 */
function updateAccountAttr() {
	// 清空账户属性下拉框
	$("#account_attr").empty();
	// 获取属性值、填充下拉框
	fill_attr("account_attr");
}

function fill_attr(attr_def_table) {
	$("#" + attr_def_table + " tr").each(function() {
		var showname = $(this).children("td:eq(2)").text();
		if (showname != "") {
			$("#accountdetail_select").append("<option value='" + showname
					+ "'>" + showname + "</option>");
		}
	})
}

// 目标资源回收的账号拥有者匹配规则 下拉框填充
function fill_account_attr() {
	// 清空下拉框
	$("#account_owner_assign_sel").empty();
	// 获取账号属性的值，填充到对应的下拉框
	$("#user_account_attr_mapping_table tr").each(function() {
		var account_attr = $(this).children("td:eq(1)").text();
		if (account_attr != "") {
			$("#account_owner_assign_sel").append("<option value='"
					+ account_attr + "'>" + account_attr + "</option>");
		}
	})
}

/*
 * jquery
 */
$(function() {
	var obj_attrdef_tr; // 编辑属性定义的时候对应的tr
	var obj_role_attrdef_tr; // 编辑属性定义的时候对应的tr（角色）
	var obj_ou_attrdef_tr; // 编辑属性定义的时候对应的tr（组织单位）
	var obj_attrdetail; // 选择属性详细资料时候对应的对象
	var obj_role_attrdetail // 选择属性详细资料时候对应的对象（角色）
	var obj_ou_attrdetail // 选择属性详细资料时候对应的对象（组织单位）

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
				$("#accountdetail_select")
						.append("<option value=''>-</option>");
				// 还原默认按钮
				$("#accountdetail_modal_confirm")
						.css("display", "inline-block");
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
	$("#attrdef_modal_confirm").click(function() {
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
				.append("<tr><td><input type='checkbox' class='account_chk'/></td><td>"
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
		 * $("#attrdef_targetname").val(""); $("#attrdef_showname").val("");
		 * $("#attrdef_datatype").val("string"); $("#attrdef_min").val("");
		 * $("#attrdef_max").val(""); $("#attrdef_required").val("false");
		 * $("#attrdef_editable").val("true");
		 */

		// 更新账号属性
		updateAccountAttr();
	})

	// 模态框，增加属性定义按钮(角色)
	$("#role_attrdef_modal_confirm").click(function() {
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
				.append("<tr><td><input type='checkbox' class='role_chk'/></td><td>"
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
	$("#ou_attrdef_modal_confirm").click(function() {
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
				.append("<tr><td><input type='checkbox' class='ou_chk'/></td><td>"
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
				var targetname = $(this).parent().parent().children().eq(1)
						.text();
				var showname = $(this).parent().parent().children().eq(2)
						.text();
				var datatype = $(this).parent().parent().children().eq(3)
						.text();
				var min = $(this).parent().parent().children().eq(4).text();
				var max = $(this).parent().parent().children().eq(5).text();
				var required = $(this).parent().parent().children().eq(6)
						.text();
				var editable = $(this).parent().parent().children().eq(7)
						.text();
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
				$("#attrdef_modal_confirm_modify").css("display",
						"inline-block");
			})

	// 属性定义编辑按钮(角色)
	$(".container").on("click", ".role_attrdef_edit", function() {
				// 获取同行元素的值
				var targetname = $(this).parent().parent().children().eq(1)
						.text();
				var showname = $(this).parent().parent().children().eq(2)
						.text();
				var datatype = $(this).parent().parent().children().eq(3)
						.text();
				var min = $(this).parent().parent().children().eq(4).text();
				var max = $(this).parent().parent().children().eq(5).text();
				var required = $(this).parent().parent().children().eq(6)
						.text();
				var editable = $(this).parent().parent().children().eq(7)
						.text();
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
				$("#role_attrdef_modal_confirm_modify").css("display",
						"inline-block");
			})

	// 属性定义编辑按钮(组织单位)
	$(".container").on("click", ".ou_attrdef_edit", function() {
				// 获取同行元素的值
				var targetname = $(this).parent().parent().children().eq(1)
						.text();
				var showname = $(this).parent().parent().children().eq(2)
						.text();
				var datatype = $(this).parent().parent().children().eq(3)
						.text();
				var min = $(this).parent().parent().children().eq(4).text();
				var max = $(this).parent().parent().children().eq(5).text();
				var required = $(this).parent().parent().children().eq(6)
						.text();
				var editable = $(this).parent().parent().children().eq(7)
						.text();
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
				$("#ou_attrdef_modal_confirm_modify").css("display",
						"inline-block");
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
				 * $("#attrdef_targetname").val("");
				 * $("#attrdef_showname").val("");
				 * $("#attrdef_datatype").val("string");
				 * $("#attrdef_min").val(""); $("#attrdef_max").val("");
				 * $("#attrdef_required").val("false");
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
	$("#account_uuid,#account_id,#account_ou_uuid,#account_createtime,#account_modifytime,#account_status,#account_lock")
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
				$("#role_accountdetail_modal_confirm").css("display",
						"inline-block");
				$("#accountdetail_modal_confirm").css("display", "none");
				obj_role_attrdetail = $(this);
				// 获取属性定义、填充模态框中的下拉框
				fill_attr("role_attrdef_table");
				// 显示模态框
				$('#accountdetail_modal').modal('show');

			});

	// 属性详细资料输入框获得焦点的时候显示模态框（组织单位）
	$("#ou_uuid,#ou_id,#ou_distinguished_name,#ou_name,#ou_name2,#ou_parent_uuid")
			.focus(function() {
				// 更改默认显示按钮
				$("#ou_accountdetail_modal_confirm").css("display",
						"inline-block");
				$("#accountdetail_modal_confirm").css("display", "none");
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

	$("#account_btn_add_mapping").click(function() {
		var userattr = $("#attr_mapping").val();
		var accountattr = $("#account_attr").val();
		// console.log(userattr);
		// console.log(accountattr);
		$("#user_account_attr_mapping_table")
				.append("<tr><td>"
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

	$("#account_btn_add_assignrule").click(function() {
		var mappingrule = $("#account_owner_assign_sel").val();
		$("#mapping_rule_table")
				.append("<tr><td>"
						+ mappingrule
						+ "</td><td><button class='btn btn-primary mappinga_rule_del_btn'>删&nbsp;&nbsp;除</button></td></tr>");
	})

	$(".container").on("click", ".mappinga_rule_del_btn", function() {
				$(this).parent().parent().remove();
			})

})
