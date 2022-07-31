package com.school.kidzee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.kidzee.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long>{
    
}
