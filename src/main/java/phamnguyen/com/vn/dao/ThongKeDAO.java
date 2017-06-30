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

import phamnguyen.com.vn.entities.TbDonVi;
import phamnguyen.com.vn.entities.TbPhongThucHanh;
import phamnguyen.com.vn.entities.TbXuat;

@Transactional
@Repository
public class ThongKeDAO extends JdbcDaoSupport {
	@Autowired
	private SessionFactory sessionFactory;

	public ThongKeDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	public ThongKeDAO(DataSource dataSource) {
		setDataSource(dataSource);
	}

	// Danh sach cac phong thuc hanh
	@SuppressWarnings("unchecked")
	public List<TbPhongThucHanh> layDanhSachPTH() {
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "Select x From " + TbPhongThucHanh.class.getName() + " x";
			Query query = session.createQuery(sql);
			List<TbPhongThucHanh> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	//Lay ma phong thuc hanh
	public TbPhongThucHanh layMaPTH(String maPhongThucHanh) {
		Session session = sessionFactory.getCurrentSession();
		try {
			TbPhongThucHanh dm = (TbPhongThucHanh) session.get(TbPhongThucHanh.class, maPhongThucHanh);
			return dm;
		} catch (Exception e) {
			System.out.println("PhongThucHanhDAO" + e.getMessage());
		}
		return null;
	}

	// Lay danh sach thiet bi ung voi ma phong thuc hanh
	@SuppressWarnings("unchecked")
	public List<TbXuat> layDanhSachXuatTheoPTH(String maPth) {
		Session session = sessionFactory.getCurrentSession();
		try {

			String sql = "Select x From " + TbXuat.class.getName() + " x" + " where x.tbPhieuXuat.tbNhanVien.tbPhongThucHanh.maPth=:i";
			Query query = session.createQuery(sql);
			query.setParameter("i", maPth);
			List<TbXuat> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	// Danh sach cac khoa
		@SuppressWarnings("unchecked")
		public List<TbDonVi> layDanhSachDonVi() {
			Session session = sessionFactory.getCurrentSession();
			try {
				String sql = "Select x From " + TbDonVi.class.getName() + " x";
				Query query = session.createQuery(sql);
				List<TbDonVi> list = query.list();
				return list;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				return null;
			}
		}
		//Lay ma khoa
		public TbDonVi layMaKhoa(int maKhoa) {
			Session session = sessionFactory.getCurrentSession();
			try {
				TbDonVi dm = (TbDonVi) session.get(TbDonVi.class, maKhoa);
				return dm;
			} catch (Exception e) {
				System.out.println("DonViDAO" + e.getMessage());
			}
			return null;
		}
		
		// Lay danh sach thiet bi ung voi ma phong thuc hanh
		@SuppressWarnings("unchecked")
		public List<TbXuat> layDanhSachXuatTheoKhoa(int maKhoa) {
			Session session = sessionFactory.getCurrentSession();
			try {

				String sql = "Select y From " + TbXuat.class.getName() + " y" + " where y.tbPhieuXuat.tbNhanVien.tbDonVi.maKhoa=:i";
				Query query = session.createQuery(sql);
				query.setParameter("i", maKhoa);
				List<TbXuat> list = query.list();
				return list;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				return null;
			}
		}
		
}
