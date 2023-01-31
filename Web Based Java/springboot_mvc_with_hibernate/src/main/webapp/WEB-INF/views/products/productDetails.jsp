<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table style="background-color: lightgrey; margin: auto;width:auto">
		<caption>Available Products with ${requestScope.keyword }</caption>
		<c:forEach var="product" items="${requestScope.product_list}">
			<tr>
				<td>${product.id}</td>
				<td>${product.productName}</td>
				<td>${product.price}</td>
			</tr>
		</c:forEach>
	</table>


</body>