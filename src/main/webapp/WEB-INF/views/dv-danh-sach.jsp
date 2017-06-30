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
<title>Danh sách đơn vị</title>
</head>
<body>
	<div class="form">
		<div class=" row form-group">
			<div class="form-group">
				<div class="col-md-1">
					<div class="input-group stylish-input-group">
						<a href="${pageContext.request.contextPath}/chuyendvthem"
							type="button" class="btn btn-primary">Thêm đơn vị</a> </span>
					</div>
				</div>
				<form method="GET"
					action="${pageContext.request.contextPath}/danhmuctbtimkiem">
					<div class="col-md-2 col-md-offset-1">
						<select name="muc" class="form-control" placeholder="Gõ từ khóa">
							<option value="maKhoa">Mã khoa</option>
							<option value="tenKhoa">Tên khoa</option>
							<option value="soDienThoai">Số điện thoại</option>
						</select>
					</div>
					<div class="col-md-offset-1 col-sm-4 input-group">
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
	<form>
		<div class="panel panel-default">
			<table class="table table-bordered">
				<thead>
					<tr style="background-color: #ccccff">
						<!-- 					<th style="width: 15px;">STT</th> -->
						<th style="width: 70px;">Mã khoa</th>
						<th style="width: 630px">Tên khoa</th>
						<th style="width: 200px">Số điện thoại</th>
						<th style="width: 75px">Sửa</th>
						<th style="width: 75px">Xóa</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="danhsach" items="${danhsach}" varStatus="stt">
						<tr>
							<td>${stt.index +1 }</td>
							<%-- 							<td>${danhsach.maKhoa }</td> --%>
							<td>${danhsach.tenKhoa}</td>
							<td>${danhsach.soDienThoai }</td>
							<td><a
								href="${pageContext.request.contextPath}/madonvisua?id=${danhsach.maKhoa }"
								type="button" class="btn btn-primary">Sửa</a></td>
							<td><a
								href="${pageContext.request.contextPath}/madonvixoa?id=${danhsach.maKhoa }"
								type="button"
								onclick="return confirm('Xác nhận xóa đơn vị khỏi danh sách')"
								class="btn btn-danger">Xóa</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</form>
</body>
</html>