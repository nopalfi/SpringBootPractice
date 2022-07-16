package me.nopalfi.springboot.services;

import me.nopalfi.springboot.models.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAll();

    Student findById(Long id);

    Student add(Student student);

    Student update(Long id, Student student);

    void delete(Long id);


}
