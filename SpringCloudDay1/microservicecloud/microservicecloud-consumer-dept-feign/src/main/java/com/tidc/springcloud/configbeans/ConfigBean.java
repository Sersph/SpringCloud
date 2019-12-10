package com.tidc.springcloud.configbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author Kay
 * @Date 2019/12/8 13:20
 * @Version 1.0
 */
@Configuration
public class ConfigBean
{
    /**
     * 添加到spring中
     * applicationContext.xml == ConfigBean(@Configuration)
     * <bean id="RestTemplate" class="com.tidc.tmall.RestTemplate" />
     */

    @Bean
    @LoadBalanced //Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端(consumer)负载均衡的工具。
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }

    /**
     * 设置自己选择的算法替代默认的论循
     * @Bean
     * public IRule myRule(){
     *      return new RandomRule();    //随机算法
     *      return new RetryRule();     //策略算法
     * }
     * */

}
