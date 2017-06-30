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
				<b>THÊM PHỤ TÙNG THIẾT BỊ</b>
			</h3>
		</div>
		<div class="title-71">
			<form:form method="post" id="form" modelAttribute="formThem"
				action="${pageContext.request.contextPath}/phutungthem">
				<!-- 				 1 -->
				<div class='row'>
					<div class='col-sm-5'>
						<div class='form-group'>
							<label for="user_title">Phiếu nhập số (*)</label> <input
								class="form-control" id="user_title"
								name="tbPhieuNhap.maPhieuNhap" size="30"
								value="${maPhieuNhapThem.maPhieuNhap}" 
								type="text" />
						</div>
					</div>
					<div class='col-sm-5'>
						<div class='form-group'>
							<label for="user_title">Phiếu xuất số (*)</label> <input
								class="form-control" id="user_title"
								name="tbPhieuNhap.maPhieuNhap" size="30"
								value="${maPhieuNhapThem.maPhieuNhap}"
								type="text" />
						</div>
					</div>
				</div>
				<div class='row'>
					<div class='col-sm-4' hidden>
						<div class='form-group'>
							<label for="user_title">ID Thiết bị</label> <input
								class="form-control" id="user_lastname" name="thietBiId"
								size="30" type="text" />
						</div>
					</div>
					<div class='col-sm-5'>
						<div class='form-group'>
							<label for="user_title">Mã thiết bị (*)</label> <select
								name="tbDanhMucThietBi.maThietBi" class="form-control">
								<c:forEach var="danhmucthietbi" items="${danhmucthietbi}">
									<option value="${danhmucthietbi.maThietBi }">${danhmucthietbi.maThietBi }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class='col-sm-5'>
						<div class='form-group'>
							<label for="user_title">Tên thiết bị</label> <select
								name="tenThietBi" class="form-control">
								<c:forEach var="danhmucthietbi" items="${danhmucthietbi}">
									<option value="${danhmucthietbi.tenThietBi }">${danhmucthietbi.tenThietBi } - ${danhmucthietbi.maThietBi }</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
				<!-- 				 2 -->
				<div class='row'>
					<div class='col-sm-5'>
						<div class='form-group'>
							<label for="user_title">Đơn vị tính</label> <input
								placeholder="Bộ - cái - thanh" class="form-control"
								id="user_title" name="donViTinh" size="30" type="text" />
						</div>
					</div>
					<div class='col-sm-5'>
						<div class='form-group'>
							<label for="user_title">Số lượng</label> <input
								class="form-control" id="user_title" name="soLuong"
								required="true" size="30" type="text" />
						</div>
					</div>
				</div>
				<!-- 				 3 -->
				<div class='row'>
					<div class='col-sm-5'>
						<div class='form-group'>
							<label for="user_title">Số hiệu tài sản cố định</label> <input
								placeholder="Tem" class="form-control" id="user_title"
								name="soHieuTscd" required="true" size="30" type="text" />
						</div>
					</div>
					<div class='col-sm-5'>
						<div class='form-group'>
							<label for="user_title">Công xuất sử dụng</label> <input
								placeholder="Watt" class="form-control" id="user_title"
								name="congXuat" size="30" type="text" />
						</div>
					</div>
				</div>
				<div class='row'>
					<div class='col-sm-5'>
						<div class='form-group'>
							<label for="user_title">Nước sản xuất</label> <select
								name="tbNuocSanXuat.maNuocSanXuat" class="form-control">
								<c:forEach var="danhsachnuoc" items="${danhsachnuoc}">
									<option value="${danhsachnuoc.maNuocSanXuat }">${danhsachnuoc.nuocSanXuat }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class='col-sm-5'>
						<div class='form-group'>
							<label for="user_title">Khấu hao</label> <input
								placeholder="Đơn vị %" class="form-control" id="user_title"
								name="khauHao" required="true" size="30" type="text" />
						</div>
					</div>
				</div>
				<div class='row'>
					<div class='col-sm-5'>
						<div class='form-group'>
							<label for="user_title">Hạn bảo hành</label> <input
								placeholder="Tháng" class="form-control" id="user_title"
								name="hanBaoHanh" size="30" type="text" />
						</div>
					</div>
					<div class='col-sm-5'>
						<div class='form-group'>
							<label for="user_title">Nguyên giá</label> <input
								placeholder="VNĐ" class="form-control" id="user_title"
								name="nguyenGia" required="true" size="30" type="text" />
						</div>
					</div>
				</div>
				<div class='row'>
					<div class='col-sm-5' hidden>
						<div class='form-group'>
							<label for="user_title">Mã Code</label> <input
								placeholder="Mã code có dạng JP2017TBP00001" class="form-control" readonly="readonly"
								id="user_title" name="maCode" size="30"
								type="text" />
						</div>
					</div>
					<div class='col-sm-10'>
						<div class='form-group'>
							<label for="user_title">Đặc tính kỹ thuật</label> <input class="form-control"
								placeholder="Thông số kỹ thuật thiết bị phụ tùng" id="user_title"
								name="moTa" size="30" type="text" />
						</div>
					</div>
				</div>
				<br>
				<div>
					<div class="col-md-1 col-md-offset-10">
						<button class="btn btn-success" type="submit">Lưu thông
							tin</button>
					</div>
					<br /> <br />
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>