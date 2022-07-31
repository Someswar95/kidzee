package com.school.kidzee.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.school.kidzee.entity.Admin;
import com.school.kidzee.payload.StudentDto;
import com.school.kidzee.service.AdminService;
import com.school.kidzee.service.NewsletterService;
import com.school.kidzee.service.StudentService;

@Controller
public class AdminController {
    
    @Autowired
    private AdminService adminService;
    
    @Autowired
    private NewsletterService newsletterService;
    
    @Autowired
    private StudentService studentService;
    
    @PostMapping("admin/login")    
    public String login(@ModelAttribute("admin") Admin admin) {
        Admin oauthAdmin = this.adminService.adminLogin(admin.getUsername(), admin.getPassword());

        if(Objects.nonNull(oauthAdmin)){
            return "redirect:/admin/dashboard";
        }else{
            return "redirect:/admin";
        }
    }
    
    @GetMapping("/admin/newsletter/list")
    public ModelAndView getAllNews(ModelAndView mav) {
    	mav.addObject("listNews", newsletterService.getAllNewsletters());
    	mav.setViewName("newsletter_list");
    	return mav;
    }
    
    @GetMapping("/admin/student/form")
    public ModelAndView showForm(ModelAndView mav, StudentDto studentDto) {
    	mav.addObject("student", new StudentDto());
    	mav.setViewName("add_student");
    	return mav;
    }
    
    @PostMapping("/admin/student/add")
    public String addStudent(@ModelAttribute("student") StudentDto studentDto) {
    	this.studentService.createStudent(studentDto);
    	return "redirect:/admin/student/list";
    }
    
    @GetMapping("/admin/student/update/{id}")
    public ModelAndView showFormForUpdate(StudentDto studentDto, @PathVariable("id") Long id, ModelAndView mav) {
    	StudentDto updateStudent = this.studentService.updateStudent(studentDto,id);
    	mav.addObject("student", updateStudent);
    	mav.setViewName("update_student");
    	return mav;
    }

}
