package com.school.kidzee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.kidzee.entity.Newsletter;

@Repository
public interface NewsletterRepo extends JpaRepository<Newsletter, Long>{
    
}
