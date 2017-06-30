package phamnguyen.com.vn.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import phamnguyen.com.vn.dao.BaoTriDAO;
import phamnguyen.com.vn.dao.ChiTietThietBiDAO;
import phamnguyen.com.vn.dao.ChiTietThietBiXuatDAO;
import phamnguyen.com.vn.dao.DanhMucChungLoaiDAO;
import phamnguyen.com.vn.dao.DanhMucThietBiDAO;
import phamnguyen.com.vn.dao.DonViDAO;
import phamnguyen.com.vn.dao.KhoDAO;
import phamnguyen.com.vn.dao.NhanVienDAO;
import phamnguyen.com.vn.dao.NhomThietBiDAO;
import phamnguyen.com.vn.dao.NuocSanXuatDAO;
import phamnguyen.com.vn.dao.PhieuNhapDAO;
import phamnguyen.com.vn.dao.PhieuSuaChuaDAO;
import phamnguyen.com.vn.dao.PhieuXuatDAO;
import phamnguyen.com.vn.dao.PhongBanDAO;
import phamnguyen.com.vn.dao.PhongThucHanhDAO;
import phamnguyen.com.vn.dao.QuyenTruyCapDAO;
import phamnguyen.com.vn.dao.ThietBiDAO;
import phamnguyen.com.vn.dao.ThongKeDAO;
import phamnguyen.com.vn.dao.TinhTrangThietBiDAO;
import phamnguyen.com.vn.dao.XuatDAO;
import phamnguyen.com.vn.entities.TbChiThietThietBiXuat;
import phamnguyen.com.vn.entities.TbChiTietNhapXuat;
import phamnguyen.com.vn.entities.TbChiTietThietBi;
import phamnguyen.com.vn.entities.TbDanhMucChungLoai;
import phamnguyen.com.vn.entities.TbDanhMucThietBi;
import phamnguyen.com.vn.entities.TbDonVi;
import phamnguyen.com.vn.entities.TbKho;
import phamnguyen.com.vn.entities.TbLichSuBaoTri;
import phamnguyen.com.vn.entities.TbLichSuNguoiQuanLy;
import phamnguyen.com.vn.entities.TbNhanVien;
import phamnguyen.com.vn.entities.TbNhomThietBi;
import phamnguyen.com.vn.entities.TbNuocSanXuat;
import phamnguyen.com.vn.entities.TbPhieuDeXuatSuaChua;
import phamnguyen.com.vn.entities.TbPhieuNhap;
import phamnguyen.com.vn.entities.TbPhieuXuat;
import phamnguyen.com.vn.entities.TbPhongBan;
import phamnguyen.com.vn.entities.TbPhongThucHanh;
//import phamnguyen.com.vn.entities.TbNuocSanXuat;
import phamnguyen.com.vn.entities.TbQuyenTruyCap;
import phamnguyen.com.vn.entities.TbTinhTrangThietBi;
import phamnguyen.com.vn.entities.TbXuat;

@Configuration
@ComponentScan("phamnguyen.com.vn.*")
@EnableTransactionManagement
public class AppConfig {
	Environment env;

	@Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean(name = "multipartResolver")
	public MultipartResolver getMultipartResolver() {
		CommonsMultipartResolver resover = new CommonsMultipartResolver();
		// 1MB
		resover.setMaxUploadSize(1 * 10 * 1024 * 1024);
		return resover;
	}
	// @Bean(name = "dataSource")
	// public DataSource getDataSource() {
	// BasicDataSource dataSource = new BasicDataSource();
	// dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	// dataSource.setUrl("jdbc:sqlserver://localhost;databaseName=MockProject");
	// dataSource.setUsername("sa");
	// dataSource.setPassword("Admin123");
	// System.out.println("Connect to database!");
	// return dataSource;
	// }
	//
	// private Properties getHibernateProperties() {
	// Properties properties = new Properties();
	// properties.put("hibernate.show_sql", "true");
	// properties.put("hibernate.dialect",
	// "org.hibernate.dialect.SQLServerDialect");
	// return properties;
	// }

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/thietbi?useUnicode=true&characterEncoding=UTF-8");
		dataSource.setUsername("root");
		dataSource.setPassword("Admin123");
		System.out.println("Connect to database!");
		return dataSource;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		return properties;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(TbQuyenTruyCap.class);
		sessionBuilder.addAnnotatedClass(QuyenTruyCapDAO.class);
		sessionBuilder.addAnnotatedClass(TbNhanVien.class);
		sessionBuilder.addAnnotatedClass(NhanVienDAO.class);	
		sessionBuilder.addAnnotatedClass(TbPhongBan.class);
		sessionBuilder.addAnnotatedClass(PhongBanDAO.class);	
		sessionBuilder.addAnnotatedClass(TbDonVi.class);
		sessionBuilder.addAnnotatedClass(DonViDAO.class);
		sessionBuilder.addAnnotatedClass(TbNhomThietBi.class);
		sessionBuilder.addAnnotatedClass(NhomThietBiDAO.class);
		sessionBuilder.addAnnotatedClass(TbDanhMucChungLoai.class);
		sessionBuilder.addAnnotatedClass(DanhMucChungLoaiDAO.class);
		sessionBuilder.addAnnotatedClass(TbDanhMucThietBi.class);
		sessionBuilder.addAnnotatedClass(DanhMucThietBiDAO.class);
		sessionBuilder.addAnnotatedClass(TbNuocSanXuat.class);
		sessionBuilder.addAnnotatedClass(NuocSanXuatDAO.class);
		sessionBuilder.addAnnotatedClass(TbChiTietNhapXuat.class);
		sessionBuilder.addAnnotatedClass(ThietBiDAO.class);		
		sessionBuilder.addAnnotatedClass(TbChiTietThietBi.class);
		sessionBuilder.addAnnotatedClass(ChiTietThietBiDAO.class);
		sessionBuilder.addAnnotatedClass(TbPhieuNhap.class);
		sessionBuilder.addAnnotatedClass(PhieuNhapDAO.class);
		sessionBuilder.addAnnotatedClass(TbPhieuXuat.class);
		sessionBuilder.addAnnotatedClass(PhieuXuatDAO.class);		
		sessionBuilder.addAnnotatedClass(TbChiThietThietBiXuat.class);
		sessionBuilder.addAnnotatedClass(ChiTietThietBiXuatDAO.class);
		sessionBuilder.addAnnotatedClass(TbKho.class);
		sessionBuilder.addAnnotatedClass(KhoDAO.class);
		sessionBuilder.addAnnotatedClass(TbPhongThucHanh.class);
		sessionBuilder.addAnnotatedClass(PhongThucHanhDAO.class);		
		sessionBuilder.addAnnotatedClass(TbXuat.class);
		sessionBuilder.addAnnotatedClass(XuatDAO.class);		
		sessionBuilder.addAnnotatedClass(TbLichSuBaoTri.class);
		sessionBuilder.addAnnotatedClass(BaoTriDAO.class);		
		sessionBuilder.addAnnotatedClass(TbPhieuDeXuatSuaChua.class);
		sessionBuilder.addAnnotatedClass(PhieuSuaChuaDAO.class);		
		sessionBuilder.addAnnotatedClass(TbTinhTrangThietBi.class);
		sessionBuilder.addAnnotatedClass(TinhTrangThietBiDAO.class);		
		sessionBuilder.addAnnotatedClass(ThongKeDAO.class);		
		sessionBuilder.addAnnotatedClass(TbLichSuNguoiQuanLy.class);		
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

}
