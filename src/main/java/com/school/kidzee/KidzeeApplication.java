package com.school.kidzee;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.school.kidzee.entity.Admin;
import com.school.kidzee.repository.AdminRepo;

@SpringBootApplication
public class KidzeeApplication implements CommandLineRunner{

	@Autowired
	private AdminRepo adminRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(KidzeeApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		
		Admin admin = new Admin();
		admin.setAdminId(1);
		admin.setUsername("admin");
		admin.setPassword("admin");
		
		this.adminRepo.save(admin);
		
		
	}

}
