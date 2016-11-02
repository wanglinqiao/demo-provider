package com.jyall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by wang.linqiao on 2016/11/2.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class DemoProvider {
    public static void main(String[] args){
        SpringApplication.run(DemoProvider.class,args);
    }
}
