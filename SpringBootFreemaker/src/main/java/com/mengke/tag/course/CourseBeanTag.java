package com.mengke.tag.course;
//package com.mengke.tag;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.ServletContext;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.ServletContextAware;
//import org.springframework.web.context.support.WebApplicationContextUtils;
//
//import com.tz.core.tag.TmTemplateDirectiveModelUtil;
//import com.tz.dao.course.ICourseDao;
//import com.tz.model.TmParams;
//
//import freemarker.core.Environment;
//import freemarker.ext.beans.BeansWrapper;
//import freemarker.template.TemplateDirectiveBody;
//import freemarker.template.TemplateDirectiveModel;
//import freemarker.template.TemplateException;
//import freemarker.template.TemplateModel;
//
///**
// * 课程私信
// * TmCourseBean
// * 创建人:柯柯 
// * 时间：2016年01月16日 02:03:51
// * @version 1.0.0
// *
// */
//@Component("courseBean")
//public class CourseBeanTag implements TemplateDirectiveModel,ServletContextAware {
//	
//	private ServletContext servletContext;
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	public void execute(Environment env, Map params, TemplateModel[] loopVars,
//			TemplateDirectiveBody body) throws TemplateException, IOException {
//		ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
//		ICourseDao courseDao =  (ICourseDao) applicationContext.getBean("ICourseDao");
//		String var = TmTemplateDirectiveModelUtil.getString("var", params);
//		Integer id = TmTemplateDirectiveModelUtil.getInteger("id",params);
//		Integer userId = TmTemplateDirectiveModelUtil.getInteger("userId",params);
//		if (var == null) var = "course";
//		TmParams params2 = new TmParams();
//		params2.setId(id);
//		params2.setUserId(userId);
//		HashMap<String, Object> content = courseDao.getCourse(params2);
//		if (content != null) {
//			env.setVariable(var, BeansWrapper.BEANS_WRAPPER.wrap(content));
//		}
//
//		if (body != null) {
//			if (content != null) {
//				body.render(env.getOut());
//			}
//		}
//	}
//	
//	@Override
//	public void setServletContext(ServletContext servletContext) {
//		this.servletContext = servletContext;
//	}
//}
