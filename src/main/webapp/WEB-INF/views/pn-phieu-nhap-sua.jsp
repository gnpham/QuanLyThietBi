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
<link rel="stylesheet" href="css/contain-1.css">

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap-filestyle.min.js"></script>
<script src="js/jquery.dataTables.min.js"></script>

<script src="js/import.js"></script>
<script src="js/phieuadd.js"></script>
<title>Sửa thông tin phiếu nhập</title>

<link href="css/datepicker.css" rel="stylesheet" />
<script src="js/bootstrap-datepicker.js"></script>
<script type="text/javascript">
$(function () {
	  $('.datepicker').datepicker({ format: "dd-mm-yyyy" }).on('changeDate', function (ev) {
	    $(this).datepicker('hide');
	  });
	});
</script>
</head>
<body>

	<div class="container">
		<div class="title-01">
			<div class="row">
				<div class="col-xs-12" id="title-41">
					<h3>
						<b>TRƯỜNG CAO ĐẲNG NGHỀ ĐÀ NẴNG</b>
					</h3>
				</div>
				<br />
				<div class="col-xs-12">
					<label>Địa chỉ:</label> <i style="color:#4B6C9E">99 Tô Hiến Thành, P. Phước Mỹ, Q.
						Sơn Trà, TP. Đà Nẵng </i>
				</div>
				<div class="col-xs-12">
					<label>Điện thoại:</label><i style="color:#4B6C9E"> 02363.942.790 – 02363.940.946</i>
				</div>
				<div class="col-xs-12">
					<label>Mã số thuế:</label><b style="color: red"> 0304785896</b>
				</div>
			</div>
		</div>
		<div class="title-7">
			<div class="title-62">
				<b>SỬA THÔNG TIN PHIẾU NHẬP </b>
			</div>
			<form:form method="post" id="form" modelAttribute="formSua"
				action="${pageContext.request.contextPath}/xacnhansua">
				<!-- 				 1 -->
				<div class='row'>
					<div class='col-sm-4'>
						<div class='form-group'>
							<label for="user_title">Số phiếu (*)</label> <input
								class="form-control" id="user_title" name="maPhieuNhap" value="${layMaPhieuNhap.maPhieuNhap}"
								size="30" type="text" />
						</div>
					</div>
					<div class='col-sm-4'>
						<div class='form-group'>
							<label for="user_firstname">Ngày nhập (*)</label> <input
								class="form-control datepicker" id="datepicker" name="ngayNhap" 
								required="true" size="30" type="text" value="${layMaPhieuNhap.ngayNhap}" />
						</div>
					</div>
					<div class='col-sm-4'>
						<div class='form-group'>
							<label for="user_lastname">Họ tên người nhập thiết bị (*)</label><select
								class="form-control" id="user_firstname" name="tbNhanVien.maNql"
								required="true" type="text">
								<option value="${layMaPhieuNhap.tbNhanVien.maNql }">${layMaPhieuNhap.tbNhanVien.hoTen }</option>
								<c:forEach var="danhsachquantrivien" items="${danhsachquantrivien}">
									<option value="${danhsachquantrivien.maNql }">${danhsachquantrivien.hoTen }</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
				<!-- 				 2 -->
				<div class='row'>
					<div class='col-sm-4'>
						<div class='form-group'>
							<label for="user_title">Tổng thành tiền</label> <input
								class="form-control" id="user_title" name="tongGiaTri" size="30" readonly="readonly"
								type="text" value="${layMaPhieuNhap.tongGiaTri}"/>
						</div>
					</div>
					<div class='col-sm-4'>
						<div class='form-group'>
							<label for="user_firstname">Đơn vị cung cấp</label> <input
								class="form-control" id="user_firstname" name="nguonGoc"
								required="true" size="30" type="text"  value="${layMaPhieuNhap.nguonGoc}"/>
						</div>
					</div>
					<div class='col-sm-4'>
						<div class='form-group'>
							<label for="user_firstname">Họ tên người giao</label> <input
								class="form-control" id="user_firstname" name="nguoiGiao"
								required="true" size="30" type="text" value="${layMaPhieuNhap.nguoiGiao}"/>
						</div>
					</div>
				</div>
				<!-- 				 3 -->
				<div class='row'>
					<div class='col-sm-4'>
						<div class='form-group'>
							<label for="user_title">Nhập về kho</label> <select
								class="form-control" id="user_firstname" name="tbKho.maKho"
								required="true" type="text">
								<option value="${layMaPhieuNhap.tbKho.maKho }">${layMaPhieuNhap.tbKho.tenKho }</option>
								<c:forEach var="danhsachkho" items="${danhsachkho}">
									<option value="${danhsachkho.maKho }">${danhsachkho.tenKho }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class='col-sm-8'>
						<div class='form-group'>
							<label for="user_lastname">Nguồn gốc tài sản</label> <input
								class="form-control" id="user_lastname" name="nguonGocTaiSan"
								required="true" size="30" type="text" value="${layMaPhieuNhap.nguonGocTaiSan}"/>
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