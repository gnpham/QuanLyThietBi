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
import phamnguyen.com.vn.dao.NhomThietBiDAO;
import phamnguyen.com.vn.entities.TbDanhMucChungLoai;

@Controller
public class DanhMucCLController {
	@Autowired
	private DanhMucChungLoaiDAO danhMucChungLoaiDAO;
	
	@Autowired
	private NhomThietBiDAO nhomThietBiDAO;
	
	// Danh sach chung loai
	@RequestMapping(value = "/danhmucchungloai", method = RequestMethod.GET,produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public String layDanhMucChungLoai(Model model) {
		List<TbDanhMucChungLoai> danhsach = danhMucChungLoaiDAO.layDanhSachChungLoai();
		model.addAttribute("danhsach", danhsach);
		return "cl-chung-loai";

	}

	// Xoa chung loai theo ma
	@RequestMapping(value = "danhmucclxoa", method = RequestMethod.GET)
	private String xoaChungLoai(@RequestParam(name = "id", required = false) int maChungLoai, TbDanhMucChungLoai danhmuccl,
			ModelMap model) {
		danhmuccl.setMaChungLoai(maChungLoai);
		danhMucChungLoaiDAO.xoaChungLoai(danhmuccl);
		return "redirect:/danhmucchungloai";
	}

	// Chon ma chung loai sua
	@RequestMapping(value = "/machungloaisua", method = RequestMethod.GET,produces = "application/x-www-form-urlencoded;charset=UTF-8")
	private String layMaChungLoaiSua(@RequestParam(name = "id", required = false) int maChungLoai,
			TbDanhMucChungLoai danhmuccl, Model model) {
		danhmuccl.setMaChungLoai(maChungLoai);
		model.addAttribute("layMaChungLoai",danhMucChungLoaiDAO.layMaChungLoai(maChungLoai));
		model.addAttribute("danhsachnhomthietbi",nhomThietBiDAO.layDanhSachNhomThietBi());
		model.addAttribute("danhsachnhomtb");
		return "cl-chung-loai-sua";
	}
	
	// Sua chung loai 
	@RequestMapping(value = "/danhmucclsua", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	private String xacNhanSua(@ModelAttribute(name = "formSua") TbDanhMucChungLoai danhmuccl, BindingResult result, Model model) {
		danhMucChungLoaiDAO.suaChungLoai(danhmuccl);
		return  "redirect:/danhmucchungloai";
	}
	
	//Dua toi trang them
	@RequestMapping(value = "/chuyendmclthem", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charest=UTF-8")
	private String them(Model model) {
		model.addAttribute("formThem", new TbDanhMucChungLoai());
		model.addAttribute("danhsachnhomthietbi",nhomThietBiDAO.layDanhSachNhomThietBi());
		return "cl-chung-loai-them";
	}
	
	//Xac nhan them	
	@RequestMapping(value = "/danhmucclthem", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charest=UTF-8")
	public String themChungLoai(@ModelAttribute(name="formThem") TbDanhMucChungLoai danhmucchungloai,
			BindingResult result, Model model) {
		danhMucChungLoaiDAO.themChungLoai(danhmucchungloai);
		return"redirect:/danhmucchungloai";
	}
	
	//Tim kiem
	@RequestMapping(value = "danhmuccltimkiem", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public String timKiemDanhMucChungLoai(@RequestParam("chuoiTimKiem")String chuoiTimKiem ,@RequestParam("muc")String muc , Model model) {
		System.out.println("Chuoi nhap vao: "+ chuoiTimKiem);
		System.out.println("O muc: " + muc);
		List<TbDanhMucChungLoai> danhsach = danhMucChungLoaiDAO.timChungLoai(chuoiTimKiem, muc);
		model.addAttribute("danhsach", danhsach);
		return "cl-chung-loai";
	}

}
