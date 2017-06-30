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

import phamnguyen.com.vn.entities.TbDanhMucThietBi;

@Transactional
@Repository
public class DanhMucThietBiDAO extends JdbcDaoSupport {
	@Autowired
	private SessionFactory sessionFactory;

	public DanhMucThietBiDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	public DanhMucThietBiDAO(DataSource dataSource) {
		setDataSource(dataSource);
	}
	// Lay danh sach 1- loi
//	 @SuppressWarnings("unchecked")
//	 public List<TbDanhMucThietBi> getAllDanhMucThietBi() {
//	 List<TbDanhMucThietBi> list = new ArrayList<TbDanhMucThietBi>();
//	 Criteria criteria =
//	 sessionFactory.getCurrentSession().createCriteria(TbDanhMucThietBi.class);
//	 list = criteria.list();
//	 return list;
//	 }

	// Lay danh sach - cach 2
	@SuppressWarnings("unchecked")
	public List<TbDanhMucThietBi> getAllDanhMucThietBi() {
		Session session = sessionFactory.getCurrentSession();
		try {
			// session.getTransaction().begin();
			String sql = "Select distinct d From " + TbDanhMucThietBi.class.getName() + " d";
			Query query = session.createQuery(sql);
			List<TbDanhMucThietBi> list = query.list();
//			for (TbDanhMucThietBi dm : list) {
//				System.out.println("Thiet bi: " + dm.getTbDanhMucChungLoai().getTenChungLoai());
//			}
			// session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			// session.getTransaction().rollback();
			System.out.println(e.getMessage());
			return null;
		}

	}

	// Xoa
	public void xoaDanhMucThietBi(TbDanhMucThietBi danhmucthietbi) {
		sessionFactory.getCurrentSession().delete(danhmucthietbi);

	}

	// Lay danh muc tb theo ma- cach 1
	// public TbDanhMucThietBi layMaDanhMucThietBi(String maThietBi) {
	// return (TbDanhMucThietBi)
	// sessionFactory.getCurrentSession().get(TbDanhMucThietBi.class,
	// maThietBi);
	//
	// }

	public TbDanhMucThietBi layMaDanhMucThietBi(String maThietBi) {
		Session session = sessionFactory.getCurrentSession();
		try{
			TbDanhMucThietBi dm = (TbDanhMucThietBi)session.get(TbDanhMucThietBi.class, maThietBi);
		return dm;
		}catch(Exception e){
			System.out.println("DanhMucThietBiDAO" +e.getMessage());
		}
		return null;
	}

	// Sua thiet bi da chon ma
	public void suaDanhMucThietBi(TbDanhMucThietBi danhmucthietbi) {
		sessionFactory.getCurrentSession().update(danhmucthietbi);
	}

	// Them
	public void themDanhMucThietBi(TbDanhMucThietBi danhmucthietbi) {
		sessionFactory.getCurrentSession().saveOrUpdate(danhmucthietbi);
	}

	// Dung de phan trang
	public long demDanhMucThietBi() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TbDanhMucThietBi.class);
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}

	// Tim kiem
	@SuppressWarnings("unchecked")
	public List<TbDanhMucThietBi> timDanhMucThietBi(String chuoiTimKiem, String muc) {
		List<TbDanhMucThietBi> danhsach = new ArrayList<TbDanhMucThietBi>();
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TbDanhMucThietBi.class);
		if ("".equals(chuoiTimKiem)) {
			danhsach = criteria.list();
			return danhsach;
		} else {
			if ("maThietBi".equals(muc)) {
				danhsach = criteria.add(Restrictions.like("maThietBi", "%" + chuoiTimKiem + "%")).list();
			} else if ("tenThietBi".equals(muc)) {
				danhsach = criteria.add(Restrictions.like("tenThietBi", "%" + chuoiTimKiem + "%")).list();
			} else if ("dacTinhKyThuat".equals(muc)) {
				danhsach = criteria.add(Restrictions.like("dacTinhKyThuat", "%" + chuoiTimKiem + "%")).list();
			} else if ("tenChungLoai".equals(muc)) {
				criteria.createAlias("tbDanhMucChungLoai", "project");
				danhsach = criteria.add(Restrictions.like("project.tenChungLoai", "%" + chuoiTimKiem + "%")).list();
			}
			return danhsach;
		}
	}
}
