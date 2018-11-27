package com.lc.platform.web.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lc.platform.core.BaseApp;

@SpringBootApplication
@MapperScan("com.lc.platform.**.mapper")
public class DemoApp extends BaseApp {
	public static void main(String[] args) {
		SpringApplication.run(DemoApp.class,args);
	}
}
