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
											maPhieuNhap : {
												required : true,
											},
											ngayNhap : {
												required : true,
											},
											nguoiMua : {
												required : true,
											},
											nguyenGia : {
												required : true,
//												number : true,
//												min : true,
											},
											nguonGoc : {
												required : true,
//												number : true,
//												min : true,
											},
											nguoiGiao : {
												required : true,
											},
											maKho : {
												required : true,
											},
											nguonGocTaiSan : {
												required : true,
											},
											soLuongXuat : {
												required : true,
												number : true,
												min : 1,
												digits : true,
											},
											
										},
										messages : {
											maPhieuNhap : {
												required : "<span style='color:red;'>Lỗi: nhập mã phiếu nhập</span>",
											},
											ngayNhap : {
												required : "<span style='color:red;'>Lỗi: nhập ngày nhập thiết bị</span>",
											},
											nguoiMua : {
												required : "<span style='color:red;'>Lỗi: nhập họ tên người mua</span>",
											},
											nguyenGia : {
												required : "<span style='color:red;'>Lỗi: nhập tổng giá trị thiết bị</span>",
//												number : "<span style='color:red;'>Lỗi: mã chủng loại là một số</span>",
//												min : "<span style='color:red;'>Lỗi: mã chủng loại phải dương</span>",
											},
											nguonGoc : {
												required : "<span style='color:red;'>Lỗi: nhập nhà cung cấp</span>",
//												number : "<span style='color:red;'>Lỗi: mã phòng ban là một số</span>",
//												min : "<span style='color:red;'>Lỗi: mã phòng ban phải dương</span>",
											},
											nguoiGiao : {
												required : "<span style='color:red;'>Lỗi: nhập họ tên người đại diện bên giao</span>",
											},
											maKho : {
												required : "<span style='color:red;'>Lỗi: nhập kho thiết bị</span>",
											},
											nguonGocTaiSan : {
												required : "<span style='color:red;'>Lỗi: nhập nguồn gốc tài sản dùng mua thiết bị</span>",
											},
											soLuongXuat : {
												required : "<span style='color:red;'>Nhập số lượng thiết bị xuất</span>",
												number : "<span style='color:red;'>Số lượng thiết bị xuất là một số</span>",
												min : "<span style='color:red;'>Số lượng thiết bị xuất phải lớn hơn 0</span>",
												digits : "<span style='color:red;'>Số lượng thiết bị xuất phải là số nguyên</span>",
											},
										},
										submitHandler : function(form) {
											buyFlower();
											return false;
										}
									});
				});