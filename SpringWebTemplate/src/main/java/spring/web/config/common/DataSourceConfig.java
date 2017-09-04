package spring.web.config.common;

import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import spring.web.app.system.hibernate.service.PhysicalNamingStrategyImpl;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:properties/database.properties")
public class DataSourceConfig {

	@Autowired
	private Environment env;
	
//	@Bean
//	public DataSource dataSource() {
//		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//		return builder.setType(EmbeddedDatabaseType.HSQL)
//				.addScript("classpath:db/create.sql")
//				.addScript("classpath:db/insert.sql")
//				.build();
//	}

	/* Database Source */
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource source = new BasicDataSource();
		source.setDriverClassName(env.getProperty("database.driverClassName"));
		source.setUrl(env.getProperty("database.url"));
		source.setUsername(env.getProperty("database.username"));
		source.setPassword(env.getProperty("database.password"));
		return source;
	}

	/* Hibernate */
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setPhysicalNamingStrategy(physicalNamingStrategy());
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { 
				"spring.web.app.common.model", 
				"spring.web.app.board.model", 
				"spring.web.app.system.security.model",
				"spring.web.app.system.*.model",
				"spring.web.app.*.*.model"
		});
		sessionFactory.setHibernateProperties(getHibernateProperties());
		return sessionFactory;
	}
	
	@Bean PhysicalNamingStrategy physicalNamingStrategy() {
		return new PhysicalNamingStrategyImpl();
	}

	@Bean
	public Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put(AvailableSettings.DIALECT, env.getRequiredProperty("hibernate.dialect"));
		// 참이면 모든 SQL문 출력 TRUE/FALSE
		properties.put(AvailableSettings.SHOW_SQL, env.getRequiredProperty("hibernate.show_sql"));
		// hibernate.jdbc.fetch.size jdbc조회크기 설정
		//
		// 쿼리문 일괄실행시 사용 - hibernate.jdbc.batch.size
		properties.put(AvailableSettings.STATEMENT_BATCH_SIZE, env.getRequiredProperty("hibernate.batch.size"));
		// 스키마 자동생성 옵션(validate/update/create/create-drop
		properties.put(AvailableSettings.HBM2DDL_AUTO, env.getRequiredProperty("hibernate.hbm2ddl.auto"));
		properties.put(AvailableSettings.CURRENT_SESSION_CONTEXT_CLASS,
				env.getRequiredProperty("hibernate.current.session.context.class"));
		// hibernate.connection.pool_size 커넥션 풀 크기
		return properties;
	}

	/* Transaction */
	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;
	}

}
