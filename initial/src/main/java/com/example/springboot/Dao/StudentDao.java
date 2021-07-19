package com.example.springboot.Dao;

import com.example.springboot.Entity.Student;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

public class StudentDao {

    //Logger lgr = Logger.getLogger(StudentDao.class);

   private BasicDataSource basicDataSource;
   private final JdbcTemplate jdbcTemplate;
   private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public StudentDao(BasicDataSource dataSource){
        this.basicDataSource = dataSource;
        System.out.print("inside constructor for Dao");
        this.jdbcTemplate = new JdbcTemplate(basicDataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(basicDataSource);
    }

    public String getStudent(Integer id){

        String query = "SELECT name FROM Student where studentId = :id";

        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);

        System.out.println("result from db" + namedParameterJdbcTemplate.queryForObject(
                query, namedParameters, String.class));

        return namedParameterJdbcTemplate.queryForObject(
                query, namedParameters, String.class);

    }

    public void insertStudent(Student s){
        String sql = "Insert into Student values(:studentId, :name, :age)";

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("studentId", s.getId());
        namedParameters.addValue("name", s.getName());
        namedParameters.addValue("age", s.getAge());

       namedParameterJdbcTemplate.update(sql, namedParameters);
    }

}
