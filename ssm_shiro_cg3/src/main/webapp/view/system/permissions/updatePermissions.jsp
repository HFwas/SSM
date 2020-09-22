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
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head" id="add">
			<strong><span class="icon-pencil-square-o"></span>增加内容</strong>
		</div>
		<div class="body-content">
			<form method="post" class="form-x"
				action="<%=basePath%>permissionsController/update.do">
				<input type="hidden" name="permissionsId"
					value="${permissions_db.permissionsId }">
				<div class="form-group">
					<div class="label">
						<label>父级节点：</label>
					</div>
					<div class="field">
						<select id="pId" name="pId">
							<option>------请选择父级节点------</option>
							<c:forEach items="${permissions_dbList }" var="permissions">
								<c:if test="${permissions.permissionsId == permissions_db.pId }"
									var="anth">
									<option value="${permissions.permissionsId}"
										selected="selected">${permissions.permissionsName}</option>
								</c:if>
								<c:if test="${permissions.permissionsId != permissions_db.pId }"
									var="anth">
									<option value="${permissions.permissionsId}">${permissions.permissionsName}</option>
								</c:if>
							</c:forEach>
						</select>



					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>菜单名称：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50"
							value="${permissions_db.permissionsName }" name="permissionsName"
							data-validate="required:请输入角色名称" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>菜单描述：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50"
							value="${permissions_db.permissionsDesc }" name="permissionsDesc"
							data-validate="required:请输入描述" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>菜单URL：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50"
							value="${permissions_db.permissionsUrl }" name="permissionsUrl"
							data-validate="required:请输入状态" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>权限码：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50"
							value="${permissions_db.percode }" name="percode"
							data-validate="required:请输入状态" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>权限类型：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50"
							value="${permissions_db.type }" name="type"
							data-validate="required:请输入状态" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
						<button class="button bg-main icon-check-square-o" type="submit">
							提交</button>
					</div>
				</div>
			</form>
		</div>
	</div>

</body>
</html>