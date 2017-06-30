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
				<b>SỬA THÔNG TIN LẦN BẢO TRÌ</b>
			</h3>
		</div>
		<div class="title-71">
			<form:form method="POST" id="form" modelAttribute="formSua"
				action="${pageContext.request.contextPath}/baotrisua">
				<!-- 				 1 -->	
				<div class='row'>
					<div class='col-sm-4'>
						<div class='form-group'>
							<label for="user_firstname">Ngày bảo trì</label> <input
								class="form-control datepicker" id="datepicker"
								name="ngayBaoTri" required="true" size="30" value="${layMaLanBaoTri.ngayBaoTri}"/>
						</div>
					</div>
					<div class='col-sm-6'>
						<div class='form-group'>
							<label for="user_title">Người bảo trì</label>  <select
								name="nguoiBaoTri" class="form-control"
								id="thietBiKho">
								<option>${layMaLanBaoTri.nguoiBaoTri}</option>
								<c:forEach var="danhsachkythuatvien" items="${danhsachkythuatvien}">
									<option value="${danhsachkythuatvien.hoTen }">${danhsachkythuatvien.hoTen} - ${danhsachkythuatvien.chucVu} ${danhsachkythuatvien.tbPhongBan.tenPhongBan}</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
				<!-- 				 2 -->
				<div class='row'>
					<div class='col-sm-4'>
						<div class='form-group'>
							<label for="user_title">Tình trạng thiết bị</label> <select
								name="tbTinhTrangThietBi.maTinhTrang" class="form-control"
								id="thietBiKho">
								<option>${layMaLanBaoTri.tbTinhTrangThietBi.tinhTrang}</option>
								<c:forEach var="danhsachtinhtrang" items="${danhsachtinhtrang}">
									<option value="${danhsachtinhtrang.maTinhTrang }">${danhsachtinhtrang.tinhTrang}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class='col-sm-6'>
						<div class='form-group'>
							<label for="user_title">Chi tiết tình trạng</label> <input
								class="form-control" id="user_title" name="chiTietTinhTrang"
								required="true" size="30" type="text" value="${layMaLanBaoTri.chiTietTinhTrang}"/>
						</div>
					</div>
				</div>
				<!-- 				 3 -->
				<div class='row'>
					<div class='col-sm-4'>
						<div class='form-group'>
							<label for="user_title">Nội dung bảo trì</label> <input
								class="form-control" id="user_title" name="noiDungBaoTri"
								size="30" type="text" value="${layMaLanBaoTri.noiDungBaoTri}"/>
						</div>
					</div>
					<div class='col-sm-6'>
						<div class='form-group'>
							<label for="user_title">Chi phí (VNĐ)</label> <input
								placeholder="VNĐ" class="form-control" id="user_title"
								name="chiPhi" required="true" size="30" type="text" value="${layMaLanBaoTri.chiPhi}"/>
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