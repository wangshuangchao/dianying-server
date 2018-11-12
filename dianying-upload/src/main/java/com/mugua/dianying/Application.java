package com.mugua.dianying;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.github.tobato.fastdfs.FdfsClientConfig;

@SpringBootApplication(scanBasePackages = { "cn.mugua" })
@Import(FdfsClientConfig.class) // fastDFS
@MapperScan("com.mugua.dianying.mapper")
public class Application {
	
	public static void main(String... args) {
		SpringApplication.run(Application.class, args);
	}

}
