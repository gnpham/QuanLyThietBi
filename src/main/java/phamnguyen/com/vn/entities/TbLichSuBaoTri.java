package phamnguyen.com.vn.entities;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Author Nguyen Pham
 */
@Entity
@Table(name = "tb_lich_su_bao_tri", catalog = "thietbi")
public class TbLichSuBaoTri{

	private int maLsbt;
	private TbTinhTrangThietBi tbTinhTrangThietBi;
	private TbXuat tbXuat;
	private Date ngayBaoTri;
	private String nguoiBaoTri;
	private String chiTietTinhTrang;
	private String noiDungBaoTri;
	private int chiPhi;
	private Set<TbPhieuDeXuatSuaChua> tbPhieuDeXuatSuaChuas = new HashSet<TbPhieuDeXuatSuaChua>(0);

	public TbLichSuBaoTri() {
	}

	public TbLichSuBaoTri(TbTinhTrangThietBi tbTinhTrangThietBi, TbXuat tbXuat, Date ngayBaoTri, String nguoiBaoTri,
			String chiTietTinhTrang, String noiDungBaoTri, int chiPhi,
			Set<TbPhieuDeXuatSuaChua> tbPhieuDeXuatSuaChuas) {
		this.tbTinhTrangThietBi = tbTinhTrangThietBi;
		this.tbXuat = tbXuat;
		this.ngayBaoTri = ngayBaoTri;
		this.nguoiBaoTri = nguoiBaoTri;
		this.chiTietTinhTrang = chiTietTinhTrang;
		this.noiDungBaoTri = noiDungBaoTri;
		this.chiPhi = chiPhi;
		this.tbPhieuDeXuatSuaChuas = tbPhieuDeXuatSuaChuas;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ma_lsbt", unique = true, nullable = false)
	public int getMaLsbt() {
		return this.maLsbt;
	}

	public void setMaLsbt(int maLsbt) {
		this.maLsbt = maLsbt;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_tinh_trang")
	public TbTinhTrangThietBi getTbTinhTrangThietBi() {
		return this.tbTinhTrangThietBi;
	}

	public void setTbTinhTrangThietBi(TbTinhTrangThietBi tbTinhTrangThietBi) {
		this.tbTinhTrangThietBi = tbTinhTrangThietBi;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_xuat")
	public TbXuat getTbXuat() {
		return this.tbXuat;
	}

	public void setTbXuat(TbXuat tbXuat) {
		this.tbXuat = tbXuat;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ngay_bao_tri", length = 10)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	public Date getNgayBaoTri() {
		return this.ngayBaoTri;
	}

	public void setNgayBaoTri(Date ngayBaoTri) {
		this.ngayBaoTri = ngayBaoTri;
	}

	@Column(name = "nguoi_bao_tri", length = 20)
	public String getNguoiBaoTri() {
		return this.nguoiBaoTri;
	}

	public void setNguoiBaoTri(String nguoiBaoTri) {
		this.nguoiBaoTri = nguoiBaoTri;
	}

	@Column(name = "chi_tiet_tinh_trang", length = 200)
	public String getChiTietTinhTrang() {
		return this.chiTietTinhTrang;
	}

	public void setChiTietTinhTrang(String chiTietTinhTrang) {
		this.chiTietTinhTrang = chiTietTinhTrang;
	}

	@Column(name = "noi_dung_bao_tri", length = 100)
	public String getNoiDungBaoTri() {
		return this.noiDungBaoTri;
	}

	public void setNoiDungBaoTri(String noiDungBaoTri) {
		this.noiDungBaoTri = noiDungBaoTri;
	}

	@Column(name = "chi_phi")
	public int getChiPhi() {
		return this.chiPhi;
	}

	public void setChiPhi(int chiPhi) {
		this.chiPhi = chiPhi;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tbLichSuBaoTri")
	@Fetch(FetchMode.SELECT)
	public Set<TbPhieuDeXuatSuaChua> getTbPhieuDeXuatSuaChuas() {
		return this.tbPhieuDeXuatSuaChuas;
	}

	public void setTbPhieuDeXuatSuaChuas(Set<TbPhieuDeXuatSuaChua> tbPhieuDeXuatSuaChuas) {
		this.tbPhieuDeXuatSuaChuas = tbPhieuDeXuatSuaChuas;
	}

}
