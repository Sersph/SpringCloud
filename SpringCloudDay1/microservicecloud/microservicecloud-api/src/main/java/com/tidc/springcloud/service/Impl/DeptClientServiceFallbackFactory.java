package com.tidc.springcloud.service.Impl;


import com.tidc.springcloud.entities.Dept;
import com.tidc.springcloud.service.DeptClientService;
import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;

import java.util.List;

/**
 * @Author Kay
 * @Date 2019/12/10 13:50
 * @Version 1.0
 */
@Component//不要忘记添加，不要忘记添加
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService>
{
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept get(long id) {
                return new Dept().setDeptno(id)
                        .setDname("该ID："+id+"没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭")
                        .setDb_source("no this database in MySQL");
            }

            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public boolean add(Dept dept) {
                return false;
            }
        };
    }
}





