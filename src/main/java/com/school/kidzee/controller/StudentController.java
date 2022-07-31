package com.school.kidzee.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.school.kidzee.payload.StudentDto;
import com.school.kidzee.service.StudentService;

@Controller
public class StudentController {
    
    @Autowired
    private StudentService studentService;

    @PostMapping("/admission/submit")
    public String createStudent(@Valid @ModelAttribute("student") StudentDto studentDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "redirect:/admission";
        }
        this.studentService.createStudent(studentDto);
        return "redirect:/";

    }
    
    @GetMapping("/admin/student/list")
    public ModelAndView listStudents(ModelAndView mav) {
    	mav.addObject("listStudents", studentService.getAllStudents());
    	mav.setViewName("student_list");
    	return mav;
    }

    @GetMapping("/admin/student/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
    	this.studentService.deleteStudent(id);
    	return "redirect:/admin/student/list";
    }
    

}
