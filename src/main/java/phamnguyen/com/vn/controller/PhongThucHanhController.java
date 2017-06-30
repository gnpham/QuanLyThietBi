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

import phamnguyen.com.vn.dao.NhanVienDAO;
import phamnguyen.com.vn.dao.PhongThucHanhDAO;
import phamnguyen.com.vn.entities.TbPhongThucHanh;

@Controller
public class PhongThucHanhController {
	@Autowired
	private PhongThucHanhDAO phongThucHanhDAO;

	@Autowired
	private NhanVienDAO nhanVienDAO;
	
	// Danh sach PTH
	@RequestMapping(value = "/danhsachpth", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charset=UTF-8") 
	public String layDanhSachPTH(Model model) {
		List<TbPhongThucHanh> danhsach = phongThucHanhDAO.layDanhSachPhongThucHanh();
		model.addAttribute("danhsach", danhsach);
		return "pth-danh-sach";
	}

	// Xoa phong thuc hanh theo ma
	@RequestMapping(value = "mapthxoa", method = RequestMethod.GET)
	private String xoaPhongThucHanh(@RequestParam(name = "id", required = false) String maPth,
			TbPhongThucHanh danhsachpth, ModelMap model) {
		danhsachpth.setMaPth(maPth);
		phongThucHanhDAO.xoaPhongThucHanh(danhsachpth);
		return "redirect:/danhsachpth";
	}

	// Chon ma pth sua
	@RequestMapping(value = "/mapthsua", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	private String layMaThietBiSua(@RequestParam(name = "id", required = false) String maPth,
			TbPhongThucHanh danhsachpth, Model model) {
		danhsachpth.setMaPth(maPth);
		model.addAttribute("layMaPhongThucHanh", phongThucHanhDAO.layMaPhongThucHanh(maPth));
		model.addAttribute("danhSachNhanVien", nhanVienDAO.layDanhSachNhanVien());
		return "pth-sua";
	}

	// Sua
	@RequestMapping(value = "/phongthuchanhsua", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	private String xacNhanSua(@ModelAttribute(name = "formSua") TbPhongThucHanh danhsachpth, BindingResult result,
			Model model) {
		phongThucHanhDAO.suaPhongThucHanh(danhsachpth);
		return "redirect:/danhsachpth";
	}

	// Dua toi trang them
	@RequestMapping(value = "/chuyenpththem", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charest=UTF-8")
	private String them(Model model) {
		model.addAttribute("formThem", new TbPhongThucHanh());
		model.addAttribute("danhSachNhanVien", nhanVienDAO.layDanhSachNhanVien());
		return "pth-them";
	}

	// Xac nhan them
	@RequestMapping(value = "/pththem", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charest=UTF-8")
	public String themPhongThucHanh(@ModelAttribute(name = "formThem") TbPhongThucHanh danhsachpth,
			BindingResult result, Model model) {
		phongThucHanhDAO.themPhongThucHanh(danhsachpth);
		return "redirect:/danhsachpth";
	}

	// Tim kiem
	@RequestMapping(value = "danhsachpthtimkiem", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public String timKiemDanhMucThietBi(@RequestParam("chuoiTimKiem") String chuoiTimKiem,
			@RequestParam("muc") String muc, Model model) {
		System.out.println("Chuoi nhap vao: " + chuoiTimKiem);
		System.out.println("O muc: " + muc);
		List<TbPhongThucHanh> danhsach = phongThucHanhDAO.timPhongThucHanh(chuoiTimKiem, muc);
		model.addAttribute("danhsach", danhsach);
		return "pth-danh-sach";
	}

}
