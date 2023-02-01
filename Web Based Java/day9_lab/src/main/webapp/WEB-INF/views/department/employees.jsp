<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table,td,tr {
	border: solid 1px;
	text-align: center;
}
</style>

</head>

<body>
	<div style="margin: auto; background-color: silver; width: 700px;"
		align="center">

		<form action="<spring:url value="/"></spring:url>">
			<h4>List of all Employee in ${requestScope.dept} department</h4>

			<table>
				<tr>
					<td>id</td>
					<td>name</td>
					<td>address</td>
					<td>salary</td>
					<td>joindate</td>
				</tr>

				<c:forEach var="emp" items="${requestScope.emp_list}">
					<tr>
						<td>${emp.id}</td>
						<td>${emp.name}</td>
						<td>${emp.address}</td>
						<td>${emp.salary}</td>
						<td>${emp.joinDate}</td>
						<td><a
							href="<spring:url value="/employees/update/${emp.id}">
						</spring:url>">Update</a></td>
						<td><a
							href="<spring:url value="/employees/delete/${emp.id}">
						</spring:url>">Delete</a></td>
					</tr>
				</c:forEach>
			</table>

			<br> <input type="submit" value="Home" />
		</form>
	</div>
</body>
</html>