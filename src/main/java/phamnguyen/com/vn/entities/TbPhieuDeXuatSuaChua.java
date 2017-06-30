package phamnguyen.com.vn.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Author Nguyen Pham
 */
@Entity
@Table(name = "tb_phieu_de_xuat_sua_chua", catalog = "thietbi")
public class TbPhieuDeXuatSuaChua{

	private String maPhieuDeXuat;
	private TbLichSuBaoTri tbLichSuBaoTri;
	private String nguoiDeXuat;
	private Date ngayDeXuat;
	private String noiDungDeXuat;
	private Boolean daXacNhan;

	public TbPhieuDeXuatSuaChua() {
	}

	public TbPhieuDeXuatSuaChua(String maPhieuDeXuat) {
		this.maPhieuDeXuat = maPhieuDeXuat;
	}

	public TbPhieuDeXuatSuaChua(String maPhieuDeXuat, TbLichSuBaoTri tbLichSuBaoTri, String nguoiDeXuat,
			Date ngayDeXuat, String noiDungDeXuat, Boolean daXacNhan) {
		this.maPhieuDeXuat = maPhieuDeXuat;
		this.tbLichSuBaoTri = tbLichSuBaoTri;
		this.nguoiDeXuat = nguoiDeXuat;
		this.ngayDeXuat = ngayDeXuat;
		this.noiDungDeXuat = noiDungDeXuat;
		this.daXacNhan = daXacNhan;
	}

	@Id

	@Column(name = "ma_phieu_de_xuat", unique = true, nullable = false, length = 15)
	public String getMaPhieuDeXuat() {
		return this.maPhieuDeXuat;
	}

	public void setMaPhieuDeXuat(String maPhieuDeXuat) {
		this.maPhieuDeXuat = maPhieuDeXuat;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_lsbt")
	public TbLichSuBaoTri getTbLichSuBaoTri() {
		return this.tbLichSuBaoTri;
	}

	public void setTbLichSuBaoTri(TbLichSuBaoTri tbLichSuBaoTri) {
		this.tbLichSuBaoTri = tbLichSuBaoTri;
	}

	@Column(name = "nguoi_de_xuat", length = 20)
	public String getNguoiDeXuat() {
		return this.nguoiDeXuat;
	}

	public void setNguoiDeXuat(String nguoiDeXuat) {
		this.nguoiDeXuat = nguoiDeXuat;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ngay_de_xuat", length = 10)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	public Date getNgayDeXuat() {
		return this.ngayDeXuat;
	}

	public void setNgayDeXuat(Date ngayDeXuat) {
		this.ngayDeXuat = ngayDeXuat;
	}

	@Column(name = "noi_dung_de_xuat", length = 200)
	public String getNoiDungDeXuat() {
		return this.noiDungDeXuat;
	}

	public void setNoiDungDeXuat(String noiDungDeXuat) {
		this.noiDungDeXuat = noiDungDeXuat;
	}

	@Column(name = "da_xac_nhan")
	public Boolean getDaXacNhan() {
		return this.daXacNhan;
	}

	public void setDaXacNhan(Boolean daXacNhan) {
		this.daXacNhan = daXacNhan;
	}

}
