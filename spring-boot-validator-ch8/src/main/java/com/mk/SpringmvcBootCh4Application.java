package com.mk;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;

@SpringBootApplication
public class SpringmvcBootCh4Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringmvcBootCh4Application.class, args);
	}
	
	/**
	 *  配置验证码参数
	 * 方法名：getDefaultKaptcha<br/>
	 * 创建人：xuke <br/>
	 * 时间：2017年11月28日-下午8:22:27 <br/>
	 * 手机:15074816437<br/>
	 * @return DefaultKaptcha<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@Bean
	public DefaultKaptcha getDefaultKaptcha() {
		DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
		Properties properties = new Properties();
		properties.setProperty("kaptcha.border","no");
		properties.setProperty("kaptcha.textproducer.font.color","black");
		properties.setProperty("kaptcha.image.width","122");
		properties.setProperty("kaptcha.image.height","46");
		properties.setProperty("kaptcha.textproducer.font.size","32");
		properties.setProperty("kaptcha.session.key","code");
		properties.setProperty("kaptcha.noise.color","white");
		properties.setProperty("kaptcha.textproducer.char.space","3");
		properties.setProperty("kaptcha.obscurificator.impl","com.google.code.kaptcha.impl.ShadowGimpy");
		properties.setProperty("kaptcha.textproducer.char.length","4");
		properties.setProperty("kaptcha.textproducer.font.names","宋体,楷体,微软雅黑");
		Config config = new Config(properties);
		defaultKaptcha.setConfig(config);
		return defaultKaptcha;
	}
}
