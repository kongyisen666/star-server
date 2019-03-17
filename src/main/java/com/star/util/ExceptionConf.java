package com.star.util;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

@Configuration
public class ExceptionConf {
 
    @Bean
    public SimpleMappingExceptionResolver resolver() {
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
        Properties properties = new Properties();
        //未授权页面
        properties.setProperty("org.apache.shiro.authz.UnauthorizedException", "/system/login/no_permission");
        resolver.setExceptionMappings(properties);
        return resolver;
    }
}
