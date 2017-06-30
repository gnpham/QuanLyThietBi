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
import phamnguyen.com.vn.entities.TbDonVi;

@Controller
public class DonViController {
	@Autowired
	private DonViDAO donViDAO;
	
	// Danh sach don vi
	@RequestMapping(value = "/danhsachdonvi", method = RequestMethod.GET,produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public String layDanhSachDonVi(Model model) {
		List<TbDonVi> danhsach = donViDAO.layDanhSachDonVi();
		model.addAttribute("danhsach", danhsach);
		return "dv-danh-sach";

	}

	// Xoa don vi
	@RequestMapping(value = "madonvixoa", method = RequestMethod.GET)
	private String xoaDonVi(@RequestParam(name = "id", required = false) int maKhoa, TbDonVi danhsachdv,
			ModelMap model) {
		danhsachdv.setMaKhoa(maKhoa);
		donViDAO.xoaDonVi(danhsachdv);
		return "redirect:/danhsachdonvi";
	}

	// Chon ma don vi
	@RequestMapping(value = "/madonvisua", method = RequestMethod.GET,produces = "application/x-www-form-urlencoded;charset=UTF-8")
	private String layMaDonVi(@RequestParam(name = "id", required = false) int maKhoa,
			TbDonVi danhsachdv, Model model) {
		danhsachdv.setMaKhoa(maKhoa);
		model.addAttribute("layMaDonVi",donViDAO.layMaDonVi(maKhoa));
		return "dv-sua";
	}
	
	// Sua 
	@RequestMapping(value = "/danhsachdvsua", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	private String xacNhanSua(@ModelAttribute(name = "formSua") TbDonVi danhsachdv, BindingResult result, Model model) {
		donViDAO.suaDonVi(danhsachdv);
		return  "redirect:/danhsachdonvi";
	}
	
	//Dua toi trang them
	@RequestMapping(value = "/chuyendvthem", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charest=UTF-8")
	private String them(Model model) {
		model.addAttribute("formThem", new TbDonVi());
		return "dv-them";
	}
	
	//Xac nhan them	
	@RequestMapping(value = "/danhsachdvthem", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charest=UTF-8")
	public String themDonVi(@ModelAttribute(name="formThem") TbDonVi danhsachdv,
			BindingResult result, Model model) {
		donViDAO.themDonVi(danhsachdv);
		return"redirect:/danhsachdonvi";
	}
	
	//Tim kiem
	@RequestMapping(value = "danhsachdvtimkiem", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public String timKiemDonVi(@RequestParam("chuoiTimKiem")String chuoiTimKiem ,@RequestParam("muc")String muc , Model model) {
		System.out.println("Chuoi nhap vao: "+ chuoiTimKiem);
		System.out.println("O muc: " + muc);
		List<TbDonVi> danhsach = donViDAO.timDonVi(chuoiTimKiem, muc);
		model.addAttribute("danhsach", danhsach);
		return "dv-danh-sach";
	}

}
