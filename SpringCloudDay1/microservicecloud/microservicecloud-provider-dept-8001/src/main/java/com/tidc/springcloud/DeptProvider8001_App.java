package com.tidc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author Kay
 * @Date 2019/12/7 21:35
 * @Version 1.0
 */
@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient
@SpringBootApplication
public class DeptProvider8001_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8001_App.class, args);
    }
}
