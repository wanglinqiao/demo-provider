package com.jyall;

import com.jyall.config.SwaggerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by wang.linqiao on 2016/11/2.
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.jyall"})
public class DemoProvider implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoProvider.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        SwaggerConfigurer.initSwagger("生产接口","生产接口列表");
    }
}
