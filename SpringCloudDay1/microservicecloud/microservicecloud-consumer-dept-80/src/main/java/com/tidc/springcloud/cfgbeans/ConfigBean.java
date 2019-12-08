package com.tidc.springcloud.cfgbeans;

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
    @Bean
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }

    /**
     * applicationContext.xml == ConfigBean(Configuration)
     * <bean id="RestTemplate" class="com.tidc.tmall.RestTemplate" />
     */
}
