package phamnguyen.com.vn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import phamnguyen.com.vn.dao.BaoTriDAO;
import phamnguyen.com.vn.dao.NhanVienDAO;
import phamnguyen.com.vn.entities.TbPhieuDeXuatSuaChua;

@Controller
public class PhieuSuaChuaController {

	@Autowired
	private BaoTriDAO baoTriDAO;

	@Autowired
	private NhanVienDAO nhanVienDAO;

	// LICH SU BAO TRI
	// Thong tin chi tiet thiet bi xuat - danh sach cac lan bao tri -01
//	@RequestMapping(value = "/thietbibaotrils", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charset=UTF-8")
//	private String layDanhSachLSBT(@RequestParam(name = "id", required = false) int xuatId, TbLichSuBaoTri danhsachbt,
//			Model model) {
//
//		// Thong tin thiet bi lay tu Id
//		danhsachbt.setMaLsbt(xuatId);
//		model.addAttribute("layMaXuat", baoTriDAO.layMaXuat(xuatId));
//
//		// Danh sach cac lan bao tri theo ma xuat
//		List<TbLichSuBaoTri> danhsachchitiet = baoTriDAO.layDanhSachBaoTri(xuatId);
//		model.addAttribute("danhsachchitiet", danhsachchitiet);
//		return "bt-chi-tiet-bao-tri";
//	}

	// Dua toi trang them phieu de xuat sua chua psc-phieu-sua-chua-them
	@RequestMapping(value = "/baotridexuatsuachua", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charest=UTF-8")
	private String chuyenThemBaoTri(@RequestParam(name = "id", required = false) int maLsbt, Model model) {
		model.addAttribute("maLSBT", baoTriDAO.layMaLanBaoTri(maLsbt));
		model.addAttribute("formThem", new TbPhieuDeXuatSuaChua());
		model.addAttribute("danhsachkythuatvien", nhanVienDAO.layDanhSachKyThuatVien());
		return "psc-phieu-sua-chua-them";
	}

	// Xac nhan them phieu de xuat
	@RequestMapping(value = "/themphieudexuatsuachua", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charest=UTF-8")
	public String themBaoTri(@ModelAttribute(name = "formThem") TbPhieuDeXuatSuaChua danhsachphieusuachua, BindingResult result,
			Model model) {
//		baoTriDAO.themLichSuBaoTri(danhsachphieusuachua);
		return "redirect:/danhsachxuatbaotri";
	}
}