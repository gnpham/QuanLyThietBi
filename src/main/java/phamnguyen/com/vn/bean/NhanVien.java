package phamnguyen.com.vn.bean;

public class NhanVien {
	private int maNql;
	private String hoTen;
	private String gioiTinh;
	private String diaChi;
	private String soDienThoai;
	private String email;
	private String chucVu;
	private String tenDangNhap;
	private String matKhau;
	private int maQtc;
	private String maPth;
	private int maPhongBan;
	private int maKhoa;

	public NhanVien() {
		super();
	}

	public NhanVien(int maNql, String hoTen, String gioiTinh, String diaChi, String soDienThoai, String email,
			String chucVu, String tenDangNhap, String matKhau, int maQtc, String maPth, int maPhongBan, int maKhoa) {
		super();
		this.maNql = maNql;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.chucVu = chucVu;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.maQtc = maQtc;
		this.maPth = maPth;
		this.maPhongBan = maPhongBan;
		this.maKhoa = maKhoa;
	}

	public int getMaNql() {
		return maNql;
	}

	public void setMaNql(int maNql) {
		this.maNql = maNql;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public int getMaQtc() {
		return maQtc;
	}

	public void setMaQtc(int maQtc) {
		this.maQtc = maQtc;
	}

	public String getMaPth() {
		return maPth;
	}

	public void setMaPth(String maPth) {
		this.maPth = maPth;
	}

	public int getMaPhongBan() {
		return maPhongBan;
	}

	public void setMaPhongBan(int maPhongBan) {
		this.maPhongBan = maPhongBan;
	}

	public int getMaKhoa() {
		return maKhoa;
	}

	public void setMaKhoa(int maKhoa) {
		this.maKhoa = maKhoa;
	}

	@Override
	public String toString() {
		return "NhanVien [maNql=" + maNql + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi
				+ ", soDienThoai=" + soDienThoai + ", email=" + email + ", chucVu=" + chucVu + ", tenDangNhap="
				+ tenDangNhap + ", matKhau=" + matKhau + ", maQtc=" + maQtc + ", maPth=" + maPth + ", maPhongBan="
				+ maPhongBan + ", maKhoa=" + maKhoa + "]";
	}

}