<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Hệ thống quản lý thiết bị - Trường Cao đẳng nghề Đà Nẵng</title>
<!-- Bootstrap -->
<link rel="shortcut icon" type="image/x-icon" href="img/logo1.jpg" />
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
<link href="css/login.css" rel="stylesheet">
<script src="js/ie10-viewport-bug-workaround.js"></script>
<script src="js/ie-emulation-modes-warning.js"></script>
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-filestyle.min.js"></script>
<script type="text/javascript">
<link rel="stylesheet" href="css/contain.css">
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
					window.location.replace("Logout"); // Logout
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
</head>
<body>
	<div class="container-fluid">
		<!-- Header -->
		<div class="row" id="body-1">
			<div class="col-md-8">
				<h3 class="title">
					<a href="index.jsp"><img alt="" src="img/logo.png" width=30
						height=30></a> HỆ THỐNG QUẢN LÝ THIẾT BỊ - TRƯỜNG CAO ĐẲNG NGHỀ
					ĐÀ NẴNG
				</h3>
			</div>
			<div class="col-md-1 col-md-offset-3" style="padding-top: 20px;">
				<p class="text text-right">
					<a class="text-right" href="http://danavtc.edu.vn/"><span
						class="glyphicon glyphicon-log-out"></span></a>
				</p>
			</div>
		</div>
		<!-- /Header -->
		<!-- Body -->
		<div class="row" id="body-2">
			<div class="panel col-sm-4 col-sm-push-4">
				<form role="form" method="POST" action="dangnhap"
					modelAttribute="formDangNhap">
					<h2 class="form-signin-heading" style="font-weight:bold;">ĐĂNG NHẬP HỆ THỐNG</h2>
					<input type="text" name="tenDangNhap" class="form-control"
						placeholder="Tên đăng nhập" autofocus required="required">
					<input type="password" name="matKhau" class="form-control"
						placeholder="Mật khẩu" required="required">
					<p id="thongbao" style="color: red; margin-top: 15px">
						<div style="margin: 10px 0px;color: red">
						<p>${loi}</p>
						</div>
					</p><br/>
<!-- 					<div class="checkbox"> -->
<!-- 						<label> <input type="checkbox"> Nhớ mật khẩu -->
<!-- 						</label> -->
<!-- 					</div> -->
					<div class="col-sm-6 ">
						<button class="btn btn-default bt col-sm-10 col-sm-push-1"
							name="btReset" type="reset">Đặt lại</button>
					</div>
					<div class="col-sm-6 ">
						<button class="btn btn-primary col-sm-10 col-sm-push-2"
							name="submit" type="submit">Đăng nhập</button>
					</div>
				</form>
			</div>

		</div>
		<!-- /Body -->
		<!-- Footer -->
		<div class="row" id="footer">
			<div class="footer-info text-center"></div>
		</div>
		<!-- /Footer -->
	</div>
</body>
</html>