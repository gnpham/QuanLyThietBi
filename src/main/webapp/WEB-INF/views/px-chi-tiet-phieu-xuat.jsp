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
<title>Thông tin chi tiết phiếu xuất</title>
</head>
<body>

	<div class="container">
		<div class="title-1">
			<h3>
				<b>THÔNG TIN CHI TIẾT PHIẾU XUẤT</b>
			</h3>
		</div>
		<div class="title-7">
			<div>
				<form:form method="POST" id="form" modelAttribute="formHienThi"
					class="textsize-01" action="${pageContext.request.contextPath}/">
					<div class="row">
						<div class="col-xs-12 form-group" id="title-4">Phiếu xuất
							số: ${layMaPhieuXuat.maPhieuXuat }</div>
						<br /> <br />
						<div class="col-xs-6 form-group">
							<label>Ngày xuất: </label> ${layMaPhieuXuat.ngayXuat}
						</div>
						<div class="col-xs-6 form-group">
							<label>Người xuất thiết bị: </label> ${layMaPhieuXuat.nguoiXuat}
						</div>
						<div class="col-xs-6 form-group">
							<label>Xuất từ kho: </label> ${layMaPhieuXuat.tbKho.tenKho }
						</div>
						<div class="col-xs-6 form-group">
							<label>Người nhận thiết bị: </label>
							${layMaPhieuXuat.tbNhanVien.hoTen} - Khoa
							${layMaPhieuXuat.tbNhanVien.tbDonVi.tenKhoa}
						</div>
						<div class="col-xs-6 form-group">
							<label>Xuất về phòng: </label>
							${layMaPhieuXuat.tbNhanVien.tbPhongThucHanh.phongThucHanh}
						</div>
					</div>
				</form:form>
			</div>
			<div class="title-61">
				<h5>
					<b>DANH SÁCH THIẾT BỊ</b>
				</h5>
			</div>
			<form class="textsize">
				<div class="panel panel-default">
					<table class="table table-bordered">
						<thead>
							<tr style="background-color: #F67011">
								<!-- 								<th style="width: 15px;">STT</th> -->
								<th style="width: 75px;">Số phiếu</th>
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
								<th style="width: 55px">Bảo trì</th>
								<th style="width: 35px">Xóa</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="danhsachtbpx" items="${danhsachtbpx}"
								varStatus="stt">
								<tr>
									<%-- 									<td>${stt.index +1 }</td> --%>
									<td>${danhsachtbpx.tbPhieuXuat.maPhieuXuat }</td>
									<td>${danhsachtbpx.tbChiTietNhapXuat.tbDanhMucThietBi.maThietBi}</td>
									<td>${danhsachtbpx.tbChiTietNhapXuat.tenThietBi }</td>
									<td>${danhsachtbpx.tbChiTietNhapXuat.donViTinh }</td>
									<td>${danhsachtbpx.soLuongXuat}</td>
									<%-- 									<td>${danhsachtbpx.tbChiTietNhapXuat.hanBaoHanh}</td> --%>
									<%-- 									<td>${danhsachtbpx.tbChiTietNhapXuat.soHieuTscd }</td> --%>
									<%-- 									<td>${danhsachtbpx.tbChiTietNhapXuat.congXuat}</td> --%>
									<td>${danhsachtbpx.tbChiTietNhapXuat.nguyenGia }</td>
									<%-- 									<td>${danhsachtbpx.tbChiTietNhapXuat.tbNuocSanXuat.nuocSanXuat}</td> --%>
									<%-- 									<td>${danhsach.tbChiTietNhapXuat.moTa}</td> --%>
									<%-- 									<td>${danhsachtbpx.tbChiTietNhapXuat.khauHao}</td> --%>
									<td>${danhsachtbpx.tbChiTietNhapXuat.maCode}</td>
									<td>${danhsachtbpx.tbPhieuXuat.tbNhanVien.hoTen}</td>
									<td><a
										href="${pageContext.request.contextPath}/thietbibaotri?id=${danhsachtbpx.maXuat}"><span
											class="glyphicon glyphicon-wrench"></span></a></td>
									<td><a
										href="${pageContext.request.contextPath}/thietbixuatxoa?id=${danhsachtbpx.maXuat}"><span
											class="glyphicon glyphicon-remove" style="color: red"
											onclick="return confirm('Xác nhận xóa thiết bị khỏi danh sách')"></span></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="col-md-1 col-md-offset-10">
					<div class="input-group stylish-input-group">
						<a
							href="${pageContext.request.contextPath}/chuyenxuatthietbi?id=${layMaPhieuXuat.maPhieuXuat}"
							type="button" class="btn btn-success">Chọn thiết bị xuất</a>
					</div>
				</div>
				<br /> <br />
			</form>
		</div>
	</div>

</body>
</html>