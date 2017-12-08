package com.mk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringmvcBootCh4Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringmvcBootCh4Application.class, args);
	}
	
	/*@Bean
	public MultipartResolver multipartResolver() throws IOException {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(100*1024*1024);//100MB,是限制总的上传文件大小
		multipartResolver.setDefaultEncoding("UTF-8");//编码设置
		multipartResolver.setResolveLazily(false);
		multipartResolver.setUploadTempDir(new FileSystemResource("c://temp"));//设置上传的临时目录
		multipartResolver.setMaxInMemorySize(10240);//文件上传读写的字节数10KB,建议不要修改。
		multipartResolver.setMaxUploadSizePerFile(10*1024*1024);//10MB 是限制每个上传文件的大小，
		return multipartResolver;
	}*/
}
