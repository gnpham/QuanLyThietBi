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

import phamnguyen.com.vn.entities.TbQuyenTruyCap;

@Transactional
@Repository
public class QuyenTruyCapDAO extends JdbcDaoSupport {
	@Autowired
	private SessionFactory sessionFactory;

	public QuyenTruyCapDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	public QuyenTruyCapDAO(DataSource dataSource) {
		setDataSource(dataSource);
	}

	// Lay danh sach
	@SuppressWarnings("unchecked")
	public List<TbQuyenTruyCap> layDanhSachQuyen() {
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "Select d From " + TbQuyenTruyCap.class.getName() + " d";
			Query query = session.createQuery(sql);
			List<TbQuyenTruyCap> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}

}