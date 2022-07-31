package com.school.kidzee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.kidzee.entity.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long>{
    
    Admin findByUsernameAndPassword(String username, String password);


}
