package com.school.kidzee.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.kidzee.entity.Student;
import com.school.kidzee.payload.StudentDto;
import com.school.kidzee.repository.StudentRepo;
import com.school.kidzee.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = this.modelMapper.map(studentDto, Student.class);
        Student sd = this.studentRepo.save(student);
        return this.modelMapper.map(sd, StudentDto.class);
    }

	@Override
	public List<StudentDto> getAllStudents() {
		List<Student> students = this.studentRepo.findAll();
		List<StudentDto> studentDtos = students.stream().map((std)-> this.modelMapper.map(std, StudentDto.class)).collect(Collectors.toList());
		return studentDtos;
	}

	@Override
	public StudentDto updateStudent(StudentDto studentDto, Long id) {
		Optional<Student> optional = this.studentRepo.findById(id);
		Student student = null;
		if(optional.isPresent()) {
			student = optional.get();
		}else {
			throw new RuntimeException("Student not found ::" +id);
		}
		return this.modelMapper.map(student, StudentDto.class);
	}

	@Override
	public void deleteStudent(Long id) {
		this.studentRepo.deleteById(id);
		
	}
    
}
