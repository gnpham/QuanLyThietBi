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

import phamnguyen.com.vn.dao.PhongBanDAO;
import phamnguyen.com.vn.entities.TbPhongBan;

@Controller
public class PhongBanController {
	@Autowired
	private PhongBanDAO phongBanDAO;

	// Danh sach phong ban
	@RequestMapping(value = "/danhmucphongban", method = RequestMethod.GET,produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public String danhSachPhongBan(Model model) {
		List<TbPhongBan> danhsach = phongBanDAO.layDanhSachPhongBan();
		model.addAttribute("danhsach", danhsach);
		return "pb-phong-ban";

	}

	// Xoa phong ban theo ma
	@RequestMapping(value = "/maphongbanxoa", method = RequestMethod.GET)
	private String xoaPhongBan(@RequestParam(name = "id", required = false) int maPhongBan, TbPhongBan danhmucpb,
			ModelMap model) {
		danhmucpb.setMaPhongBan(maPhongBan);
		phongBanDAO.xoaPhongBan(danhmucpb);
		return "redirect:/danhmucphongban";
	}

	// Chon ma phong ban sua
	@RequestMapping(value = "/maphongbansua", method = RequestMethod.GET,produces = "application/x-www-form-urlencoded;charset=UTF-8")
	private String layMaPhongBanSua(@RequestParam(name = "id", required = false) int maPhongBan,
			TbPhongBan danhmucpb, Model model) {
		danhmucpb.setMaPhongBan(maPhongBan);
		model.addAttribute("layMaPhongBan",phongBanDAO.layMaPhongBan(maPhongBan));
		return "pb-phong-ban-sua";
	}
	
	// Sua phong ban
	@RequestMapping(value = "/danhmucpbsua", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	private String xacNhanSua(@ModelAttribute(name = "formSua") TbPhongBan danhmucpb, BindingResult result, Model model) {
		phongBanDAO.suaPhongBan(danhmucpb);
		return  "redirect:/danhmucphongban";
	}
	
	//Dua toi trang them
	@RequestMapping(value = "/chuyenphongbanthem", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charest=UTF-8")
	private String them(Model model) {
		model.addAttribute("formThem", new TbPhongBan());
		return "pb-phong-ban-them";
	}
	
	//Xac nhan them	
	@RequestMapping(value = "/danhmucphongbanthem", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charest=UTF-8")
	public String themPhongBan(@ModelAttribute(name="formThem") TbPhongBan danhmucphongban,
			BindingResult result, Model model) {
		phongBanDAO.themPhongBan(danhmucphongban);
		return"redirect:/danhmucphongban";
	}
	
	//Tim kiem
	@RequestMapping(value = "danhmucpbtimkiem", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public String timKiemDanhMucPhongBan(@RequestParam("chuoiTimKiem")String chuoiTimKiem ,@RequestParam("muc")String muc , Model model) {
		System.out.println("Chuoi nhap vao: "+ chuoiTimKiem);
		System.out.println("O muc: " + muc);
		List<TbPhongBan> danhsach = phongBanDAO.timPhongBan(chuoiTimKiem, muc);
		model.addAttribute("danhsach", danhsach);
		return "pb-phong-ban";
	}

}
