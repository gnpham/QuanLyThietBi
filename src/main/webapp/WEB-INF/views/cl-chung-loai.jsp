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
<link rel="stylesheet" href="css/contain-1.css">
<title>Danh mục chủng loại</title>
</head>
<body>
	<div class="form">
		<div class=" row form-group">
			<div class="form-group">
				<div class="col-md-1">
					<div class="input-group stylish-input-group">
						<a href="${pageContext.request.contextPath}/chuyendmclthem"
							type="button" class="btn btn-primary">Thêm chủng loại thiết
							bị</a> </span>
					</div>
				</div>
				<form method="GET"
					action="${pageContext.request.contextPath}/danhmuccltimkiem">
					<div class="col-md-3 col-md-offset-2">
						<select name="muc" class="form-control" placeholder="Gõ từ khóa">
							<option value="tenChungLoai">Tên chủng loại thiết bị</option>
							<option value="tenNhomThietBi">Nhóm thiết
								bị</option>
							<option value="ghiChu">Ghi chú</option>
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
	<div class="title-12">
		<h3>
			<b>DANH MỤC CHỦNG LOẠI </b>
		</h3>
	</div>
	<!-- 		   <div style="padding: 1px;"> -->
	<form>
		<div class="panel panel-default">
			<table class="table table-bordered">
				<!-- 			table-striped -->
				<thead>
					<tr style="background-color: #ccccff">
						<th style="width: 40px;">Mã</th>
						<th style="width: 300px;">Tên chủng loại thiết bị</th>
						<th style="width: 300px;">Nhóm thiết bị</th>
						<th style="width: 350px;">Ghi chú</th>
						<th style="width: 40px">Sửa</th>
						<th style="width: 40px">Xóa</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="danhsach" items="${danhsach}" varStatus="stt">
						<tr>
							<td>${danhsach.maChungLoai }</td>
							<td>${danhsach.tenChungLoai}</td>
							<td>${danhsach.tbNhomThietBi.tenNhomThietBi}</td>
							<td>${danhsach.ghiChu }</td>
							<!-- 							<td><a -->
							<%-- 								href="${pageContext.request.contextPath}/machungloaisua?id=${danhsach.maChungLoai }" --%>
							<!-- 								type="button" class="btn btn-primary">Sửa</a></td> -->
							<!-- 							<td><a -->
							<%-- 								href="${pageContext.request.contextPath}/danhmucclxoa?id=${danhsach.maChungLoai }" --%>
							<!-- 								type="button" -->
							<!-- 								onclick="return confirm('Xác nhận xóa chủng loại thiết bị khỏi danh mục')" -->
							<!-- 								class="btn btn-danger">Xóa</a></td> -->
							<td><a
								href="${pageContext.request.contextPath}/machungloaisua?id=${danhsach.maChungLoai }"><span
									class="glyphicon glyphicon-pencil"></span></a></td>
							<td><a
								href="${pageContext.request.contextPath}/danhmucclxoa?id=${danhsach.maChungLoai }"><span
									class="glyphicon glyphicon-remove" style="color: red"
									onclick="return confirm('Xác nhận xóa chủng loại thiết bị khỏi danh mục')"></span></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</form>
</body>
</html>