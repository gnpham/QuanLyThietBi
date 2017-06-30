package phamnguyen.com.vn.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
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
@Table(name = "tb_lich_su_nguoi_quan_ly", catalog = "thietbi")
public class TbLichSuNguoiQuanLy{

	private int maLsnql;
	private TbPhieuXuat tbPhieuXuat;
	private int maNql;
	private Date ngayBatDau;
	private Date ngayKetThuc;

	public TbLichSuNguoiQuanLy() {
	}

	public TbLichSuNguoiQuanLy(TbPhieuXuat tbPhieuXuat, int maNql, Date ngayBatDau, Date ngayKetThuc) {
		this.tbPhieuXuat = tbPhieuXuat;
		this.maNql = maNql;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ma_lsnql", unique = true, nullable = false)
	public int getMaLsnql() {
		return this.maLsnql;
	}

	public void setMaLsnql(int maLsnql) {
		this.maLsnql = maLsnql;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_phieu_xuat")
	public TbPhieuXuat getTbPhieuXuat() {
		return this.tbPhieuXuat;
	}

	public void setTbPhieuXuat(TbPhieuXuat tbPhieuXuat) {
		this.tbPhieuXuat = tbPhieuXuat;
	}

	@Column(name = "ma_nql")
	public int getMaNql() {
		return this.maNql;
	}

	public void setMaNql(int maNql) {
		this.maNql = maNql;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ngay_bat_dau", length = 10)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	public Date getNgayBatDau() {
		return this.ngayBatDau;
	}

	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ngay_ket_thuc", length = 10)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	public Date getNgayKetThuc() {
		return this.ngayKetThuc;
	}

	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

}
