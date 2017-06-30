package phamnguyen.com.vn.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import phamnguyen.com.vn.bean.NhanVien;
import phamnguyen.com.vn.entities.TbNhanVien;
import phamnguyen.com.vn.entities.TbXuat;
import phamnguyen.com.vn.mapper.NhanVienMapper;

/**
 * @author Pham Nguyen
 *
 */
@Repository
@Transactional
@Service
public class NhanVienDAO extends JdbcDaoSupport {

	@Autowired
	private SessionFactory sessionFactory;

	public NhanVienDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	public NhanVienDAO(DataSource dataSource) {
		setDataSource(dataSource);
	}

	// Dang nhap
	public NhanVien getNhanVien(String tenDangNhap) {
		String getQuery = "SELECT * FROM tb_nhan_vien WHERE ten_dang_nhap = ?";
		Object[] params = new Object[] { tenDangNhap };
		NhanVienMapper mapper = new NhanVienMapper();
		try {
			NhanVien nhanVien = this.getJdbcTemplate().queryForObject(getQuery, params, mapper);
			return nhanVien;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Not found ten dang nhap : " + tenDangNhap);
			return null;
		}
	}

	public NhanVien getNhanVien(String tenDangNhap, String matKhau) {
		String getQuery = "SELECT * FROM tb_nhan_vien WHERE ten_dang_nhap = ? AND mat_khau = ?";
		Object[] params = new Object[] { tenDangNhap, matKhau };
		NhanVienMapper mapper = new NhanVienMapper();
		try {
			return this.getJdbcTemplate().queryForObject(getQuery, params, mapper);
		} catch (Exception e) {
			System.out.println("Tài khoản không tồn tại !.");
			return null;
		}
	}

	public boolean xacNhanQuanTriVien(String tenDangNhap, String matKhau) {
		boolean result = false;
		try {
			NhanVien nhanVien = this.getNhanVien(tenDangNhap, matKhau);
			// if ("1".equals(nhanVien.getMaQtc()))
			if (1 == nhanVien.getMaQtc())
				result = true;
		} catch (Exception e) {
			result = false;
		}
		return result;
	}

	public boolean xacNhanNguoiDung(String tenDangNhap, String matKhau) {
		boolean result = false;
		try {
			NhanVien nhanVien = this.getNhanVien(tenDangNhap, matKhau);
			if (1 != nhanVien.getMaQtc())
				result = true;
		} catch (Exception e) {
			result = false;
		}
		return result;
	}

	// Lay danh sach toan bo nhan vien
	@SuppressWarnings("unchecked")
	public List<TbNhanVien> layDanhSachNhanVien() {
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "Select e From " + TbNhanVien.class.getName() + " e" + " order by e.tbDonVi.maKhoa asc";
			Query query = session.createQuery(sql);
			List<TbNhanVien> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}

	// Chi lay danh sach nhan vien co quyen truy cap la Quan Tri Vien
	@SuppressWarnings("unchecked")
	public List<TbNhanVien> layDanhSachQuanTriVien() {
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "Select f From " + TbNhanVien.class.getName() + " f"
					+ " where f.tbQuyenTruyCap.quyen like '%Quản trị viên%'";
			Query query = session.createQuery(sql);
			List<TbNhanVien> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	// Lay danh sach nhan vien co quyen truy cap la Quan Tri Vien - chuc vu la Ky thuat vien
		@SuppressWarnings("unchecked")
		public List<TbNhanVien> layDanhSachKyThuatVien() {
			Session session = sessionFactory.getCurrentSession();
			try {
				String sql = "Select h From " + TbNhanVien.class.getName() + " h"
						+ " where h.tbQuyenTruyCap.quyen like '%Quản trị viên%' and h.chucVu like '%Kỹ thuật viên%'";
				Query query = session.createQuery(sql);
				List<TbNhanVien> list = query.list();
				return list;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				return null;
			}
		}

	// Chi lay danh sach Nguoi Dung
	@SuppressWarnings("unchecked")
	public List<TbNhanVien> layDanhSachNguoiDung() {
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "Select g From " + TbNhanVien.class.getName() + " g"
					+ " where g.tbQuyenTruyCap.quyen like '%Người dùng%'";
			Query query = session.createQuery(sql);
			List<TbNhanVien> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}

	// Xoa nhan vien
	public void xoaNhanVien(TbNhanVien tbNhanVien) {
		sessionFactory.getCurrentSession().delete(tbNhanVien);
	}

	// Chon de sua
	public TbNhanVien layMaNhanVien(int maNql) {
		return (TbNhanVien) sessionFactory.getCurrentSession().get(TbNhanVien.class, maNql);
	}

	// Sua nhan vien
	public void suaNhanVien(TbNhanVien tbNhanVien) {
		sessionFactory.getCurrentSession().update(tbNhanVien);
	}

	// Them nhan vien
	public void themNhanVien(TbNhanVien tbNhanVien) {
		sessionFactory.getCurrentSession().saveOrUpdate(tbNhanVien);
	}

	// Dung de phan trang
	public long demNhanVien() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TbNhanVien.class);
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}

	// Tim kiem
	@SuppressWarnings("unchecked")
	public List<TbNhanVien> timThietBi(String chuoiTimKiem, String muc) {
		List<TbNhanVien> danhsach = new ArrayList<TbNhanVien>();
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TbNhanVien.class);
		if ("".equals(chuoiTimKiem)) {
			danhsach = criteria.list();
			return danhsach;
		} else {
			if ("maNql".equals(muc)) {
				danhsach = criteria.add(Restrictions.like("maNql", "%" + chuoiTimKiem + "%")).list();
			} else if ("hoTen".equals(muc)) {
				danhsach = criteria.add(Restrictions.like("hoTen", "%" + chuoiTimKiem + "%")).list();
			} else if ("gioiTinh".equals(muc)) {
				danhsach = criteria.add(Restrictions.like("gioiTinh", "%" + chuoiTimKiem + "%")).list();
			} else if ("diaChi".equals(muc)) {
				danhsach = criteria.add(Restrictions.like("diaChi", "%" + chuoiTimKiem + "%")).list();
			} else if ("soDienThoai".equals(muc)) {
				danhsach = criteria.add(Restrictions.like("soDienThoai", "%" + chuoiTimKiem + "%")).list();
			} else if ("email".equals(muc)) {
				danhsach = criteria.add(Restrictions.like("email", "%" + chuoiTimKiem + "%")).list();
			} else if ("chucVu".equals(muc)) {
				danhsach = criteria.add(Restrictions.like("chucVu", "%" + chuoiTimKiem + "%")).list();
			}
			return danhsach;
		}
	}

	// Lay ten nhan vien
	public TbNhanVien layTenNV(String hoTen) {
		Session session = sessionFactory.getCurrentSession();
		try {
			TbNhanVien dm = (TbNhanVien) session.get(TbNhanVien.class, hoTen);
			return dm;
		} catch (Exception e) {
			System.out.println("NhanVienDAO" + e.getMessage());
		}
		return null;
	}

	// Lay danh sach thiet bi theo ten nhan vien
	@SuppressWarnings("unchecked")
	public List<TbXuat> layDanhSachXuatTheoNV(String ten) {
		Session session = sessionFactory.getCurrentSession();
		try {

			String sql = "Select x From " + TbXuat.class.getName() + " x" + " where x.tbPhieuXuat.tbNhanVien.hoTen=:i";
			Query query = session.createQuery(sql);
			query.setParameter("i", ten);
			List<TbXuat> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}

	// Lay thong tin ca nhan theo ten nhan vien
	@SuppressWarnings("unchecked")
	public List<TbXuat> layThongTinCaNhanNV(String ten) {
		Session session = sessionFactory.getCurrentSession();
		try {

			String sql = "Select x From " + TbNhanVien.class.getName() + " x" + " where x.hoTen=:i";
			Query query = session.createQuery(sql);
			query.setParameter("i", ten);
			List<TbXuat> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}

	// lay ngay gio hien tai
	public String layNgayHienTai() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date date = new Date();
		return dateFormat.format(date);
	}

}
