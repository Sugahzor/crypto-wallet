package org.sci.finalproj;

import org.sci.finalproj.controller.UserController;
import org.sci.finalproj.model.CryptoCoin;
import org.sci.finalproj.model.FiatCoin;
import org.sci.finalproj.repo.UserRepo;
import org.sci.finalproj.service.AssetService;
import org.sci.finalproj.service.CryptoCoinService;
import org.sci.finalproj.service.FiatCoinService;
import org.sci.finalproj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;



@Component
@SpringBootApplication
public class DogeRulzApplication /* implements CommandLineRunner */ {


	public static void main(String[] args) {
		SpringApplication.run(DogeRulzApplication.class, args);
		}

}
