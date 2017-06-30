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
<title>Danh sách phiếu xuất</title>
</head>
<body>
	<div class="form">
		<div class=" row form-group">
			<div class="form-group">
				<div class="col-md-1">
					<div class="input-group stylish-input-group">
						<a href="${pageContext.request.contextPath}/chuyenphieuxuatthem"
							type="button" class="btn btn-primary">Lập phiếu mới</a> </span>
					</div>
				</div>
				<form method="GET"
					action="${pageContext.request.contextPath}/timkiemphieuxuat">
					<div class="col-md-3 col-md-offset-1">
						<select name="muc" class="form-control" placeholder="Gõ từ khóa">
							<option value="maPhieuXuat">Số phiếu</option>
							<option value="nguoiXuat">Người xuất thiết bị</option>
							<option value="tenKho">Xuất từ kho</option>
							<option value="hoTen">Người nhận thiết bị</option>
							<option value="maPth">Nơi nhận thiết bị</option>

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
	<div class="title-12">
		<h3>
			<b>DANH SÁCH PHIẾU XUẤT THIẾT BỊ</b>
		</h3>
	</div>
	<!-- 		   <div style="padding: 1px;"> -->
	<form class="textsize">
		<div class="panel panel-default">
			<table class="table table-bordered">
				<thead>
					<tr style="background-color: #ccccff">
						<!-- 					<th style="width: 15px;">STT</th> -->
						<th style="width: 130px;">Số phiếu</th>
						<th style="width: 110px">Ngày xuất</th>
						<th style="width: 220px">Người xuất thiết bị</th>
						<!-- 						<th style="width: 400px">Xuất từ Kho</th> -->
						<th style="width: 220px">Người nhận thiết bị</th>
						<th style="width: 430px">Đơn vị nhận thiết bị</th>
						<th style="width: 50px">Phòng</th>
						<th style="width: 130px">Tổng giá trị</th>
						<th style="width: 80px">Chi tiết</th>
						<th style="width: 35px">Sửa</th>
						<th style="width: 35px">Xóa</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="danhsach" items="${danhsach}" varStatus="stt">
						<tr>
							<%-- 							<td>${stt.index +1 }</td> --%>
							<td>${danhsach.maPhieuXuat }</td>
							<td>${danhsach.ngayXuat }</td>
							<td>${danhsach.nguoiXuat}</td>
							<%-- 							<td>${danhsach.tbKho.tenKho}</td> --%>
							<td>${danhsach.tbNhanVien.hoTen}</td>
							<td>${danhsach.tbNhanVien.tbPhongThucHanh.phongThucHanh}</td>
							<td>${danhsach.tbNhanVien.tbPhongThucHanh.maPth}</td>
							<td>${danhsach.tongGiaTri} VNĐ</td>
							<td><a
								href="${pageContext.request.contextPath}/phieuxuatchitiet?id=${danhsach.maPhieuXuat}"><span
									class="glyphicon glyphicon-folder-open"></span></a></td>
							<td><a
								href="${pageContext.request.contextPath}/phieuxuatsua?id=${danhsach.maPhieuXuat}"><span
									class="glyphicon glyphicon-pencil"></span></a></td>
							<td><a
								href="${pageContext.request.contextPath}/phieuxuatxoa?id=${danhsach.maPhieuXuat }"><span
									class="glyphicon glyphicon-remove" style="color: red"
									onclick="return confirm('Xác nhận xóa phiếu xuất khỏi danh sách')"></span></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</form>
</body>
</html>