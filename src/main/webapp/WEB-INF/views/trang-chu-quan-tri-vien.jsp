<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>${title}</title>
<!-- Bootstrap -->
<link rel="shortcut icon" type="image/x-icon" href="img/logo1.jpg" />
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
<link href="css/indexpage.css" rel="stylesheet">
<script src="js/ie10-viewport-bug-workaround.js"></script>
<script src="js/ie-emulation-modes-warning.js"></script>
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-filestyle.min.js"></script>
<script type="text/javascript">
	function poll() {
		var url = "LastAccessTimeFilter"; //ajaxpollng
		$.ajax({
			url : url,
			dataType : 'text',
			async : true,
			beforeSend : function(request) {
				request.setRequestHeader("IS_AJAX_POLL", "Y");
			},
			type : 'POST',
			success : function(data, testStatus, request) {
				var isSessionTimeout = request
						.getResponseHeader("IS_SESSION_TIMEOUT");
				if (isSessionTimeout != null && isSessionTimeout == 'Y') {
					window.location.replace("dangxuat"); // Logout
					location.reload();
				}
			}
		});
	}
</script>
<script type="text/javascript">
	window.onLoad = function() {
		setInterval(poll(), 5000);
	}//Polling Server every 30 seconds.};
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('.panel-collapse .list-group li a').click(function(ev) {
			$('.panel-collapse .list-group li').removeClass('selected');
			$(ev.currentTarget).parent('li').addClass('selected');
		});
	});
</script>
</head>
<body>
	<div class="container-fluid">
		<!-- Top -->
		<div class="row" id="body-1">
			<div class="col-md-8">
				<h3 class="title">
					<a href="index.jsp"><img alt="" src="img/tb1.png" width=30
						height=30 style="margin-right: 7px"></a> HỆ THỐNG QUẢN LÝ THIẾT
					BỊ - TRƯỜNG CAO ĐẲNG NGHỀ ĐÀ NẴNG
				</h3>
			</div>
			<%
				String ten = (String) session.getAttribute("ten");
				String quyen = (String) session.getAttribute("quyen");
			%>
			<div class="col-md-3" style="color: #FFFFFF;">
				<p class="text text-right">${ten} (${quyen})</p>
			</div>
			<div class="col-md-1" style="padding-top: 13px;">
				<a class="btn btn-danger btn-block"
					href="${pageContext.request.contextPath}/dangxuat">Thoát</a>
			</div>
		</div>
		<!-- /Top -->
		<!-- Bottom -->
		<div class="row" id="body-2">
			<!-- Left -->
			<div class="col-md-2">
				<!-- Groups -->
				<div class="panel-group">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<span class="glyphicon glyphicon-home"></span> <a
									href="${pageContext.request.contextPath}/danhsachphieunhap"
									target="_main" id="click-1">Trang chủ</a>
							</h4>
						</div>
					</div>

					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<span class="glyphicon glyphicon-briefcase"></span> <a
									data-toggle="collapse" href="#RevenuesManagement" id="click-1">
									Quản lý thiết bị</a>
							</h4>
						</div>
						<div id="RevenuesManagement" class="panel-collapse collapse">
							<ul class="list-group">
								<li class="list-group-item checkEdit"><a
									href="${pageContext.request.contextPath}/danhsachthietbi"
									target="_main">Kho thiết bị</a></li>
								<li class="list-group-item checkEdit"><a
									href="${pageContext.request.contextPath}/danhmucthietbi"
									target="_main">Danh mục thiết bị</a></li>
								<li class="list-group-item"><a
									href="${pageContext.request.contextPath}/danhmucchungloai"
									target="_main">Danh mục chủng loại</a></li>
							</ul>
						</div>
					</div>

					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<span class="glyphicon glyphicon-sort"></span> <a
									data-toggle="collapse" href="#ExpendituresManagement"
									id="click-1">Quản lý sử dụng</a>
							</h4>
						</div>
						<div id="ExpendituresManagement" class="panel-collapse collapse">
							<ul class="list-group">
								<li class="list-group-item"><a
									href="${pageContext.request.contextPath}/danhsachphieunhap"
									target="_main">Phiếu nhập thiết bị</a></li>
								<li class="list-group-item"><a
									href="${pageContext.request.contextPath}/danhsachphieuxuat"
									target="_main">Phiếu xuất thiết bị</a></li>
								<li class="list-group-item"><a
									href="${pageContext.request.contextPath}/danhsachxuatbaotri"
									target="_main">Bảo trì sửa chữa</a></li>
								<!-- 								<li class="list-group-item"><a href="OtherExpenditures" -->
								<!-- 									target="_main">Thanh lý</a></li> -->
							</ul>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<span class="glyphicon glyphicon-object-align-bottom"></span> <a
									data-toggle="collapse" href="#StatisticManagement" id="click-1">Báo
									cáo - thống kê</a>
							</h4>
						</div>
						<div id="StatisticManagement" class="panel-collapse collapse">
							<ul class="list-group">
								<li class="list-group-item"><a
									href="${pageContext.request.contextPath}/thongketheophong"
									target="_main">Thống kê theo phòng</a></li>
								<li class="list-group-item"><a href="${pageContext.request.contextPath}/thongketheodonvi"
									target="_main">Thống kê theo khoa</a></li>
							</ul>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<span class="glyphicon glyphicon-lock"></span> <a
									data-toggle="collapse" href="#SystemManagement" id="click-1">Hệ
									thống</a>
							</h4>
						</div>
						<div id="SystemManagement" class="panel-collapse collapse">
							<ul class="list-group">
								<li class="list-group-item"><a
									href="${pageContext.request.contextPath}/danhmucphongban"
									target="_main">Danh mục phòng ban</a></li>
								<li class="list-group-item"><a
									href="${pageContext.request.contextPath}/danhsachdonvi"
									target="_main">Danh mục khoa</a></li>
								<li class="list-group-item"><a
									href="${pageContext.request.contextPath}/danhsachpth"
									target="_main">Phòng thực hành</a></li>
								<li class="list-group-item"><a
									href="${pageContext.request.contextPath}/danhsachnhanvien"
									target="_main">Người dùng - Tài khoản</a></li>
							</ul>
						</div>
					</div>

					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<span class="glyphicon glyphicon-cog"></span> <a
									href="chuyenthongtin" target="_main" id="click-1">Thông tin</a>
							</h4>
						</div>
					</div>

					<div class="panel panel-success">
						<div class="panel-heading">
							<h5 class="panel-title">
								<span class="glyphicon glyphicon-map-marker"></span><b>
									DANAVTC</b>
							</h5>
						</div>
						<div class="panel-body danavtc-01">
							<div>
								<b>Ngày ${ngayhientai}</b>
							</div>
							<div>Số thiết bị trong kho: ${soLuongKho}</div>
							<div>Số lượng đã xuất kho: ${soLuongXuatKho}</div>
						</div>
					</div>
				</div>
				<!-- /Groups -->
			</div>
			<!-- /Left -->
			<!-- Right -->
			<div class="col-md-10">
				<div class="well">
					<iframe src="<%=request.getContextPath()%>/danhsachphieunhap"
						name="_main" id="_main"
						style="border: none; width: 100%; height: 1000px;"> </iframe>
				</div>
			</div>
			<!-- /RIGHT -->
		</div>
		<!-- /BOTTOM -->
	</div>
</body>
</html>