<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="<%=basePath%>css/pintuer.css">
<link rel="stylesheet" href="<%=basePath%>css/admin.css">
<script src="<%=basePath%>js/jquery.js"></script>
<script src="<%=basePath%>js/pintuer.js"></script>
<script>
	$(function() {
		var array = new Array();
		<c:forEach items="${ids}" var="item" >
		array.push("${item}"); //对象，加引号       
		</c:forEach>
		for (var i = 0; i < array.length; i++) {
			$("#" + array[i]).attr("checked", "checked");
		}
	})
</script>
</head>
<body>
	<form method="post" action="<%=basePath%>permissionsController/FPPermissions.do">
		<input type="hidden" name="roleIdStr" value="${role_db.roleId }">
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong class="icon-reorder"> 分配权限:&nbsp;<font color="red">${role_db.roleName }</font>&nbsp;&nbsp;${message }
				</strong>
			</div>
			<div class="body-content">
				<c:forEach items="${permissions_dbList }" var="permissions">
					<div class="field">
						<input type="checkbox" id="${permissions.permissionsId }" name="permissionsIdStrs"
							value="${permissions.permissionsId }" >${permissions.permissionsName }
						<div class="tips"></div>
					</div>
				</c:forEach>	
			</div>
		</div>

		<div class="form-group">
			<div class="label">
				<label></label>
			</div>
			<div class="field">
				<input type="submit" value="提交"
					class="button bg-main icon-check-square-o">
			</div>
		</div>
	</form>
	<script type="text/javascript">
		function del(id) {
			if (confirm("您确定要删除吗?")) {

			}
		}

		$("#checkall").click(function() {
			$("input[name='id[]']").each(function() {
				if (this.checked) {
					this.checked = false;
				} else {
					this.checked = true;
				}
			});
		})

		function DelSelect() {
			var Checkbox = false;
			$("input[name='id[]']").each(function() {
				if (this.checked == true) {
					Checkbox = true;
				}
			});
			if (Checkbox) {
				var t = confirm("您确认要删除选中的内容吗？");
				if (t == false)
					return false;
			} else {
				alert("请选择您要删除的内容!");
				return false;
			}
		}
	</script>
</body>
</html>