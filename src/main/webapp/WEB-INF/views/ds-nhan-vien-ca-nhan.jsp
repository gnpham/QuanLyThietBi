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
<link rel="stylesheet" href="css/contain.css">
<link rel="stylesheet" href="css/bang_chu.css">
<title>Thông tin cá nhân</title>
</head>
<body>
	<form class="textsize">
		<div class="panel panel-default">
			<table class="table table-bordered table-striped">
				<thead>
					<tr style="background-color: #ccccff">
						<th style="width: 20px;">STT</th>
						<th style="width: 130px">Họ tên</th>
						<th style="width: 75px">Giới tính</th>
						<th style="width: 90px">Địa chỉ</th>
						<th style="width: 90px">Số điện thoại</th>
						<th style="width: 100px">Email</th>
						<th style="width: 90px">Chức vụ</th>
						<th style="width: 180px">PTH làm việc</th>
						<th style="width: 100px">Tên đăng nhập</th>
						<th style="width: 75px">Mật khẩu</th>
						<th style="width: 75px">Quyền</th>
						<!-- 						<th style="width: 100px">Quyền truy cập</th> -->
						<!-- 						<th style="width: 100px">Khoa</th> -->
						<th>Sửa</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="thongtincn" items="${thongtincn}" varStatus="stt">
						<tr>
							<td>${thongtincn.maNql }</td>
							<td>${thongtincn.hoTen}</td>
							<td>${thongtincn.gioiTinh }</td>
							<td>${thongtincn.diaChi }</td>
							<td>${thongtincn.soDienThoai }</td>
							<td>${thongtincn.email }</td>
							<td>${thongtincn.chucVu }</td>
							<td>${thongtincn.tbPhongThucHanh.phongThucHanh}</td>
							<td>${thongtincn.tenDangNhap }</td>
							<td>${thongtincn.matKhau }</td>
							<td>${thongtincn.tbQuyenTruyCap.quyen}</td>
							<td><a
								href="${pageContext.request.contextPath}/manhanviensua?ma=${thongtincn.maNql}"><span
									class="glyphicon glyphicon-pencil"></span></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</form>
</body>
</html>