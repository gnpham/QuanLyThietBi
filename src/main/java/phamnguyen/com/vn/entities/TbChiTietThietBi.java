package phamnguyen.com.vn.entities;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Author Pham Nguyen
 */
@Entity
@Table(name = "tb_chi_tiet_thiet_bi", catalog = "thietbi")
public class TbChiTietThietBi{

	private int id;
	private TbChiTietNhapXuat tbChiTietNhapXuat;
	private String maThietBi;
	private String tenThietBi;
	private String donViTinh;
	private int soLuong;
	private String hanBaoHanh;
	private String soHieuTscd;
	private String congXuat;
	private int nguyenGia;
	private String nuocSanXuat;
	private int khauHao;
	private String dacTinhKyThuat;
	private String maPhieuNhap;
	private String maPhieuXuat;
	private String maCode;

	public TbChiTietThietBi() {
	}

	public TbChiTietThietBi(TbChiTietNhapXuat tbChiTietNhapXuat, String maThietBi, String tenThietBi, String donViTinh,
			int soLuong, String hanBaoHanh, String soHieuTscd, String congXuat, int nguyenGia,
			String nuocSanXuat, int khauHao, String dacTinhKyThuat, String maPhieuNhap, String maPhieuXuat,
			String maCode) {
		this.tbChiTietNhapXuat = tbChiTietNhapXuat;
		this.maThietBi = maThietBi;
		this.tenThietBi = tenThietBi;
		this.donViTinh = donViTinh;
		this.soLuong = soLuong;
		this.hanBaoHanh = hanBaoHanh;
		this.soHieuTscd = soHieuTscd;
		this.congXuat = congXuat;
		this.nguyenGia = nguyenGia;
		this.nuocSanXuat = nuocSanXuat;
		this.khauHao = khauHao;
		this.dacTinhKyThuat = dacTinhKyThuat;
		this.maPhieuNhap = maPhieuNhap;
		this.maPhieuXuat = maPhieuXuat;
		this.maCode = maCode;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "thiet_bi_id")
	public TbChiTietNhapXuat getTbChiTietNhapXuat() {
		return this.tbChiTietNhapXuat;
	}

	public void setTbChiTietNhapXuat(TbChiTietNhapXuat tbChiTietNhapXuat) {
		this.tbChiTietNhapXuat = tbChiTietNhapXuat;
	}

	@Column(name = "ma_thiet_bi", length = 10)
	public String getMaThietBi() {
		return this.maThietBi;
	}

	public void setMaThietBi(String maThietBi) {
		this.maThietBi = maThietBi;
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

	@Column(name = "nuoc_san_xuat")
	public String getNuocSanXuat() {
		return this.nuocSanXuat;
	}

	public void setNuocSanXuat(String nuocSanXuat) {
		this.nuocSanXuat = nuocSanXuat;
	}

	@Column(name = "khau_hao")
	public int getKhauHao() {
		return this.khauHao;
	}

	public void setKhauHao(int khauHao) {
		this.khauHao = khauHao;
	}

	@Column(name = "dac_tinh_ky_thuat", length = 500)
	public String getDacTinhKyThuat() {
		return this.dacTinhKyThuat;
	}

	public void setDacTinhKyThuat(String dacTinhKyThuat) {
		this.dacTinhKyThuat = dacTinhKyThuat;
	}

	@Column(name = "ma_phieu_nhap", length = 15)
	public String getMaPhieuNhap() {
		return this.maPhieuNhap;
	}

	public void setMaPhieuNhap(String maPhieuNhap) {
		this.maPhieuNhap = maPhieuNhap;
	}

	@Column(name = "ma_phieu_xuat", length = 15)
	public String getMaPhieuXuat() {
		return this.maPhieuXuat;
	}

	public void setMaPhieuXuat(String maPhieuXuat) {
		this.maPhieuXuat = maPhieuXuat;
	}

	@Column(name = "ma_code", length = 30)
	public String getMaCode() {
		return this.maCode;
	}

	public void setMaCode(String maCode) {
		this.maCode = maCode;
	}

}
