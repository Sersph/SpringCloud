package com.tidc.springcloud.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tidc.springcloud.entities.Dept;

/**
 * @Author Kay
 * @Date 2019/12/8 13:23
 * @Version 控制层消费者 v1.0
 */

@RestController
public class DeptController_Consumer
{
    private static final String REST_URL_PREFIX = "http://localhost:8001";

    /**
     * 使用RestTemplate访问restful接口
     * 参数（url，requestMap，ResponseBean.class）
     * 分别是：REST请求地址，请求参数，Http响应转换：被转换成的对象类型。
     */
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value="/consumer/dept/add")
    public boolean add(Dept dept)
    {
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add", dept, Boolean.class);
    }

    @RequestMapping(value="/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id)
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id, Dept.class);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value="/consumer/dept/list")
    public List<Dept> list()
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list", List.class);
    }
}





