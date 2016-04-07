package org.rapes.rr.app.core.environment.config;

import org.rapes.rr.app.core.environment.conditions.LocalDevelWindowsHsqlCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Conditional(LocalDevelWindowsHsqlCondition.class)
@PropertySource("classpath:environment/local-devel-hsql.properties")
public class LocalDevelWindowsHsqlConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(LocalDevelWindowsHsqlConfig.class);

	@Bean
	public static PropertyPlaceholderConfigurer configurer() {
		LOGGER.info("Application is being started as [Windows,HSQLDB]");
		return new PropertyPlaceholderConfigurer();
	}

	
}
