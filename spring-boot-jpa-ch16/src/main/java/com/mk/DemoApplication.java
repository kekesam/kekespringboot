package com.mk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	/*@Bean  
    public DataSource dataSource() {  
        HikariConfig config = new HikariConfig(getClass().getClassLoader().getResource("db.properties").getPath());  
        return new HikariDataSource(config);  
    } */
}
