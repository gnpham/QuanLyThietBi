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

import phamnguyen.com.vn.entities.TbNhomThietBi;

@Transactional
@Repository
public class NhomThietBiDAO extends JdbcDaoSupport {
	@Autowired
	private SessionFactory sessionFactory;

	public NhomThietBiDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	public NhomThietBiDAO(DataSource dataSource) {
		setDataSource(dataSource);
	}

	// Lay danh sach - cach 2
	@SuppressWarnings("unchecked")
	public List<TbNhomThietBi> layDanhSachNhomThietBi() {
		Session session = sessionFactory.getCurrentSession();
		try {
			// session.getTransaction().begin();
			String sql = "Select d From " + TbNhomThietBi.class.getName() + " d";
			Query query = session.createQuery(sql);
			List<TbNhomThietBi> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}

	}
}