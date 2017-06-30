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
<link rel="stylesheet" href="css/bang_chu.css">
<title>Danh sách phiếu nhập</title>
</head>
<body>
	<div class="form">
		<div class=" row form-group">
			<div class="form-group">
				<div class="col-md-1">
					<div class="input-group stylish-input-group">
						<a href="${pageContext.request.contextPath}/chuyenphieunhapthem"
							type="button" class="btn btn-primary">Lập phiếu mới</a> </span>
					</div>
				</div>
				<div class="form-group">
					<form method="GET"
						action="${pageContext.request.contextPath}/timkiemphieunhap">
						<div class="col-md-2 col-md-offset-1">
							<select name="muc" class="form-control" placeholder="Gõ từ khóa">
								<option value="ma">Số phiếu</option>
								<option value="nguoi">Tên người nhập</option>
								<option value="donVi">Đơn vị cung cấp</option>
								<option value="nguonTaiSan">Nguồn gốc tài sản</option>
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
	</div>
	<div class="title-12">
		<h3>
			<b>DANH SÁCH PHIẾU NHẬP THIẾT BỊ</b>
		</h3>
	</div>
	<!-- 		   <div style="padding: 1px;"> -->
	<form class="textsize">
		<div class="panel panel-default">
			<table class="table table-bordered">
				<thead>
					<tr style="background-color: #ccccff">
						<!-- 					<th style="width: 15px;">STT</th> -->
						<th style="width: 80px;">Số phiếu</th>
						<th style="width: 90px">Ngày nhập</th>
						<th style="width: 150px">Người nhập thiết bị</th>
						<th style="width: 190px;">Đơn vị cung cấp</th>
						<th style="width: 250px">Kho chứa</th>
						<th style="width: 190px">Nguồn gốc tài sản</th>
						<th style="width: 120px">Tổng giá trị</th>
						<th style="width: 65px">Chi tiết</th>
						<th style="width: 35px">Sửa</th>
						<th style="width: 35px">Xóa</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="danhsach" items="${danhsach}" varStatus="stt">
						<tr>
							<%-- 							<td>${stt.index +1 }</td> --%>
							<td>${danhsach.maPhieuNhap }</td>
							<td>${danhsach.ngayNhap}</td>
							<td>${danhsach.tbNhanVien.hoTen}</td>
							<td>${danhsach.nguonGoc}</td>
							<td>${danhsach.tbKho.tenKho}</td>
							<td>${danhsach.nguonGocTaiSan}</td>
							<td>${danhsach.tongGiaTri} VNĐ</td>
							<td><a
								href="${pageContext.request.contextPath}/phieunhapchitiet?id=${danhsach.maPhieuNhap }"><span
									class="glyphicon glyphicon-folder-open"></span></a></td>
							<td><a
								href="${pageContext.request.contextPath}/phieunhapsua?id=${danhsach.maPhieuNhap }"><span
									class="glyphicon glyphicon-pencil"></span></a></td>
							<td><a
								href="${pageContext.request.contextPath}/phieunhapxoa?id=${danhsach.maPhieuNhap }"><span
									class="glyphicon glyphicon-remove" style="color: red"
									onclick="return confirm('Xác nhận xóa phiếu nhập khỏi danh sách')"></span></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</form>
</body>
</html>