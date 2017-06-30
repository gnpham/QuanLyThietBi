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
		<div class="title-2">
			<form:form method="POST" id="form" modelAttribute="formSua"
				action="${pageContext.request.contextPath}/danhsachtbsua">
				<div class="row">
					<div class="col-xs-6 form-group">
						<label>ID Thiết bị</label> <input class="form-control"
							readonly="true" name="thietBiId" type="text"
							value="${layMaThietBi.thietBiId}" />
					</div>
					<div class="col-xs-6 form-group">
						<label>Mã thiết bị</label><input class="form-control"
							readonly="true" name="tbDanhMucThietBi.maThietBi" type="text"
							value="${layMaThietBi.tbDanhMucThietBi.maThietBi}" />
					</div>
					<div class="col-xs-6 form-group">
						<label>Tên thiết bị</label><input class="form-control"
							name="tenThietBi" type="text" value="${layMaThietBi.tenThietBi }" />
					</div>

					<div class="col-xs-6 form-group">
						<label>Đơn vị tính</label><input class="form-control"
							name="donViTinh" type="text" value="${layMaThietBi.donViTinh }" />
					</div>
					<div class="col-xs-6 form-group">
						<label>Số lượng</label><input class="form-control" name="soLuong"
							type="text" value="${layMaThietBi.soLuong }" />
					</div>
					<div class="col-xs-6 form-group">
						<label>Hạn bảo hành</label><input class="form-control"
							name="hanBaoHanh" type="text" value="${layMaThietBi.hanBaoHanh }" />
					</div>
					<div class="col-xs-6 form-group">
						<label>Số hiệu tài sản cố định</label><input class="form-control"
							name="soHieuTscd" type="text" value="${layMaThietBi.soHieuTscd }" />
					</div>
					<div class="col-xs-6 form-group">
						<label>Công xuất</label><input class="form-control"
							name="congXuat" type="text" value="${layMaThietBi.congXuat }" />
					</div>
					<div class="col-xs-6 form-group">
						<label>Nguyên giá</label><input class="form-control"
							name="nguyenGia" type="text" value="${layMaThietBi.nguyenGia }" />
					</div>
					<div class="col-xs-6 form-group">
						<label>Nước sản xuất</label> <select
							name="tbNuocSanXuat.maNuocSanXuat" class="form-control">
							<option value="">${layMaThietBi.tbNuocSanXuat.nuocSanXuat }</option>
							<c:forEach var="danhsachnuoc" items="${danhsachnuoc}">
								<option value="${danhsachnuoc.maNuocSanXuat }">${danhsachnuoc.nuocSanXuat }</option>
							</c:forEach>
						</select>
					</div>
					<div class="col-xs-6 form-group">
						<label>Mô tả</label><input class="form-control" name="moTa"
							type="text" value="${layMaThietBi.moTa }" />
					</div>
					<div class="col-xs-6 form-group">
						<label>Khấu hao</label><input class="form-control" name="khauHao"
							type="text" value="${layMaThietBi.khauHao }" />
					</div>
					<div class="col-xs-6 form-group">
						<label>Mã kiểm kê</label><input class="form-control" name="maCode"
							type="maCode" value="${layMaThietBi.maCode }" />
					</div>
				</div>
				<div>
					<div class="col-md-1 col-md-offset-7">
						<a class="btn btn-warning"
							href="${pageContext.request.contextPath}/danhsachthietbi">
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