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
<link rel="stylesheet" href="css/contain.css">
<link rel="stylesheet" href="css/contain-1.css">
<title>Danh mục chủng loại</title>
</head>
<body>
	<div class="form">
		<div class=" row form-group">
			<div class="form-group">
				<div class="col-md-1">
					<div class="input-group stylish-input-group">
						<a href="${pageContext.request.contextPath}/chuyenphongbanthem"
							type="button" class="btn btn-primary">Thêm phòng ban</a> </span>
					</div>
				</div>
				<form method="GET"
					action="${pageContext.request.contextPath}/danhmucphongbantimkiem">
					<div class="col-md-3 col-md-offset-2">
						<select name="muc" class="form-control" placeholder="Gõ từ khóa">
							<option value="maPhongBan">Mã phòng ban</option>
							<option value="tenPhongBan">Phòng ban</option>
							<option value="soDienThoai">Số điện thoại</option>
						</select>
					</div>
					<div class="col-md-offset-1 col-sm-4 input-group">
						<input type="text" class="form-control" placeholder="Gõ từ khóa"
							name="chuoiTimKiem"> <span class="input-group-btn">
							<button class="btn " type="submit">
								<span class="glyphicon glyphicon-search"></span>Tìm kiếm
							</button>
						</span>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- 		   <div style="padding: 1px;"> -->
	<form>
		<div class="panel panel-default">
			<table class="table table-bordered">
				<!-- 			table-striped -->
				<thead>
					<tr style="background-color: #ccccff">
						<th style="width: 100px;">Mã phòng ban</th>
						<th style="width: 430px;">Phòng ban</th>
						<th style="width: 430px;">Số điện thoại</th>
						<th style="width: 35px">Sửa</th>
						<th style="width: 35px">Xóa</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="danhsach" items="${danhsach}" varStatus="stt">
						<tr>
							<td>${stt.index +1 }</td>
							<%-- 							<td>${danhsach.maPhongBan }</td> --%>
							<td>${danhsach.tenPhongBan}</td>
							<td>${danhsach.soDienThoai }</td>
							<td><a
								href="${pageContext.request.contextPath}/maphongbansua?id=${danhsach.maPhongBan }"><span
									class="glyphicon glyphicon-pencil"></span></a></td>
							<td><a
								href="${pageContext.request.contextPath}/maphongbanxoa?id=${danhsach.maPhongBan }"><span
									class="glyphicon glyphicon-remove" style="color: red"
									onclick="return confirm('Xác nhận xóa phòng ban khỏi danh sách')"></span></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</form>
</body>
</html>