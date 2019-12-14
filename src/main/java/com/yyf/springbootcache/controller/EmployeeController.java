package com.yyf.springbootcache.controller;

import com.yyf.springbootcache.bean.Employee;
import com.yyf.springbootcache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @ResponseBody
    @GetMapping("/emp/{id}")
    public Employee emp(@PathVariable("id") Integer id){

        Employee employee = employeeService.getEmp(id);
        return employee;
    }
    @GetMapping("/emp")
    @ResponseBody
    public Employee updateEmp(Employee employee){
        Employee  emp =employeeService.updateEmp(employee);
        return  emp;
    }
    @GetMapping("/deleteEmp/{id}")
    @ResponseBody
    public String deleteEmp(@PathVariable("id") Integer id){
      employeeService.deleteEmp(id);
        return "success delete"+id;
    }
    @Qualifier("empCacheManager")
    @Autowired
     CacheManager empCacheManager;
    @GetMapping("/testCache")
    @ResponseBody
    public void testCache(){
        Cache employee=empCacheManager.getCache("employee");
        employee.put("emp2",new Employee("zzz","qq@",1,1));

    }

}
