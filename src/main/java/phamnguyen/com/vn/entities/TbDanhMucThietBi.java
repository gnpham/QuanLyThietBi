package phamnguyen.com.vn.entities;

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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


/**
 * Author Nguyen Pham
 */
@Entity
@Table(name = "tb_danh_muc_thiet_bi", catalog = "thietbi")
public class TbDanhMucThietBi{

	private String maThietBi;
	private TbDanhMucChungLoai tbDanhMucChungLoai;
	private String tenThietBi;
	private String dacTinhKyThuat;
	private Set<TbChiTietNhapXuat> tbChiTietNhapXuats = new HashSet<TbChiTietNhapXuat>(0);

	public TbDanhMucThietBi() {
	}

	public TbDanhMucThietBi(String maThietBi) {
		this.maThietBi = maThietBi;
	}

	public TbDanhMucThietBi(String maThietBi, TbDanhMucChungLoai tbDanhMucChungLoai, String tenThietBi,
			String dacTinhKyThuat, Set<TbChiTietNhapXuat> tbChiTietNhapXuats) {
		this.maThietBi = maThietBi;
		this.tbDanhMucChungLoai = tbDanhMucChungLoai;
		this.tenThietBi = tenThietBi;
		this.dacTinhKyThuat = dacTinhKyThuat;
		this.tbChiTietNhapXuats = tbChiTietNhapXuats;
	}

	@Id

	@Column(name = "ma_thiet_bi", unique = true, nullable = false, length = 10)
	public String getMaThietBi() {
		return this.maThietBi;
	}

	public void setMaThietBi(String maThietBi) {
		this.maThietBi = maThietBi;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_chung_loai")
	public TbDanhMucChungLoai getTbDanhMucChungLoai() {
		return this.tbDanhMucChungLoai;
	}

	public void setTbDanhMucChungLoai(TbDanhMucChungLoai tbDanhMucChungLoai) {
		this.tbDanhMucChungLoai = tbDanhMucChungLoai;
	}

	@Column(name = "ten_thiet_bi", length = 100)
	public String getTenThietBi() {
		return this.tenThietBi;
	}

	public void setTenThietBi(String tenThietBi) {
		this.tenThietBi = tenThietBi;
	}

	@Column(name = "dac_tinh_ky_thuat", length = 500)
	public String getDacTinhKyThuat() {
		return this.dacTinhKyThuat;
	}

	public void setDacTinhKyThuat(String dacTinhKyThuat) {
		this.dacTinhKyThuat = dacTinhKyThuat;
	}

	@OneToMany(fetch = FetchType.EAGER,mappedBy = "tbDanhMucThietBi")
	@Fetch(FetchMode.SELECT)
//	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE, CascadeType.MERGE})
	public Set<TbChiTietNhapXuat> getTbChiTietNhapXuats() {
		return this.tbChiTietNhapXuats;
	}

	public void setTbChiTietNhapXuats(Set<TbChiTietNhapXuat> tbChiTietNhapXuats) {
		this.tbChiTietNhapXuats = tbChiTietNhapXuats;
	}

}
