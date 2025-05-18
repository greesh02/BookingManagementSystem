package com.greeshwar.BookingManagementSystem;

import com.greeshwar.BookingManagementSystem.Controllers.UserController;
import com.greeshwar.BookingManagementSystem.Dtos.SignUpRequestDto;
import com.greeshwar.BookingManagementSystem.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaAuditing
public class BookingManagementSystemApplication implements CommandLineRunner {
	@Autowired
	UserController uc;

	public static void main(String[] args) {
		SpringApplication.run(BookingManagementSystemApplication.class, args);
	}
	public void run(String[] args){
//		SignUpRequestDto req = new SignUpRequestDto();
//		req.setEmail("helwlo@gmail.com");
//		req.setName("abc");
//		req.setPassword("hello");
//		uc.signup(req);

	}
}
