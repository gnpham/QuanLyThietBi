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
<link rel="stylesheet" href="css/bang_chu.css">
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="css/bootstrap.min.css"></script>
<script src="js/bootstrap-filestyle.min.js"></script>
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/import.js"></script>
<link rel="stylesheet" href="css/contain.css">
<link rel="stylesheet" href="css/contain-1.css">
<title>Danh sách thiết bị đã xuất</title>
</head>
<body>
	<div class="form">
		<div class=" row form-group">
			<div class="form-group">
				<form method="GET"
					action="${pageContext.request.contextPath}/baotritimkiem">
					<div class="col-md-2 col-md-offset-0">
						<select name="muc" class="form-control" placeholder="Gõ từ khóa">
							<option value="maPth">Nơi đặt</option>
							<option value="maPhieuXuat">Mã phiếu xuất</option>
							<option value="maThietBi">Mã thiết bị</option>
							<option value="tenThietBi">Tên thiết bị</option>
							<option value="maCode">Mã code</option>
							<option value="hoTen">Người quản lý</option>
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
			<b>DANH SÁCH THIẾT BỊ ĐÃ XUẤT</b>
		</h3>
	</div>
	<!-- 		   <div style="padding: 1px;"> -->
	<form class="textsize">
		<div class="panel panel-default">
			<table class="table table-bordered">
				<thead>
					<tr style="background-color: #ccccff">
						<!-- 								<th style="width: 15px;">STT</th> -->
						<th style="width: 65px;">Mã PX</th>
						<th style="width: 80px;">Ngày xuất</th>
						<th style="width: 75px">Mã TB</th>
						<th style="width: 290px">Tên thiết bị</th>
						<!-- 						<th style="width: 45px;">ĐVT</th> -->
						<th style="width: 15px">SL</th>
						<th style="width: 80px">Nguyên giá</th>
						<th style="width: 80px">Tình trạng</th>
						<!-- 								<th style="width: 90px;">HBH</th> -->
						<!-- 								<th style="width: 100px">Số hiệu TSCD</th> -->
						<!-- 								<th style="width: 90px;">Công suất</th> -->
						<!-- 								<th style="width: 75px">Nước SX</th> -->
						<!-- 								<th style="width: 100px">Mô tả</th> -->
						<!-- 								<th style="width: 90px">Khấu hao</th> -->
						<th style="width: 100px">Mã code</th>
						<th style="width: 130px">Người QLTB</th>
						<th style="width: 60px">Nơi đặt</th>
						<th style="width: px">BT</th>
						<th style="width: px">Xóa</th>
						<!-- 						<th>Xóa</th> -->
					</tr>
				</thead>
				<tbody>
					<c:forEach var="danhsach" items="${danhsach}" varStatus="stt">
						<tr>
							<%-- 									<td>${stt.index +1 }</td> --%>
							<td>${danhsach.tbPhieuXuat.maPhieuXuat }</td>
							<td>${danhsach.tbPhieuXuat.ngayXuat }</td>
							<td>${danhsach.tbChiTietNhapXuat.tbDanhMucThietBi.maThietBi}</td>
							<td>${danhsach.tbChiTietNhapXuat.tenThietBi }</td>
							<%-- 							<td>${danhsach.tbChiTietNhapXuat.donViTinh }</td> --%>
							<td>${danhsach.soLuongXuat}</td>
							<td>${danhsach.tbChiTietNhapXuat.nguyenGia }</td>
							<td>${danhsach.tinhTrangThietBi}</td>
							<%-- 									<td>${danhsach.tbChiTietNhapXuat.hanBaoHanh}</td> --%>
							<%-- 									<td>${danhsach.tbChiTietNhapXuat.soHieuTscd }</td> --%>
							<%-- 									<td>${danhsach.tbChiTietNhapXuat.congXuat}</td> --%>
							<%-- 									<td>${danhsach.tbChiTietNhapXuat.tbNuocSanXuat.nuocSanXuat}</td> --%>
							<%-- 									<td>${danhsach.tbChiTietNhapXuat.moTa}</td> --%>
							<%-- 									<td>${danhsach.tbChiTietNhapXuat.khauHao}</td> --%>
							<td>${danhsach.tbChiTietNhapXuat.maCode}</td>
							<td>${danhsach.tbPhieuXuat.tbNhanVien.hoTen}</td>
							<td>${danhsach.tbPhieuXuat.tbNhanVien.tbPhongThucHanh.maPth}</td>
							<td><a
								href="${pageContext.request.contextPath}/thietbibaotrils?id=${danhsach.maXuat}"><span
									class="glyphicon glyphicon-wrench"></span></a></td>
							<!-- 							<td><a -->
							<%-- 								href="${pageContext.request.contextPath}/thietbinguoiquanlyls?id=${danhsach.maXuat}"><span --%>
							<!-- 									class="glyphicon glyphicon-user" style="color: green"></span></a></td> -->
							<td><a
								href="${pageContext.request.contextPath}/thietbixuatxoa?id=${danhsach.maXuat}"><span
									class="glyphicon glyphicon-remove" style="color: red"
									onclick="return confirm('Xác nhận xóa thiết bị đã xuất khỏi danh sách')"></span></a></td>
							<!-- 							<td><a -->
							<%-- 								href="${pageContext.request.contextPath}/thietbixuatxoa?id=${danhsach.maXuat}"><span --%>
							<!-- 									class="glyphicon glyphicon-remove" style="color: red" -->
							<!-- 									onclick="return confirm('Xác nhận xóa thiết bị khỏi danh sách')"></span></a></td> -->
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</form>
</body>
</html>