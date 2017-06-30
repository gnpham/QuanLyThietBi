package phamnguyen.com.vn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import phamnguyen.com.vn.dao.ChiTietThietBiDAO;
import phamnguyen.com.vn.dao.DanhMucThietBiDAO;
import phamnguyen.com.vn.dao.NuocSanXuatDAO;
import phamnguyen.com.vn.dao.ThietBiDAO;
import phamnguyen.com.vn.entities.TbChiTietNhapXuat;
import phamnguyen.com.vn.entities.TbChiTietThietBi;

@Controller
public class ChiTietThietBiController {
	@Autowired
	private ThietBiDAO thietBiDAO;

	@Autowired
	private DanhMucThietBiDAO danhMucThietBiDAO;

	@Autowired
	private NuocSanXuatDAO nuocSanXuatDAO;

	@Autowired
	private ChiTietThietBiDAO chiTietThietBiDAO;

	// Thong tin thiet bi - danh sach thiet bi phu tung -01
	@RequestMapping(value = "/thietbichitiet", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	private String layMaThietBiChiTiet(@RequestParam(name = "id", required = false) int tbId,
			TbChiTietNhapXuat danhsachtb, Model model) {
	
		// Thong tin thiet bi lay tu Id
		danhsachtb.setThietBiId(tbId);
		model.addAttribute("layMaThietBi", thietBiDAO.layThietBiId(tbId));
		model.addAttribute("danhsachthietbi", danhMucThietBiDAO.getAllDanhMucThietBi());
		model.addAttribute("danhsachnuoc", nuocSanXuatDAO.layDanhSachNuoc());
		
		// Danh sach cac phu tung theo Id
				List<TbChiTietThietBi> danhsachchitiet = chiTietThietBiDAO.layDanhSachPhuTung(tbId);
				model.addAttribute("danhsachchitiet", danhsachchitiet);				
		return "ct-thiet-bi";
	}
	
	// Dua toi trang them thiet bi phu tung
		@RequestMapping(value = "/chuyenthemphutung", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charest=UTF-8")
		private String them( Model model) {
			model.addAttribute("formThem", new TbChiTietThietBi());
//			model.addAttribute("maThietBiThemPhuTung", chiTietThietBiDAO.layMaThietBiThemPhuTung(thietBiId));
			model.addAttribute("danhsachthietbi", thietBiDAO.layDanhSachThietBi());
			model.addAttribute("danhsachnuoc", nuocSanXuatDAO.layDanhSachNuoc());
			model.addAttribute("danhmucthietbi", danhMucThietBiDAO.getAllDanhMucThietBi());
			return "ct-thiet-bi-them";
		}

		// Xac nhan them
		@RequestMapping(value = "/phutungthem", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charest=UTF-8")
		public String themPhieuNhap(@ModelAttribute(name = "formThem") TbChiTietThietBi chitietthietbi, BindingResult result,
				Model model) {
			chiTietThietBiDAO.themPhuTung(chitietthietbi);
			return "redirect:/thietbichitiet";
		}

}
