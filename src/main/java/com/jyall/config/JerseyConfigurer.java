package com.jyall.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

/**
 * Created by wang.linqiao on 2016/11/10.
 */
@Configuration
@ApplicationPath("/v1")
public class JerseyConfigurer extends ResourceConfig{
    public JerseyConfigurer() {
        // 注册异常处理类和swagger相关Provider
        packages("com.wordnik.swagger.jersey.listing");
        // 注册Resource，约定为上级目录resource下
        String packageName = JerseyConfigurer.class.getPackage().getName();
        // 所有resource自动扫描，不需要再依次手动添加
        packages(packageName.substring(0, packageName.lastIndexOf(".")) + ".resource");
    }
}
