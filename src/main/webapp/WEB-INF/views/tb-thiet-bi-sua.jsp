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
				<b>SỬA THÔNG TIN THIẾT BỊ</b>
			</h3>
		</div>
		<div class="title-71">
			<form:form method="POST" id="form" modelAttribute="formSua"
				action="${pageContext.request.contextPath}/danhsachtbsua">
				<div class='row'>
					<div class='col-sm-5'>
						<div class='form-group'>
							<label for="user_title">ID Thiết bị</label> <input
								class="form-control" id="user_lastname" name="thietBiId"
								readonly="true" size="30" type="text"
								value="${layMaThietBi.thietBiId}" />
						</div>
					</div>
					<div class='col-sm-5'>
						<div class='form-group'>
							<label for="user_title">Số phiếu</label> <input
								class="form-control" id="user_title" readonly="true"
								name="tbPhieuNhap.maPhieuNhap" size="30" type="text"
								value="${layMaThietBi.tbPhieuNhap.maPhieuNhap }" />
						</div>
					</div>
				</div>
				<div class='row'>
					<div class='col-sm-5'>
						<div class='form-group'>
							<label for="user_title">Mã thiết bị</label><input
								class="form-control" id="user_title" readonly="true"
								name="tbDanhMucThietBi.maThietBi" size="30" type="text"
								value="${layMaThietBi.tbDanhMucThietBi.maThietBi}" />
						</div>
					</div>
					<div class='col-sm-5'>
						<div class='form-group'>
							<label for="user_title">Tên thiết bị</label><input
								class="form-control" id="user_title" readonly="true"
								name="tenThietBi" size="30" type="text"
								value="${layMaThietBi.tenThietBi}" />
						</div>
					</div>
				</div>
				<div class='row'>
					<div class='col-sm-5'>
						<div class='form-group'>
							<label for="user_title">Đơn vị tính</label> <input
								placeholder="Bộ - cái - thanh" class="form-control"
								id="user_title" name="donViTinh" size="30" type="text"
								value="${layMaThietBi.donViTinh }" />
						</div>
					</div>
					<div class='col-sm-5'>
						<div class='form-group'>
							<label for="user_title">Số lượng</label> <input
								class="form-control" id="user_title" name="soLuong" size="30"
								type="text" value="${layMaThietBi.soLuong }" />
						</div>
					</div>
				</div>
				<!-- 				 3 -->
				<div class='row'>
					<div class='col-sm-5'>
						<div class='form-group'>
							<label for="user_title">Số hiệu tài sản cố định</label> <input
								placeholder="Tem" class="form-control" id="user_title"
								name="soHieuTscd" size="30" type="text"
								value="${layMaThietBi.soHieuTscd }" />
						</div>
					</div>
					<div class='col-sm-5'>
						<div class='form-group'>
							<label for="user_title">Công xuất</label> <input
								placeholder="Watt" class="form-control" id="user_title"
								name="congXuat" size="30" type="text"
								value="${layMaThietBi.congXuat }" />
						</div>
					</div>
				</div>
				<div class='row'>
					<div class='col-sm-5'>
						<div class='form-group'>
							<label for="user_title">Nước sản xuất</label> <select
								name="tbNuocSanXuat.maNuocSanXuat" class="form-control">
								<c:forEach var="danhsachnuoc" items="${danhsachnuoc}">
									<option value="${layMaThietBi.tbNuocSanXuat.maNuocSanXuat }">${danhsachnuoc.nuocSanXuat }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class='col-sm-5'>
						<div class='form-group'>
							<label for="user_title">Khấu hao</label> <input
								placeholder="Đơn vị %" class="form-control" id="user_title"
								name="khauHao" size="30" type="text"
								value="${layMaThietBi.khauHao }" />
						</div>
					</div>
				</div>
				<div class='row'>
					<div class='col-sm-5'>
						<div class='form-group'>
							<label for="user_title">Hạn bảo hành</label> <input
								placeholder="Tháng" class="form-control" id="user_title"
								name="hanBaoHanh" size="30" type="text"
								value="${layMaThietBi.hanBaoHanh }" />
						</div>
					</div>
					<div class='col-sm-5'>
						<div class='form-group'>
							<label for="user_title">Nguyên giá</label> <input
								placeholder="VNĐ" class="form-control" id="user_title"
								name="nguyenGia" size="30" type="text"
								value="${layMaThietBi.nguyenGia }" />
						</div>
					</div>
				</div>
				<div class='row'>
					<div class='col-sm-5'>
						<div class='form-group'>
							<label for="user_title">Mô tả</label> <input class="form-control"
								id="user_title" name="moTa" size="30" type="text"
								value="${layMaThietBi.moTa }" />
						</div>
					</div>
					<div class='col-sm-5'>
						<div class='form-group'>
							<label for="user_title">Mã Code</label> <input
								class="form-control" id="user_title" name="maCode" size="30"
								type="text" type="text" value="${layMaThietBi.maCode }" />
						</div>
					</div>
				</div>
				<div>
					<br />
					<div class="col-md-1 col-md-offset-7">
						<a class="btn btn-danger"
							href="${pageContext.request.contextPath}/danhsachthietbi">
							Quay lại</a>
					</div>
					<div class="col-md-1 col-md-offset-1">
						<button class="btn btn-success" type="submit">Lưu thông
							tin</button>
					</div>
				</div>
				<br />
				<br />
			</form:form>
		</div>
	</div>

</body>
</html>