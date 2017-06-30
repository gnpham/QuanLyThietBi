package phamnguyen.com.vn.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import phamnguyen.com.vn.bean.NhanVien;

public class NhanVienMapper implements RowMapper<NhanVien> {

	@Override
	public NhanVien mapRow(ResultSet rs, int rowNum) throws SQLException {

		int maNql = rs.getInt("ma_nql");
		String hoTen = rs.getString("ho_ten");
		String gioiTinh = rs.getString("gioi_tinh");
		String diaChi = rs.getString("dia_chi");
		String soDienThoai = rs.getString("so_dien_thoai");
		String email = rs.getString("email");
		String chucVu = rs.getString("chuc_vu");
		String tenDangNhap = rs.getString("ten_dang_nhap");
		String matKhau = rs.getString("mat_khau");
		int maQtc = rs.getInt("ma_qtc");
		String maPth = rs.getString("ma_pth");
		int maPhongBan = rs.getInt("ma_phong_ban");
		int maKhoa = rs.getInt("ma_khoa");

		return new NhanVien(maNql, hoTen, gioiTinh, diaChi, soDienThoai, email, chucVu, tenDangNhap, matKhau, maQtc,
				maPth, maPhongBan, maKhoa);
	}

}
