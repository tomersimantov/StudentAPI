package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping // GET request
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping // POST request
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}") // DELETE request by Student ID
    public void deleteStudent(@PathVariable("studentId") Long studentId ) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}") // PUT request by Student ID
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, name, email);
    }



}
