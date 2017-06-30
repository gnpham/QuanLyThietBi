package phamnguyen.com.vn.entities;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_quyen_truy_cap")
public class TbQuyenTruyCap{

	private int maQuyen;
	private String quyen;

	public TbQuyenTruyCap() {
	}

	
	public TbQuyenTruyCap(int maQuyen, String quyen) {
		super();
		this.maQuyen = maQuyen;
		this.quyen = quyen;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ma_quyen", unique = true, nullable = false)
	public int getMaQuyen() {
		return this.maQuyen;
	}

	public void setMaQuyen(int maQuyen) {
		this.maQuyen = maQuyen;
	}

	@Column(name = "quyen", unique = true, nullable = false, length = 30)
	public String getQuyen() {
		return this.quyen;
	}

	public void setQuyen(String quyen) {
		this.quyen = quyen;
	}

}
