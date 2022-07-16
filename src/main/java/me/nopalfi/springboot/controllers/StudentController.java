package me.nopalfi.springboot.controllers;

import me.nopalfi.springboot.models.Student;
import me.nopalfi.springboot.services.StudentService;
import me.nopalfi.springboot.services.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/v1/student")
public class StudentController {


    @Autowired
    private StudentServiceImpl studentService;

    @GetMapping("/")
    public ResponseEntity<List> getAllStudent() {
        return new ResponseEntity<List>(studentService.getAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id) {
        return new ResponseEntity<Student>(studentService.findById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return new ResponseEntity<Student>(studentService.add(student), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") Long id, @RequestBody Student student) {
        return new ResponseEntity<Student>(studentService.update(id, student), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id) {
        studentService.delete(id);
        return new ResponseEntity<String>("Student deleted successfully",HttpStatus.ACCEPTED);
    }
}
