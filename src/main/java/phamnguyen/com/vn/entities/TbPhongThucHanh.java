package phamnguyen.com.vn.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Author Pham Nguyen
 */
@Entity
@Table(name = "tb_phong_thuc_hanh", catalog = "thietbi")
public class TbPhongThucHanh {

	private String maPth;
	private String phongThucHanh;
	private String ghiChu;
	private Set<TbNhanVien> tbNhanViens = new HashSet<TbNhanVien>(0);

	public TbPhongThucHanh() {
	}

	public TbPhongThucHanh(String maPth, String phongThucHanh, String ghiChu, Set<TbNhanVien> tbNhanViens) {
		this.maPth = maPth;
		this.phongThucHanh = phongThucHanh;
		this.ghiChu = ghiChu;
		this.tbNhanViens = tbNhanViens;
	}

	@Id

	@Column(name = "ma_pth", unique = true, nullable = false, length = 10)
	public String getMaPth() {
		return this.maPth;
	}

	public void setMaPth(String maPth) {
		this.maPth = maPth;
	}

	@Column(name = "phong_thuc_hanh", length = 100)
	public String getPhongThucHanh() {
		return this.phongThucHanh;
	}

	public void setPhongThucHanh(String phongThucHanh) {
		this.phongThucHanh = phongThucHanh;
	}

	@Column(name = "ghi_chu", length = 200)
	public String getGhiChu() {
		return this.ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tbPhongThucHanh")
	@Fetch(FetchMode.SELECT)
	public Set<TbNhanVien> getTbNhanViens() {
		return this.tbNhanViens;
	}

	public void setTbNhanViens(Set<TbNhanVien> tbNhanViens) {
		this.tbNhanViens = tbNhanViens;
	}

}
