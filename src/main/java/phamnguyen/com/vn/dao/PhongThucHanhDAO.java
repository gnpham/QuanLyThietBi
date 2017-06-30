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

import phamnguyen.com.vn.entities.TbPhongThucHanh;

@Transactional
@Repository
public class PhongThucHanhDAO extends JdbcDaoSupport {
	@Autowired
	private SessionFactory sessionFactory;

	public PhongThucHanhDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	public PhongThucHanhDAO(DataSource dataSource) {
		setDataSource(dataSource);
	}

	// Lay danh sach
	@SuppressWarnings("unchecked")
	public List<TbPhongThucHanh> layDanhSachPhongThucHanh() {
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "Select d From " + TbPhongThucHanh.class.getName() + " d";
			Query query = session.createQuery(sql);
			List<TbPhongThucHanh> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}

	// Xoa
	public void xoaPhongThucHanh(TbPhongThucHanh phongthuchanh) {
		sessionFactory.getCurrentSession().delete(phongthuchanh);
	}

	public TbPhongThucHanh layMaPhongThucHanh(String maPhongThucHanh) {
		Session session = sessionFactory.getCurrentSession();
		try {
			TbPhongThucHanh dm = (TbPhongThucHanh) session.get(TbPhongThucHanh.class, maPhongThucHanh);
			return dm;
		} catch (Exception e) {
			System.out.println("PhongThucHanhDAO" + e.getMessage());
		}
		return null;
	}

	// Sua PTH da chon ma
	public void suaPhongThucHanh(TbPhongThucHanh phongthuchanh) {
		sessionFactory.getCurrentSession().update(phongthuchanh);
	}

	// Them
	public void themPhongThucHanh(TbPhongThucHanh phongthuchanh) {
		sessionFactory.getCurrentSession().saveOrUpdate(phongthuchanh);
	}

	// Dung de phan trang
	public long demPhongThucHanh() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TbPhongThucHanh.class);
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}

	// Tim kiem
	@SuppressWarnings("unchecked")
	public List<TbPhongThucHanh> timPhongThucHanh(String chuoiTimKiem, String muc) {
		List<TbPhongThucHanh> danhsach = new ArrayList<TbPhongThucHanh>();
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TbPhongThucHanh.class);
		if ("".equals(chuoiTimKiem)) {
			danhsach = criteria.list();
			return danhsach;
		} else {
			if ("maPth".equals(muc)) {
				danhsach = criteria.add(Restrictions.like("maThietBi", "%" + chuoiTimKiem + "%")).list();
			} else if ("phongThucHanh".equals(muc)) {
				danhsach = criteria.add(Restrictions.like("phongThucHanh", "%" + chuoiTimKiem + "%")).list();
			} else if ("ghiChu".equals(muc)) {
				danhsach = criteria.add(Restrictions.like("ghiChu", "%" + chuoiTimKiem + "%")).list();
			} else if ("tbNhanViens.hoTen".equals(muc)) {
				danhsach = criteria.add(Restrictions.like("tbNhanViens.hoTen", "%" + chuoiTimKiem + "%")).list();
			}
			return danhsach;
		}
	}
}
