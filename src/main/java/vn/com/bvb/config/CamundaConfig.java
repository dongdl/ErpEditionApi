package vn.com.bvb.config;

import javax.sql.DataSource;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.spring.ProcessEngineFactoryBean;
import org.camunda.bpm.engine.spring.SpringProcessEngineConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.AllArgsConstructor;

@Configuration
@ConfigurationProperties(prefix = "datasource.camunda")
@AllArgsConstructor
public class CamundaConfig extends HikariConfig {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Bean
	public ProcessEngine processEngine() throws Exception {
		logger.info("Creating the process engine.....");
		ProcessEngineFactoryBean processEngineFactoryBean = new ProcessEngineFactoryBean();
		processEngineFactoryBean.setProcessEngineConfiguration(processEngineConfiguration());
		return processEngineFactoryBean.getObject();
	}

	@Bean
	public SpringProcessEngineConfiguration processEngineConfiguration() {
		SpringProcessEngineConfiguration configuration = new SpringProcessEngineConfiguration();
		configuration.setProcessEngineName("hrm");
		configuration.setDataSource(camundaDataSource());
		configuration.setTransactionManager(camundaTransactionManager());
		configuration.setDatabaseSchemaUpdate("true");
		configuration.setHistory("audit");
		configuration.setJobExecutorActivate(true);
		configuration.setDbMetricsReporterActivate(false);

		logger.info("Deploying automatically the processes in the process folder ......");
		Resource resources[] = { new ClassPathResource("process/recruitment_main.bpmn"),
				new ClassPathResource("process/two_eyes_approval.bpmn") };
		configuration.setDeploymentResources(resources);

		return configuration;
	}

	@Bean(name = "camundaTransactionManager")
	public PlatformTransactionManager camundaTransactionManager() {
		return new DataSourceTransactionManager(camundaDataSource());
	}

	@Bean("camundaDataSource")
	public DataSource camundaDataSource() {
		return new HikariDataSource(this);
	}

}
