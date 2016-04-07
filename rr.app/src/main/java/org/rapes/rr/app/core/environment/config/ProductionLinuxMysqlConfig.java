package org.rapes.rr.app.core.environment.config;

import org.rapes.rr.app.core.environment.conditions.ProductionLinuxMysqlCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Conditional(ProductionLinuxMysqlCondition.class)
@PropertySource("classpath:environment/production-mysql.properties")
public class ProductionLinuxMysqlConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductionLinuxMysqlConfig.class);
	
	@Bean
	public static PropertyPlaceholderConfigurer configurer(){
		LOGGER.info("Application is being started as [Linux,MySQLDb]");
		return new PropertyPlaceholderConfigurer();
	}
}
