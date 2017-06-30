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

import phamnguyen.com.vn.entities.TbDonVi;

@Transactional
@Repository
public class DonViDAO extends JdbcDaoSupport {
	@Autowired
	private SessionFactory sessionFactory;

	public DonViDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	public DonViDAO(DataSource dataSource) {
		setDataSource(dataSource);
	}

	// Lay danh sach - cach 2
	@SuppressWarnings("unchecked")
	public List<TbDonVi> layDanhSachDonVi() {
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "Select d From " + TbDonVi.class.getName() + " d";
			Query query = session.createQuery(sql);
			List<TbDonVi> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}

	// Xoa
	public void xoaDonVi(TbDonVi danhsachdonvi) {
		sessionFactory.getCurrentSession().delete(danhsachdonvi);

	}
	public TbDonVi layMaDonVi(int maKhoa) {
		Session session = sessionFactory.getCurrentSession();
		try{
			TbDonVi dm = (TbDonVi)session.get(TbDonVi.class, maKhoa);
		return dm;
		}catch(Exception e){
			System.out.println("DonViDAO" +e.getMessage());
		}
		return null;
	}

	// Sua thiet bi da chon ma
	public void suaDonVi(TbDonVi danhsachdonvi) {
		sessionFactory.getCurrentSession().update(danhsachdonvi);
	}

	// Them
	public void themDonVi(TbDonVi danhsachdonvi) {
		sessionFactory.getCurrentSession().saveOrUpdate(danhsachdonvi);
	}

	// Dung de phan trang
	public long demDonVi() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TbDonVi.class);
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}

	// Tim kiem
	@SuppressWarnings("unchecked")
	public List<TbDonVi> timDonVi(String chuoiTimKiem, String muc) {
		List<TbDonVi> danhsach = new ArrayList<TbDonVi>();
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TbDonVi.class);
		if ("".equals(chuoiTimKiem)) {
			danhsach = criteria.list();
			return danhsach;
		} else {
			if ("maKhoa".equals(muc)) {
				danhsach = criteria.add(Restrictions.like("maKhoa", "%" + chuoiTimKiem + "%")).list();
			} else if ("tenKhoa".equals(muc)) {
				danhsach = criteria.add(Restrictions.like("tenKhoa", "%" + chuoiTimKiem + "%")).list();
			} else if ("soDienThoai".equals(muc)) {
				danhsach = criteria.add(Restrictions.like("soDienThoai", "%" + chuoiTimKiem + "%")).list();
			}
			return danhsach;
		}
	}
}
