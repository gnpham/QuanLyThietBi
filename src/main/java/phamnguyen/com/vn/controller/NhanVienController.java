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

import phamnguyen.com.vn.dao.DonViDAO;
import phamnguyen.com.vn.dao.NhanVienDAO;
import phamnguyen.com.vn.dao.PhongBanDAO;
import phamnguyen.com.vn.dao.PhongThucHanhDAO;
import phamnguyen.com.vn.dao.QuyenTruyCapDAO;
import phamnguyen.com.vn.entities.TbNhanVien;
import phamnguyen.com.vn.entities.TbXuat;

@Controller
public class NhanVienController {
	@Autowired
	private NhanVienDAO nhanVienDAO;

	@Autowired
	private DonViDAO donViDAO;

	@Autowired
	private PhongBanDAO phongBanDAO;

	@Autowired
	private PhongThucHanhDAO phongThucHanhDAO;

	@Autowired
	private QuyenTruyCapDAO quyenTruyCapDAO;

	// Danh sach
	@RequestMapping(value = "danhsachnhanvien", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public String layDanhMucNhanVien(Model model) {
		List<TbNhanVien> danhsach = nhanVienDAO.layDanhSachNhanVien();
		model.addAttribute("danhsach", danhsach);
		return "/ds-nhan-vien";
	}

	// Xoa
	@RequestMapping(value = "nhanvienxoa", method = RequestMethod.GET)
	public String xoaNhanVien(@RequestParam(name = "ma", required = false) int maNql, TbNhanVien tbNhanVien,
			Model model) {
		tbNhanVien.setMaNql(maNql);
		nhanVienDAO.xoaNhanVien(tbNhanVien);
		return "redirect:/danhsachnhanvien";
	}

	// Chon de sua
	@RequestMapping(value = "manhanviensua", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public String chonMaNhanVien(@RequestParam(name = "ma", required = false) int maNql, TbNhanVien tbNhanVien,
			ModelMap model) {
		tbNhanVien.setMaNql(maNql);
		model.addAttribute("layMaNhanVien", nhanVienDAO.layMaNhanVien(maNql));
		
		model.addAttribute("danhsachquyen", quyenTruyCapDAO.layDanhSachQuyen());
		model.addAttribute("danhsachpth", phongThucHanhDAO.layDanhSachPhongThucHanh());
		model.addAttribute("danhsachpb", phongBanDAO.layDanhSachPhongBan());
		model.addAttribute("danhsachdv", donViDAO.layDanhSachDonVi());
		return "ds-nhan-vien-sua";
	}

	// Sua nhan vien
	@RequestMapping(value = "nhanvienxacnhansua", method = RequestMethod.POST, produces = "application/x-www-urlencoded;charset=UTF-8")
	public String suaNhanVien(@ModelAttribute(name = "formSua") TbNhanVien tbNhanVien, BindingResult result,
			Model model) {
		nhanVienDAO.suaNhanVien(tbNhanVien);
		return "redirect:/danhsachnhanvien";
	}

	// Toi trang them
	@RequestMapping(value = "chuyendsnvthem", method = RequestMethod.GET)
	public String them(Model model) {
		model.addAttribute("formThem", new TbNhanVien());
		model.addAttribute("danhsachquyen", quyenTruyCapDAO.layDanhSachQuyen());
		model.addAttribute("danhsachpth", phongThucHanhDAO.layDanhSachPhongThucHanh());
		model.addAttribute("danhsachpb", phongBanDAO.layDanhSachPhongBan());
		model.addAttribute("danhsachdv", donViDAO.layDanhSachDonVi());
		return "ds-nhan-vien-them";
	}

	// Them nhan vien
	@RequestMapping(value = "nhanvienxacnhanthem", method = RequestMethod.POST, produces = "application/x-www-urlencoded;charset=UTF-8")
	public String xacNhanThemNhanVien(@ModelAttribute(name = "formThem") TbNhanVien tbNhanVien, BindingResult result,
			Model model) {
		nhanVienDAO.themNhanVien(tbNhanVien);
		return "redirect:/danhsachnhanvien";
		// ...
	}

	// THIET BI DA XUAT
	// Thong tin nhân viên- danh sach thiet bi theo ten nhan vien
	@RequestMapping(value = "/danhsachthietbitheoten", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	private String layMaThietBiTheoTenNV(@RequestParam(name = "id", required = false) String ten, TbNhanVien danhsachnv,
			Model model) {

		// Thong tin phong thuc hanh lay tu Id
		danhsachnv.setHoTen(ten);
		model.addAttribute("layTenNhanVien", nhanVienDAO.layTenNV(ten));

		// Danh sach cac thiet bi theo ten nhan vien
		List<TbXuat> danhsachtbnv = nhanVienDAO.layDanhSachXuatTheoNV(ten);
		model.addAttribute("danhsachtbnv", danhsachtbnv);
		return "ds-nhan-vien-chi-tiet-thiet-bi";
	}

	// Thong tin ca nhan - chuc nang nguoi dung
	@RequestMapping(value = "/thongtincanhan", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	private String layThongTinCaNhan(@RequestParam(name = "id", required = false) String ten, TbNhanVien danhsachnv,
			Model model) {

		// Thong tin phong thuc hanh lay tu Id
		danhsachnv.setHoTen(ten);
		model.addAttribute("layTenNhanVien", nhanVienDAO.layTenNV(ten));

		// Danh sach cac thiet bi theo ten nhan vien
		List<TbXuat> thongtincn = nhanVienDAO.layThongTinCaNhanNV(ten);
		model.addAttribute("thongtincn", thongtincn);
		return "ds-nhan-vien-ca-nhan";
	}
}
