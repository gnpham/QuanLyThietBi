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
<title>Phòng thực hành</title>
</head>
<body>
	<div class="form">
			<div class=" row form-group">
				<div class="form-group">
					<div class="col-md-1">
						<div class="input-group stylish-input-group">
							<a href="${pageContext.request.contextPath}/chuyenpththem"
								type="button" class="btn btn-primary">Thêm phòng thực hành</a> </span>
						</div>
					</div>
					<form method="GET" action="${pageContext.request.contextPath}/danhsachpthtimkiem">
						<div class="col-md-2 col-md-offset-1">
							<select name="muc" class="form-control" placeholder="Gõ từ khóa">
								<option value="maPth">Mã phòng thực hành</option>
								<option value="phongThucHanh">Phòng thực hành</option>
								<option value="ghiChu">Ghi chú</option>
								<option value="tbNhanViens.hoTen">Người quản lý</option>
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
						<th style="width: 20px;">Phòng</th>
						<th style="width: 250px">Chức năng</th>
						<th style="width: 600px">Ghi chú</th>
<!-- 						<th style="width: 100px">Người quản lý</th> -->
						<th style="width: 75px">Sửa</th>
						<th style="width: 75px">Xóa</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="danhsach" items="${danhsach}" varStatus="stt">
						<tr>
<%-- 							<td>${stt.index +1 }</td> --%>
							<td>${danhsach.maPth }</td>
							<td>${danhsach.phongThucHanh}</td>
							<td>${danhsach.ghiChu}</td>
<%-- 							<td>${danhsach.tbNhanViens.hoTen}</td> --%>
							<td><a
								href="${pageContext.request.contextPath}/mapthsua?id=${danhsach.maPth }"
								type="button" class="btn btn-primary">Sửa</a></td>
							<td><a
								href="${pageContext.request.contextPath}/mapthxoa?id=${danhsach.maPth }"
								type="button"
								onclick="return confirm('Xác nhận xóa phòng thực hành khỏi danh sách')"
								class="btn btn-danger">Xóa</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</form>
</body>
</html>