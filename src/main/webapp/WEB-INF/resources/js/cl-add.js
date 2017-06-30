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
											tenChungLoai : {
												required : true,
											},
											tenNhomThietBi : {
												required : true,
											},								
										},
										messages : {
											tenChungLoai : {
												required : "<span style='color:red;'>Lỗi: bạn phải nhập tên chủng loại thiết bị</span>",
											},
											tenNhomThietBi : {
												required : "<span style='color:red;'>Lỗi: bạn phải nhập tên nhóm thiết bị</span>",
											},						
										},
										submitHandler : function(form) {
											buyFlower();
											return false;
										}
									});
				});