package com.example.springboot;

import com.example.springboot.Dao.StudentDao;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.springboot")
public class StudentApplicationConfig {

    @Bean
    public BasicDataSource mysqlDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/springbootdb?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("spanish89");
        return dataSource;
    }

    @Bean
    public StudentDao studentDao(){
        return new StudentDao(mysqlDataSource());
    }
}
