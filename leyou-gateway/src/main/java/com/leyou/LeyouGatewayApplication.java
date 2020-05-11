package com.leyou;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by jingxingqiang on 2019/12/21 0:02
 */
@SpringBootApplication
@EnableDiscoveryClient  // eureka的客户端
@EnableZuulProxy        // 开启zuul
public class LeyouGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(LeyouGatewayApplication.class,args);
    }
}

