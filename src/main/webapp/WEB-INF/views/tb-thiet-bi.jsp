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
<link rel="stylesheet" href="css/bang_chu.css">
<title>Danh sách thiết bị</title>
</head>
<body>
	<div class="form">
		<div class=" row form-group">
			<div class="form-group">
				<form method="GET"
					action="${pageContext.request.contextPath}/danhsachthietbitimkiem">
					<div class="col-md-2 col-md-offset-0">
						<select name="muc" class="form-control" placeholder="Gõ từ khóa">
							<option value="maThietBi">Mã thiết bị</option>
							<option value="tenThietBi">Tên thiết bị</option>
							<option value="donViTinh">Đơn vị tính</option>
							<option value="nuocSanXuat">Nước sản xuất</option>
							<option value="maCode">Mã code</option>
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
			<b>DANH SÁCH THIẾT BỊ TRONG KHO</b>
		</h3>
	</div>
	<!-- 		   <div style="padding: 1px;"> -->
	<form class="textsize">
		<div class="panel panel-default">
			<table class="table table-bordered">
				<thead>
					<tr style="background-color: #ccccff">
						<th style="width: 15px;">Mã</th>
						<!-- 						<th style="width: 40px;">Mã</th> -->
						<th style="width: 80px">Mã TB</th>
						<th style="width: 390px">Tên thiết bị</th>
						<th style="width: 120px">Ngày nhập</th>
						<th style="width: 50px;">ĐVT</th>
						<th style="width: 90px">Số lượng</th>
						<!-- 						<th style="width: 90px;">HBH</th> -->
						<!-- 						<th style="width: 100px">Số hiệu TSCD</th> -->
						<!-- 						<th style="width: 90px;">Công suất</th> -->
						<th style="width: 90px">Nguyên giá </th>
						<th style="width: 100px">Nước SX</th>
						<!-- 						<th style="width: 100px">Mô tả</th> -->
						<th style="width: 90px">Khấu hao</th>
						<th style="width: 100px">Mã code</th>
						<th style="width: 80px">Chi tiết</th>
						<th style="width: 35px">Sửa</th>
						<th style="width: 35px">Xóa</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="danhsach" items="${danhsach}" varStatus="stt">
						<tr>
							<td>${stt.index +1 }</td>
							<%-- 							<td>${danhsach.thietBiId }</td> --%>
							<td>${danhsach.tbDanhMucThietBi.maThietBi}</td>
							<td>${danhsach.tenThietBi }</td>
							<td>${danhsach.tbPhieuNhap.ngayNhap}</td>
							<td>${danhsach.donViTinh }</td>
							<td>${danhsach.soLuong}</td>
							<%-- 							<td>${danhsach.hanBaoHanh}</td> --%>
							<%-- 							<td>${danhsach.soHieuTscd }</td> --%>
							<%-- 							<td>${danhsach.congXuat}</td> --%>
							<td>${danhsach.nguyenGia }</td>
							<td>${danhsach.tbNuocSanXuat.nuocSanXuat }</td>
							<%-- 							<td>${danhsach.moTa}</td> --%>
							<td>${danhsach.khauHao}</td>
							<td>${danhsach.maCode}</td>
							<td><a
								href="${pageContext.request.contextPath}/thietbichitiet?id=${danhsach.thietBiId }"><span
									class="glyphicon glyphicon-folder-open"></span></a></td>
							<td><a
								href="${pageContext.request.contextPath}/thietbisua?id=${danhsach.thietBiId }"><span
									class="glyphicon glyphicon-pencil"></span></a></td>
							<td><a
								href="${pageContext.request.contextPath}/thietbixoa?id=${danhsach.thietBiId }"><span
									class="glyphicon glyphicon-remove" style="color: red"
									onclick="return confirm('Xác nhận xóa thiết bị khỏi danh sách')"></span></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</form>
</body>
</html>