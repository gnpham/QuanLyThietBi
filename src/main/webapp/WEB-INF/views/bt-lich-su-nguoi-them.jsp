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
<link href="css/datepicker.css" rel="stylesheet" />
<script src="js/bootstrap-datepicker.js"></script>
<title></title>
<script type="text/javascript">
	$(function() {
		$('.datepicker').datepicker({
			format : "dd-mm-yyyy"
		}).on('changeDate', function(ev) {
			$(this).datepicker('hide');
		});
	});
</script>
</head>
<body>
	<div class="container">
		<div class="title-1">
			<h3>
				<b>CHUYỂN ĐỔI NGƯỜI QUẢN LÝ THIẾT BỊ</b>
			</h3>
		</div>
		<div class="title-71">
			<form:form method="post" id="form" modelAttribute="formThem"
				action="${pageContext.request.contextPath}/themnguoiquanlyls">
				<!-- 				 1 -->
				<div class='row' hidden>
					<div class='col-sm-10'>
						<div class='form-group'>
							<label for="user_title">Mã lần xuất thiết bị</label> <input
								class="form-control" id="user_title" name="tbXuat.maXuat"
								value="${maXuatThemLSNQL.maXuat}" size="30" readonly="readonly"
								type="text" />
						</div>
					</div>
				</div>
				<div class='row'>
					<div class='col-sm-5'>
						<div class='form-group'>
							<label for="user_title">Tên thiết bị</label> <input
								class="form-control" id="user_title" name=""
								value="${maXuatThemLSNQL.tbChiTietNhapXuat.tenThietBi}"
								size="30" readonly="readonly" type="text" />
						</div>
					</div>
					<div class='col-sm-5'>
						<div class='form-group'>
							<label for="user_firstname">Ngày bàn giao thiết bị</label> <input
								class="form-control datepicker" id="datepicker"
								name="ngayBatDau" required="true" size="30" />
						</div>
					</div>
				</div>
				<div class='row'>
					<div class='col-sm-5'>
						<div class='form-group'>
							<label for="user_title">Tên người quản lý hiện tại</label> <input
								class="form-control" id="user_title" name=""
								value="${maXuatThemLSNQL.tbPhieuXuat.tbNhanVien.hoTen}"
								size="30" readonly="readonly" type="text" />
						</div>
					</div>
					<div class='col-sm-5'>
						<div class='form-group'>
							<label for="user_title">Tên người quản lý mới</label> <select
								name="maNql" class="form-control" id="">
								<c:forEach var="danhsachnguoidung"
									items="${danhsachnguoidung}">
									<option value="${danhsachnguoidung.maNql }">${danhsachnguoidung.hoTen} - Khoa ${danhsachnguoidung.tbDonVi.tenKhoa}</option>
								</c:forEach>
							</select>
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