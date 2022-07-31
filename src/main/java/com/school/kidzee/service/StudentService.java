package com.school.kidzee.service;

import java.util.List;

import com.school.kidzee.payload.StudentDto;

public interface StudentService {
    
    //create
    StudentDto createStudent(StudentDto studentDto);
    
    //get all students
    List<StudentDto> getAllStudents();

    //update
    StudentDto updateStudent(StudentDto studentDto, Long id);
    
    //delete
    void deleteStudent(Long id);
    
}
