package org.sci.finalproj;

import org.sci.finalproj.model.FiatCoin;
import org.sci.finalproj.model.User;
import org.sci.finalproj.repo.UserRepo;
import org.sci.finalproj.service.AssetService;
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
	private static UserService userService;
	@Autowired
	private static UserRepo userRepo;
	@Autowired
	private static AssetService assetService;

	public static void main(String[] args) {
		SpringApplication.run(DogeRulzApplication.class, args);
	}
}
