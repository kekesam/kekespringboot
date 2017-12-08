package com.mengke.util;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

/**
 * 
 * json转换类 JSONUtil<br/>
 * 创建人:xuchengfei<br/>
 * 时间：2017年7月21日-上午9:12:14 <br/>
 * 
 * @version 1.0.0<br/>
 *
 */
public class JSONUtil {

	/*
	 * 导入包：json-lib-2.4-jdk15.jar
	 */

	/**
	 * 对象 map转字符串 方法名：toJson<br/>
	 * 创建人：xuchengfei <br/>
	 * 时间：2017年7月21日-上午9:52:14 <br/>
	 * 手机:1564545646464<br/>
	 * 
	 * @param object
	 * @return String<br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	public static String toJson(Object object) {
		// JsonConfig提供了在对一个Json串和Java对象进行互转时，有选择性的过滤掉一些属性值的方法
		JsonConfig config = new JsonConfig();
		config.registerJsonValueProcessor(Date.class, new JSONUtil.DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
		JSONObject jsonObject = new JSONObject();
		String json = jsonObject.fromObject(object, config).toString();
		return json;
	}

	/**
	 * 集合转json字符串 方法名：toJson<br/>
	 * 创建人：xuchengfei <br/>
	 * 时间：2017年7月21日-上午9:51:53 <br/>
	 * 手机:1564545646464<br/>
	 * 
	 * @param object
	 * @return String<br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	public static String toJson(List object) {
		JsonConfig config = new JsonConfig();
		config.registerJsonValueProcessor(Date.class, new JSONUtil.DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
		JSONArray jsonArray = new JSONArray();
		String jsonstring = jsonArray.fromObject(object, config).toString();
		return jsonstring;
	}

	static class DateJsonValueProcessor implements JsonValueProcessor {
		private String format;

		public DateJsonValueProcessor(String format) {
			this.format = format;
		}

		public Object processArrayValue(Object value, JsonConfig jsonConfig) {
			return null;
		}

		public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
			if (value == null) {
				return "";
			}
			if (value instanceof java.sql.Timestamp) {
				String str = new SimpleDateFormat(format).format((java.sql.Timestamp) value);
				return str;
			}
			if (value instanceof java.util.Date) {
				String str = new SimpleDateFormat(format).format((java.util.Date) value);
				return str;
			}

			return value.toString();
		}
	}
}