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

import phamnguyen.com.vn.entities.TbKho;

@Transactional
@Repository
public class KhoDAO extends JdbcDaoSupport {
	@Autowired
	private SessionFactory sessionFactory;

	public KhoDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	public KhoDAO(DataSource dataSource) {
		setDataSource(dataSource);
	}

	// Lay danh sach - cach 2
	@SuppressWarnings("unchecked")
	public List<TbKho> layDanhSachKho() {
		Session session = sessionFactory.getCurrentSession();
		try {
			// session.getTransaction().begin();
			String sql = "Select k From " + TbKho.class.getName() + " k";
			Query query = session.createQuery(sql);
			List<TbKho> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			// session.getTransaction().rollback();
			System.out.println(e.getMessage());
			return null;
		}

	}
}
