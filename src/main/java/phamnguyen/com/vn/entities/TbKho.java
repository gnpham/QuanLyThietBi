package phamnguyen.com.vn.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Author Pham Nguyen
 */
@Entity
@Table(name = "tb_kho", catalog = "thietbi")
public class TbKho{

	private int maKho;
	private TbPhongBan tbPhongBan;
	private String tenKho;
	private String thuKho;
	private Set<TbPhieuNhap> tbPhieuNhaps = new HashSet<TbPhieuNhap>(0);
	private Set<TbPhieuXuat> tbPhieuXuats = new HashSet<TbPhieuXuat>(0);

	public TbKho() {
	}

	public TbKho(TbPhongBan tbPhongBan, String tenKho) {
		this.tbPhongBan = tbPhongBan;
		this.tenKho = tenKho;
	}

	public TbKho(TbPhongBan tbPhongBan, String tenKho, String thuKho, Set<TbPhieuNhap> tbPhieuNhaps,
			Set<TbPhieuXuat> tbPhieuXuats) {
		this.tbPhongBan = tbPhongBan;
		this.tenKho = tenKho;
		this.thuKho = thuKho;
		this.tbPhieuNhaps = tbPhieuNhaps;
		this.tbPhieuXuats = tbPhieuXuats;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ma_kho", unique = true, nullable = false)
	public int getMaKho() {
		return this.maKho;
	}

	public void setMaKho(int maKho) {
		this.maKho = maKho;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_phong_ban", nullable = false)
	public TbPhongBan getTbPhongBan() {
		return this.tbPhongBan;
	}

	public void setTbPhongBan(TbPhongBan tbPhongBan) {
		this.tbPhongBan = tbPhongBan;
	}

	@Column(name = "ten_kho", nullable = false, length = 50)
	public String getTenKho() {
		return this.tenKho;
	}

	public void setTenKho(String tenKho) {
		this.tenKho = tenKho;
	}

	@Column(name = "thu_kho", length = 30)
	public String getThuKho() {
		return this.thuKho;
	}

	public void setThuKho(String thuKho) {
		this.thuKho = thuKho;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tbKho")
	@Fetch(FetchMode.SELECT)
	public Set<TbPhieuNhap> getTbPhieuNhaps() {
		return this.tbPhieuNhaps;
	}

	public void setTbPhieuNhaps(Set<TbPhieuNhap> tbPhieuNhaps) {
		this.tbPhieuNhaps = tbPhieuNhaps;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tbKho")
	@Fetch(FetchMode.SELECT)
	public Set<TbPhieuXuat> getTbPhieuXuats() {
		return this.tbPhieuXuats;
	}

	public void setTbPhieuXuats(Set<TbPhieuXuat> tbPhieuXuats) {
		this.tbPhieuXuats = tbPhieuXuats;
	}

}
