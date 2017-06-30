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

import phamnguyen.com.vn.dao.PhieuXuatDAO;
import phamnguyen.com.vn.dao.ThietBiDAO;
import phamnguyen.com.vn.dao.XuatDAO;
import phamnguyen.com.vn.entities.TbChiTietNhapXuat;
import phamnguyen.com.vn.entities.TbPhieuXuat;
import phamnguyen.com.vn.entities.TbXuat;

@Controller
public class XuatController {
	@Autowired
	private XuatDAO xuatDAO;

	@Autowired
	private ThietBiDAO thietBiDAO;

	@Autowired
	private PhieuXuatDAO phieuXuatDAO;

	// Dua toi trang xuat
	@RequestMapping(value = "/chuyenxuatthietbi", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charest=UTF-8")
	private String them(@RequestParam(name = "id", required = false) String maPhieuXuat, Model model) {

		model.addAttribute("maPhieuXuatThemXuat", thietBiDAO.layMaPhieuXuat(maPhieuXuat));
		model.addAttribute("formThem", new TbXuat());
		model.addAttribute("danhsachthietbi", thietBiDAO.layDanhSachThietBi());
		model.addAttribute("danhsachphieuxuat", phieuXuatDAO.layDanhSachPhieuXuat());
		return "x-xuat-them";
	}

	// Xac nhan them lan xuat - xuat mot thiet bi khoi kho
	@RequestMapping(value = "/themxuat", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charest=UTF-8")
	public String themThietBiVaoPhieuXuat(@ModelAttribute(name = "formThem") TbXuat danhsachxuat, BindingResult result,
			Model model) {
		// Cap nhat so luong thiet bi con lai
		TbChiTietNhapXuat tbChiTietNhapXuat = thietBiDAO
				.layThietBiId(danhsachxuat.getTbChiTietNhapXuat().getThietBiId());
		if (tbChiTietNhapXuat.getSoLuong() - danhsachxuat.getSoLuongXuat() >= 0) {
			xuatDAO.themXuat(danhsachxuat);
			// Cap nhat lai so luong trong kho
			tbChiTietNhapXuat.setSoLuong(tbChiTietNhapXuat.getSoLuong() - danhsachxuat.getSoLuongXuat());
			thietBiDAO.suaThietBi(tbChiTietNhapXuat);

			// Cong don gia tri phieu xuat
			TbPhieuXuat tbPhieuXuat = phieuXuatDAO.layMaPhieuXuat(danhsachxuat.getTbPhieuXuat().getMaPhieuXuat());
			tbPhieuXuat.setTongGiaTri(tbPhieuXuat.getTongGiaTri()
					+ (tbChiTietNhapXuat.getNguyenGia() * danhsachxuat.getSoLuongXuat()));
			phieuXuatDAO.suaDanhSachPhieuXuat(tbPhieuXuat);
			return "redirect:/danhsachphieuxuat";
		} else {
			model.addAttribute("loi", "Số lượng thiết bị trong kho không đủ!");
			return "x-xuat-them";
		}
	}

	// Danh sach lan xuat - danh sach thiet bi - chuc nang bao tri
	@RequestMapping(value = "/danhsachxuatbaotri", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public String layThietBiXuat(Model model) {		
		List<TbXuat> danhsach = xuatDAO.layDanhSachXuat();
		model.addAttribute("danhsach", danhsach);
		return "bt-bao-tri";
	}
	
	 // Xoa thiet bi xuat
	 @RequestMapping(value = "/thietbixuatxoa", method = RequestMethod.GET)
	 private String xoaThietBiXuat(@RequestParam(name = "id", required = false)
	 int maXuat, TbXuat danhsachtbxuat,
	 ModelMap model) {
		 danhsachtbxuat.setMaXuat(maXuat);
	 xuatDAO.xoaLanXuat(danhsachtbxuat);
	 return "redirect:/danhsachxuatbaotri";
	 }

	// Tim kiem
	@RequestMapping(value = "/baotritimkiem", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public String timKiemDanhSachBaoTri(@RequestParam("chuoiTimKiem") String chuoiTimKiem,
			@RequestParam("muc") String muc, Model model) {
		System.out.println("Chuoi nhap vao: " + chuoiTimKiem);
		System.out.println("O muc: " + muc);
		List<TbXuat> danhsach = xuatDAO.timThietBiDaXuat(chuoiTimKiem, muc);
		model.addAttribute("danhsach", danhsach);
		return "bt-bao-tri";
	}
}
