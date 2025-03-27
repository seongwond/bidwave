package com.bidwave.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");


        // images 폴더를 처리할 수 있도록 설정
        registry.addResourceHandler("/images/**")
                .addResourceLocations("classpath:/static/images/");  // 실제 이미지 파일들이 위치하는 경로

    }
}
