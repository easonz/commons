package org.eason.common.demo.spring;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.ServletContextAware;

public class SpringContextDemo implements ApplicationContextAware, ServletContextAware {
	
	private static final Logger logger = LoggerFactory.getLogger(SpringContextDemo.class);

	private ServletContext servletContext;  
	private ApplicationContext applicationContext;

	public void setServletContext(ServletContext servletContext) {
		this.servletContext=servletContext;  
	}

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

	
	public void foo(){
		//SomeClass object applicationContext.getBean(SomeClass.class);
		String contextPath = servletContext.getContextPath();
		String realPath = servletContext.getRealPath("/");
	}
}
