package springcloud.service.Impl;

import com.tidc.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springcloud.dao.DeptDao;
import springcloud.service.DeptService;

import java.util.List;

/**
 * @Author Kay
 * @Date 2019/12/7 21:31
 * @Version 2.0
 */
@Service
public class DeptServiceImpl implements DeptService{

    @Autowired
    private DeptDao dao;

    @Override
    public boolean add(Dept dept) {
        return dao.addDept(dept);
    }

    @Override
    public Dept get(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<Dept> list() {
        return dao.findAll();
    }
}
