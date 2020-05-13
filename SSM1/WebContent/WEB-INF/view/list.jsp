<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>展示员工信息</title>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/index_work.css">
</head>
<body>
	<table>
		<tr>
			<th>EID</th>
			<th>ENAME</th>
			<th>AGE</th>
			<th>SEX</th>
			<th>DEPARTMENTNAME</th>
			<th>OPTIONS</th>
		</tr>
		<c:forEach items="${empList}" var="emp">
			<tr>
				<td>${emp.eid}</td>
				<td>${emp.ename}</td>
				<td>${emp.age}</td>
				<td>${emp.sex}</td>
				<td>${emp.dept.dname}</td>
				<td>
					<a href="emp">删除</a>
					<a href="emp">修改</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>