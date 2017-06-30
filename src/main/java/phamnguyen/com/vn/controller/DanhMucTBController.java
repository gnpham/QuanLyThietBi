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

import phamnguyen.com.vn.dao.DanhMucChungLoaiDAO;
import phamnguyen.com.vn.dao.DanhMucThietBiDAO;
import phamnguyen.com.vn.entities.TbDanhMucThietBi;

@Controller
public class DanhMucTBController {
	@Autowired
	private DanhMucThietBiDAO danhMucThietBiDAO;
	
	@Autowired
	private DanhMucChungLoaiDAO danhMucChungLoaiDAO;

	// Danh sach thiet bi
	@RequestMapping(value = "/danhmucthietbi", method = RequestMethod.GET,produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public String layDanhMucThietBi(Model model) {
		List<TbDanhMucThietBi> danhsach = danhMucThietBiDAO.getAllDanhMucThietBi();
		model.addAttribute("danhsach", danhsach);
		return "dm-thiet-bi";

	}

	// Xoa thiet bi theo Ma thiet bi
	@RequestMapping(value = "/danhmuctbxoa", method = RequestMethod.GET)
	private String xoaThietBi(@RequestParam(name = "id", required = false) String maThietBi, TbDanhMucThietBi danhmuctb,
			ModelMap model) {
		danhmuctb.setMaThietBi(maThietBi);
		danhMucThietBiDAO.xoaDanhMucThietBi(danhmuctb);
		return "redirect:/danhmucthietbi";
	}

	// Chon ma thiet bi sua
	@RequestMapping(value = "/mathietbisua", method = RequestMethod.GET,produces = "application/x-www-form-urlencoded;charset=UTF-8")
	private String layMaThietBiSua(@RequestParam(name = "id", required = false) String maThietBi,
			TbDanhMucThietBi danhmuctb, Model model) {
		danhmuctb.setMaThietBi(maThietBi);
		model.addAttribute("layMaThietBi",danhMucThietBiDAO.layMaDanhMucThietBi(maThietBi));
		model.addAttribute("danhsachchungloai", danhMucChungLoaiDAO.layDanhSachChungLoai());
		return "dm-thiet-bi-sua";
	}
	
	// Sua 
	@RequestMapping(value = "/danhmuctbsua", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	private String xacNhanSua(@ModelAttribute(name = "formSua") TbDanhMucThietBi danhmuctb, BindingResult result, Model model) {
		danhMucThietBiDAO.suaDanhMucThietBi(danhmuctb);
		return  "redirect:/danhmucthietbi";
	}
	
	//Dua toi trang them
	@RequestMapping(value = "/chuyendmtbthem", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charest=UTF-8")
	private String them(Model model) {
		model.addAttribute("formThem", new TbDanhMucThietBi());
		model.addAttribute("danhsachchungloai", danhMucChungLoaiDAO.layDanhSachChungLoai());
		return "dm-thiet-bi-them";
	}
	
	//Xac nhan them	
	@RequestMapping(value = "/danhmuctbthem", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charest=UTF-8")
	public String themDanhMucThietBi(@ModelAttribute(name="formThem") TbDanhMucThietBi danhmucthietbi,
			BindingResult result, Model model) {
		danhMucThietBiDAO.themDanhMucThietBi(danhmucthietbi);
		return"redirect:/danhmucthietbi";
	}
	
	//Tim kiem
	@RequestMapping(value = "/danhmuctbtimkiem", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public String timKiemDanhMucThietBi(@RequestParam("chuoiTimKiem")String chuoiTimKiem ,@RequestParam("muc")String muc , Model model) {
		System.out.println("Chuoi nhap vao: "+ chuoiTimKiem);
		System.out.println("O muc: " + muc);
		List<TbDanhMucThietBi> danhsach = danhMucThietBiDAO.timDanhMucThietBi(chuoiTimKiem, muc);
		model.addAttribute("danhsach", danhsach);
		return "dm-thiet-bi";
	}

}
