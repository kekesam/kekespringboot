package com.mk;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;

@SpringBootApplication
@MapperScan(basePackages="com.mk.mapper")
public class SpringmvcBootCh4Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringmvcBootCh4Application.class, args);
	}
	
	/*@Bean
    public Converter<String, Date> addNewConvert() {
        return new Converter<String, Date>() {
            @Override
            public Date convert(String source) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date = null;
            try {
                date = sdf.parse((String) source);
                } catch (Exception e) {
                e.printStackTrace();
                }
             return date;
            }
        };
    }*/
	
//	@Bean
//	public ObjectMapper getObjectMapper() {
//		ObjectMapper objectMapper = new ObjectMapper();
//		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
//		objectMapper.setDefaultPropertyInclusion(Include.NON_EMPTY);
//		return objectMapper;
//	}
}
