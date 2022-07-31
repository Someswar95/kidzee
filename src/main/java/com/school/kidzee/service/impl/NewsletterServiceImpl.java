package com.school.kidzee.service.impl;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.school.kidzee.entity.Newsletter;
import com.school.kidzee.payload.NewsletterDto;
import com.school.kidzee.repository.NewsletterRepo;
import com.school.kidzee.service.NewsletterService;

@Service
public class NewsletterServiceImpl implements NewsletterService{

    @Value("${spring.mail.username}") private String sender;

    @Autowired
    private NewsletterRepo newsletterRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public NewsletterDto customLetter(NewsletterDto newsletterDto) {
        Newsletter newsletter = this.modelMapper.map(newsletterDto, Newsletter.class);
        Date currentDate = new Date();
        String formatDate = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.SHORT).format(currentDate);
        newsletter.setJoinDate(formatDate);
        Newsletter saveNews = this.newsletterRepo.save(newsletter);
//        sendNewsletterEmail(newsletterDto);
        return this.modelMapper.map(saveNews, NewsletterDto.class);
    }

    @Override
    public void sendNewsletterEmail(NewsletterDto newsletterDto) {
        String toAddress = newsletterDto.getEmail();
		String subject = "Sunshine Community";
		String content = "Thank you for joining us./n/t Keep in touch for more updates";
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(sender);	
		mailMessage.setTo(toAddress);
		mailMessage.setSubject(subject);
		mailMessage.setText(content);
		
		javaMailSender.send(mailMessage);
    }

	@Override
	public List<NewsletterDto> getAllNewsletters() {
		List<Newsletter> newsletters = this.newsletterRepo.findAll();
		List<NewsletterDto> newsletterDtos = newsletters.stream().map((news)-> this.modelMapper.map(news, NewsletterDto.class)).collect(Collectors.toList());
		return newsletterDtos;
	}
    
}
