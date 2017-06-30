package phamnguyen.com.vn.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * Author Pham Nguyen
 */
@Entity
@Table(name = "tb_phieu_nhap", catalog = "thietbi")
public class TbPhieuNhap{

	private String maPhieuNhap;
	private TbKho tbKho;
	private TbNhanVien tbNhanVien;
	private Date ngayNhap;
	private String nguoiGiao;
	private int tongGiaTri;
	private String nguonGoc;
	private String nguonGocTaiSan;
	private Set<TbChiTietNhapXuat> tbChiTietNhapXuats = new HashSet<TbChiTietNhapXuat>(0);

	public TbPhieuNhap() {
	}

	public TbPhieuNhap(String maPhieuNhap) {
		this.maPhieuNhap = maPhieuNhap;
	}

	public TbPhieuNhap(String maPhieuNhap, TbKho tbKho, TbNhanVien tbNhanVien, Date ngayNhap, String nguoiGiao,
			int tongGiaTri, String nguonGoc, String nguonGocTaiSan, Set<TbChiTietNhapXuat> tbChiTietNhapXuats) {
		this.maPhieuNhap = maPhieuNhap;
		this.tbKho = tbKho;
		this.tbNhanVien = tbNhanVien;
		this.ngayNhap = ngayNhap;
		this.nguoiGiao = nguoiGiao;
		this.tongGiaTri = tongGiaTri;
		this.nguonGoc = nguonGoc;
		this.nguonGocTaiSan = nguonGocTaiSan;
		this.tbChiTietNhapXuats = tbChiTietNhapXuats;
	}

	@Id

	@Column(name = "ma_phieu_nhap", unique = true, nullable = false, length = 15)
	public String getMaPhieuNhap() {
		return this.maPhieuNhap;
	}

	public void setMaPhieuNhap(String maPhieuNhap) {
		this.maPhieuNhap = maPhieuNhap;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_kho")
	public TbKho getTbKho() {
		return this.tbKho;
	}

	public void setTbKho(TbKho tbKho) {
		this.tbKho = tbKho;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_nql")
	public TbNhanVien getTbNhanVien() {
		return this.tbNhanVien;
	}

	public void setTbNhanVien(TbNhanVien tbNhanVien) {
		this.tbNhanVien = tbNhanVien;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ngay_nhap", length = 10)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	public Date getNgayNhap() {
		return this.ngayNhap;
	}

	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	@Column(name = "nguoi_giao", length = 30)
	public String getNguoiGiao() {
		return this.nguoiGiao;
	}

	public void setNguoiGiao(String nguoiGiao) {
		this.nguoiGiao = nguoiGiao;
	}

	@Column(name = "tong_gia_tri")
	public int getTongGiaTri() {
		return this.tongGiaTri;
	}

	public void setTongGiaTri(int tongGiaTri) {
		this.tongGiaTri = tongGiaTri;
	}

	@Column(name = "nguon_goc", length = 100)
	public String getNguonGoc() {
		return this.nguonGoc;
	}

	public void setNguonGoc(String nguonGoc) {
		this.nguonGoc = nguonGoc;
	}

	@Column(name = "nguon_goc_tai_san", length = 100)
	public String getNguonGocTaiSan() {
		return this.nguonGocTaiSan;
	}

	public void setNguonGocTaiSan(String nguonGocTaiSan) {
		this.nguonGocTaiSan = nguonGocTaiSan;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tbPhieuNhap")
	@Fetch(FetchMode.SELECT)
	public Set<TbChiTietNhapXuat> getTbChiTietNhapXuats() {
		return this.tbChiTietNhapXuats;
	}

	public void setTbChiTietNhapXuats(Set<TbChiTietNhapXuat> tbChiTietNhapXuats) {
		this.tbChiTietNhapXuats = tbChiTietNhapXuats;
	}

}
