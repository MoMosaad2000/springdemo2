package com.example.demo.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collections;
import java.util.List;

@Configuration

public class AppConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("https://66bfb07b9a4e0da54aaa6970--papaya-crumble-595094.netlify.app")  // specify allowed origin(s)
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // specify allowed HTTP methods
                        .allowedHeaders("*")  // specify allowed headers
                        .allowCredentials(true);  // allow credentials like cookies
            }
        };
    }

    private CorsConfigurationSource corsConfigurationSource() {
    return new CorsConfigurationSource() {
        @Override
        public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
            CorsConfiguration cfg = new CorsConfiguration();
            cfg.setAllowedOrigins(List.of(
                    "https://66bfb07b9a4e0da54aaa6970--papaya-crumble-595094.netlify.app")
            );
            cfg.setAllowedMethods(Collections.singletonList("*"));
            cfg.setAllowCredentials(true);
            cfg.setAllowedHeaders((Collections.singletonList("*")));
            cfg.setAllowedHeaders((List.of("Authorization")));
            cfg.setMaxAge(3600L);
            return cfg;
        }
    };
}
}
