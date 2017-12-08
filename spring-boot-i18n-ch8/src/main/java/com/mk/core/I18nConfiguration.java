package com.mk.core;

import java.util.Locale;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class I18nConfiguration {
	
    @Bean(name = "localeResolver")
    public I18nLocaleResolver myLocaleResolver(){
    	I18nLocaleResolver localeResolver = new I18nLocaleResolver();
    	localeResolver.setDefaultLocale(Locale.ENGLISH);
        return localeResolver;
    }
}