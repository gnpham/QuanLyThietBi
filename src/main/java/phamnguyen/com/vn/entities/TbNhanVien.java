package phamnguyen.com.vn.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Author Pham Nguyen
 */
@Entity
@Table(name = "tb_nhan_vien", catalog = "thietbi")
public class TbNhanVien{

	private int maNql;
	private TbDonVi tbDonVi;
	private TbPhongBan tbPhongBan;
	private TbPhongThucHanh tbPhongThucHanh;
	private TbQuyenTruyCap tbQuyenTruyCap;
	private String hoTen;
	private String gioiTinh;
	private String diaChi;
	private String soDienThoai;
	private String email;
	private String chucVu;
	private String tenDangNhap;
	private String matKhau;
	private Set<TbPhieuXuat> tbPhieuXuats = new HashSet<TbPhieuXuat>(0);

	public TbNhanVien() {
	}

	public TbNhanVien(TbDonVi tbDonVi, TbPhongBan tbPhongBan, TbPhongThucHanh tbPhongThucHanh,
			TbQuyenTruyCap tbQuyenTruyCap, String hoTen, String gioiTinh, String diaChi, String soDienThoai,
			String email, String chucVu, String tenDangNhap, String matKhau, Set<TbPhieuXuat> tbPhieuXuats) {
		this.tbDonVi = tbDonVi;
		this.tbPhongBan = tbPhongBan;
		this.tbPhongThucHanh = tbPhongThucHanh;
		this.tbQuyenTruyCap = tbQuyenTruyCap;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.chucVu = chucVu;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.tbPhieuXuats = tbPhieuXuats;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ma_nql", unique = true, nullable = false)
	public int getMaNql() {
		return this.maNql;
	}

	public void setMaNql(int maNql) {
		this.maNql = maNql;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_khoa")
	public TbDonVi getTbDonVi() {
		return this.tbDonVi;
	}

	public void setTbDonVi(TbDonVi tbDonVi) {
		this.tbDonVi = tbDonVi;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_phong_ban")
	public TbPhongBan getTbPhongBan() {
		return this.tbPhongBan;
	}

	public void setTbPhongBan(TbPhongBan tbPhongBan) {
		this.tbPhongBan = tbPhongBan;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_pth")
	public TbPhongThucHanh getTbPhongThucHanh() {
		return this.tbPhongThucHanh;
	}

	public void setTbPhongThucHanh(TbPhongThucHanh tbPhongThucHanh) {
		this.tbPhongThucHanh = tbPhongThucHanh;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_qtc")
	public TbQuyenTruyCap getTbQuyenTruyCap() {
		return this.tbQuyenTruyCap;
	}

	public void setTbQuyenTruyCap(TbQuyenTruyCap tbQuyenTruyCap) {
		this.tbQuyenTruyCap = tbQuyenTruyCap;
	}

	@Column(name = "ho_ten", length = 20)
	public String getHoTen() {
		return this.hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	@Column(name = "gioi_tinh", length = 5)
	public String getGioiTinh() {
		return this.gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	@Column(name = "dia_chi", length = 50)
	public String getDiaChi() {
		return this.diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	@Column(name = "so_dien_thoai", length = 15)
	public String getSoDienThoai() {
		return this.soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	@Column(name = "email", length = 20)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "chuc_vu", length = 50)
	public String getChucVu() {
		return this.chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	@Column(name = "ten_dang_nhap", length = 36)
	public String getTenDangNhap() {
		return this.tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	@Column(name = "mat_khau", length = 36)
	public String getMatKhau() {
		return this.matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tbNhanVien")
	@Fetch(FetchMode.SELECT)
	public Set<TbPhieuXuat> getTbPhieuXuats() {
		return this.tbPhieuXuats;
	}

	public void setTbPhieuXuats(Set<TbPhieuXuat> tbPhieuXuats) {
		this.tbPhieuXuats = tbPhieuXuats;
	}

}
