package com.yyf.springbootcache.mapper;

import com.yyf.springbootcache.bean.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    @Select("select id,last_name,email,gender,dId from employee")
    public List<Employee> selectAll();

    @Select("select id,last_name,email,gender,dId from employee where id=#{id}")
    public Employee selectById(Integer id);

    @Delete("delete  from employee where id=#{id}")
    public void deleteById(Integer id);

    @Update("update employee set last_name=#{lastName},email=#{email},gender=#{gender},dId=#{dId}  where id=#{id}")
     public void  updateEmployeeById(Employee employee);

    @Insert("insert into employee(last_name,email,gender,dId) values(#{lastName},#{email},#{gender},#{dId})")
    public void insertEmployee(Employee employee);
}
