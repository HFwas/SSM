<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>展示员工信息</title>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/index_work.css">
</head>
<body>
	<table>
		<tr>
			<th>ID</th>
			<th>LASTNAME</th>
			<th>EMAIL</th>
			<th>GENDER</th>
			<th>DEPARTMENTNAME</th>
			<th>OPYION(<a href="emp">ADD</a>)</th>
		</tr>
		<c:forEach items="${emps}" var="emp">
			<tr>
				<td>${emp.id}</td>
				<td>${emp.lastName}</td>
				<td>${emp.email }</td>
				<td>${emp.gender==0?'女':'男' }</td>
				<td>${emp.department.departmentName }</td>
				<td>
					<a href="emp/${emp.id }">Update</a>
					<a href="emp">Delete</a>
				</td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>