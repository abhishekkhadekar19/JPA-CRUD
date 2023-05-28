package com.example.cruddemo.dao;

import java.util.List;

import com.example.cruddemo.Entity.Student;

public interface StudentDAO {

  void save(Student theStudent);

  Student findById(Integer id);

  List<Student> findAll();

  List<Student> findByLastname(String Lastname);

  void update(Student theStudent);
   
  void delete(Integer id);

  int deleteAll();


}
