package com.tidc.springcloud.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.tidc.springcloud.entities.Dept;

/**
 * @Author Kay
 * @Date 2019/12/7 21:24
 * @Version 1.0
 */
@Mapper
public interface DeptDao
{
    public boolean addDept(Dept dept);

    public Dept findById(Long id);

    public List<Dept> findAll();
}


