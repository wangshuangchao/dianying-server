package com.mugua.dianying;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.mugua.dianying" })
@MapperScan(basePackages={"com.mugua.dianying.mapper"})
public class Application {
	
	public static void main(String... args) {
		SpringApplication.run(Application.class, args);
	}

}
