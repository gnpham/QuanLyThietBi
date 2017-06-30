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
<script src="js/addpage.js"></script>
<link rel="stylesheet" href="css/contain-1.css">
<link rel="stylesheet" href="css/contain.css">
<link rel="stylesheet" href="css/bang_chu.css">
<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<title>Thống kê thiết bị theo phòng thực hành</title>
</head>
<body>
	<div class="title-1">
		<h3>
			<b>DANH SÁCH THIẾT BỊ PHÒNG ${layMaPth.maPth}</b><br />
			(${layMaPth.phongThucHanh})
		</h3>
	</div>
	<div class="form">
		<div class=" row form-group">
			<div class="form-group">
				<form method="GET"
					action="${pageContext.request.contextPath}/danhmuccltimkiem">
					<div class="col-md-3 col-md-offset-0">
						<select name="muc" class="form-control" placeholder="Gõ từ khóa">
							<option value="maChungLoai">Mã phiếu xuất</option>
							<option value="tenChungLoai">Mã thiết bị</option>
							<option value="tbNhomThietBi.tenNhomThietBi">Tên thiết
								bị</option>
							<option value="ghiChu">Mã code</option>
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
	<form class="textsize">
		<div class="panel panel-default">
			<table class="table table-bordered">
				<thead>
					<tr style="background-color: #ccccff">
						<!-- 								<th style="width: 15px;">STT</th> -->
						<th style="width: 75px;">Mã phiếu</th>
						<th style="width: 75px;">Ngày xuất</th>
						<th style="width: 75px">Mã TB</th>
						<th style="width: 300px">Tên thiết bị</th>
						<th style="width: 45px;">ĐVT</th>
						<th style="width: 65px">SL xuất</th>
						<!-- 								<th style="width: 90px;">HBH</th> -->
						<!-- 								<th style="width: 100px">Số hiệu TSCD</th> -->
						<!-- 								<th style="width: 90px;">Công suất</th> -->
						<th style="width: 85px">Nguyên giá</th>
						<!-- 								<th style="width: 75px">Nước SX</th> -->
						<!-- 								<th style="width: 100px">Mô tả</th> -->
						<!-- 								<th style="width: 90px">Khấu hao</th> -->
						<th style="width: 100px">Mã code</th>
						<th style="width: 130px">Người QLTB</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="danhsachtbpth" items="${danhsachtbpth}"
						varStatus="stt">
						<tr>
							<%-- 									<td>${stt.index +1 }</td> --%>
							<td>${danhsachtbpth.tbPhieuXuat.maPhieuXuat }</td>
							<td>${danhsachtbpth.tbPhieuXuat.ngayXuat }</td>
							<td>${danhsachtbpth.tbChiTietNhapXuat.tbDanhMucThietBi.maThietBi}</td>
							<td>${danhsachtbpth.tbChiTietNhapXuat.tenThietBi }</td>
							<td>${danhsachtbpth.tbChiTietNhapXuat.donViTinh }</td>
							<td>${danhsachtbpth.soLuongXuat}</td>
							<%-- 									<td>${danhsachtbpth.tbChiTietNhapXuat.hanBaoHanh}</td> --%>
							<%-- 									<td>${danhsachtbpth.tbChiTietNhapXuat.soHieuTscd }</td> --%>
							<%-- 									<td>${danhsachtbpth.tbChiTietNhapXuat.congXuat}</td> --%>
							<td>${danhsachtbpth.tbChiTietNhapXuat.nguyenGia }</td>
							<%-- 									<td>${danhsachtbpth.tbChiTietNhapXuat.tbNuocSanXuat.nuocSanXuat}</td> --%>
							<%-- 									<td>${danhsach.tbChiTietNhapXuat.moTa}</td> --%>
							<%-- 									<td>${danhsachtbpth.tbChiTietNhapXuat.khauHao}</td> --%>
							<td>${danhsachtbpth.tbChiTietNhapXuat.maCode}</td>
							<td>${danhsachtbpth.tbPhieuXuat.tbNhanVien.hoTen}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</form>
</body>
</html>