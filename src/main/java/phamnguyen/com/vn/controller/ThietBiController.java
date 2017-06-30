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
import phamnguyen.com.vn.dao.NuocSanXuatDAO;
import phamnguyen.com.vn.dao.ThietBiDAO;
import phamnguyen.com.vn.entities.TbChiTietNhapXuat;

@Controller
public class ThietBiController {
	@Autowired
	private ThietBiDAO thietBiDAO;

	@Autowired
	private DanhMucThietBiDAO danhMucThietBiDAO;

	@Autowired
	private NuocSanXuatDAO nuocSanXuatDAO;
	

	// THIET BI

	// Danh sach thiet bi-01
	@RequestMapping(value = "/danhsachthietbi", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public String layDanhSachThietBi(Model model) {
		List<TbChiTietNhapXuat> danhsach = thietBiDAO.layDanhSachThietBi();
		model.addAttribute("danhsach", danhsach);
		return "tb-thiet-bi";

	}

	// Xoa thiet bi theo Ma thiet bi-01
	@RequestMapping(value = "thietbixoa", method = RequestMethod.GET)
	private String xoaThietBi(@RequestParam(name = "id", required = false) int thietBiId, TbChiTietNhapXuat danhsachtb,
			ModelMap model) {
		danhsachtb.setThietBiId(thietBiId);
		thietBiDAO.xoaThietBi(danhsachtb);
		return "redirect:/danhsachthietbi";
	}

	// Chon ma thiet bi sua-01
	@RequestMapping(value = "/thietbisua", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	private String layMaThietBiSua(@RequestParam(name = "id", required = false) int thietBiId,
			TbChiTietNhapXuat danhsachtb, Model model) {
		danhsachtb.setThietBiId(thietBiId);
		model.addAttribute("layMaThietBi", thietBiDAO.layThietBiId(thietBiId));
		model.addAttribute("danhsachthietbi", danhMucThietBiDAO.getAllDanhMucThietBi());
		model.addAttribute("danhsachnuoc", nuocSanXuatDAO.layDanhSachNuoc());
		return "tb-thiet-bi-sua";
	}

	// Sua-01
	@RequestMapping(value = "/danhsachtbsua", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	private String xacNhanSua(@ModelAttribute(name = "formSua") TbChiTietNhapXuat danhsachtb, BindingResult result,
			Model model) {
		thietBiDAO.suaThietBi(danhsachtb);
		return "redirect:/danhsachthietbi";
	}

	//Tim kiem thiet bi trong kho
		@RequestMapping(value = "/danhsachthietbitimkiem", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charset=UTF-8")
		public String timThietBiTrongKho(@RequestParam("chuoiTimKiem")String chuoiTimKiem ,@RequestParam("muc")String muc , Model model) {
			System.out.println("Chuoi nhap vao: "+ chuoiTimKiem);
			System.out.println("O muc: " + muc);
			List<TbChiTietNhapXuat> danhsach = thietBiDAO.timDanhSachThietBiTrongKho(chuoiTimKiem, muc);
			model.addAttribute("danhsach", danhsach);
			return "tb-thiet-bi";
		}
	
}