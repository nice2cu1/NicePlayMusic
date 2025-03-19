package com.nice2cu1.niceplaymusic.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 允许所有路径进行跨源请求
                .allowedOriginPatterns("*") // 允许所有的源
                .allowedMethods("GET", "POST", "PUT", "DELETE") // 允许这些请求方法
                .allowedHeaders("*") // 允许所有的请求头
                .allowCredentials(true) // 允许凭证
                .maxAge(3600); // 预检请求的缓存时间
    }
}