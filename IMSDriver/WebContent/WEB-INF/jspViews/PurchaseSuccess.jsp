<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<jsp:include page="include.jsp" />
		<h2 align="center">Material Purchase Details</h2>
	</div>
	<!-- Display purchase details in table along with purchase id. -->
	<table align="center">
		<tr>
			<td><b>Vendor Name</b></td>
			<td>${bean.vendorName}</td>
		</tr>
		<tr>
			<td><b>Material Category</b></td>
			<td>${bean.materialCategoryName}</td>
		</tr>
		<tr>
			<td><b>Material Type</b></td>
			<td>${bean.materialTypeName}</td>
		</tr>
		<tr>
			<td><b>Unit</b></td>
			<td>${bean.unitName}</td>
		</tr>
		<tr>
			<td><b>Brand Name</b></td>
			<td>${bean.brandname}</td>
		</tr>
		<tr>
			<td><b>Quantity</b></td>
			<td>${bean.quantity}</td>
		</tr>
		<tr>
			<td><b>Purchase Amount</b></td>
			<td>${bean.purchaseAmount}</td>
		</tr>
		<tr>
			<td><b>Purchase Date</b></td>
			<td>${bean.purchaseDate}</td>
		</tr>
		<tr>
			<td><b>Transaction ID</b></td>
			<td>${bean.transactionId}</td>
		</tr>
	</table>
	

	<div class="terms1">
		<p align="center" style="font-family: calibri; color: #6666CC;">Copyright
			© 2021 All Rights Reserved.</p>
	</div>
</body>
</html>