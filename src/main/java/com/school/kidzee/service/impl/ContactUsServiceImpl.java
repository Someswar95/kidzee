package com.school.kidzee.service.impl;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.kidzee.entity.ContactUs;
import com.school.kidzee.payload.ContactUsDto;
import com.school.kidzee.repository.ContactUsRepo;
import com.school.kidzee.service.ContactUsService;

@Service
public class ContactUsServiceImpl implements ContactUsService{

    @Autowired
    private ContactUsRepo contactUsRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ContactUsDto createContact(ContactUsDto contactUsDto) {
        ContactUs contactUs = this.modelMapper.map(contactUsDto, ContactUs.class);
        Date currentDate = new Date();
        String formatDate = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.SHORT).format(currentDate);
        contactUs.setTime(formatDate);
        ContactUs savedContact = this.contactUsRepo.save(contactUs);
        return this.modelMapper.map(savedContact, ContactUsDto.class);
    }

	@Override
	public List<ContactUsDto> getAllContacts() {
		List<ContactUs> contacts = this.contactUsRepo.findAll();
		List<ContactUsDto> contactUsDtos = contacts.stream().map((contact)-> this.modelMapper.map(contact, ContactUsDto.class)).collect(Collectors.toList());
		return contactUsDtos;
	}
    
}
