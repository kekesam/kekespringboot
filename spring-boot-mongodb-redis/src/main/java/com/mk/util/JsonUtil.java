package com.mk.util;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.util.StringUtils;

import com.mk.bean.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonUtil {

	
	private static ObjectMapper objectMapper = new ObjectMapper();
	static {
		
		//返回的json所有属性都包含
		objectMapper.setSerializationInclusion(Inclusion.ALWAYS);
		
		//取消默认转换timestamps形式
		objectMapper.configure(Feature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
		
		//忽略空bean转换json的错误
		objectMapper.configure(Feature.FAIL_ON_EMPTY_BEANS, false);
		
		//所有日期统一格式化
		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		
		//反序列化,忽略json字符串中存在，但在java对象中不存在的属性的情况，放置出错。
		objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	
	
	/**
	 * 
	 * 对象转json字符串格式
	 * 方法名：ToString<br/>
	 * 创建人：xuchengfeifei <br/>
	 * 时间：2017年12月18日-下午7:05:25 <br/>
	 * 手机:15074816437<br/>
	 * @param obj
	 * @return String<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public static<T> String toString(T obj) {
		
		if(obj==null) {
			return null;
		}
		
		try {
			return obj instanceof String ?String.valueOf(obj):objectMapper.writeValueAsString(obj);
		} catch (Exception e) {
			log.error("Parse JsonString to Object error",e);
			return null;
		}
	}
	
	
	/**
	 * 
	 * 格式输出
	 * 对象转json字符串格式
	 * 方法名：ToString<br/>
	 * 创建人：xuchengfeifei <br/>
	 * 时间：2017年12月18日-下午7:05:25 <br/>
	 * 手机:15074816437<br/>
	 * @param obj
	 * @return String<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public static<T> String toStringPretty(T obj) {
		
		if(obj==null) {
			return null;
		}
		
		try {
			return obj instanceof String ?String.valueOf(obj):objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
		} catch (Exception e) {
			log.error("Parse JsonString to Object error",e);
			return null;
		}
	}
	
	
	
	/**
	 * 
	 * json转对象--string转 bean
	 * 方法名：toObject<br/>
	 * 创建人：xuchengfeifei <br/>
	 * 时间：2017年12月18日-下午7:08:15 <br/>
	 * 手机:15074816437<br/>
	 * @param jsonString
	 * @param clz
	 * @return T<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public static <T>T toObject(String jsonString,Class<T> clz){
		if(StringUtils.isEmpty(jsonString) || clz==null) {
			return null;
		}
		try {
			return clz.equals(String.class)?(T)jsonString:objectMapper.readValue(jsonString, clz);
		} catch (Exception e) {
			log.error("Parse JsonString to Object error",e);
			return null;
		}
	}
	
	/**
	 * 反序列化 json转对象集合对象
	 * 方法名：toObject<br/>
	 * 创建人：xuchengfeifei <br/>
	 * 时间：2017年12月18日-下午7:25:09 <br/>
	 * 手机:15074816437<br/>
	 * @param jsonString
	 * @param typeReference
	 * @return T<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public static <T>T toObject(String jsonString,TypeReference<T> typeReference){
		if(StringUtils.isEmpty(jsonString) || typeReference==null) {
			return null;
		}
		try {
			return (T)(typeReference.getType().equals(String.class)?jsonString:objectMapper.readValue(jsonString,typeReference));
		} catch (Exception e) {
			log.error("Parse JsonString to Object error",e);
			return null;
		}
	}
	
	/**
	 * json转对象集合对象
	 * 方法名：toObject<br/>
	 * 创建人：xuchengfeifei <br/>
	 * 时间：2017年12月18日-下午7:27:35 <br/>
	 * 手机:15074816437<br/>
	 * @param jsonString
	 * @param collectionClass
	 * @param clzs
	 * @return T<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public static <T>T toObject(String jsonString,Class<?> collectionClass,Class<?> ...clzs){
		if(StringUtils.isEmpty(jsonString) || collectionClass==null || clzs==null) {
			return null;
		}
		try {
			JavaType javaType = objectMapper.getTypeFactory().constructParametricType(collectionClass, clzs);
			return objectMapper.readValue(jsonString, javaType);
		} catch (Exception e) {
			log.error("Parse JsonString to Object error",e);
			return null;
		}
	}
	
	
	public static void main(String[] args) {
		User user = new com.mk.bean.User();
		user.setId(1);
		user.setDate(new Date());
		user.setPassword("1234t5");
		user.setUsername("xuke");
		
		
		User user2 = new com.mk.bean.User();
		user2.setId(2);
		user2.setDate(new Date());
		user2.setPassword("1234t52222222");
		user2.setUsername("222222222222xuke");
		
		/*System.out.println(JsonUtil.toString(user));
		System.out.println(JsonUtil.toStringPretty(user));
		
		User user2 = JsonUtil.toObject(JsonUtil.toString(user), User.class);
		System.out.println(user2.getUsername());*/
		
		List<User> users = new ArrayList<>();
		users.add(user);
		users.add(user2);
		
		String jsonstring = JsonUtil.toStringPretty(users);
		System.out.println(jsonstring);
		
		
		List<User> users2 = JsonUtil.toObject(jsonstring, new TypeReference<List<User>>() {
		});
		System.out.println(user2);
		
		
		List<User> users3 = JsonUtil.toObject(jsonstring,List.class,User.class);
		System.out.println(users3);
		
	}
	
	
	
	
	

	
}
