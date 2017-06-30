package phamnguyen.com.vn.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Author Pham Nguyen
 */
@Entity
@Table(name = "tb_don_vi", catalog = "thietbi")
public class TbDonVi{

	private int maKhoa;
	private String tenKhoa;
	private String soDienThoai;
	private Set<TbNhanVien> tbNhanViens = new HashSet<TbNhanVien>(0);

	public TbDonVi() {
	}

	public TbDonVi(String tenKhoa, String soDienThoai, Set<TbNhanVien> tbNhanViens) {
		this.tenKhoa = tenKhoa;
		this.soDienThoai = soDienThoai;
		this.tbNhanViens = tbNhanViens;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ma_khoa", unique = true, nullable = false)
	public int getMaKhoa() {
		return this.maKhoa;
	}

	public void setMaKhoa(int maKhoa) {
		this.maKhoa = maKhoa;
	}

	@Column(name = "ten_khoa", length = 50)
	public String getTenKhoa() {
		return this.tenKhoa;
	}

	public void setTenKhoa(String tenKhoa) {
		this.tenKhoa = tenKhoa;
	}

	@Column(name = "so_dien_thoai", length = 15)
	public String getSoDienThoai() {
		return this.soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tbDonVi")
	@Fetch(FetchMode.SELECT)
	public Set<TbNhanVien> getTbNhanViens() {
		return this.tbNhanViens;
	}

	public void setTbNhanViens(Set<TbNhanVien> tbNhanViens) {
		this.tbNhanViens = tbNhanViens;
	}

}
