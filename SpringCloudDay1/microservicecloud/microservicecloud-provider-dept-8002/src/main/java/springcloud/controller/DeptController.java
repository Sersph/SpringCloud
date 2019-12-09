package springcloud.controller;

import com.tidc.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import springcloud.service.DeptService;

import java.util.List;

/**
 * @Author Kay
 * @Date 2019/12/7 21:34
 * @Version 2.0
 */
@RestController
public class DeptController
{
    @Autowired
    private DeptService service;

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value="/dept/add",method=RequestMethod.POST)
    public boolean add(@RequestBody Dept dept)
    {
        return service.add(dept);
    }

    @RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id)
    {
        return service.get(id);
    }

    @RequestMapping(value="/dept/list",method=RequestMethod.GET)
    public List<Dept> list()
    {
        return service.list();
    }

    //服务发现
    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery(){
        //获取拥有的微服务
        List<String> list = client.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId()
                    + "\t" + element.getHost()
                    + "\t" + element.getPort()
                    + "\t" + element.getUri());
        }
        return this.client;
    }
}



