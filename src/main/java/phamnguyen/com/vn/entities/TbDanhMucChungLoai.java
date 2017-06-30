package phamnguyen.com.vn.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "tb_danh_muc_chung_loai", uniqueConstraints = @UniqueConstraint(columnNames = "ten_chung_loai"))
public class TbDanhMucChungLoai{

	private int maChungLoai;
	private TbNhomThietBi tbNhomThietBi;
	private String tenChungLoai;
	private String ghiChu;
	private Set<TbDanhMucThietBi> tbDanhMucThietBis = new HashSet<TbDanhMucThietBi>(0);

	public TbDanhMucChungLoai() {
	}

	public TbDanhMucChungLoai(TbNhomThietBi tbNhomThietBi, String tenChungLoai, String ghiChu,
			Set<TbDanhMucThietBi> tbDanhMucThietBis) {
		this.tbNhomThietBi = tbNhomThietBi;
		this.tenChungLoai = tenChungLoai;
		this.ghiChu = ghiChu;
		this.tbDanhMucThietBis = tbDanhMucThietBis;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ma_chung_loai", unique = true, nullable = false)
	public int getMaChungLoai() {
		return this.maChungLoai;
	}

	public void setMaChungLoai(int maChungLoai) {
		this.maChungLoai = maChungLoai;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_nhom_thiet_bi")
	public TbNhomThietBi getTbNhomThietBi() {
		return this.tbNhomThietBi;
	}

	public void setTbNhomThietBi(TbNhomThietBi tbNhomThietBi) {
		this.tbNhomThietBi = tbNhomThietBi;
	}

	@Column(name = "ten_chung_loai", unique = true, length = 50)
	public String getTenChungLoai() {
		return this.tenChungLoai;
	}

	public void setTenChungLoai(String tenChungLoai) {
		this.tenChungLoai = tenChungLoai;
	}

	@Column(name = "ghi_chu", length = 150, nullable = true)
	public String getGhiChu() {
		return this.ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tbDanhMucChungLoai")
	@Fetch(FetchMode.SELECT) 
	public Set<TbDanhMucThietBi> getTbDanhMucThietBis() {
		return this.tbDanhMucThietBis;
	}

	public void setTbDanhMucThietBis(Set<TbDanhMucThietBi> tbDanhMucThietBis) {
		this.tbDanhMucThietBis = tbDanhMucThietBis;
	}

}
