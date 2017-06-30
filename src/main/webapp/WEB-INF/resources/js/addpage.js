$(document)
		.ready(
				function() {
					jQuery.validator.setDefaults({
						success : "valid"
					});
					$("#form")
							.validate(
									{
										rules : {
											maThietBi : {
												required : true,
											},
											tenThietBi : {
												required : true,
											},
											dacTinhKyThuat : {
												required : true,
											},
											maChungLoai : {
												required : true,
//												number : true,
//												min : true,
											},
											maPhongBan : {
												required : true,
//												number : true,
//												min : true,
											},
											tenChungLoai : {
												required : true,
											},
										},
										messages : {
											maThietBi : {
												required : "<span style='color:red;'>Lỗi: bạn phải nhập mã thiết bị</span>",
											},
											tenThietBi : {
												required : "<span style='color:red;'>Lỗi: bạn phải nhập tên thiết bị</span>",
											},
											dacTinhKyThuat : {
												required : "<span style='color:red;'>Lỗi: bạn phải nhập đặc tính kỹ thuật của thiết bị</span>",
											},
											maChungLoai : {
												required : "<span style='color:red;'>Lỗi: bạn phải nhập mã chủng loại</span>",
//												number : "<span style='color:red;'>Lỗi: mã chủng loại là một số</span>",
//												min : "<span style='color:red;'>Lỗi: mã chủng loại phải dương</span>",
											},
											maPhongBan : {
												required : "<span style='color:red;'>Lỗi: bạn phải nhập mã phòng ban</span>",
//												number : "<span style='color:red;'>Lỗi: mã phòng ban là một số</span>",
//												min : "<span style='color:red;'>Lỗi: mã phòng ban phải dương</span>",
											},
											tenChungLoai : {
												required : "<span style='color:red;'>Lỗi: bạn phải nhập tên chủng loại thiết bị</span>",
											},
										},
										submitHandler : function(form) {
											buyFlower();
											return false;
										}
									});
				});