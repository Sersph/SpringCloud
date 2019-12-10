package com.tidc.springcloud.service;

import com.tidc.springcloud.entities.Dept;

import java.util.List;

/**
 * @Author Kay
 * @Date 2019/12/7 21:30
 * @Version 1.0
 */
public interface DeptService {

    public boolean add(Dept dept);

    public Dept get(Long id);

    public List<Dept> list();

}
