package com.example.springboot.Entity;

public class Student {

    private String name;
    private Integer id;
    private Integer age;

    public Student(String name, Integer id, Integer age){
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isValid(){

        if( !this.getName().isEmpty() && this.getId() != null && this.getAge() !=null ){
            return true;
        }
        return false;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
