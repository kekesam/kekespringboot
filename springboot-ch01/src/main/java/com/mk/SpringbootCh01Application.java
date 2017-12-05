package com.mk;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.convert.converter.Converter;

@SpringBootApplication
@ImportResource(locations="classpath:applicationContext.xml")
//@ImportResource(locations= {"classpath:applicationContext.xml","classpath:applicationContext2.xml"})//多个用逗号分开,虚拟代码不能运行
public class SpringbootCh01Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCh01Application.class, args);
	}
	
	@Bean
    public Converter<String, Date> addNewConvert() {
        return new Converter<String, Date>() {
            @Override
            public Date convert(String source) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = null;
                try {
                    date = sdf.parse((String) source);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return date;
            }
        };
    }
	
	
}
