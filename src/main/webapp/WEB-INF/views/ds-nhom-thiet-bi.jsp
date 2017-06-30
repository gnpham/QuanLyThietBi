<%@page import="org.apache.el.lang.ELSupport"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="css/bootstrap.min.css"></script>
<script src="js/bootstrap-filestyle.min.js"></script>
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/import.js"></script>
<link rel="stylesheet" href="css/importpage.css">
<title>Insert title here</title>
</head>
<body>



	<div class="container">
		<a href="${pageContext.request.contextPath}/them">thêm Khu
			Vực</a> Tìm Kiếm:
		<form method="GET"
			action="${pageContext.request.contextPath}/khuvucsearch">
			<div class="small-3 columns">
				<label>Nhập Tên Tìm Kiếm</label> <input type="text" id="txt"
					name="searchString">
			</div>
			<div class="form-group">
				<label>Mã Khu vực</label> <select name="id" class="input-short">
					<option value="">Tất Cả Khu Vực</option>
					<c:forEach var="listkhuvuc" items="${lists}">
						<option value="${listkhuvuc.MAKV }">${listkhuvuc.tenKV }</option>
					</c:forEach>
				</select>
			</div>

			<div class="small-5 columns end">
				<button id="button-id" type="submit">Search Teams</button>
			</div>


		</form>
		<div style="padding: 40px; margin-top: 10px;">
			<table class="table">
				<thead>
					<tr>
						<th>Số thứ tự</th>
						<th>Mã nhóm thiết bị </th>
						<th>Tên nhóm thiết bị</th>
						<th>Ghi chú</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="list" items="${list}" varStatus="stt">
						<tr>
							<td>${stt.index +1 }</td>
							<td>${list. }</td>
							<td>${list.tenKV }</td>
							<td>${list.matHangKinhDoanh }</td>
							<td>${list.phiCho }</td>
							<td><a
								href="${pageContext.request.contextPath}/khuvucedit?id=${list.MAKV }"
								type="button" class="btn btn-primary">Edit</a> <a
								href="${pageContext.request.contextPath}/khuvucdel?id=${list.MAKV }"
								type="button" onclick="return confirm('ban co muon xoa ko?')"
								class="btn btn-danger">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>

</body>
</html>