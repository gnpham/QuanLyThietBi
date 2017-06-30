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

import phamnguyen.com.vn.dao.DanhMucThietBiDAO;
import phamnguyen.com.vn.dao.KhoDAO;
import phamnguyen.com.vn.dao.NhanVienDAO;
import phamnguyen.com.vn.dao.NuocSanXuatDAO;
import phamnguyen.com.vn.dao.PhieuNhapDAO;
import phamnguyen.com.vn.dao.ThietBiDAO;
import phamnguyen.com.vn.entities.TbChiTietNhapXuat;
import phamnguyen.com.vn.entities.TbPhieuNhap;

@Controller
public class PhieuNhapController {
	@Autowired
	private PhieuNhapDAO phieuNhapDAO;

	@Autowired
	private KhoDAO khoDAO;

	@Autowired
	private NhanVienDAO nhanVienDAO;

	@Autowired
	private ThietBiDAO thietBiDAO;

	@Autowired
	private DanhMucThietBiDAO danhMucThietBiDAO;

	@Autowired
	private NuocSanXuatDAO nuocSanXuatDAO;

	// Danh sach phieu nhap
	@RequestMapping(value = "/danhsachphieunhap", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public String layDanhSachPhieuNhap(Model model) {
		List<TbPhieuNhap> danhsach = phieuNhapDAO.layDanhSachPhieuNhap();
		model.addAttribute("danhsach", danhsach);
		return "pn-phieu-nhap";
	}

	 // Xoa phieu nhap
	 @RequestMapping(value = "/phieunhapxoa", method = RequestMethod.GET)
	 private String xoaPhieuNhap(@RequestParam(name = "id", required = false)
	 String maPhieuNhap, TbPhieuNhap danhsachphieunhap,
	 ModelMap model) {
		 danhsachphieunhap.setMaPhieuNhap(maPhieuNhap);
	 phieuNhapDAO.xoaPhieuNhap(danhsachphieunhap);
	 return "redirect:/danhsachphieunhap";
	 }
	
	// Chon ma phieu nhap sua
	@RequestMapping(value = "/phieunhapsua", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	private String layMaThietBiSua(@RequestParam(name = "id", required = false) String maPhieuNhap,
			TbPhieuNhap danhsachphieunhap, Model model) {
		danhsachphieunhap.setMaPhieuNhap(maPhieuNhap);
		model.addAttribute("layMaPhieuNhap", phieuNhapDAO.layMaPhieuNhap(maPhieuNhap));
		model.addAttribute("danhsachkho", khoDAO.layDanhSachKho());
		model.addAttribute("danhsachquantrivien", nhanVienDAO.layDanhSachQuanTriVien());
		return "pn-phieu-nhap-sua";
	}

	// Sua
	@RequestMapping(value = "/xacnhansua", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	private String xacNhanSua(@ModelAttribute(name = "formSua") TbPhieuNhap danhsachphieunhap, BindingResult result,
			Model model) {
		phieuNhapDAO.suaDanhSachPhieuNhap(danhsachphieunhap);
		return "redirect:/danhsachphieunhap";
	}

	// Dua toi trang them phieu nhap
	@RequestMapping(value = "/chuyenphieunhapthem", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charest=UTF-8")
	private String them(Model model) {
		model.addAttribute("formThem", new TbPhieuNhap());
		model.addAttribute("danhsachkho", khoDAO.layDanhSachKho());
		model.addAttribute("danhsachquantrivien", nhanVienDAO.layDanhSachQuanTriVien());
		return "pn-phieu-nhap-them";
	}

	// Xac nhan them
	@RequestMapping(value = "/phieunhapthem", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charest=UTF-8")
	public String themPhieuNhap(@ModelAttribute(name = "formThem") TbPhieuNhap dsphieunhap, BindingResult result,
			Model model) {
		phieuNhapDAO.themPhieuNhap(dsphieunhap);
		return "redirect:/danhsachphieunhap";
	}

	// Tim kiem
		@RequestMapping(value = "/timkiemphieunhap", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charset=UTF-8")
		public String timKiemPhieuNhap(@RequestParam("chuoiTimKiem") String chuoiTimKiem,
				@RequestParam("muc") String muc, Model model) {
			System.out.println("Chuoi nhap vao: " + chuoiTimKiem);
			System.out.println("O muc: " + muc);
			List<TbPhieuNhap> danhsach = phieuNhapDAO.timPhieuNhap(chuoiTimKiem, muc);
			model.addAttribute("danhsach", danhsach);
			return "pn-phieu-nhap";
		}

	// THIET BI NHAP
	// Thong tin phieu nhap - danh sach thiet bi theo ma Phieu Nhap
	@RequestMapping(value = "/phieunhapchitiet", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	private String layMaThietBiTheoMaPhieuNhap(@RequestParam(name = "id", required = false) String maPhieuNhap,
			TbPhieuNhap danhsachpn, TbChiTietNhapXuat danhsachtb, Model model) {

		// Thong tin phieu nhap lay tu Id
		danhsachpn.setMaPhieuNhap(maPhieuNhap);
		model.addAttribute("layMaPhieuNhap", thietBiDAO.layMaThietBiPhieuNhap(maPhieuNhap));

		// Danh sach cac thiet bi theo ma phieu nhap
		List<TbChiTietNhapXuat> danhsachtbpn = thietBiDAO.layDanhSachThietBiPhieuNhap(maPhieuNhap);
		model.addAttribute("danhsachtbpn", danhsachtbpn);
		return "pn-chi-tiet-phieu-nhap";
	}

	// Dua toi trang them thiet bi o phieu nhap
	@RequestMapping(value = "/chuyennhapthietbi", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charest=UTF-8")
	private String them(@RequestParam(name = "id", required = false) String maPhieuNhap, Model model) {
		model.addAttribute("formThem", new TbChiTietNhapXuat());
		model.addAttribute("maPhieuNhapThem", thietBiDAO.layMaThietBiPhieuNhap(maPhieuNhap));
		model.addAttribute("danhsachthietbi", thietBiDAO.layDanhSachThietBi());
		model.addAttribute("danhsachnuoc", nuocSanXuatDAO.layDanhSachNuoc());
		model.addAttribute("danhmucthietbi", danhMucThietBiDAO.getAllDanhMucThietBi());
		return "tb-thiet-bi-them";
	}

	// Xac nhan them-01
	@RequestMapping(value = "/themtb", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charest=UTF-8")
	public String themThietBi(@ModelAttribute(name = "formThem") TbChiTietNhapXuat danhsachthietbi,
			BindingResult result, Model model) {
		
		//Tao ma code
		danhsachthietbi.setMaCode(danhsachthietbi.getTbNuocSanXuat().getMaNuocSanXuat() + "2017"
				+ danhsachthietbi.getTbDanhMucThietBi().getMaThietBi());
		thietBiDAO.themThietBi(danhsachthietbi);
		//Tinh tong gia tri phieu nhap
		TbPhieuNhap tbPhieuNhap = phieuNhapDAO.layMaPhieuNhap(danhsachthietbi.getTbPhieuNhap().getMaPhieuNhap());
		tbPhieuNhap.setTongGiaTri(
				tbPhieuNhap.getTongGiaTri() + (danhsachthietbi.getNguyenGia() * danhsachthietbi.getSoLuong()));
		phieuNhapDAO.suaDanhSachPhieuNhap(tbPhieuNhap);
		return "redirect:/danhsachphieunhap";
	}

}
