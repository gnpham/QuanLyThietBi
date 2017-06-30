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
				<b>THÔNG TIN CHI TIẾT NHÂN VIÊN</b>
			</h3>
		</div>
		<div class="title-7">
			<div>
				<form:form method="POST" id="form" modelAttribute="formHienThi"
					class="textsize-01" action="${pageContext.request.contextPath}/">
					<div class="row">
						<div class="col-xs-12 form-group" id="title-4">Phiếu nhập
							số: ${layMaPhieuNhap.maPhieuNhap }</div>
						<br /> <br />
						<div class="col-xs-6 form-group">
							<label>Ngày nhập: </label> ${layMaPhieuNhap.ngayNhap}
						</div>
						<div class="col-xs-6 form-group">
							<label>Người lập phiếu: </label>
							${layMaPhieuNhap.tbNhanVien.hoTen}
						</div>
						<div class="col-xs-6 form-group">
							<label>Đơn vị cung cấp: </label> ${layMaPhieuNhap.nguonGoc }
						</div>
						<div class="col-xs-6 form-group">
							<label>Họ tên người giao: </label> ${layMaPhieuNhap.nguoiGiao}
						</div>
						<div class="col-xs-6 form-group">
							<label>Kho chứa: </label> ${layMaPhieuNhap.tbKho.tenKho }
						</div>
						<div class="col-xs-6 form-group">
							<label>Thủ kho thiết bị: </label> ${layMaPhieuNhap.tbKho.thuKho }
						</div>
						<div class="col-xs-6 form-group">
							<label>Nguồn gốc tài sản: </label>
							${layMaPhieuNhap.nguonGocTaiSan }
						</div>
						<div class="col-xs-6 form-group">
							<label>Tổng giá trị:</label> ${layMaPhieuNhap.nguyenGia }
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
								<!-- 					<th style="width: 15px;">STT</th> -->
								<th style="width: 80px;">Mã phiếu</th>
								<th style="width: 80px">Mã TB</th>
								<th style="width: 300px">Tên thiết bị</th>
								<th style="width: 50px;">ĐVT</th>
								<th style="width: 80px">Số lượng</th>
								<!-- 						<th style="width: 90px;">HBH</th> -->
								<!-- 						<th style="width: 100px">Số hiệu TSCD</th> -->
								<!-- 						<th style="width: 90px;">Công suất</th> -->
								<th style="width: 90px">Nguyên giá</th>
								<th style="width: 80px">Nước SX</th>
								<!-- 						<th style="width: 100px">Mô tả</th> -->
								<th style="width: 90px">Khấu hao</th>
								<th style="width: 100px">Mã code</th>
								<th style="width: 35px">Sửa</th>
								<th style="width: 35px">Xóa</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="danhsachtbpn" items="${danhsachtbpn}"
								varStatus="stt">
								<tr>
									<%-- 							<td>${stt.index +1 }</td> --%>
									<td>${danhsachtbpn.tbPhieuNhap.maPhieuNhap }</td>
									<td>${danhsachtbpn.tbDanhMucThietBi.maThietBi}</td>
									<td>${danhsachtbpn.tenThietBi }</td>
									<td>${danhsachtbpn.donViTinh }</td>
									<td>${danhsachtbpn.soLuong}</td>
									<%-- 							<td>${danhsachtbpn.hanBaoHanh}</td> --%>
									<%-- 							<td>${danhsachtbpn.soHieuTscd }</td> --%>
									<%-- 							<td>${danhsachtbpn.congXuat}</td> --%>
									<td>${danhsachtbpn.nguyenGia }</td>
									<td>${danhsachtbpn.tbNuocSanXuat.nuocSanXuat }</td>
									<%-- 							<td>${danhsach.moTa}</td> --%>
									<td>${danhsachtbpn.khauHao}</td>
									<td>${danhsachtbpn.maCode}</td>
									<td><a
										href="${pageContext.request.contextPath}/thietbisua?id=${danhsachtbpn.thietBiId }"><span
											class="glyphicon glyphicon-pencil"></span></a></td>
									<td><a
										href="${pageContext.request.contextPath}/thietbixoa?id=${danhsachtbpn.thietBiId }"><span
											class="glyphicon glyphicon-remove" style="color: red"
											onclick="return confirm('Xác nhận xóa thiết bị khỏi danh sách')"></span></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="col-md-1 col-md-offset-10">
					<div class="input-group stylish-input-group">
						<a href="${pageContext.request.contextPath}/chuyennhapthietbi"
							type="button" class="btn btn-success">Nhập thiết bị</a>
					</div>
				</div>
				<br />
				<br />
			</form>
		</div>
	</div>

</body>
</html>