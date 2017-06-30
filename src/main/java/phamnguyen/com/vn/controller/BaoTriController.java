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

import phamnguyen.com.vn.dao.BaoTriDAO;
import phamnguyen.com.vn.dao.NhanVienDAO;
import phamnguyen.com.vn.dao.TinhTrangThietBiDAO;
import phamnguyen.com.vn.dao.XuatDAO;
import phamnguyen.com.vn.entities.TbLichSuBaoTri;
import phamnguyen.com.vn.entities.TbLichSuNguoiQuanLy;
import phamnguyen.com.vn.entities.TbXuat;

@Controller
public class BaoTriController {

	@Autowired
	private BaoTriDAO baoTriDAO;

	@Autowired
	private TinhTrangThietBiDAO tinhTrangThietBiDAO;

	@Autowired
	private NhanVienDAO nhanVienDAO;

	@Autowired
	private XuatDAO xuatDAO;

	// LICH SU BAO TRI
	// Thong tin chi tiet thiet bi xuat - danh sach cac lan bao tri -01
	@RequestMapping(value = "/thietbibaotrils", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	private String layDanhSachLSbt(@RequestParam(name = "id", required = false) int xuatId, TbLichSuBaoTri danhsachbt,
			Model model) {
		// Thong tin thiet bi lay tu Id
		danhsachbt.setMaLsbt(xuatId);
		model.addAttribute("layMaXuat", baoTriDAO.layMaXuat(xuatId));
		// Danh sach cac lan bao tri theo ma xuat
		List<TbLichSuBaoTri> danhsachchitiet = baoTriDAO.layDanhSachBaoTri(xuatId);
		model.addAttribute("danhsachchitiet", danhsachchitiet);
		return "bt-chi-tiet-bao-tri";
	}

	// Xoa lan bao tri
	@RequestMapping(value = "/malanbaotrixoa", method = RequestMethod.GET)
	private String xoaLanBaoTri(@RequestParam(name = "id", required = false) int maLsbt, TbLichSuBaoTri lichsubaotri,
			ModelMap model) {
		lichsubaotri.setMaLsbt(maLsbt);
		baoTriDAO.xoaLanBaoTri(lichsubaotri);
		return "redirect:/danhsachxuatbaotri";
	}

	// Chon ma lan bao tri sua
	@RequestMapping(value = "/malanbaotrisua", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	private String layMaLanBaoTriSua(@RequestParam(name = "id", required = false) int maLsbt,
			TbLichSuBaoTri lichsubaotri, Model model) {
		lichsubaotri.setMaLsbt(maLsbt);
		model.addAttribute("danhsachtinhtrang", tinhTrangThietBiDAO.layTinhTrang());
		return "bt-bao-tri-sua";
	}

	// Sua
	@RequestMapping(value = "/baotrisua", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	private String xacNhanSua(@ModelAttribute(name = "formSua") TbLichSuBaoTri danhsachbt, BindingResult result,
			Model model) {
		baoTriDAO.suaLanBaoTri(danhsachbt);
		return "redirect:/danhsachxuatbaotri";
	}

	// Dua toi trang them lan bao tri bt-bao-tri-them
	@RequestMapping(value = "/chuyenthembaotri", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charest=UTF-8")
	private String chuyenThemBaoTri(@RequestParam(name = "id", required = false) int maXuat, Model model) {
		model.addAttribute("maXuatThemLSBT", baoTriDAO.layMaXuat(maXuat));
		model.addAttribute("formThem", new TbLichSuBaoTri());
		model.addAttribute("danhsachtinhtrang", tinhTrangThietBiDAO.layTinhTrang());
		model.addAttribute("danhsachkythuatvien", nhanVienDAO.layDanhSachKyThuatVien());
		return "bt-bao-tri-them";
	}

	// Xac nhan them lan bao tri
	@RequestMapping(value = "/themlanbaotri", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charest=UTF-8")
	public String themBaoTri(@ModelAttribute(name = "formThem") TbLichSuBaoTri danhsachbaotri, BindingResult result,
			Model model) {
		baoTriDAO.themLichSuBaoTri(danhsachbaotri);
		// Update tinh trang thiet bi xuat
		
		TbXuat tbXuat = xuatDAO.layMaXuat(danhsachbaotri.getTbXuat().getMaXuat());
//		String tt = baoTriDAO.layTinhTrangMoiNhat(danhsachbaotri.getTbXuat().getMaXuat());
		tbXuat.setTinhTrangThietBi((String)baoTriDAO.layTinhTrangMoiNhat(danhsachbaotri.getTbXuat().getMaXuat()));
		xuatDAO.suaXuat(tbXuat);
		return "redirect:/danhsachxuatbaotri"; 
	}

	// LICH SU NGUOI QUAN LY
	// Thong tin chi tiet thiet bi xuat - danh sach nguoi quan ly
	@RequestMapping(value = "/thietbinguoiquanlyls", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	private String layDanhSachNQL(@RequestParam(name = "id", required = false) int xuatId,
			TbLichSuNguoiQuanLy danhsachnql, Model model) {

		// Thong tin thiet bi lay tu Id
		danhsachnql.setMaLsnql(xuatId);
		model.addAttribute("layMaXuat", baoTriDAO.layMaXuat(xuatId));

		// Danh sach nguoi quan ly theo ma xuat
		List<TbLichSuNguoiQuanLy> danhsachnqlchitiet = baoTriDAO.layDanhSachNguoiQuanLy(xuatId);
		model.addAttribute("danhsachnqlchitiet", danhsachnqlchitiet);
		return "bt-chi-tiet-nguoi-quan-ly";
	}

	// Dua toi trang them lich su nguoi quan ly
	@RequestMapping(value = "/chuyenthemlichsunql", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charest=UTF-8")
	private String chuyenThemLichSuNQL(@RequestParam(name = "id", required = false) int maXuat, Model model) {
		model.addAttribute("maXuatThemLSNQL", baoTriDAO.layMaXuat(maXuat));
		model.addAttribute("formThem", new TbLichSuNguoiQuanLy());
		model.addAttribute("danhsachnguoidung", nhanVienDAO.layDanhSachNguoiDung());
		return "bt-lich-su-nguoi-them";
	}

	// Xac nhan thay doi nguoi quan ly
	@RequestMapping(value = "/themnguoiquanlyls", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charest=UTF-8")
	public String themLichSuNQL(@ModelAttribute(name = "formThem") TbLichSuNguoiQuanLy danhsachnql,
			BindingResult result, Model model) {
		baoTriDAO.themLichSuNQL(danhsachnql);

		// TbNhanVien tbNhanVien = nhanVienDAO
		// .layMaNhanVien(danhsachnql.getTbXuat().getTbPhieuXuat().getTbNhanVien().getMaNql());
		// tbNhanVien.setMaNql(danhsachnql.getMaNql());
		// nhanVienDAO.suaNhanVien(tbNhanVien);
		return "redirect:/danhsachxuatbaotri";
	}
}
