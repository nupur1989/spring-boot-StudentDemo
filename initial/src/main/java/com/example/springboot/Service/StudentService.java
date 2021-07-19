package com.example.springboot.Service;

import com.example.springboot.Dao.StudentDao;
import com.example.springboot.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class StudentService {

    @Autowired
    StudentDao studentDao;

    public StudentService(){

    }

    public String getStudent(int id){
        String result =  studentDao.getStudent(id);
        System.out.println("result from dao" + result);
        return result;
    }

    public void createStudent(Student s){
        studentDao.insertStudent(s);
    }

    public void updateStudent(Student s){
        studentDao.insertStudent(s);

    }

}
