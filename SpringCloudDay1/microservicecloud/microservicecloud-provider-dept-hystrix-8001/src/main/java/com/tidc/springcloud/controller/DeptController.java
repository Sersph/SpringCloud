package com.tidc.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tidc.springcloud.entities.Dept;
import com.tidc.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Kay
 * @Date 2019/12/7 21:34
 * @Version 1.0
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService service = null;

    /**
     * 一旦调用服务方法失败并抛出错误信息后，会自动调用@HystrixCommand注解
     * 标注的(fallbackMethod = "processHystrix_Get")调用类中的指定方法
     * @param id
     * @return
     */
    @RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id") Long id) {
        Dept dept =  this.service.get(id);
        if(null == dept) {
            throw new RuntimeException("该ID："+id+"没有没有对应的信息");
        }
        return dept;
    }

    public Dept processHystrix_Get(@PathVariable("id") Long id) {
        return new Dept()
                .setDeptno(id)
                .setDname("该ID："+id+"没有没有对应的信息,null--@HystrixCommand")
                .setDb_source("no this database in MySQL");
    }
}



