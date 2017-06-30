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
<title></title>
</head>
<body>

	<div class="container">
		<div class="title-1">
			<h3>
				<b>THÔNG TIN CHI TIẾT THIẾT BỊ XUẤT</b>
			</h3>
		</div>
		<div class="title-3">
			<form:form method="POST" id="form" modelAttribute="formHienThi"
				action="${pageContext.request.contextPath}/">
				<div class="row" style="">
					<div class="col-xs-12 form-group" id="title-4">
						${layMaXuat.tbChiTietNhapXuat.tenThietBi }</div>
					<br /> <br />
					<div class="col-xs-6 form-group">
						<label>Ngày xuất: </label> ${layMaXuat.tbPhieuXuat.ngayXuat}
					</div>
					<div class="col-xs-6 form-group">
						<label>Nơi đặt để: </label> Phòng
						${layMaXuat.tbPhieuXuat.tbNhanVien.tbPhongThucHanh.maPth}
					</div>
					<div class="col-xs-6 form-group">
						<label>Mã thiết bị: </label>
						${layMaXuat.tbChiTietNhapXuat.tbDanhMucThietBi.maThietBi}
					</div>
					<div class="col-xs-6 form-group">
						<label>Đơn vị tính: </label>
						${layMaXuat.tbChiTietNhapXuat.donViTinh }
					</div>
					<div class="col-xs-6 form-group">
						<label>Số lượng: </label> ${layMaXuat.soLuongXuat }
					</div>
					<div class="col-xs-6 form-group">
						<label>Hạn bảo hành: </label>
						${layMaXuat.tbChiTietNhapXuat.hanBaoHanh }
					</div>
					<div class="col-xs-6 form-group">
						<label>Số hiệu tài sản cố định:</label>
						${layMaXuat.tbChiTietNhapXuat.soHieuTscd }
					</div>
					<div class="col-xs-6 form-group">
						<label>Công xuất: </label> ${layMaXuat.tbChiTietNhapXuat.congXuat }
					</div>
					<div class="col-xs-6 form-group">
						<label>Nguyên giá: </label>
						${layMaXuat.tbChiTietNhapXuat.nguyenGia }
					</div>
					<div class="col-xs-6 form-group">
						<label>Nước sản xuất: </label>
						${layMaXuat.tbChiTietNhapXuat.tbNuocSanXuat.nuocSanXuat }
					</div>
					<div class="col-xs-6 form-group">
						<label>Mô tả:</label> ${layMaXuat.tbChiTietNhapXuat.moTa }
					</div>
					<div class="col-xs-6 form-group">
						<label>Khấu hao :</label> ${layMaXuat.tbChiTietNhapXuat.khauHao }
						(%)
					</div>
					<div class="col-xs-6 form-group">
						<label>Mã kiểm kê: </label> ${layMaXuat.tbChiTietNhapXuat.maCode }
					</div>
					<div class="col-xs-6 form-group">
						<label>Người quản lý: </label>
						${layMaXuat.tbPhieuXuat.tbNhanVien.hoTen }
					</div>
				</div>
			</form:form>
		</div>
		<div class="title-51">
			<h3>
				<b>LỊCH SỬ NGƯỜI QUẢN LÝ</b>
			</h3>
		</div>
		<!-- 		   <div style="padding: 1px;"> -->
		<form class="textsize">
			<div class="panel panel-default">
				<table class="table table-bordered">
					<thead>
						<tr style="background-color: #F67011">
							<th style="width: 15px;">STT</th>
							<th style="width: 180px;">Tên người quản lý</th>
							<th style="width: 300px;">Ngày nhận thiết bị</th>
							<th style="width: 300px">Ngày bàn giao thiết bị</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="danhsachnqlchitiet" items="${danhsachnqlchitiet}"
							varStatus="stt">
							<tr>
								<td>${stt.index +1 }</td>
								<td>${danhsachnqlchitiet.maNql}</td>
								<td>${danhsachnqlchitiet.ngayBatDau}</td>
								<td>${danhsachnqlchitiet.ngayKetThuc}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<hr />
			<div class="col-md-1 col-md-offset-9">
				<div class="input-group stylish-input-group">
					<a
						href="${pageContext.request.contextPath}/chuyenthemlichsunql?id=${layMaXuat.maXuat}"
						type="button" class="btn btn-success">Thay đổi người quản lý</a>
				</div>
			</div>
		</form>
	</div>
</body>
</html>