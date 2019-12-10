package com.tidc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


/**
 * @Author Kay
 * @Date 2019/12/8 13:37
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
//@ComponentScan("com.tidc.springcloud")
@EnableFeignClients(basePackages= {"com.tidc.springcloud"})
public class DeptConsumer80_Feign_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_Feign_App.class, args);
    }
}
