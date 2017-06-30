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

import phamnguyen.com.vn.entities.TbPhongBan;

@Transactional
@Repository
public class PhongBanDAO extends JdbcDaoSupport {
	@Autowired
	private SessionFactory sessionFactory;

	public PhongBanDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	public PhongBanDAO(DataSource dataSource) {
		setDataSource(dataSource);
	}

	// Lay danh sach
	@SuppressWarnings("unchecked")
	public List<TbPhongBan> layDanhSachPhongBan() {
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "Select d From " + TbPhongBan.class.getName() + " d";
			Query query = session.createQuery(sql);
			List<TbPhongBan> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}

	}

	// Xoa
	public void xoaPhongBan(TbPhongBan danhmucphongban) {
		sessionFactory.getCurrentSession().delete(danhmucphongban);

	}

	// Lay danh muc tb theo ma
	public TbPhongBan layMaPhongBan(int maPhongBan) {
		Session session = sessionFactory.getCurrentSession();
		try {
			TbPhongBan dm = (TbPhongBan) session.get(TbPhongBan.class, maPhongBan);
			return dm;
		} catch (Exception e) {
			System.out.println("DanhMucPhongBanDAO" + e.getMessage());
		}
		return null;
	}

	// Sua thiet bi da chon ma
	public void suaPhongBan(TbPhongBan danhmucphongban) {
		sessionFactory.getCurrentSession().update(danhmucphongban);
	}

	// Them
	public void themPhongBan(TbPhongBan danhmucphongban) {
		sessionFactory.getCurrentSession().saveOrUpdate(danhmucphongban);
	}

	// Dung de phan trang
	public long demDanhMucPhongBan() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TbPhongBan.class);
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}

	// Tim kiem
	@SuppressWarnings("unchecked")
	public List<TbPhongBan> timPhongBan(String chuoiTimKiem, String muc) {
		List<TbPhongBan> danhsach = new ArrayList<TbPhongBan>();
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TbPhongBan.class);
		if ("".equals(chuoiTimKiem)) {
			danhsach = criteria.list();
			return danhsach;
		} else {
			if ("maPhongBan".equals(muc)) {
				danhsach = criteria.add(Restrictions.like("maPhongBan", "%" + chuoiTimKiem + "%")).list();
			} else if ("tenPhongBan".equals(muc)) {
				danhsach = criteria.add(Restrictions.like("tenPhongBan", "%" + chuoiTimKiem + "%")).list();
			} else if ("soDienThoai".equals(muc)) {
				danhsach = criteria.add(Restrictions.like("soDienThoai", "%" + chuoiTimKiem + "%")).list();
			}
			return danhsach;
		}
	}
}
