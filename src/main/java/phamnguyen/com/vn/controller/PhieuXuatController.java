package phamnguyen.com.vn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import phamnguyen.com.vn.dao.KhoDAO;
import phamnguyen.com.vn.dao.NhanVienDAO;
import phamnguyen.com.vn.dao.PhieuXuatDAO;
import phamnguyen.com.vn.dao.PhongThucHanhDAO;
import phamnguyen.com.vn.dao.ThietBiDAO;
import phamnguyen.com.vn.dao.XuatDAO;
import phamnguyen.com.vn.entities.TbChiTietNhapXuat;
import phamnguyen.com.vn.entities.TbPhieuXuat;
import phamnguyen.com.vn.entities.TbXuat;

@Controller
public class PhieuXuatController {
	@Autowired
	private PhieuXuatDAO phieuXuatDAO;

	@Autowired
	private KhoDAO khoDAO;

	@Autowired
	private PhongThucHanhDAO phongThucHanhDAO;

	@Autowired
	private NhanVienDAO nhanVienDAO;

	@Autowired
	private XuatDAO xuatDAO;

	@Autowired
	private ThietBiDAO thietBiDAO;

	// Danh sach phieu xuat
	@RequestMapping(value = "/danhsachphieuxuat", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public String layDanhSachPhieuXuat(Model model) {
		List<TbPhieuXuat> danhsach = phieuXuatDAO.layDanhSachPhieuXuat();
		model.addAttribute("danhsach", danhsach);
		return "px-phieu-xuat";
	}

	 // Xoa phieu xuat
	 @RequestMapping(value = "/phieuxuatxoa", method = RequestMethod.GET)
	 private String xoaPhieuXuat(@RequestParam(name = "id", required = false)
	 String maPhieuXuat, TbPhieuXuat danhsachphieuxuat,
	 ModelMap model) {
		 danhsachphieuxuat.setMaPhieuXuat(maPhieuXuat);
	 phieuXuatDAO.xoaPhieuXuat(danhsachphieuxuat);
	 return "redirect:/danhsachphieuxuat";
	 }
		
		// Chon ma phieu nhap sua
		@RequestMapping(value = "/phieuxuatsua", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charset=UTF-8")
		private String layMaThietBiSua(@RequestParam(name = "id", required = false) String maPhieuXuat,
				TbPhieuXuat danhsachphieuxuat, Model model) {
			danhsachphieuxuat.setMaPhieuXuat(maPhieuXuat);
			model.addAttribute("layMaPhieuXuat", phieuXuatDAO.layMaPhieuXuat(maPhieuXuat));
			model.addAttribute("danhsachkho", khoDAO.layDanhSachKho());
			model.addAttribute("danhsachquantrivien", nhanVienDAO.layDanhSachQuanTriVien());
			model.addAttribute("danhsachnguoidung", nhanVienDAO.layDanhSachNguoiDung());
			model.addAttribute("danhsachpth", phongThucHanhDAO.layDanhSachPhongThucHanh());
			return "px-phieu-xuat-sua";
		}

		// Sua
		@RequestMapping(value = "/xacnhansuaphieuxuat", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
		private String xacNhanSuaPhieuXuat(@ModelAttribute(name = "formSua") TbPhieuXuat danhsachphieuxuat, BindingResult result,
				Model model) {
			phieuXuatDAO.suaDanhSachPhieuXuat(danhsachphieuxuat);
			return "redirect:/danhsachphieuxuat";
		}
	// Dua toi trang them
	@RequestMapping(value = "/chuyenphieuxuatthem", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charest=UTF-8")
	private String them(Model model) {
		model.addAttribute("formThem", new TbPhieuXuat());
		model.addAttribute("danhsachkho", khoDAO.layDanhSachKho());
		model.addAttribute("danhsachquantrivien", nhanVienDAO.layDanhSachQuanTriVien());
		model.addAttribute("danhsachnguoidung", nhanVienDAO.layDanhSachNguoiDung());
		model.addAttribute("danhsachpth", phongThucHanhDAO.layDanhSachPhongThucHanh());
		return "px-phieu-xuat-them";
	}

	// Xac nhan them
	@RequestMapping(value = "/phieuxuatthem", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charest=UTF-8")
	public String themPhieuXuat(@ModelAttribute(name = "formThem") TbPhieuXuat dsphieuxuat, BindingResult result,
			Model model) {
		phieuXuatDAO.themPhieuXuat(dsphieuxuat);
		return "redirect:/danhsachphieuxuat";
	}

	// Tim kiem
	@RequestMapping(value = "timkiemphieuxuat", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public String timKiemDanhMucThietBi(@RequestParam("chuoiTimKiem") String chuoiTimKiem,
			@RequestParam("muc") String muc, Model model) {
		System.out.println("Chuoi nhap vao: " + chuoiTimKiem);
		System.out.println("O muc: " + muc);
		List<TbPhieuXuat> danhsach = phieuXuatDAO.timKiemPhieuXuat(chuoiTimKiem, muc);
		model.addAttribute("danhsach", danhsach);
		return "px-phieu-xuat";
	}

	// THIET BI XUAT
	// Thong tin phieu xuat - danh sach thiet bi theo ma Phieu Xuat
	@RequestMapping(value = "/phieuxuatchitiet", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	private String layMaThietBiTheoMaPhieuXuat(@RequestParam(name = "id", required = false) String maPhieuXuat,
			TbPhieuXuat danhsachpx, TbChiTietNhapXuat danhsachtb, Model model) {
		// Thong tin phieu xuat lay tu Id
		danhsachpx.setMaPhieuXuat(maPhieuXuat);
		model.addAttribute("layMaPhieuXuat", thietBiDAO.layMaPhieuXuat(maPhieuXuat));
		// Danh sach cac thiet bi theo ma phieu xuat
		List<TbXuat> danhsachtbpx = xuatDAO.layDanhSachXuatTheoMa(maPhieuXuat);
		model.addAttribute("danhsachtbpx", danhsachtbpx);
		return "px-chi-tiet-phieu-xuat";
	}

}
