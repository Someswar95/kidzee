package com.school.kidzee.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.school.kidzee.entity.Admin;
import com.school.kidzee.payload.ContactUsDto;
import com.school.kidzee.payload.NewsletterDto;
import com.school.kidzee.payload.StudentDto;
import com.school.kidzee.service.NewsletterService;

@Controller
public class MyController {
    
    @Autowired
    private NewsletterService newsletterService;

    //drop down list for student class
    static List<String> classList = null;

    static {
        classList = new ArrayList<>();
        classList.add("Default class");
        classList.add("LKG");
        classList.add("UKG");
        classList.add("Nursery");
        classList.add("I");
        classList.add("II");
        classList.add("III");
        classList.add("IV");
        classList.add("V");
    }

    // List<String> classList2 = Arrays.asList("Default class", "LKG", "UKG", "Nursery", "I", "II", "III", "IV", "V");

    @GetMapping("/")
    public ModelAndView homePage(ModelAndView mav){
        mav.addObject("news", new NewsletterDto());
        mav.addObject("brand", "Kidzee");
        mav.setViewName("index");
        return mav;
    }

    @GetMapping("/about")
    public ModelAndView aboutPage(ModelAndView mav){
        mav.addObject("news", new NewsletterDto());
        mav.addObject("brand", "Kidzee");
        mav.setViewName("about");
        return mav;
    }

    @GetMapping("/classes")
    public ModelAndView classPage(ModelAndView mav){
        mav.addObject("news", new NewsletterDto());
        mav.addObject("brand", "Kidzee");
        mav.addObject("classList", classList);
        mav.setViewName("class");
        return mav;
    }

    @GetMapping("/teachers")
    public ModelAndView teacherPage(ModelAndView mav){
        mav.addObject("news", new NewsletterDto());
        mav.addObject("brand", "Kidzee");
        mav.setViewName("team");
        return mav;
    }

    @GetMapping("/gallery")
    public ModelAndView galleryPage(ModelAndView mav){
        mav.addObject("news", new NewsletterDto());
        mav.addObject("brand", "Kidzee");
        mav.setViewName("gallery");
        return mav;
    }

    @GetMapping("/contact")
    public ModelAndView contactPage(ModelAndView mav){
        mav.addObject("news", new NewsletterDto());
        mav.addObject("brand", "Kidzee");
        mav.addObject("contact", new ContactUsDto());
        mav.setViewName("contact");
        return mav;
    }

    @GetMapping("/admission")
    public ModelAndView admissionPage(ModelAndView mav){
        mav.addObject("brand", "Kidzee");
        mav.addObject("student", new StudentDto());
        mav.addObject("classList", classList);
        mav.setViewName("admission");
        return mav;
    }

    @PostMapping("/newsletter/save")
    public String newsLetter(@ModelAttribute("news") NewsletterDto newsletterDto){
        this.newsletterService.customLetter(newsletterDto);
        return "redirect:/";
    }

    @GetMapping("/admin")
    public ModelAndView loginAdmin(ModelAndView mav){
        mav.addObject("brand", "Kidzee");
        mav.addObject("admin", new Admin());
        mav.setViewName("admin_login");
        return mav;
    }
    
    @GetMapping("/admin/dashboard")
    public ModelAndView adminHome(ModelAndView mav) {
    	mav.addObject("brand", "Kidzee");
    	mav.setViewName("admin");
    	return mav;
    }


}
