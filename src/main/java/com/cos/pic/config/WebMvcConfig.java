package com.cos.pic.config;

import com.cos.pic.utils.MyPath;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    // 외부에 있는 폴더를 찾을수 있게 환경을 만들어줌
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("나 실행됬어??");
        WebMvcConfigurer.super.addResourceHandlers(registry);

        // html /upload/*/*를 넣으면 중간에서 가로채서 바꿔준다.
        registry.addResourceHandler("/upload/**").addResourceLocations("file:///" + MyPath.IMAGEPATH)
                .setCachePeriod(60 * 10 * 6).resourceChain(true).addResolver(new PathResourceResolver());
    }
}
