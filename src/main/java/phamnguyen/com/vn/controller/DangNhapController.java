package phamnguyen.com.vn.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import phamnguyen.com.vn.bean.NhanVien;
import phamnguyen.com.vn.dao.NhanVienDAO;
import phamnguyen.com.vn.dao.ThietBiDAO;

@Controller
public class DangNhapController {

	@Autowired
	NhanVienDAO nhanVienDAO;
	
	@Autowired
	ThietBiDAO thietBiDAO;

	@RequestMapping(value = "/")
	public String getDefaultPage(Model model) {
		return "dang-nhap";
	}

	@RequestMapping(value = "/dangnhap", method = RequestMethod.GET)
	public String getLoginPage(Model model) {
		return "dang-nhap";
	}

	@RequestMapping(value = "/dangnhap", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public String postLoginProcess(HttpServletRequest request, Model model,
			@ModelAttribute(value = "formDangNhap") NhanVien nhanVien) {
		System.out.println(nhanVien.getTenDangNhap());
		System.out.println(nhanVien.getMatKhau());
		HttpSession session = request.getSession();
		if (nhanVienDAO.xacNhanQuanTriVien(nhanVien.getTenDangNhap(), nhanVien.getMatKhau())) {
			session.setAttribute("ten", nhanVienDAO.getNhanVien(nhanVien.getTenDangNhap()).getHoTen());
			session.setAttribute("quyen", "Quản trị viên");
			model.addAttribute("title", "Trang quản trị viên");
			model.addAttribute("ngayhientai", nhanVienDAO.layNgayHienTai());
			model.addAttribute("soLuongKho", thietBiDAO.tinhTongThietBiKho().get(0));
			model.addAttribute("soLuongXuatKho", thietBiDAO.tinhTongThietBiXuatKho().get(0));
			return "trang-chu-quan-tri-vien";
		} else if (nhanVienDAO.xacNhanNguoiDung(nhanVien.getTenDangNhap(), nhanVien.getMatKhau())) {
			session.setAttribute("ten", nhanVienDAO.getNhanVien(nhanVien.getTenDangNhap()).getHoTen());
			session.setAttribute("quyen", "Người dùng");
			model.addAttribute("title", "Trang người dùng");
			model.addAttribute("ngayhientai", nhanVienDAO.layNgayHienTai());
//			model.addAttribute("soLuongXuatKhoTheoTen", thietBiDAO.tinhTongThietBiXuatKhoTheoTen());
			return "trang-chu-nguoi-dung";
		} else {
			model.addAttribute("loi", "Tên đăng nhập hoặc mật khẩu không đúng.");
			return "dang-nhap";
		}
	}

	@RequestMapping(value = "/dangxuat", method = RequestMethod.GET)
	public String getLogin(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		session.setAttribute("quyen", "");
		return "redirect:/dangnhap";
	}
	
	// Dua toi trang thong tin thiet bi
		@RequestMapping(value = "/chuyenthongtin", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charest=UTF-8")
		private String them(Model model) {
			return "tt-thong-tin";
		}
}
