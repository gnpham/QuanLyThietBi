package phamnguyen.com.vn.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Author Nguyen Pham
 */
@Entity
@Table(name = "tb_chi_thiet_thiet_bi_xuat", catalog = "thietbi")
public class TbChiThietThietBiXuat {

	private String maCtpx;
	private TbPhieuXuat tbPhieuXuat;
	private String maQr;
	private int maTinhTrang;

	public TbChiThietThietBiXuat() {
	}

	public TbChiThietThietBiXuat(String maCtpx) {
		this.maCtpx = maCtpx;
	}

	public TbChiThietThietBiXuat(String maCtpx, TbPhieuXuat tbPhieuXuat, String maQr, int maTinhTrang) {
		this.maCtpx = maCtpx;
		this.tbPhieuXuat = tbPhieuXuat;
		this.maQr = maQr;
		this.maTinhTrang = maTinhTrang;
	}

	@Id

	@Column(name = "ma_ctpx", unique = true, nullable = false, length = 10)
	public String getMaCtpx() {
		return this.maCtpx;
	}

	public void setMaCtpx(String maCtpx) {
		this.maCtpx = maCtpx;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_phieu_xuat")
	public TbPhieuXuat getTbPhieuXuat() {
		return this.tbPhieuXuat;
	}

	public void setTbPhieuXuat(TbPhieuXuat tbPhieuXuat) {
		this.tbPhieuXuat = tbPhieuXuat;
	}

	@Column(name = "ma_qr", length = 20)
	public String getMaQr() {
		return this.maQr;
	}

	public void setMaQr(String maQr) {
		this.maQr = maQr;
	}

	@Column(name = "ma_tinh_trang")
	public int getMaTinhTrang() {
		return this.maTinhTrang;
	}

	public void setMaTinhTrang(int maTinhTrang) {
		this.maTinhTrang = maTinhTrang;
	}

}
