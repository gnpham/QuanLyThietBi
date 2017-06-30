package phamnguyen.com.vn.entities;


import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "tb_nhom_thiet_bi")
public class TbNhomThietBi{

	private int maNhomThietBi;
	private String tenNhomThietBi;
	private String ghiChu;
	private Set<TbDanhMucChungLoai> tbDanhMucChungLoais = new HashSet<TbDanhMucChungLoai>(0);

	public TbNhomThietBi() {
	}

	public TbNhomThietBi(String tenNhomThietBi, String ghiChu, Set<TbDanhMucChungLoai> tbDanhMucChungLoais) {
		this.tenNhomThietBi = tenNhomThietBi;
		this.ghiChu = ghiChu;
		this.tbDanhMucChungLoais = tbDanhMucChungLoais;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ma_nhom_thiet_bi", unique = true, nullable = false)
	public int getMaNhomThietBi() {
		return this.maNhomThietBi;
	}

	public void setMaNhomThietBi(int maNhomThietBi) {
		this.maNhomThietBi = maNhomThietBi;
	}

	@Column(name = "ten_nhom_thiet_bi", length = 50)
	public String getTenNhomThietBi() {
		return this.tenNhomThietBi;
	}

	public void setTenNhomThietBi(String tenNhomThietBi) {
		this.tenNhomThietBi = tenNhomThietBi;
	}

	@Column(name = "ghi_chu", length = 100)
	public String getGhiChu() {
		return this.ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbNhomThietBi")
	@Fetch(FetchMode.SELECT)
	public Set<TbDanhMucChungLoai> getTbDanhMucChungLoais() {
		return this.tbDanhMucChungLoais;
	}

	public void setTbDanhMucChungLoais(Set<TbDanhMucChungLoai> tbDanhMucChungLoais) {
		this.tbDanhMucChungLoais = tbDanhMucChungLoais;
	}

}
