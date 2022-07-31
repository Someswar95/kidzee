package com.school.kidzee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.school.kidzee.payload.ContactUsDto;
import com.school.kidzee.service.ContactUsService;

@Controller
public class ContactUsController {
    
    @Autowired
    private ContactUsService contactUsService;

    @PostMapping("/contact_us/send")
    public String contactSend(@ModelAttribute("contact") ContactUsDto contactUsDto){
        this.contactUsService.createContact(contactUsDto);
        return "redirect:/contact";
    }

    @GetMapping("/admin/contact/list")
    public ModelAndView listContacts(ModelAndView mav) {
    	mav.addObject("listContacts", contactUsService.getAllContacts());
    	mav.setViewName("contact_list");
    	return mav;
    }
    

}
