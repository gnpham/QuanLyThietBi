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
<title>Danh sách người dùng</title>
</head>
<body>
	<div class="form">
		<div class=" row form-group">
			<div class="form-group">
				<div class="col-md-1">
					<div class="input-group stylish-input-group">
						<a href="${pageContext.request.contextPath}/chuyendsnvthem"
							type="button" class="btn btn-primary">Thêm người dùng</a> </span>
					</div>
				</div>
				<form method="GET"
					action="${pageContext.request.contextPath}/nhanvientimkiem">
					<div class="col-md-2 col-md-offset-1">
						<select name="muc" class="form-control" placeholder="Gõ từ khóa">
							<option value="maThietBi">Mã người dùng</option>
							<option value="tenThietBi">Tên</option>
							<option value="dacTinhKyThuat">Địa chỉ</option>
							<option value="maChungLoai">Số điện thoại</option>
							<option value="maPhongBan">Email</option>
							<option value="maChungLoai">Chức vụ</option>
						</select>
					</div>
					<div class="col-sm-offset-1 col-sm-4 input-group">
						<input type="text" class="form-control" placeholder="Gõ từ khóa"
							name="chuoiTimKiem"> <span class="input-group-btn">
							<button class="btn " type="submit">
								<span class="glyphicon glyphicon-search"></span>Tìm kiếm
							</button>
						</span>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- 		   <div style="padding: 1px;"> -->
	<form class="textsize">
		<div class="panel panel-default">
			<table class="table table-bordered table-striped">
				<thead>
					<tr style="background-color: #ccccff">
						<!-- 					<th style="width: 15px;">STT</th> -->
						<th style="width: 20px;">STT</th>
						<th style="width: 130px">Họ tên</th>
						<th style="width: 50px">GT</th>
						<th style="width: 110px">Địa chỉ</th>
						<th style="width: 90px">Số điện thoại</th>
						<th style="width: 100px">Email</th>
						<th style="width: 80px">Chức vụ</th>
						<th style="width: 160px">PTH làm việc</th>
						<th style="width: 70px">Tên ĐN</th>
						<th style="width: 70px">Mật khẩu</th>
						<th style="width: 80px">Quyền</th>
<!-- 						<th style="width: 65px">Chi tiết</th> -->
						<!-- 						<th style="width: 100px">Quyền truy cập</th> -->
						<!-- 						<th style="width: 100px">Khoa</th> -->
						<th style="width: 35px">Sửa</th>
						<th style="width: 35px">Xóa</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="danhsach" items="${danhsach}" varStatus="stt">
						<tr>
							<td>${stt.index +1 }</td>
							<%-- 							<td>${danhsach.maNql }</td> --%>
							<td>${danhsach.hoTen}</td>
							<td>${danhsach.gioiTinh }</td>
							<td>${danhsach.diaChi }</td>
							<td>${danhsach.soDienThoai }</td>
							<td>${danhsach.email }</td>
							<td>${danhsach.chucVu }</td>
							<td>${danhsach.tbPhongThucHanh.phongThucHanh}</td>
							<td>${danhsach.tenDangNhap }</td>
							<td>${danhsach.matKhau }</td>
							<td>${danhsach.tbQuyenTruyCap.quyen}</td>
<!-- 							<td><a -->
<%-- 								href="${pageContext.request.contextPath}/manhanvienchitiet?ma=${danhsach.maNql}"><span --%>
<!-- 									class="glyphicon glyphicon-folder-open"></span></a></td> -->
							<td><a
								href="${pageContext.request.contextPath}/manhanviensua?ma=${danhsach.maNql }"><span
									class="glyphicon glyphicon-pencil"></span></a></td>
							<td><a
								href="${pageContext.request.contextPath}/nhanvienxoa?ma=${danhsach.maNql }"><span
									class="glyphicon glyphicon-remove" style="color: red"
									onclick="return confirm('Xác nhận xóa nhân viên khỏi danh sách')"></span></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</form>
</body>
</html>