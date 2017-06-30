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

import phamnguyen.com.vn.entities.TbLichSuBaoTri;
import phamnguyen.com.vn.entities.TbLichSuNguoiQuanLy;
import phamnguyen.com.vn.entities.TbXuat;

@Transactional
@Repository
public class BaoTriDAO extends JdbcDaoSupport {
	@Autowired
	private SessionFactory sessionFactory;

	public BaoTriDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	public BaoTriDAO(DataSource dataSource) {
		setDataSource(dataSource);
	}

	// Lay ma de xuat ra thong tin
	public TbXuat layMaXuat(int xuatId) {
		Session session = sessionFactory.getCurrentSession();
		try {
			TbXuat dm = (TbXuat) session.get(TbXuat.class, xuatId);
			return dm;
		} catch (Exception e) {
			System.out.println("BaoTriDAO" + e.getMessage());
		}
		return null;
	}

	// Lay danh sach bao tri ung voi moi ma xuat
	@SuppressWarnings("unchecked")
	public List<TbLichSuBaoTri> layDanhSachBaoTri(int xuatId) {
		Session session = sessionFactory.getCurrentSession();
		try {

			String sql = "Select l From " + TbLichSuBaoTri.class.getName() + " l" + " where l.tbXuat.maXuat=:i";
			Query query = session.createQuery(sql);
			query.setParameter("i", xuatId);
			List<TbLichSuBaoTri> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}

	// Xoa
	public void xoaLanBaoTri(TbLichSuBaoTri danhsachbaotri) {
		sessionFactory.getCurrentSession().delete(danhsachbaotri);

	}

	// Sua lan bao tri da chon ma
	public void suaLanBaoTri(TbLichSuBaoTri danhsachbaotri) {
		sessionFactory.getCurrentSession().update(danhsachbaotri);
	}

	// Lay tinh trang moi nhat cua thiet bi xuat ung voi ma xuat
	public String layTinhTrangMoiNhat(int maXuat) {
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "Select t.tinhTrang From TbLichSuBaoTri l inner join l.tbTinhTrangThietBi t"
					+ " where l.maLsbt = (Select max(ls.maLsbt) From TbLichSuBaoTri ls where "
					+ " ls.tbXuat.maXuat=:i)";
			Query query = session.createQuery(sql);
			query.setParameter("i", maXuat);
			return (String) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}

	// Lay ma lan bao tri
	public TbLichSuBaoTri layMaLanBaoTri(int maLsbt) {
		Session session = sessionFactory.getCurrentSession();
		try {
			TbLichSuBaoTri dm = (TbLichSuBaoTri) session.get(TbLichSuBaoTri.class, maLsbt);
			return dm;
		} catch (Exception e) {
			System.out.println("LichSuBaoTriDAO" + e.getMessage());
		}
		return null;
	}

	// Lay danh sach nguoi quan ly ung voi moi ma
	@SuppressWarnings("unchecked")
	public List<TbLichSuNguoiQuanLy> layDanhSachNguoiQuanLy(int xuatId) {
		Session session = sessionFactory.getCurrentSession();
		try {

			String sql = "Select n From " + TbLichSuNguoiQuanLy.class.getName() + " n"
					+ " where n.tbXuat.maXuat=:i order by n.ngayBatDau asc";
			Query query = session.createQuery(sql);
			query.setParameter("i", xuatId);
			List<TbLichSuNguoiQuanLy> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}

	// Xoa
	// public void xoaThietBi(TbChiTietNhapXuat danhsachtb) {
	// sessionFactory.getCurrentSession().delete(danhsachtb);
	//
	// }

	// // Sua thiet bi da chon ma
	// public void suaThietBi(TbChiTietNhapXuat danhsachtb) {
	// sessionFactory.getCurrentSession().update(danhsachtb);
	// }

	// Them bao tri
	public void themLichSuBaoTri(TbLichSuBaoTri danhsachlsbt) {
		sessionFactory.getCurrentSession().saveOrUpdate(danhsachlsbt);
	}

	// Them nguoi quan ly
	public void themLichSuNQL(TbLichSuNguoiQuanLy danhsachlsnql) {
		sessionFactory.getCurrentSession().saveOrUpdate(danhsachlsnql);
	}

}
