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

import org.springframework.format.annotation.DateTimeFormat;

/**
 * TAuthor Nguyen Pham
 */
@Entity
@Table(name = "tb_phieu_xuat", catalog = "thietbi")
public class TbPhieuXuat{

	private String maPhieuXuat;
	private TbKho tbKho;
	private TbNhanVien tbNhanVien;
	private Date ngayXuat;
	private String nguoiXuat;
	private int tongGiaTri;
	private Set<TbChiThietThietBiXuat> tbChiThietThietBiXuats = new HashSet<TbChiThietThietBiXuat>(0);
	private Set<TbLichSuNguoiQuanLy> tbLichSuNguoiQuanLies = new HashSet<TbLichSuNguoiQuanLy>(0);
	private Set<TbXuat> tbXuats = new HashSet<TbXuat>(0);

	public TbPhieuXuat() {
	}

	public TbPhieuXuat(String maPhieuXuat) {
		this.maPhieuXuat = maPhieuXuat;
	}

	public TbPhieuXuat(String maPhieuXuat, TbKho tbKho, TbNhanVien tbNhanVien, Date ngayXuat, String nguoiXuat,
			int tongGiaTri, Set<TbChiThietThietBiXuat> tbChiThietThietBiXuats,
			Set<TbLichSuNguoiQuanLy> tbLichSuNguoiQuanLies, Set<TbXuat> tbXuats) {
		this.maPhieuXuat = maPhieuXuat;
		this.tbKho = tbKho;
		this.tbNhanVien = tbNhanVien;
		this.ngayXuat = ngayXuat;
		this.nguoiXuat = nguoiXuat;
		this.tongGiaTri = tongGiaTri;
		this.tbChiThietThietBiXuats = tbChiThietThietBiXuats;
		this.tbLichSuNguoiQuanLies = tbLichSuNguoiQuanLies;
		this.tbXuats = tbXuats;
	}

	@Id

	@Column(name = "ma_phieu_xuat", unique = true, nullable = false, length = 15)
	public String getMaPhieuXuat() {
		return this.maPhieuXuat;
	}

	public void setMaPhieuXuat(String maPhieuXuat) {
		this.maPhieuXuat = maPhieuXuat;
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
	@Column(name = "ngay_xuat", length = 10)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	public Date getNgayXuat() {
		return this.ngayXuat;
	}

	public void setNgayXuat(Date ngayXuat) {
		this.ngayXuat = ngayXuat;
	}

	@Column(name = "nguoi_xuat", length = 30)
	public String getNguoiXuat() {
		return this.nguoiXuat;
	}

	public void setNguoiXuat(String nguoiXuat) {
		this.nguoiXuat = nguoiXuat;
	}

	@Column(name = "tong_gia_tri")
	public int getTongGiaTri() {
		return this.tongGiaTri;
	}

	public void setTongGiaTri(int tongGiaTri) {
		this.tongGiaTri = tongGiaTri;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tbPhieuXuat")
	public Set<TbChiThietThietBiXuat> getTbChiThietThietBiXuats() {
		return this.tbChiThietThietBiXuats;
	}

	public void setTbChiThietThietBiXuats(Set<TbChiThietThietBiXuat> tbChiThietThietBiXuats) {
		this.tbChiThietThietBiXuats = tbChiThietThietBiXuats;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tbPhieuXuat")
	public Set<TbLichSuNguoiQuanLy> getTbLichSuNguoiQuanLies() {
		return this.tbLichSuNguoiQuanLies;
	}

	public void setTbLichSuNguoiQuanLies(Set<TbLichSuNguoiQuanLy> tbLichSuNguoiQuanLies) {
		this.tbLichSuNguoiQuanLies = tbLichSuNguoiQuanLies;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tbPhieuXuat")
	public Set<TbXuat> getTbXuats() {
		return this.tbXuats;
	}

	public void setTbXuats(Set<TbXuat> tbXuats) {
		this.tbXuats = tbXuats;
	}

}
