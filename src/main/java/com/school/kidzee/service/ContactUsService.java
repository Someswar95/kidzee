package com.school.kidzee.service;

import java.util.List;

import com.school.kidzee.payload.ContactUsDto;

public interface ContactUsService {
    
    //create
    ContactUsDto createContact(ContactUsDto contactUsDto);

    //get all contact
    List<ContactUsDto> getAllContacts();
    

}
