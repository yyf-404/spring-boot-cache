package com.yyf.springbootcache;

import com.yyf.springbootcache.bean.Employee;
import com.yyf.springbootcache.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@MapperScan(value = "com.yyf.springbootcache.mapper")
@SpringBootTest
class SpringBootCacheApplicationTests {
    @Autowired
    DataSource dataSource;
    @Autowired
    EmployeeMapper employeeMapper;
    @Test
    void contextLoads() throws SQLException {
      Connection connection= dataSource.getConnection();
        System.out.println(connection);
       employeeMapper.insertEmployee(new Employee("yyf","123@",1,1));
       List<Employee> emps= employeeMapper.selectAll();
        System.out.println(Arrays.asList(emps));
    }

}
