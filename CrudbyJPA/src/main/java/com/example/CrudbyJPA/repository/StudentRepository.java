package com.example.CrudbyJPA.repository;

import com.example.CrudbyJPA.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    // Derived Query Methods
    List<Student> findByGenderAndTech(String gender, String tech);

    List<Student> findByNameAndTech(String name, String tech);

    List<Student> findByTech(String tech);

    // Native SQL Query
    @Query(
            value = "SELECT * FROM student WHERE gender = :gender AND tech = :tech",
            nativeQuery = true
    )
    List<Student> findStudentsByGenderAndTech(
            @Param("gender") String gender,
            @Param("tech") String tech
    );

    // JPQL Query
    @Query("SELECT s FROM Student s WHERE s.name = 'ram'")
    List<Student> findByName();
}