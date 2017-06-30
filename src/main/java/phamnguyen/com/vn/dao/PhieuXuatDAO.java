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

import phamnguyen.com.vn.entities.TbPhieuXuat;

@Transactional
@Repository
public class PhieuXuatDAO extends JdbcDaoSupport {
	@Autowired
	private SessionFactory sessionFactory;

	public PhieuXuatDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	public PhieuXuatDAO(DataSource dataSource) {
		setDataSource(dataSource);
	}

	// Lay danh sach
	@SuppressWarnings("unchecked")
	public List<TbPhieuXuat> layDanhSachPhieuXuat() {
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "Select distinct d From " + TbPhieuXuat.class.getName() + " d" + " order by d.ngayXuat desc";
			Query query = session.createQuery(sql);
			List<TbPhieuXuat> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}

//	 Xoa
	 public void xoaPhieuXuat(TbPhieuXuat danhsachphieuxuat) {
	 sessionFactory.getCurrentSession().delete(danhsachphieuxuat);
	
	 }

	// Lay phieu xuat tb theo ma
	public TbPhieuXuat layMaPhieuXuat(String maPhieuXuat) {
		return (TbPhieuXuat) sessionFactory.getCurrentSession().get(TbPhieuXuat.class, maPhieuXuat);

	}

	// Sua phieu xuat da chon ma
	public void suaDanhSachPhieuXuat(TbPhieuXuat danhsachphieuxuat) {
		sessionFactory.getCurrentSession().update(danhsachphieuxuat);
	}

	//
	// Them
	public void themPhieuXuat(TbPhieuXuat danhsachphieuxuat) {
		sessionFactory.getCurrentSession().saveOrUpdate(danhsachphieuxuat);
	}

	//
	// // Dung de phan trang
	// public long demDanhMucThietBi() {
	// Criteria criteria =
	// sessionFactory.getCurrentSession().createCriteria(TbDanhMucThietBi.class);
	// criteria.setProjection(Projections.rowCount());
	// return (Long) criteria.uniqueResult();
	// }
	//
	// Tim kiem
	@SuppressWarnings("unchecked")
	public List<TbPhieuXuat> timKiemPhieuXuat(String chuoiTimKiem, String muc) {
		List<TbPhieuXuat> danhsach = new ArrayList<TbPhieuXuat>();
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TbPhieuXuat.class);
		if ("".equals(chuoiTimKiem)) {
			danhsach = criteria.list();
			return danhsach;
		} else {
			if ("maPhieuXuat".equals(muc)) {
				danhsach = criteria.add(Restrictions.like("maPhieuXuat", "%" + chuoiTimKiem + "%")).list();
			} else if ("nguoiXuat".equals(muc)) {
				criteria.createAlias("tbNhanVien", "project");
				danhsach = criteria.add(Restrictions.like("project.hoTen", "%" + chuoiTimKiem + "%")).list();
			} else if ("tenThietBi".equals(muc)) {
				criteria.createAlias("tbKho", "project");
				danhsach = criteria.add(Restrictions.like("project.tenKho", "%" + chuoiTimKiem + "%")).list();
			} else if ("hoTen".equals(muc)) {
				criteria.createAlias("tbNhanVien", "project");
				danhsach = criteria.add(Restrictions.like("project.hoTen", "%" + chuoiTimKiem + "%")).list();
			} else if ("maPth".equals(muc)) {
				criteria.createAlias("tbNhanVien.tbPhongThucHanh", "project");
				danhsach = criteria.add(Restrictions.like("project.maPth", "%" + chuoiTimKiem + "%")).list();
			}
			return danhsach;
		}
	}
}
