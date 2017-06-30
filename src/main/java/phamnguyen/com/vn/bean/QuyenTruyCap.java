package phamnguyen.com.vn.bean;

/**
 * @author Pham Nguyen
 *
 */

public class QuyenTruyCap {
	private int maQuyen;
	private String quyen;

	public QuyenTruyCap() {
		super();
	}

	public QuyenTruyCap(int maQuyen, String quyen) {
		super();
		this.maQuyen = maQuyen;
		this.quyen = quyen;
	}

	public int getMaQuyen() {
		return maQuyen;
	}

	public void setMaQuyen(int maQuyen) {
		this.maQuyen = maQuyen;
	}

	public String getQuyen() {
		return quyen;
	}

	public void setQuyen(String quyen) {
		this.quyen = quyen;
	}

	@Override
	public String toString() {
		return "QuyenTruyCap [maQuyen=" + maQuyen + ", quyen=" + quyen + "]";
	}

}
