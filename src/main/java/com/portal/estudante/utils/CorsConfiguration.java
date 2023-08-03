package com.portal.estudante.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfiguration implements WebMvcConfigurer{
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:3000") // Coloque a origem permitida (seu frontend)
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
            .allowCredentials(true);
    }
}
