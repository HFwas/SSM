<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑员工信息</title>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/index_work.css">
</head>
<body>
	<!--modelAttribute:自定义回显对象的属性名  -->
	<form:form action="${pageContext.servletContext.contextPath }/emp" method="post" modelAttribute="emp">
		
		<c:if test="${empty emp.id }" var="flag"></c:if>
		<c:if test="#{!flag }" >
			<form:hidden path="id"/>
			<input type="hidden" name="_method" value="PUT"/>
		</c:if>
		
		<table>
			<tr>
				<c:if test="${flag }">添加员工信息</c:if>
				<c:if test="${!flag }">编辑员工信息</c:if>
			</tr>
			<tr>
				<td>LASTNAME</td>
				<td>
					<form:input path="lastName"/>
				</td>
			</tr>
			<tr>
				<td>EMAIL</td>
				<td>
					<form:input path="email"/>
				</td>
			</tr>
			<tr>
				<td>GENDER</td>
				<td>
					<form:radiobuttons path="gender" items="${genders }"/>
				</td>
			</tr>
			<tr>
				<td>DEPARTMENT</td>
				<td>
					<%-- <select name="department.id">
						<option>SELECT DEPARTMENT</option>
						<c:forEach items="${departments }" var="dept">
							<option value="${dept.id }">${dept.departmentName }</option>
						</c:forEach>
					</select> --%>
					<form:select path="department.id" items="${depts}" itemLabel="departmentName" itemValue="id"></form:select>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<c:if test="${flag }">
						<input type="submit" value="ADD " />
					</c:if>
					<c:if test="${!flag }">
						<input type="submit" value="UPDATE " />
					</c:if>
				</td>
			</tr>
			
		</table>
	</form:form>
	
	
</body>
</html>