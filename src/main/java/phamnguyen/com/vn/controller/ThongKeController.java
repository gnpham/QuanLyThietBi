package phamnguyen.com.vn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import phamnguyen.com.vn.dao.ThongKeDAO;
import phamnguyen.com.vn.entities.TbDonVi;
import phamnguyen.com.vn.entities.TbPhongThucHanh;
import phamnguyen.com.vn.entities.TbXuat;

@Controller
public class ThongKeController {
	@Autowired
	private ThongKeDAO thongKeDAO;
	
	// Danh sach phong thuc hanh
	@RequestMapping(value = "/thongketheophong", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public String layDanhSachPTH(Model model) {
		List<TbPhongThucHanh> danhsachpth = thongKeDAO.layDanhSachPTH();
		model.addAttribute("danhsachpth", danhsachpth);
		return "tk-phong-thuc-hanh";
	}

	// THIET BI XUAT
	// Thong tin phong thuc hanh- danh sach thiet bi theo ma phong thuc hanh
	@RequestMapping(value = "/maphongthuchanhtk", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	private String layMaThietBiTheoMaPTH(@RequestParam(name = "id", required = false) String maPth,
			TbPhongThucHanh danhsachpth, Model model) {

		// Thong tin phong thuc hanh lay tu Id
		danhsachpth.setMaPth(maPth);
		model.addAttribute("layMaPth", thongKeDAO.layMaPTH(maPth));

		// Danh sach cac thiet bi theo ma phong thuc hanh
		List<TbXuat> danhsachtbpth = thongKeDAO.layDanhSachXuatTheoPTH(maPth);
		model.addAttribute("danhsachtbpth", danhsachtbpth);
		return "tk-phong-thuc-hanh-chi-tiet";
	}

	//Danh sach khoa
	@RequestMapping(value = "/thongketheodonvi", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public String layDanhSachKhoa(Model model) {
		List<TbDonVi> danhsachkhoa = thongKeDAO.layDanhSachDonVi();
		model.addAttribute("danhsachkhoa", danhsachkhoa);
		return "tk-khoa";
	}
	
	// THIET BI XUAT
		// Thong tin khoa- danh sach thiet bi theo ma khoa
		@RequestMapping(value = "/makhoatk", method = RequestMethod.GET, produces = "application/x-www-form-urlencoded;charset=UTF-8")
		private String layMaThietBiTheoMaKhoa(@RequestParam(name = "id", required = false) int maKhoa,
				TbDonVi danhsachdonvi, Model model) {

			// Thong tin phong thuc hanh lay tu Id
			danhsachdonvi.setMaKhoa(maKhoa);
			model.addAttribute("layMaKhoa", thongKeDAO.layMaKhoa(maKhoa)); 

			// Danh sach cac thiet bi theo ma khoa
			List<TbXuat> danhsachtbkhoa = thongKeDAO.layDanhSachXuatTheoKhoa(maKhoa);
			model.addAttribute("danhsachtbkhoa", danhsachtbkhoa);
			return "tk-khoa-chi-tiet";
		}
}