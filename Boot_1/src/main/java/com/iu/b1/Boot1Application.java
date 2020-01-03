package com.iu.b1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement //생략가능
@SpringBootApplication
@EnableAspectJAutoProxy //생략가능
//@ComponentScan(basePackages = "com.") 굳이..?
public class Boot1Application {

	public static void main(String[] args) {
		SpringApplication.run(Boot1Application.class, args);
	}

}
