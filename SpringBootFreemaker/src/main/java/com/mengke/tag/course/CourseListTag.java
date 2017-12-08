package com.mengke.tag.course;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.mengke.bean.User;
import com.mengke.mapper.IUserMapper;
import com.mengke.tag.TmTemplateDirectiveModelUtil;

import freemarker.core.Environment;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * 课程私信
 * TzCourseListTag
 * 创建人:柯柯 
 * 时间：2016年01月16日 02:03:51
 * @version 1.0.0
 *
 */
@Component("userList")
public class CourseListTag implements TemplateDirectiveModel ,ServletContextAware {
	private ServletContext servletContext;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		IUserMapper userMapper =  (IUserMapper) applicationContext.getBean("IUserMapper");
		String var = TmTemplateDirectiveModelUtil.getString("var", params);
		Integer isDelete = TmTemplateDirectiveModelUtil.getInteger("isDelete", params);
		List<User> users = userMapper.findUsers(null);
		if (body != null) {
			if(users!=null && users.size()>0){
				int i = 0;
				env.setVariable(var+"_size", BeansWrapper.BEANS_WRAPPER.wrap(users.size()));
				for (User course : users) {
					env.setVariable(var, BeansWrapper.BEANS_WRAPPER.wrap(course));
					env.setVariable(var+"_index", BeansWrapper.BEANS_WRAPPER.wrap(i));
					body.render(env.getOut());
					i++;
				}
			}else{
				env.setVariable(var, BeansWrapper.BEANS_WRAPPER.wrap(null));
				body.render(env.getOut());
			}
		} else {
		}
	}
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
}
