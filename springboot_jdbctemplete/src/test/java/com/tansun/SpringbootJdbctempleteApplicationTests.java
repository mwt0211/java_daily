package com.tansun;

import com.tansun.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class SpringbootJdbctempleteApplicationTests {

    @Test
    void contextLoads() {
    }
    @Test
    void testGetAll(@Autowired JdbcTemplate jdbcTemplate){
        String sql="select * from student";

        RowMapper<Student> rs=new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student stu = new Student();
                stu.setAddress(rs.getString("address"));
                stu.setAge(rs.getInt("age"));
               stu.setEnglish(rs.getInt("english"));
               stu.setId(rs.getInt("id"));
               stu.setName(rs.getString("name"));
               stu.setSex(rs.getString("sex"));
               stu.setMath(rs.getInt("math"));

                return stu;
            }
        };
        List<Student> studentList = jdbcTemplate.query(sql, rs);
        System.out.println("studentList = " + studentList);
    }

}
