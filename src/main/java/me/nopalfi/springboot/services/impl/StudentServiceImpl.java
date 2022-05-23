package me.nopalfi.springboot.services.impl;

import me.nopalfi.springboot.repositories.StudentRepository;
import me.nopalfi.springboot.exceptions.ResourceNotFoundException;
import me.nopalfi.springboot.models.Student;
import me.nopalfi.springboot.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student add(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student upadte(Long id, Student student) {
        Student update = studentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Student", "id", id)
        );
        update.setFirstName(student.getFirstName());
        update.setLastName(student.getLastName());
        update.setAddress(student.getAddress());
        update.setClassGrade(student.getClassGrade());
        return studentRepository.save(update);
    }

    @Override
    public void delete(Long id) {
        Student findStudent = studentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Student","ID",id)
        );
        studentRepository.delete(findStudent);
    }
}
