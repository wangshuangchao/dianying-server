package com.mugua.dianying;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "cn.mugua" })
public class Application {
	
	public static void main(String... args) {
		SpringApplication.run(Application.class, args);
	}

}
