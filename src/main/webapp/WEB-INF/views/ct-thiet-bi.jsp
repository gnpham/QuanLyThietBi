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
				<b>THÔNG TIN CHI TIẾT THIẾT BỊ</b>
			</h3>
		</div>
		<div class="title-3">
			<form:form method="POST" id="form" modelAttribute="formHienThi"
				action="${pageContext.request.contextPath}/">
				<div class="row">
					<div class="col-xs-12 form-group" id="title-4">
						${layMaThietBi.tenThietBi }</div>

					<!-- 					<div class="col-xs-6 form-group"> -->
					<%-- 						<label>ID Thiết bị: </label> ${layMaThietBi.thietBiId} --%>
					<!-- 					</div> -->
					<div class="col-xs-6 form-group">
						<label>Mã thiết bị: </label>
						${layMaThietBi.tbDanhMucThietBi.maThietBi}
					</div>
					<div class="col-xs-6 form-group">
						<label>Ngày nhập: </label> ${layMaThietBi.tbPhieuNhap.ngayNhap}
					</div>
					<div class="col-xs-6 form-group">
						<label>Đơn vị tính: </label> ${layMaThietBi.donViTinh }
					</div>
					<div class="col-xs-6 form-group">
						<label>Số lượng: </label> ${layMaThietBi.soLuong }
					</div>
					<div class="col-xs-6 form-group">
						<label>Hạn bảo hành: </label> ${layMaThietBi.hanBaoHanh }
					</div>
					<div class="col-xs-6 form-group">
						<label>Số hiệu tài sản cố định:</label> ${layMaThietBi.soHieuTscd }
					</div>
					<div class="col-xs-6 form-group">
						<label>Công xuất: </label> ${layMaThietBi.congXuat }
					</div>
					<div class="col-xs-6 form-group">
						<label>Nguyên giá: </label> ${layMaThietBi.nguyenGia }
					</div>
					<div class="col-xs-6 form-group">
						<label>Nước sản xuất: </label>
						${layMaThietBi.tbNuocSanXuat.nuocSanXuat }
					</div>
					<div class="col-xs-6 form-group">
						<label>Khấu hao (%) :</label> ${layMaThietBi.khauHao }
					</div>
					<div class="col-xs-6 form-group">
						<label>Mã code: </label> ${layMaThietBi.maCode }
					</div>
					<div class="col-xs-6 form-group">
						<label>Kho thiết bị: </label>
						${layMaThietBi.tbPhieuNhap.tbKho.tenKho}
					</div>
					<div class="col-xs-6 form-group">
						<label>Đặc tính kỹ thuật:</label> ${layMaThietBi.moTa }
					</div>
				</div>
			</form:form>
		</div>
		<div class="title-5">
			<h3>
				<b>DANH MỤC PHỤ TÙNG</b>
			</h3>
		</div>
		<div class="form">
			<div class=" row form-group">
				<div class="form-group">
					<div class="col-md-1">
						<div class="input-group stylish-input-group">
							<a href="${pageContext.request.contextPath}/chuyenthemphutung"
								type="button" class="btn btn-primary">Thêm phụ tùng</a> </span>
						</div>
					</div>
					<form method="GET" action="${pageContext.request.contextPath}/">
						<div class="col-md-2 col-md-offset-1">
							<select name="muc" class="form-control" placeholder="Gõ từ khóa">
								<option value="maThietBi">Mã thiết bị</option>
								<option value="tenThietBi">Tên thiết bị</option>
								<option value="dacTinhKyThuat">Đặc tính kỹ thuật</option>
								<option value="tbDanhMucThietBi.tenChungLoai">Chủng
									loại</option>
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
		<form class="textsize">
			<div class="panel panel-default">
				<table class="table table-bordered">
					<thead>
						<tr style="background-color: #ccccff">
							<!-- 					<th style="width: 15px;">STT</th> -->
							<th style="width: 50px;">Mã</th>
							<!-- 						<th style="width: 95px">Mã thiết bị</th> -->
							<th style="width: 80px">ID thiết bị</th>
							<th style="width: 230px">Tên thiết bị</th>
							<th style="width: 50px;">ĐVT</th>
							<th style="width: 40px">SL</th>
							<th style="width: 80px;">HBH</th>
							<th style="width: 100px">Số hiệu TSCD</th>
							<th style="width: 30px;">CS</th>
							<th style="width: 110px">Nguyên giá</th>
							<th style="width: 100px">Nước SX</th>
							<th style="width: 100px">Khấu hao</th>
							<!-- 							<th style="width: 100px">ĐTKT</th> -->
							<th style="width: 100px">Mã code</th>
							<th style="width: 35px">Sửa</th>
							<th style="width: 35px">Xóa</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="danhsachchitiet" items="${danhsachchitiet}"
							varStatus="stt">
							<tr>
								<td>${stt.index +1 }</td>
								<%-- 								<td>${danhsachchitiet.id }</td> --%>
								<%-- 							<td>${danhsachchitiet.tbChiTietNhapXuat.thietBiId}</td> --%>
								<td>${danhsachchitiet.maThietBi}</td>
								<td>${danhsachchitiet.tenThietBi }</td>
								<td>${danhsachchitiet.donViTinh}</td>
								<td>${danhsachchitiet.soLuong}</td>
								<td>${danhsachchitiet.hanBaoHanh }</td>
								<td>${danhsachchitiet.soHieuTscd}</td>
								<td>${danhsachchitiet.congXuat }</td>
								<td>${danhsachchitiet.nguyenGia }</td>
								<td>${danhsachchitiet.nuocSanXuat}</td>
								<td>${danhsachchitiet.khauHao}</td>
								<%-- 								<td>${danhsachchitiet.dacTinhKyThuat}</td> --%>
								<td>${danhsachchitiet.maCode}</td>
								<td><a
									href="${pageContext.request.contextPath}/thietbiphutungsua?id=${danhsachchitiet.id }"><span
										class="glyphicon glyphicon-pencil"></span></a></td>
								<td><a
									href="${pageContext.request.contextPath}/thietbiphutungxoa?id=${danhsachchitiet.id }"><span
										class="glyphicon glyphicon-remove" style="color: red"
										onclick="return confirm('Xác nhận xóa thiết bị khỏi danh sách')"></span></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<br /> <br />
			<hr />
			<div class="col-md-1 col-md-offset-10">
				<a class="btn btn-danger"
					href="${pageContext.request.contextPath}/danhsachthietbi"> Quay
					lại</a>
			</div>
		</form>
	</div>

</body>
</html>