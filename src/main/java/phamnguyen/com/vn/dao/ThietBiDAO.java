package phamnguyen.com.vn.dao;

import java.util.ArrayList;
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
import org.springframework.transaction.annotation.Transactional;

import phamnguyen.com.vn.entities.TbChiTietNhapXuat;
import phamnguyen.com.vn.entities.TbPhieuNhap;
import phamnguyen.com.vn.entities.TbPhieuXuat;
import phamnguyen.com.vn.entities.TbXuat;

@Transactional
@Repository
public class ThietBiDAO extends JdbcDaoSupport {
	@Autowired
	private SessionFactory sessionFactory;

	public ThietBiDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	public ThietBiDAO(DataSource dataSource) {
		setDataSource(dataSource);
	}

	// --------------------------------------------------------------------------------------------
	// THIET BI
	// Lay danh sach - cach 2
	@SuppressWarnings("unchecked")
	public List<TbChiTietNhapXuat> layDanhSachThietBi() {
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "Select d From " + TbChiTietNhapXuat.class.getName() + " d"
					+ " where d.soLuong > 0 order by d.tbPhieuNhap.ngayNhap asc, d.thietBiId asc ";
			Query query = session.createQuery(sql);
			List<TbChiTietNhapXuat> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}

	// Xoa
	public void xoaThietBi(TbChiTietNhapXuat danhsachtb) {
		sessionFactory.getCurrentSession().delete(danhsachtb);
	}

	// Lay ma
	public TbChiTietNhapXuat layThietBiId(int thietBiId) {
		Session session = sessionFactory.getCurrentSession();
		try {
			TbChiTietNhapXuat dm = (TbChiTietNhapXuat) session.get(TbChiTietNhapXuat.class, thietBiId);
			return dm;
		} catch (Exception e) {
			System.out.println("ThietBiDAO" + e.getMessage());
		}
		return null;
	}

	// Sua thiet bi
	public void suaThietBi(TbChiTietNhapXuat danhsachtb) {
		sessionFactory.getCurrentSession().update(danhsachtb);
	}

	// Them
	public void themThietBi(TbChiTietNhapXuat danhsachtb) {
		sessionFactory.getCurrentSession().saveOrUpdate(danhsachtb);
	}

	// Dung de phan trang
	public long demThietBi() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TbChiTietNhapXuat.class);
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}

	// Tim kiem
	@SuppressWarnings("unchecked")
	public List<TbChiTietNhapXuat> timDanhSachThietBiTrongKho(String chuoiTimKiem, String muc) {
		List<TbChiTietNhapXuat> danhsach = new ArrayList<TbChiTietNhapXuat>();
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TbChiTietNhapXuat.class);
		if ("".equals(chuoiTimKiem)) {
			danhsach = criteria.list();
			return danhsach;
		} else {
			if ("maThietBi".equals(muc)) {
				criteria.createAlias("tbDanhMucThietBi", "project");
				danhsach = criteria.add(Restrictions.like("project.maThietBi", "%" + chuoiTimKiem + "%")).list();
			} else if ("tenThietBi".equals(muc)) {
				danhsach = criteria.add(Restrictions.like("tenThietBi", "%" + chuoiTimKiem + "%")).list();
			}else if ("donViTinh".equals(muc)) {
				danhsach = criteria.add(Restrictions.like("donViTinh", "%" + chuoiTimKiem + "%")).list();
			} else if ("nuocSanXuat".equals(muc)) {
				criteria.createAlias("tbNuocSanXuat", "project");
				danhsach = criteria.add(Restrictions.like("project.nuocSanXuat", "%" + chuoiTimKiem + "%")).list();
			} else if ("maCode".equals(muc)) {
				danhsach = criteria.add(Restrictions.like("maCode", "%" + chuoiTimKiem + "%")).list();
			}
			return danhsach;
		}
	}

	// -----------------------------------------------------------------------------------------
	// THIET BI NHAP
	// Lay ma phieu nhap de xuat ra thong tin phieu nhap
	public TbPhieuNhap layMaThietBiPhieuNhap(String maPhieuNhap) {
		Session session = sessionFactory.getCurrentSession();
		try {
			TbPhieuNhap dm = (TbPhieuNhap) session.get(TbPhieuNhap.class, maPhieuNhap);
			return dm;
		} catch (Exception e) {
			System.out.println("PhieuNhapDAO" + e.getMessage());
		}
		return null;
	}

	// Lay danh sach thiet bi ung voi ma phieu nhap
	@SuppressWarnings("unchecked")
	public List<TbChiTietNhapXuat> layDanhSachThietBiPhieuNhap(String maPhieuNhap) {
		Session session = sessionFactory.getCurrentSession();
		try {

			String sql = "Select d From " + TbChiTietNhapXuat.class.getName() + " d"
					+ " where d.tbPhieuNhap.maPhieuNhap=:i";
			Query query = session.createQuery(sql);
			query.setParameter("i", maPhieuNhap);
			List<TbChiTietNhapXuat> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}

	// // Sua thiet bi da chon ma
	// public void suaThietBi(TbChiTietNhapXuat danhsachtb) {
	// sessionFactory.getCurrentSession().update(danhsachtb);
	// }

	// -----------------------------------------------------------------------------------------
	// THIET BI XUAT
	// Lay ma phieu xuat de xuat ra thong tin phieu xuat
	public TbPhieuXuat layMaPhieuXuat(String maPhieuXuat) {
		Session session = sessionFactory.getCurrentSession();
		try {
			TbPhieuXuat dm = (TbPhieuXuat) session.get(TbPhieuXuat.class, maPhieuXuat);
			return dm;
		} catch (Exception e) {
			System.out.println("PhieuXuatDAO" + e.getMessage());
		}
		return null;
	}

	// Tinh tong so luong thiet bi trong kho
	@SuppressWarnings("rawtypes")
	public List tinhTongThietBiKho() {
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "Select SUM(d.soLuong) From " + TbChiTietNhapXuat.class.getName() + " d";
			Query query = session.createQuery(sql);
			List result = query.list();		
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}

	}

	// Tinh tong so luong thiet bi da xuat khoi kho
	@SuppressWarnings("rawtypes")
	public List tinhTongThietBiXuatKho() {
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "Select SUM(d.soLuongXuat) From " + TbXuat.class.getName() + " d";
			Query query = session.createQuery(sql);
			List result = query.list();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}

	// Tinh tong so luong thiet bi da xuat theo ten nhan vien
	@SuppressWarnings("rawtypes")
	public List tinhTongThietBiXuatKhoTheoTen(String ten) {
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "Select SUM(d.soLuongXuat) From " + TbXuat.class.getName() + " d"
					+ " where d.tbPhieuXuat.tbNhanVien.hoTen=:i";
			Query query = session.createQuery(sql);
			query.setParameter("i", ten);
			List result = query.list();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}
}
