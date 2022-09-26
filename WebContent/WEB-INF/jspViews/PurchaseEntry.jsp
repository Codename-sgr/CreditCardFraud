<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/datetimepicker.js"></script>
<title>Purchase Entry</title>
<script type="text/javascript">
	function displayPageElements() {
		if (document.getElementById("category").value == "") {

			document.getElementById("belowTables").style.display = "none";
		} else {

			document.getElementById("belowTables").style.display = "block";
		}
	}
</script>
</head>
<body>
	<div class="container">
		<jsp:include page="include.jsp" />
		<h2 align="center">Material Purchase Entry</h2>
		<!-- Add tables and form tags to get purchase details here -->
		<f:form action="getUnitAndTypeList.html" method="post"
			modelAttribute="purchaseBean">
			<center>
				<c:if test="${not empty error}">
					<div>${error}</div>
				</c:if>

				<table>
					<tr>
						<td>Vendor Name</td>
						<td><f:select path="vendorName">
								<f:option label="--Select--" value="" />
								<f:options items="${vendorList}" />
							</f:select></td>
						<td><f:errors path="vendorName" /></td>
					</tr>

					<tr>
						<td>Material Category</td>
						<td><f:select path="materialCategoryId" onchange="submit()">
								<f:option label="--Select--" value="" />
								<f:options items="${categoryList}" />
							</f:select></td>
						<td><f:errors path="materialCategoryId" /></td>
					</tr>
					</f:form>
					<c:if test="${not empty purchaseBean.materialTypeId}">
						<f:form action="addPurchaseDetail.html" method="POST"
							modelAttribute="purchaseBean">
							<tr>
								<td>Material Type</td>
								<!-- 					materialTypeId -->
								<td><f:select path="materialTypeId">
										<f:option label="--Select--" value="" />
										<f:options items="${materialTypeList}" />
									</f:select></td>
								<td><f:errors path="materialTypeId" /></td>
							</tr>
							<tr>
								<td>Unit</td>
								<td><f:select path="unitId">
										<f:option label="--Select--" value="" />
										<f:options items="${unitBeanList}" />
									</f:select></td>
								<td><f:errors path="unitId" /></td>
							</tr>
							<tr>
								<td>Brand Name</td>
								<td><f:input path="brandname" /></td>
								<td><f:errors path="brandname" /></td>
							</tr>
							<%-- <tr>
							<td>Status</td>
							<td><f:input path="status" /></td>
						</tr> --%>
							<tr>
								<td>Quantity</td>
								<td><f:input path="quantity" /></td>
							</tr>
							<tr>
								<td>Purchase Amount</td>
								<td><f:input path="purchaseAmount" /></td>
							</tr>
							<tr>
								<td>Purchase Date</td>
								<td><f:input path="purchaseDate" /></td>
							</tr>
							<tr>
								<td><f:button value="Submit">Submit Details</f:button></td>
							</tr>

						</f:form>
					</c:if>
				</table>
			</center>
	</div>
	<div class="terms2">
		<p align="center" style="font-family: calibri; color: #6666CC;">Copyright
			© 2021 All Rights Reserved.</p>
	</div>
</body>
</html>