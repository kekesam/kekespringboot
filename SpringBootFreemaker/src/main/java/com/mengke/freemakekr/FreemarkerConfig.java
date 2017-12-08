package com.mengke.freemakekr;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;



/**
 * 
 * TzFreemakerInitManager
 * 创建人:xuchengfei 
 * 时间：2015年5月14日-下午2:10:25 
 * @version 1.0.0
 * 
 */
@Component
public class FreemarkerConfig  implements ApplicationContextAware{
	
	@Autowired
	private Configuration configuration;

	private ApplicationContext context;
	
	@PostConstruct
	public void init() throws IOException, TemplateException{
		Map<String, TemplateModel> beans = (Map<String, TemplateModel>) context
				.getBeansOfType(TemplateModel.class);
		for (Entry<String, TemplateModel> entry: beans.entrySet()) {
			configuration.setSharedVariable(entry.getKey(), entry.getValue());
		}
	}
	
	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		this.context = context;
	}
}
