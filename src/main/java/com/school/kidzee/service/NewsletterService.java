package com.school.kidzee.service;

import java.util.List;

import com.school.kidzee.payload.NewsletterDto;

public interface NewsletterService {
    
    //create newsletter just for user can get all updated information from our community
    NewsletterDto customLetter(NewsletterDto newsletterDto);

    //when a customer proceed the newsletter features, automatically send email to provide mail 
    void sendNewsletterEmail(NewsletterDto newsletterDto);
    
    //get all news
    List<NewsletterDto> getAllNewsletters();

}
