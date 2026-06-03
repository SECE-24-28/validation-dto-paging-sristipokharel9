package com.example.CrudbyJPA.controller;

import com.example.CrudbyJPA.Dto.StudentDto;
import com.example.CrudbyJPA.model.Student;
import com.example.CrudbyJPA.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService s;

    @GetMapping("students")
    public List<Student> getAllStudents() {
        return s.getAllStudents();
    }

    @PostMapping("students")
    public String addStudent(@Valid @RequestBody Student std) {
        s.addStudent(std);
        return "added";
    }

    /*    @GetMapping("students/{rno}")
    public Student getStudentByRollNo(@PathVariable("rno") int roll) {
        return s.getStudentByRollNo(roll);
    }*/

    @PutMapping("students")
    public String updateStudent(@RequestBody Student std) {
        s.updateStudent(std);
        return "updated";
    }

    @DeleteMapping("students")
    public String deleteAllStudents() {
        s.deleteAllStudents();
        return "deleted sucessfully";
    }

    @DeleteMapping("students/{rno}")
    public String deleteAllStudents(@PathVariable("rno") int rno) {
        s.deleteStudentByRollNo(rno);
        return "deleted successfully";
    }

    @GetMapping("students/custom")
    public List<Student> getStudentByGenderAndTech(
            @Param("gender") String gender,
            @Param("tech") String tech
    ) {
        return s.getStudentByGenderAndTech(gender, tech);
    }

    @GetMapping("Student/cust")
    public List<Student> getStuByNameAndTech(
            @Param("name") String name,
            @Param("tech") String tech
    ) {
        return s.getStuByNameAndTech(name, tech);
    }

    @GetMapping("students/tech/{tech}")
    public List<Student> getStudentByTech(@PathVariable("tech") String tech) {
        return s.getStudentByTech(tech);
    }

    @GetMapping("students/{rno}")
    public StudentDto getAllStudentByRollNo(
            @PathVariable("rno") String rno
    ) {
        return s.getAllStudentByRollNo(rno);
    }
    @PostMapping("students/dto")
    public StudentDto addStudents(@RequestBody StudentDto std) {
        return s.addStudents(std);
    }
    @GetMapping("students")
    public Page<Student> getAllStudent(@RequestParam("page") int age
                                       @RequestParam("size")int size){
        return s.getAllStudent()

    }
}