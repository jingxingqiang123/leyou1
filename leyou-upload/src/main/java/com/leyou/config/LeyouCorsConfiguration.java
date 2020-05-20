package com.leyou.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * cors处理跨域请求的过滤器
 */
@Configuration
public class LeyouCorsConfiguration {

    @Bean
    public CorsFilter corsFilter() {

        // 3、初始化cors配置对象
        CorsConfiguration corsConfig = new CorsConfiguration();


        // 3.1、允许跨域的域名，如果要携带cookie,不能写*。 *代表所有域名都可以跨域访问
        corsConfig.addAllowedOrigin("*");
        corsConfig.addAllowedOrigin("http://manage.leyou.com");
        // 3.2、是否发送Cookie信息
        corsConfig.setAllowCredentials(true);  // 允许携带cookie
        // 3.3、允许的头信息
        corsConfig.addAllowedHeader("*"); // 允许携带任何头信息
        // 3.4、允许的请求方式
        corsConfig.addAllowedMethod("*"); // 代表所有的请求方法 GET POST DEL
//        corsConfig.addAllowedMethod("OPTIONS");
//        corsConfig.addAllowedMethod("HEAD");
//        corsConfig.addAllowedMethod("GET");
//        corsConfig.addAllowedMethod("PUT");
//        corsConfig.addAllowedMethod("POST");
//        corsConfig.addAllowedMethod("DELETE");
//        corsConfig.addAllowedMethod("PATCH");


        // 2、初始化cors配置源对象
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        // 添加映射路径，拦截一切请求
        configSource.registerCorsConfiguration("/**", corsConfig);

        // 1、返回corsFilter实例,参数：cors配置源对象
        return new CorsFilter(configSource);
    }
}
