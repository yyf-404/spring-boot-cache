package com.yyf.springbootcache;

import com.yyf.springbootcache.bean.Employee;
import com.yyf.springbootcache.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@MapperScan(value = "com.yyf.springbootcache.mapper")
@SpringBootTest
class RedisCacheApplicationTests {
    @Autowired
     RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate<Object,Employee> empRedisTemplate;
    @Test
    void contextLoads() throws SQLException {
        stringRedisTemplate.opsForValue().set("k1","v1");
       String k1= stringRedisTemplate.opsForValue().get("k1");
        System.out.println(k1);
    }
    @Test
    void test() throws SQLException {
        redisTemplate.opsForValue().set("emp1",new Employee("yyf","qq@",1,1));
        Employee employee=(Employee) redisTemplate.opsForValue().get("emp1");
        System.out.println("emp= "+employee);

    }
    @Test
    void test1() throws SQLException {
        empRedisTemplate.opsForValue().set("emp1",new Employee("yyf","qq@",1,1));
        Employee employee=(Employee) empRedisTemplate.opsForValue().get("emp1");
        System.out.println("emp= "+employee);

    }

}
