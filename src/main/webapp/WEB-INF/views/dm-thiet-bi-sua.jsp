<%-- <%@page import="org.apache.el.lang.ELSupport"%> --%>
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
				action="${pageContext.request.contextPath}/danhmuctbsua">
				<div class='row'>
					<div class='col-sm-10'>
						<div class='form-group'>
							<label for="user_title">Mã Thiết Bị</label> <input
								class="form-control" id="user_title" name="maThietBi"
								value="${layMaThietBi.maThietBi}" size="30" readonly="readonly"
								type="text" />
						</div>
					</div>
				</div>
				<div class='row'>
					<div class='col-sm-10'>
						<div class='form-group'>
							<label for="user_title">Tên thiết bị</label> <input
								class="form-control" id="user_title" name="tenThietBi"
								value="${layMaThietBi.tenThietBi }" size="30"
								readonly="readonly" type="text" />
						</div>
					</div>
				</div>
				<div class='row'>
					<div class='col-sm-10'>
						<div class='form-group'>
							<label for="user_title">Đặc tính kỹ thuật</label> <input
								class="form-control" id="user_title" name="dacTinhKyThuat"
								value="${layMaThietBi.dacTinhKyThuat }" size="30" type="text" />
						</div>
					</div>
				</div>
				<div class='row'>
					<div class='col-sm-10'>
						<div class='form-group'>
							<label for="user_title">Chủng loại thiết bị</label> <select
								name="tbDanhMucChungLoai.maChungLoai" class="form-control">
								<c:forEach var="danhsachchungloai" items="${danhsachchungloai}">
									<option value="${danhsachchungloai.maChungLoai }">${danhsachchungloai.tenChungLoai }</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
				<br />
				<div>
					<div class="col-md-1 col-md-offset-7">
						<a class="btn btn-danger"
							href="${pageContext.request.contextPath}/danhmucthietbi"> Hủy
							bỏ</a>
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