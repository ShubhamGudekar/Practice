<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


</head>

<body>
	<div style="margin: auto; background-color: gray; width: 700px;"
		align="center">
		
		<form action="<spring:url value="/department/show"></spring:url>">
			<h4>Select Department</h4>
			
			<select name="deptName">
				<c:forEach var="dept" items="${requestScope.dept_list}">
					<option value="${dept.name}">${dept.name }</option>
				</c:forEach>
			</select> 
			
			<br> 
			<input type="submit" value="Choose" />
		</form>
	</div>
</body>
</html>