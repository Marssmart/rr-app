package org.rapes.rr.app.core.environment.conditions;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class ProductionLinuxMysqlCondition implements Condition{

	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		  return (context.getEnvironment().getProperty("os.name").indexOf("nux") >= 0 
                || context.getEnvironment().getProperty("os.name").indexOf("aix") >= 0);
	}

	
}
