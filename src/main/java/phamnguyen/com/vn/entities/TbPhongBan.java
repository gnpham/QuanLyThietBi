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
 * Author Nguyen Pham
 */
@Entity
@Table(name = "tb_phong_ban", catalog = "thietbi")
public class TbPhongBan{

	private int maPhongBan;
	private String tenPhongBan;
	private String soDienThoai;
	private Set<TbNhanVien> tbNhanViens = new HashSet<TbNhanVien>(0);
	private Set<TbKho> tbKhos = new HashSet<TbKho>(0);

	public TbPhongBan() {
	}

	public TbPhongBan(String tenPhongBan, String soDienThoai, Set<TbNhanVien> tbNhanViens, Set<TbKho> tbKhos) {
		this.tenPhongBan = tenPhongBan;
		this.soDienThoai = soDienThoai;
		this.tbNhanViens = tbNhanViens;
		this.tbKhos = tbKhos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ma_phong_ban", unique = true, nullable = false)
	public int getMaPhongBan() {
		return this.maPhongBan;
	}

	public void setMaPhongBan(int maPhongBan) {
		this.maPhongBan = maPhongBan;
	}

	@Column(name = "ten_phong_ban", length = 50)
	public String getTenPhongBan() {
		return this.tenPhongBan;
	}

	public void setTenPhongBan(String tenPhongBan) {
		this.tenPhongBan = tenPhongBan;
	}

	@Column(name = "so_dien_thoai", length = 15)
	public String getSoDienThoai() {
		return this.soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tbPhongBan")
	@Fetch(FetchMode.SELECT)
	public Set<TbNhanVien> getTbNhanViens() {
		return this.tbNhanViens;
	}

	public void setTbNhanViens(Set<TbNhanVien> tbNhanViens) {
		this.tbNhanViens = tbNhanViens;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tbPhongBan")
	@Fetch(FetchMode.SELECT)
	public Set<TbKho> getTbKhos() {
		return this.tbKhos;
	}

	public void setTbKhos(Set<TbKho> tbKhos) {
		this.tbKhos = tbKhos;
	}

}
