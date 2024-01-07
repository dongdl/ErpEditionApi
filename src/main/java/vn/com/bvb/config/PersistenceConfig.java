package vn.com.bvb.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.AllArgsConstructor;
import vn.com.bvb.Application;
import vn.com.bvb.support.AuditorAwareImpl;

@EnableJpaRepositories(basePackageClasses = Application.class)
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
@EnableTransactionManagement
@ConfigurationProperties(prefix = "datasource.hrm")
@Configuration
@AllArgsConstructor
public class PersistenceConfig extends HikariConfig {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	private Environment env;
	
	private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
	private static final String PROPERTY_NAME_HIBERNATE_MAX_FETCH_DEPTH = "hibernate.max_fetch_depth";
	private static final String PROPERTY_NAME_HIBERNATE_JDBC_FETCH_SIZE = "hibernate.jdbc.fetch_size";
	private static final String PROPERTY_NAME_HIBERNATE_JDBC_BATCH_SIZE = "hibernate.jdbc.batch_size";
	private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	private static final String PROPERTY_NAME_HIBERNATE_DDL_AUTO = "hibernate.hbm2ddl.auto";


	@Bean
	AuditorAware<String> auditorProvider() {
		return new AuditorAwareImpl();
	}

	@Bean
	@Primary
	public PlatformTransactionManager transactionManager() {
	  return new JpaTransactionManager(entityManagerFactory().getObject());
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setJpaVendorAdapter(vendorAdaptor());
		entityManagerFactoryBean.setDataSource(primaryDataSource());
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		entityManagerFactoryBean.setPackagesToScan("vn.com.bvb.entity");
		entityManagerFactoryBean.setJpaProperties(jpaHibernateProperties());

		return entityManagerFactoryBean;
	}
	
	private HibernateJpaVendorAdapter vendorAdaptor() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setShowSql(true);
		return vendorAdapter;
	}
	
	private Properties jpaHibernateProperties() {
        logger.info("Initializing persistent properties >>>>>>>");
        Properties properties = new Properties();
        properties.put(PROPERTY_NAME_HIBERNATE_DIALECT, env.getProperty("spring.jpa.database-platform"));
        properties.put(PROPERTY_NAME_HIBERNATE_MAX_FETCH_DEPTH, env.getProperty("spring.jpa.properties.hibernate.max_fetch_depth"));
        properties.put(PROPERTY_NAME_HIBERNATE_JDBC_FETCH_SIZE, env.getProperty("spring.jpa.properties.hibernate.jdbc.fetch_size"));
        properties.put(PROPERTY_NAME_HIBERNATE_JDBC_BATCH_SIZE, env.getProperty("spring.jpa.properties.hibernate.jdbc.batch_size"));
        properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, env.getProperty("spring.jpa.show-sql"));
        properties.put(PROPERTY_NAME_HIBERNATE_DDL_AUTO, env.getProperty("spring.jpa.ddl-auto"));
        logger.info(properties.toString());

        return properties;
	}


	@Bean
	@Primary
	public DataSource primaryDataSource() {
		return new HikariDataSource(this);
	}
	
}
