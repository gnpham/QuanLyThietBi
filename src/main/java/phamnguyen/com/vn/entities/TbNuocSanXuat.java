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
 * Author Nguyen Pham
 */
@Entity
@Table(name = "tb_nuoc_san_xuat", catalog = "thietbi")
public class TbNuocSanXuat{

	private String maNuocSanXuat;
	private String nuocSanXuat;
	private Set<TbChiTietNhapXuat> tbChiTietNhapXuats = new HashSet<TbChiTietNhapXuat>(0);

	public TbNuocSanXuat() {
	}

	public TbNuocSanXuat(String maNuocSanXuat) {
		this.maNuocSanXuat = maNuocSanXuat;
	}

	public TbNuocSanXuat(String maNuocSanXuat, String nuocSanXuat, Set<TbChiTietNhapXuat> tbChiTietNhapXuats) {
		this.maNuocSanXuat = maNuocSanXuat;
		this.nuocSanXuat = nuocSanXuat;
		this.tbChiTietNhapXuats = tbChiTietNhapXuats;
	}

	@Id

	@Column(name = "ma_nuoc_san_xuat", unique = true, nullable = false, length = 10)
	public String getMaNuocSanXuat() {
		return this.maNuocSanXuat;
	}

	public void setMaNuocSanXuat(String maNuocSanXuat) {
		this.maNuocSanXuat = maNuocSanXuat;
	}

	@Column(name = "nuoc_san_xuat", length = 20)
	public String getNuocSanXuat() {
		return this.nuocSanXuat;
	}

	public void setNuocSanXuat(String nuocSanXuat) {
		this.nuocSanXuat = nuocSanXuat;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tbNuocSanXuat")
	@Fetch(FetchMode.SELECT)
	public Set<TbChiTietNhapXuat> getTbChiTietNhapXuats() {
		return this.tbChiTietNhapXuats;
	}

	public void setTbChiTietNhapXuats(Set<TbChiTietNhapXuat> tbChiTietNhapXuats) {
		this.tbChiTietNhapXuats = tbChiTietNhapXuats;
	}

}
