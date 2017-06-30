package phamnguyen.com.vn.bean;

public class ChiTietNhapXuat {

	int thietBiId;
	String maThietBi;
	int maNuocSanXuat;
	String maPhieuNhap;
	String tenThietBi;
	String donViTinh;
	int soLuong;
	String hanBaoHanh;
	String soHieuTscd;
	String congXuat;
	int nguyenGia;
	String moTa;
	int khauHao;
	String maCode;
	public ChiTietNhapXuat() {
		super();
	}
	public ChiTietNhapXuat(int thietBiId, String maThietBi, int maNuocSanXuat, String maPhieuNhap, String tenThietBi,
			String donViTinh, int soLuong, String hanBaoHanh, String soHieuTscd, String congXuat, int nguyenGia,
			String moTa, int khauHao, String maCode) {
		super();
		this.thietBiId = thietBiId;
		this.maThietBi = maThietBi;
		this.maNuocSanXuat = maNuocSanXuat;
		this.maPhieuNhap = maPhieuNhap;
		this.tenThietBi = tenThietBi;
		this.donViTinh = donViTinh;
		this.soLuong = soLuong;
		this.hanBaoHanh = hanBaoHanh;
		this.soHieuTscd = soHieuTscd;
		this.congXuat = congXuat;
		this.nguyenGia = nguyenGia;
		this.moTa = moTa;
		this.khauHao = khauHao;
		this.maCode = maCode;
	}
	public ChiTietNhapXuat(int thietBiId, int soLuong) {
		super();
		this.thietBiId = thietBiId;
		this.soLuong = soLuong;
	}
	public int getThietBiId() {
		return thietBiId;
	}
	public void setThietBiId(int thietBiId) {
		this.thietBiId = thietBiId;
	}
	public String getMaThietBi() {
		return maThietBi;
	}
	public void setMaThietBi(String maThietBi) {
		this.maThietBi = maThietBi;
	}
	public int getMaNuocSanXuat() {
		return maNuocSanXuat;
	}
	public void setMaNuocSanXuat(int maNuocSanXuat) {
		this.maNuocSanXuat = maNuocSanXuat;
	}
	public String getMaPhieuNhap() {
		return maPhieuNhap;
	}
	public void setMaPhieuNhap(String maPhieuNhap) {
		this.maPhieuNhap = maPhieuNhap;
	}
	public String getTenThietBi() {
		return tenThietBi;
	}
	public void setTenThietBi(String tenThietBi) {
		this.tenThietBi = tenThietBi;
	}
	public String getDonViTinh() {
		return donViTinh;
	}
	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getHanBaoHanh() {
		return hanBaoHanh;
	}
	public void setHanBaoHanh(String hanBaoHanh) {
		this.hanBaoHanh = hanBaoHanh;
	}
	public String getSoHieuTscd() {
		return soHieuTscd;
	}
	public void setSoHieuTscd(String soHieuTscd) {
		this.soHieuTscd = soHieuTscd;
	}
	public String getCongXuat() {
		return congXuat;
	}
	public void setCongXuat(String congXuat) {
		this.congXuat = congXuat;
	}
	public int getNguyenGia() {
		return nguyenGia;
	}
	public void setNguyenGia(int nguyenGia) {
		this.nguyenGia = nguyenGia;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public int getKhauHao() {
		return khauHao;
	}
	public void setKhauHao(int khauHao) {
		this.khauHao = khauHao;
	}
	public String getMaCode() {
		return maCode;
	}
	public void setMaCode(String maCode) {
		this.maCode = maCode;
	}
	
	
}
