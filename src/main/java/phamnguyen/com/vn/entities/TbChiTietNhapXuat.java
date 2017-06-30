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
 * Author Nguyen Pham
 */
@Entity
@Table(name = "tb_chi_tiet_nhap_xuat", catalog = "thietbi")
public class TbChiTietNhapXuat{

	private int thietBiId;
	private TbDanhMucThietBi tbDanhMucThietBi;
	private TbNuocSanXuat tbNuocSanXuat;
	private TbPhieuNhap tbPhieuNhap;
	private String tenThietBi;
	private String donViTinh;
	private int soLuong;
	private String hanBaoHanh;
	private String soHieuTscd;
	private String congXuat;
	private int nguyenGia;
	private String moTa;
	private int khauHao;
	private String maCode;
	private Set<TbChiTietThietBi> tbChiTietThietBis = new HashSet<TbChiTietThietBi>(0);
	private Set<TbXuat> tbXuats = new HashSet<TbXuat>(0);

	public TbChiTietNhapXuat() {
	}

	public TbChiTietNhapXuat(TbDanhMucThietBi tbDanhMucThietBi, TbNuocSanXuat tbNuocSanXuat, TbPhieuNhap tbPhieuNhap,
			String tenThietBi, String donViTinh, int soLuong, String hanBaoHanh, String soHieuTscd, String congXuat,
			int nguyenGia, String moTa, int khauHao, String maCode, Set<TbChiTietThietBi> tbChiTietThietBis,
			Set<TbXuat> tbXuats) {
		this.tbDanhMucThietBi = tbDanhMucThietBi;
		this.tbNuocSanXuat = tbNuocSanXuat;
		this.tbPhieuNhap = tbPhieuNhap;
		this.tenThietBi = tenThietBi;
		this.donViTinh = donViTinh;
		this.soLuong = soLuong;
		this.hanBaoHanh = hanBaoHanh;
		this.soHieuTscd = soHieuTscd;
		this.congXuat = congXuat;
		this.nguyenGia = nguyenGia;
		this.moTa = moTa;
		this.khauHao = khauHao;
		this.maCode = maCode;
		this.tbChiTietThietBis = tbChiTietThietBis;
		this.tbXuats = tbXuats;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "thiet_bi_id", unique = true, nullable = false)
	public int getThietBiId() {
		return this.thietBiId;
	}

	public void setThietBiId(int thietBiId) {
		this.thietBiId = thietBiId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_thiet_bi")
	public TbDanhMucThietBi getTbDanhMucThietBi() {
		return this.tbDanhMucThietBi;
	}

	public void setTbDanhMucThietBi(TbDanhMucThietBi tbDanhMucThietBi) {
		this.tbDanhMucThietBi = tbDanhMucThietBi;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_nuoc_san_xuat")
	public TbNuocSanXuat getTbNuocSanXuat() {
		return this.tbNuocSanXuat;
	}

	public void setTbNuocSanXuat(TbNuocSanXuat tbNuocSanXuat) {
		this.tbNuocSanXuat = tbNuocSanXuat;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_phieu_nhap")
	public TbPhieuNhap getTbPhieuNhap() {
		return this.tbPhieuNhap;
	}

	public void setTbPhieuNhap(TbPhieuNhap tbPhieuNhap) {
		this.tbPhieuNhap = tbPhieuNhap;
	}

	@Column(name = "ten_thiet_bi", length = 100)
	public String getTenThietBi() {
		return this.tenThietBi;
	}

	public void setTenThietBi(String tenThietBi) {
		this.tenThietBi = tenThietBi;
	}

	@Column(name = "don_vi_tinh", length = 10)
	public String getDonViTinh() {
		return this.donViTinh;
	}

	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}

	@Column(name = "so_luong")
	public int getSoLuong() {
		return this.soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Column(name = "han_bao_hanh", length = 20)
	public String getHanBaoHanh() {
		return this.hanBaoHanh;
	}

	public void setHanBaoHanh(String hanBaoHanh) {
		this.hanBaoHanh = hanBaoHanh;
	}

	@Column(name = "so_hieu_tscd", length = 20)
	public String getSoHieuTscd() {
		return this.soHieuTscd;
	}

	public void setSoHieuTscd(String soHieuTscd) {
		this.soHieuTscd = soHieuTscd;
	}

	@Column(name = "cong_xuat", length = 10)
	public String getCongXuat() {
		return this.congXuat;
	}

	public void setCongXuat(String congXuat) {
		this.congXuat = congXuat;
	}

	@Column(name = "nguyen_gia")
	public int getNguyenGia() {
		return this.nguyenGia;
	}

	public void setNguyenGia(int nguyenGia) {
		this.nguyenGia = nguyenGia;
	}

	@Column(name = "mo_ta", length = 500)
	public String getMoTa() {
		return this.moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	@Column(name = "khau_hao")
	public int getKhauHao() {
		return this.khauHao;
	}

	public void setKhauHao(int khauHao) {
		this.khauHao = khauHao;
	}

	@Column(name = "ma_code", length = 30)
	public String getMaCode() {
		return this.maCode;
	}

	public void setMaCode(String maCode) {
		this.maCode = maCode;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tbChiTietNhapXuat")
	@Fetch(FetchMode.SELECT)
	public Set<TbChiTietThietBi> getTbChiTietThietBis() {
		return this.tbChiTietThietBis;
	}

	public void setTbChiTietThietBis(Set<TbChiTietThietBi> tbChiTietThietBis) {
		this.tbChiTietThietBis = tbChiTietThietBis;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tbChiTietNhapXuat")
	@Fetch(FetchMode.SELECT)
	public Set<TbXuat> getTbXuats() {
		return this.tbXuats;
	}

	public void setTbXuats(Set<TbXuat> tbXuats) {
		this.tbXuats = tbXuats;
	}

}
