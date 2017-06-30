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

import phamnguyen.com.vn.entities.TbDanhMucChungLoai;

@Transactional
@Repository
public class DanhMucChungLoaiDAO extends JdbcDaoSupport {
	@Autowired
	private SessionFactory sessionFactory;

	public DanhMucChungLoaiDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	public DanhMucChungLoaiDAO(DataSource dataSource) {
		setDataSource(dataSource);
	}

	// Lay danh sach
	@SuppressWarnings("unchecked")
	public List<TbDanhMucChungLoai> layDanhSachChungLoai() {
		Session session = sessionFactory.getCurrentSession();
		try {
			// session.getTransaction().begin();
			String sql = "Select distinct d From " + TbDanhMucChungLoai.class.getName() + " d";
			Query query = session.createQuery(sql);
			List<TbDanhMucChungLoai> list = query.list();
//			for (TbDanhMucChungLoai dm : list) {
//				System.out.println("Chủng loại: " + dm.getTbNhomThietBi().getTenNhomThietBi());
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
	public void xoaChungLoai(TbDanhMucChungLoai danhmucchungloai) {
		sessionFactory.getCurrentSession().delete(danhmucchungloai);

	}

	// Lay danh muc tb theo ma
	public TbDanhMucChungLoai layMaChungLoai(int maChungLoai) {
		Session session = sessionFactory.getCurrentSession();
		try {
			TbDanhMucChungLoai dm = (TbDanhMucChungLoai) session.get(TbDanhMucChungLoai.class, maChungLoai);
			return dm;
		} catch (Exception e) {
			System.out.println("DanhMucChungLoaiDAO" + e.getMessage());
		}
		return null;
	}

	// Sua thiet bi da chon ma
	public void suaChungLoai(TbDanhMucChungLoai danhmucchungloai) {
		sessionFactory.getCurrentSession().update(danhmucchungloai);
	}

	// Them
	public void themChungLoai(TbDanhMucChungLoai danhmucchungloai) {
		sessionFactory.getCurrentSession().saveOrUpdate(danhmucchungloai);
	}


	// Tim kiem
	@SuppressWarnings("unchecked")
	public List<TbDanhMucChungLoai> timChungLoai(String chuoiTimKiem, String muc) {
		List<TbDanhMucChungLoai> danhsach = new ArrayList<TbDanhMucChungLoai>();
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TbDanhMucChungLoai.class);
		if ("".equals(chuoiTimKiem)) {
			danhsach = criteria.list();
			return danhsach;
		} else {
//			if ("maChungLoai".equals(muc)) {
//				danhsach = criteria.add(Restrictions.like("maChungLoai", "%" + chuoiTimKiem + "%")).list();
//			} else 
			if ("tenChungLoai".equals(muc)) {
				danhsach = criteria.add(Restrictions.like("tenChungLoai", "%" + chuoiTimKiem + "%")).list();
			} else if ("ghiChu".equals(muc)) {
				danhsach = criteria.add(Restrictions.like("ghiChu", "%" + chuoiTimKiem + "%")).list();
			} else if ("tenNhomThietBi".equals(muc)) {
				criteria.createAlias("tbNhomThietBi", "project");
				danhsach = criteria.add(Restrictions.like("project.tenNhomThietBi", "%" + chuoiTimKiem + "%")).list();
			}
			return danhsach;
		}
	}
}
