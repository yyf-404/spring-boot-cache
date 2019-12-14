package com.yyf.springbootcache.service;

import com.yyf.springbootcache.bean.Employee;
import com.yyf.springbootcache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    @Cacheable(cacheNames = {"employee"}/*,keyGenerator = "paramGenerator"*/)
    public Employee getEmp(Integer id){
        System.out.println("查询id为"+id+" 员工");
    Employee employee  =employeeMapper.selectById(id);
        return employee;
    }
     @CachePut(cacheNames = "employee",key = "#employee.id")
    public Employee updateEmp(Employee employee){
        employeeMapper.updateEmployeeById(employee);
        return  employee;
    }
     @CacheEvict(cacheNames = "employee")
    public void deleteEmp(Integer id){
        employeeMapper.deleteById(id);
    }
}


