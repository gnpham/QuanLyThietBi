package phamnguyen.com.vn.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import phamnguyen.com.vn.entities.TbPhieuNhap;

@Transactional
@Repository
public class PhieuNhapDAO extends JdbcDaoSupport {
	@Autowired
	private SessionFactory sessionFactory;

	public PhieuNhapDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	public PhieuNhapDAO(DataSource dataSource) {
		setDataSource(dataSource);
	}
	// Lay danh sach 1- loi
	// @SuppressWarnings("unchecked")
	// public List<TbDanhMucThietBi> getAllDanhMucThietBi() {
	// List<TbDanhMucThietBi> list = new ArrayList<TbDanhMucThietBi>();
	// Criteria criteria =
	// sessionFactory.getCurrentSession().createCriteria(TbDanhMucThietBi.class);
	// list = criteria.list();
	// return list;
	// }

	// Lay danh sach
	@SuppressWarnings("unchecked")
	public List<TbPhieuNhap> layDanhSachPhieuNhap() {
		Session session = sessionFactory.getCurrentSession();
		try {
			// session.getTransaction().begin();
			String sql = "Select distinct d From " + TbPhieuNhap.class.getName() + " d" + " order by d.ngayNhap desc";
			Query query = session.createQuery(sql);
			List<TbPhieuNhap> list = query.list();
			// for (TbDanhMucThietBi dm : list) {
			// System.out.println("Thiet bi: " +
			// dm.getTbDanhMucChungLoai().getTenChungLoai());
			// }
			// session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			// session.getTransaction().rollback();
			System.out.println(e.getMessage());
			return null;
		}
	}

//	 Xoa
	 public void xoaPhieuNhap(TbPhieuNhap danhsachphieunhap) {
	 sessionFactory.getCurrentSession().delete(danhsachphieunhap);	
	 }

	// Lay phieu nhap theo ma- cach 1
	public TbPhieuNhap layMaPhieuNhap(String maPhieuNhap) {
		return (TbPhieuNhap) sessionFactory.getCurrentSession().get(TbPhieuNhap.class, maPhieuNhap);

	}

	// Sua phieu nhap da chon ma
	public void suaDanhSachPhieuNhap(TbPhieuNhap danhsachphieunhap) {
		sessionFactory.getCurrentSession().update(danhsachphieunhap);
	}

	// Them
	public void themPhieuNhap(TbPhieuNhap danhsachphieunhap) {
		sessionFactory.getCurrentSession().saveOrUpdate(danhsachphieunhap);
	}

	// Tim kiem
	@SuppressWarnings("unchecked")
	public List<TbPhieuNhap> timPhieuNhap(String chuoiTimKiem, String muc) {
		List<TbPhieuNhap> danhsach = new ArrayList<TbPhieuNhap>();
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TbPhieuNhap.class);
		if ("".equals(chuoiTimKiem)) {
			danhsach = criteria.list();
			return danhsach;
		} else {
			if ("ma".equals(muc)) {
				danhsach = criteria.add(Restrictions.like("maPhieuNhap", "%" + chuoiTimKiem + "%")).list();
			} else if ("nguoi".equals(muc)) {
				criteria.createAlias("tbNhanVien", "project");
				danhsach = criteria.add(Restrictions.like("project.hoTen", "%" + chuoiTimKiem + "%")).list();
			} else if ("donVi".equals(muc)) {
				danhsach = criteria.add(Restrictions.like("nguonGoc", "%" + chuoiTimKiem + "%")).list();
			} else if ("nguonTaiSan".equals(muc)) {
				danhsach = criteria.add(Restrictions.like("nguonGocTaiSan", "%" + chuoiTimKiem + "%")).list();
			}
			return danhsach;
		}
	}
}
