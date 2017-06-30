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

import phamnguyen.com.vn.entities.TbNuocSanXuat;

@Transactional
@Repository
public class NuocSanXuatDAO extends JdbcDaoSupport {
	@Autowired
	private SessionFactory sessionFactory;

	public NuocSanXuatDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	public NuocSanXuatDAO(DataSource dataSource) {
		setDataSource(dataSource);
	}

	// Lay danh sach - cach 2
	@SuppressWarnings("unchecked")
	public List<TbNuocSanXuat> layDanhSachNuoc() {
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "Select d From " + TbNuocSanXuat.class.getName() + " d";
			Query query = session.createQuery(sql);
			List<TbNuocSanXuat> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}

	}

	// Xoa
	public void xoaNuoc(TbNuocSanXuat danhsachnuoc) {
		sessionFactory.getCurrentSession().delete(danhsachnuoc);

	}
}