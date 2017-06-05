package petfriends.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

import petfriends.model.AdoptBean;
import petfriends.model.AdoptPhotosBean;

@Configuration
@ComponentScan(basePackages={"petfriends.configuration"})
public class HibernateConfiguration {
	//設定hibernate與設定datasource連結
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		dmds.setUrl("jdbc:sqlserver://localhost:1433;database=PetFriends");
		dmds.setUsername("sa");
		dmds.setPassword("passw0rd");
		return dmds;
	}

	@Bean
	public SessionFactory sessionFactory() {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource());
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
		props.setProperty("hibernate.current_session_context_class", "thread");
		props.setProperty("hibernate.show_sql", "true");
		builder.addProperties(props);
		builder.addAnnotatedClasses(AdoptBean.class, AdoptPhotosBean.class);
		
//		builder.configure("hibernate.cfg.xml");
		
		return builder.buildSessionFactory();
	}
}
