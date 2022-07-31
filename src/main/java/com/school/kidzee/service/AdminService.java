package com.school.kidzee.service;

import com.school.kidzee.entity.Admin;

public interface AdminService {
    
    //admin can login to access the site
    Admin adminLogin(String username, String password);

}
