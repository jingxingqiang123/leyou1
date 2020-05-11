package com.leyou.gatewayconfig;

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

        // 初始化cors配置对象
        CorsConfiguration corsConfig = new CorsConfiguration();

        // 允许跨域的域名，如果要携带cookie,不能写*。 *代表所有域名都可以跨域访问
        corsConfig.setAllowCredentials(true);  // 允许携带cookie
        //corsConfig.addAllowedOrigin("http://manage.leyou.com");
        //corsConfig.addAllowedOrigin("http://manage.leyou.com");
        //corsConfig.addAllowedOrigin("http://www.leyou.com");
        corsConfig.addAllowedOrigin("*");
        corsConfig.addAllowedMethod("*"); // 所有的请求方法: put get posr head
//        corsConfig.addAllowedMethod("OPTIONS");
//        corsConfig.addAllowedMethod("HEAD");
//        corsConfig.addAllowedMethod("GET");
//        corsConfig.addAllowedMethod("PUT");
//        corsConfig.addAllowedMethod("POST");
//        corsConfig.addAllowedMethod("DELETE");
//        corsConfig.addAllowedMethod("PATCH");
        corsConfig.addAllowedHeader("*"); // 允许携带任何头信息

        // 初始化cors配置源对象
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();

        configSource.registerCorsConfiguration("/**", corsConfig);

        // 返回corsFilter实例,参数：cors配置源对象
        return new CorsFilter(configSource);
    }
}
