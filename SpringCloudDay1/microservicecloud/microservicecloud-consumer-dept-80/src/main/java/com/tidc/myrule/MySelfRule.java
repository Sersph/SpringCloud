package com.tidc.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Kay
 * @Date 2019/12/9 16:54
 * @Version 自定义Robbin的规则类
 */
@Configuration
public class MySelfRule {


    @Bean
    public IRule myRule(){
        /**
         * Ribbon默认是轮询算法，自定义为随机算法
         *  return new RandomRule();
         * @return
         */
//      使用自定义的
        return new RandomRule_ZY();
    }
}
