package org.sci.finalproj;

import org.sci.finalproj.model.User;
import org.sci.finalproj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;
import java.sql.Date;

@SpringBootApplication
public class DogeRulzApplication /* implements CommandLineRunner */ {
	@Autowired //injects it here
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(DogeRulzApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		actualRun();
//	}
//
//	private void actualRun() {
//		Date user1Birth =  new java.sql.Date(Calendar.getInstance().getTime().getTime());
//		User user1 = new User("Iulia", "Sugah", "abcde", user1Birth);
//		User user2 = new User("Iulia2", "Sugah2", "abcde", user1Birth);
//		User user3 = new User("Iulia3", "Sugah3", "abcde", user1Birth);
//
//		userService.register(user1);
//		userService.register(user2);
//		userService.register(user3);
//
//		User testUser = new User();
//		testUser.setUsername("Sugah");
//		testUser.setPassword("abcde");
//		System.out.println("Testing user login: " + userService.login(testUser));
//
//	}

}
