package phamnguyen.com.vn.bean;

public class DanhMucThietBi {

	private String maThietBi;
	private String tenThietBi;
	private String dacTinhKyThuat;
	private String maChungLoai;

	public DanhMucThietBi(String maThietBi, String tenThietBi, String dacTinhKyThuat, String maChungLoai) {
		this.maThietBi = maThietBi;
		this.tenThietBi = tenThietBi;
		this.dacTinhKyThuat = dacTinhKyThuat;
		this.maChungLoai = maChungLoai;
	}

	public DanhMucThietBi() {
	}

	public String getMaThietBi() {
		return maThietBi;
	}

	public void setMaThietBi(String maThietBi) {
		this.maThietBi = maThietBi;
	}

	public String getTenThietBi() {
		return tenThietBi;
	}

	public void setTenThietBi(String tenThietBi) {
		this.tenThietBi = tenThietBi;
	}

	public String getDacTinhKyThuat() {
		return dacTinhKyThuat;
	}

	public void setDacTinhKyThuat(String dacTinhKyThuat) {
		this.dacTinhKyThuat = dacTinhKyThuat;
	}

	public String getMaChungLoai() {
		return maChungLoai;
	}

	public void setMaChungLoai(String maChungLoai) {
		this.maChungLoai = maChungLoai;
	}

	@Override
	public String toString() {
		return "DanhMucThietBi [maThietBi=" + maThietBi + ", tenThietBi=" + tenThietBi + ", dacTinhKyThuat="
				+ dacTinhKyThuat + ", maChungLoai=" + maChungLoai + "]";
	}

}
