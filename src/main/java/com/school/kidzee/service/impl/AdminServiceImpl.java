package com.school.kidzee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.kidzee.entity.Admin;
import com.school.kidzee.repository.AdminRepo;
import com.school.kidzee.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminRepo adminRepo;

    @Override
    public Admin adminLogin(String username, String password) {
        Admin admin = this.adminRepo.findByUsernameAndPassword(username, password);
        return admin;
    }
    
}
