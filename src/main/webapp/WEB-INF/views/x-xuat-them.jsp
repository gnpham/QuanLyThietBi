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
<script src="js/phieuadd.js"></script>
<link rel="stylesheet" href="css/contain-1.css">
<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<title></title>
</head>
<body>
	<div class="container">
		<div class="title-1">
			<h3>
				<b>CHỌN THIẾT BỊ XUẤT</b>
			</h3>
		</div>
		<div class="title-71">
			<form:form method="post" id="form" modelAttribute="formThem"
				onsubmit="return validateForm()"
				action="${pageContext.request.contextPath}/themxuat">
				<!-- 				 1 -->
				<div class='row'>
					<div class='col-sm-10'>
						<div class='form-group'>
							<label for="user_title">Phiếu xuất số</label> <input
								class="form-control" id="user_title"
								name="tbPhieuXuat.maPhieuXuat"
								value="${maPhieuXuatThemXuat.maPhieuXuat }" size="30"
								type="text" readonly="readonly" />
						</div>
					</div>
				</div>
				<!-- 				 2 -->
				<div class='row'>
					<div class='col-sm-10'>
						<div class='form-group'>
							<label for="user_title">Chọn thiết bị từ kho</label> <select
								name="tbChiTietNhapXuat.thietBiId" class="form-control"
								id="thietBiKho">
								<c:forEach var="danhsachthietbi" items="${danhsachthietbi}">
									<option value="${danhsachthietbi.thietBiId }">${danhsachthietbi.tenThietBi}
										- Số lượng ${danhsachthietbi.soLuong}
										(${danhsachthietbi.donViTinh})</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
				<!-- 				 3 -->
				<div class='row'>
					<div class='col-sm-5'>
						<div class='form-group'>
							<label for="user_title">Nhập số lượng thiết bị xuất</label> <input
								placeholder="Số lượng nhập vào nhỏ hơn số lượng hiện có trong kho"
								class="form-control" id="soLuongXuat" name="soLuongXuat"
								size="30" type="text" /> <span id="username_error"></span><br />
							<div class="bg-danger">${loi}</div>
						</div>
					</div>
				</div>
				<!-- 				 3 -->
				<div class='row' style="visibility: hidden;">
					<div class='col-sm-5'>
						<div class='form-group'>
							<label for="user_title">Nhập tình trạng</label> <input
								placeholder="Nhập tình trạng thiết bị"
								class="form-control" id="tinhTrangThietBi" name="tinhTrangThietBi" value="Tốt"
								size="30" type="text" />
						</div>
					</div>
				</div>
				<br>
				<div>
					<div>
						<br />
						<div class="col-md-1 col-md-offset-7">
							<a class="btn btn-danger"
								href="${pageContext.request.contextPath}/danhsachphieuxuat">
								Quay lại</a>
						</div>
						<div class="col-md-1 col-md-offset-1">
							<button class="btn btn-success" type="submit">Lưu thông
								tin</button>
						</div>
					</div>
					<br /> <br />
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>