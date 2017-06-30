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
<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<title></title>
</head>
<body>

	<div class="container">
		<div class="title-1">
			<h3>
				<b>SỬA THÔNG TIN NGƯỜI DÙNG</b>
			</h3>
		</div>
		<div class="title-2">
			<form:form method="POST" id="form" modelAttribute="formSua"
				action="${pageContext.request.contextPath}/nhanvienxacnhansua">
				<div class="row">
					<div class="col-xs-6 form-group" hidden="true">
						<label>Mã người dùng</label> <input class="form-control"
							name="maNql" type="text" value="${layMaNhanVien.maNql}" />
					</div>
					<div class="col-xs-6 form-group">
						<label>Họ tên</label><input class="form-control" name="hoTen"
							readonly="readonly" type="text" value="${layMaNhanVien.hoTen }" />
					</div>
					<div class="col-xs-6 form-group">
						<label>Giới tính</label><input class="form-control"
							readonly="readonly" name="gioiTinh" type="text"
							value="${layMaNhanVien.gioiTinh }" />
					</div>

					<div class="col-xs-6 form-group">
						<label>Địa chỉ</label><input class="form-control" name="diaChi"
							type="text" value="${layMaNhanVien.diaChi }" />
					</div>
					<div class="col-xs-6 form-group">
						<label>Số điện thoại</label><input class="form-control"
							name="soDienThoai" type="text"
							value="${layMaNhanVien.soDienThoai }" />
					</div>
					<div class="col-xs-6 form-group">
						<label>Email</label><input class="form-control" name="email"
							type="text" value="${layMaNhanVien.email }" />
					</div>
					<div class="col-xs-6 form-group">
						<label>Chức vụ</label><input class="form-control" name="chucVu"
							type="text" value="${layMaNhanVien.chucVu }" />
					</div>
					<div class="col-xs-6 form-group">
						<label>Tên đăng nhập</label><input class="form-control"
							name="tenDangNhap" type="text"
							value="${layMaNhanVien.tenDangNhap }" />
					</div>
					<div class="col-xs-6 form-group">
						<label>Mật khẩu</label><input class="form-control" name="matKhau"
							type="password" value="${layMaNhanVien.matKhau }" />
					</div>
					<div class="col-xs-6 form-group">
						<label>Quyền truy cập</label><select class="form-control"
							name="tbQuyenTruyCap.maQuyen" type="text">
							<option value="${layMaNhanVien.tbQuyenTruyCap.maQuyen }">${layMaNhanVien.tbQuyenTruyCap.quyen }</option>
							<c:forEach var="danhsachquyen" items="${danhsachquyen}">
								<option value="${danhsachquyen.maQuyen }">${danhsachquyen.quyen }</option>
							</c:forEach>
						</select>
					</div>
					<div class="col-xs-6 form-group">
						<label>Phòng thực hành</label><select class="form-control"
							name="tbPhongThucHanh.maPth" type="text">
							<option value="${layMaNhanVien.tbPhongThucHanh.maPth }">${layMaNhanVien.tbPhongThucHanh.phongThucHanh }</option>
							<c:forEach var="danhsachpth" items="${danhsachpth}">
								<option value="${danhsachpth.maPth }">${danhsachpth.phongThucHanh }</option>
							</c:forEach>
						</select>
					</div>
					<div class="col-xs-6 form-group">
						<label>Phòng ban</label><select class="form-control"
							name="tbPhongBan.maPhongBan" type="text">
							<option value="${layMaNhanVien.tbPhongBan.maPhongBan }">${layMaNhanVien.tbPhongBan.tenPhongBan }</option>
							<c:forEach var="danhsachpb" items="${danhsachpb}">
								<option value="${danhsachpb.maPhongBan }">${danhsachpb.tenPhongBan }</option>
							</c:forEach>
						</select>
					</div>
					<div class="col-xs-6 form-group">
						<label>Đơn vi công tác</label><select class="form-control"
							name="tbDonVi.maKhoa" type="text">
							<option value="${layMaNhanVien.tbDonVi.maKhoa }">${layMaNhanVien.tbDonVi.tenKhoa }</option>
							<c:forEach var="danhsachdv" items="${danhsachdv}">
								<option value="${danhsachdv.maKhoa }">${danhsachdv.tenKhoa }</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<hr />
				<br />
				<div>
					<div class="col-md-1 col-md-offset-8">
						<a class="btn btn-danger"
							href="${pageContext.request.contextPath}/danhsachnhanvien">
							Quay lại</a>
					</div>
					<div class="col-md-1 col-md-offset-1">
						<button class="btn btn-success" type="submit">Lưu thông
							tin</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>

</body>
</html>