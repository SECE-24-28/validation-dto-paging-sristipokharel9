package com.example.CrudbyJPA.service;

import com.example.CrudbyJPA.Dto.StudentDto;
import com.example.CrudbyJPA.model.Student;
import com.example.CrudbyJPA.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository sr;

    public List<Student> getAllStudents() {
        return sr.findAll();
    }

    public void addStudent(Student std) {
        sr.save(std);
    }

    public Student getStudentByRollNo(int roll) {
        return sr.findById(roll).orElse(new Student());
    }

    public void updateStudent(Student std) {
        sr.save(std);
    }

    public List<Student> getStudentByGenderAndTech(String gender, String tech) {
        return sr.findByGenderAndTech(gender, tech);
    }

    public List<Student> getStuByNameAndTech(String name, String tech) {
        return sr.findByNameAndTech(name, tech);
    }

    public List<Student> getStudentByTech(String tech) {
        return sr.findByTech(tech);
    }

    public List<Student> getStudentsByName() {
        return sr.findByName();
    }

    public void deleteAllStudents() {
        sr.deleteAll();
    }

    public void deleteStudentByRollNo(int rno) {
        sr.deleteById(rno);
    }

    public StudentDto getAllStudentByRollNo(String rno) {
        Student s1 = sr.findById(Integer.parseInt(rno)).orElseThrow();
        return covertStudentToDto(s1);
    }

    public StudentDto covertStudentToDto(Student s1) {
        StudentDto std = new StudentDto();
        std.setRno(s1.getRno());
        std.setName(s1.getName());
        std.setGender(s1.getGender());
        std.setTech(s1.getTech());
        std.setEmail(s1.getEmail());
        return std;
    }

    /*
    public StudentDto addStudents(StudentDto std){
        sr.save(convertDtoToStudent(std));
    }
    */

    public Student convertDtoToStudent(StudentDto std1) {
        Student s2 = new Student();
        s2.setRno(std1.getRno());
        s2.setName(std1.getName());
        s2.setGender(std1.getGender());
        s2.setTech(std1.getTech());
        s2.setEmail(std1.getEmail());
        return s2;
    }

    public StudentDto addStudents(StudentDto std) {
        Student student = sr.save(convertDtoToStudent(std));
        return covertStudentToDto(student);
    }
    public Page<Student> getAllStudent(int age, int size){
        return sr.findAll(
                PageRequest.of(page,size)
        );
    }
}