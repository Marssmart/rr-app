package org.rapes.rr.app.core.context.provider;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.google.common.base.Preconditions;

public class ApplicationContextProvider implements  ApplicationContextAware{

	private ApplicationContext context;
	
	public ApplicationContext provideContext(){
		return context;
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		Preconditions.checkState(this.context == null, "Context allready set");
		this.context=applicationContext;
	}
	
}
