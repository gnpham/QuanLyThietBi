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

import phamnguyen.com.vn.entities.TbXuat;

@Transactional
@Repository
public class XuatDAO extends JdbcDaoSupport {
	@Autowired
	private SessionFactory sessionFactory;

	public XuatDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	public XuatDAO(DataSource dataSource) {
		setDataSource(dataSource);
	}

	// Them
	public void themXuat(TbXuat danhsachxuat) {
		sessionFactory.getCurrentSession().saveOrUpdate(danhsachxuat);
	}

	// Lay danh sach thiet bi ung voi ma phieu xuat
	@SuppressWarnings("unchecked")
	public List<TbXuat> layDanhSachXuatTheoMa(String maPhieuXuat) {
		Session session = sessionFactory.getCurrentSession();
		try {

			String sql = "Select x From " + TbXuat.class.getName() + " x" + " where x.tbPhieuXuat.maPhieuXuat=:i";
			Query query = session.createQuery(sql);
			query.setParameter("i", maPhieuXuat);
			List<TbXuat> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}

	// Danh sach cac thiet bi da xuat - duoc nhom lai boi ma phieu xuat - chuc
	// nang bao tri
	@SuppressWarnings("unchecked")
	public List<TbXuat> layDanhSachXuat() {
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "Select x From " + TbXuat.class.getName() + " x" + " order by x.tbPhieuXuat.maPhieuXuat asc";
			Query query = session.createQuery(sql);
			List<TbXuat> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}
	
//	 Xoa
	 public void xoaLanXuat(TbXuat danhsachtbxuat) {
	 sessionFactory.getCurrentSession().delete(danhsachtbxuat);	
	 }


	// Lay ma xuat
	public TbXuat layMaXuat(int maXuat) {
		return (TbXuat) sessionFactory.getCurrentSession().get(TbXuat.class, maXuat);
	}
	

	// Sua xuat da chon ma
	public void suaXuat(TbXuat danhsachxuat) {
		sessionFactory.getCurrentSession().update(danhsachxuat);
	}

	// Tim kiem
	@SuppressWarnings("unchecked")
	public List<TbXuat> timThietBiDaXuat(String chuoiTimKiem, String muc) {
		List<TbXuat> danhsach = new ArrayList<TbXuat>();
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TbXuat.class);
		if ("".equals(chuoiTimKiem)) {
			danhsach = criteria.list();
			return danhsach;
		} else {
			if ("maPhieuXuat".equals(muc)) {
				criteria.createAlias("tbPhieuXuat", "project");
				danhsach = criteria.add(Restrictions.like("project.maPhieuXuat", "%" + chuoiTimKiem + "%")).list();
			} else if ("maThietBi".equals(muc)) {
				criteria.createAlias("tbChiTietNhapXuat.tbDanhMucThietBi", "project");
				danhsach = criteria.add(Restrictions.like("project.maThietBi", "%" + chuoiTimKiem + "%")).list();
			} else if ("tenThietBi".equals(muc)) {
				criteria.createAlias("tbChiTietNhapXuat.tbDanhMucThietBi", "project");
				danhsach = criteria.add(Restrictions.like("project.tenThietBi", "%" + chuoiTimKiem + "%")).list();
			} else if ("maCode".equals(muc)) {
				criteria.createAlias("tbChiTietNhapXuat", "project");
				danhsach = criteria.add(Restrictions.like("project.maCode", "%" + chuoiTimKiem + "%")).list();
			} else if ("hoTen".equals(muc)) {
				criteria.createAlias("tbPhieuXuat.tbNhanVien", "project");
				danhsach = criteria.add(Restrictions.like("project.hoTen", "%" + chuoiTimKiem + "%")).list();
			} else if ("maPth".equals(muc)) {
				criteria.createAlias("tbPhieuXuat.tbNhanVien.tbPhongThucHanh", "project");
				danhsach = criteria.add(Restrictions.like("project.maPth", "%" + chuoiTimKiem + "%")).list();
			}
			return danhsach;
		}
	}
}