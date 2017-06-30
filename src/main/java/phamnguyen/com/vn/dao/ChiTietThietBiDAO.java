package phamnguyen.com.vn.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import phamnguyen.com.vn.entities.TbChiTietNhapXuat;
import phamnguyen.com.vn.entities.TbChiTietThietBi;

@Transactional
@Repository
public class ChiTietThietBiDAO extends JdbcDaoSupport {
	@Autowired
	private SessionFactory sessionFactory;

	public ChiTietThietBiDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	public ChiTietThietBiDAO(DataSource dataSource) {
		setDataSource(dataSource);
	}

	// Lay ma de xuat ra thong tin
	public TbChiTietNhapXuat layThietBiId(int tbId) {
		Session session = sessionFactory.getCurrentSession();
		try {
			TbChiTietNhapXuat dm = (TbChiTietNhapXuat) session.get(TbChiTietNhapXuat.class, tbId);
			return dm;
		} catch (Exception e) {
			System.out.println("ThietBiDAO" + e.getMessage());
		}
		return null;
	}

	// Lay danh sach phu tung ung voi moi ma
	@SuppressWarnings("unchecked")
	public List<TbChiTietThietBi> layDanhSachPhuTung(int tbId) {
		Session session = sessionFactory.getCurrentSession();
		try {

			String sql = "Select d From " + TbChiTietThietBi.class.getName() + " d"
					+ " where d.tbChiTietNhapXuat.thietBiId=:i";
			Query query = session.createQuery(sql);
			query.setParameter("i", tbId);
			List<TbChiTietThietBi> list = query.list();
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

	// Them
	public void themPhuTung(TbChiTietThietBi chitietthietbi) {
		sessionFactory.getCurrentSession().saveOrUpdate(chitietthietbi);
	}

	// Lay ma thiet bi de xuat them phu tung
	public TbChiTietNhapXuat layMaThietBiThemPhuTung(int thietBiId) {
		Session session = sessionFactory.getCurrentSession();
		try {
			TbChiTietNhapXuat dm = (TbChiTietNhapXuat) session.get(TbChiTietNhapXuat.class, thietBiId);
			return dm;
		} catch (Exception e) {
			System.out.println("ChiTietThietBiDAO" + e.getMessage());
		}
		return null;
	}
}
