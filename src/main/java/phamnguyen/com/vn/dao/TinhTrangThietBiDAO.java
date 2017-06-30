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

import phamnguyen.com.vn.entities.TbTinhTrangThietBi;

@Transactional
@Repository
public class TinhTrangThietBiDAO extends JdbcDaoSupport {
	@Autowired
	private SessionFactory sessionFactory;

	public TinhTrangThietBiDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	public TinhTrangThietBiDAO(DataSource dataSource) {
		setDataSource(dataSource);
	}

	// Danh sach cac tinh trang
	@SuppressWarnings("unchecked")
	public List<TbTinhTrangThietBi> layTinhTrang() {
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "Select x From " + TbTinhTrangThietBi.class.getName() + " x";
					
			Query query = session.createQuery(sql);
			List<TbTinhTrangThietBi> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}
}
