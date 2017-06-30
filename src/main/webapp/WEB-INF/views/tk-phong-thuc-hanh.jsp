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
<title>Thống kê thiết bị phòng thực hành</title>
</head>
<body>
	<form>
		<div class="panel panel-default">
			<table class="table table-bordered">
				<thead>
					<tr style="background-color: #F67011">
						<th style="width: 18px;">STT</th>
						<th style="width: 80px;">Phòng</th>
						<th style="width: 700px">Phòng thực hành</th>
						<!-- 						<th style="width: 100px">Người quản lý</th> -->
						<th style="width: 240px">Thống kê</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="danhsachpth" items="${danhsachpth}" varStatus="stt">
						<tr>
							<td>${stt.index +1 }</td>
							<td>${danhsachpth.maPth }</td>
							<td>${danhsachpth.phongThucHanh}</td>
							<%-- 							<td>${danhsach.tbNhanViens.hoTen}</td> --%>
							<td><a
								href="${pageContext.request.contextPath}/maphongthuchanhtk?id=${danhsachpth.maPth }"
								type="button" class="btn btn-primary">Danh sách thiết bị phòng ${danhsachpth.maPth}</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</form>
</body>
</html>