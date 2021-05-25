package org.sci.finalproj.controller;

import org.sci.finalproj.model.CryptoCoin;
import org.sci.finalproj.model.FiatCoin;
import org.sci.finalproj.model.User;
import org.sci.finalproj.service.CryptoCoinService;
import org.sci.finalproj.service.FiatCoinService;
import org.sci.finalproj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.*;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private FiatCoinService fiatCoinService;
    @Autowired
    private CryptoCoinService cryptoCoinService;

    @RequestMapping("/home")
    public String myIndexPage() {
        return "redirect:login";
    }

    @RequestMapping("/")
    public String myDefaultPage() {
        return this.myIndexPage();
    }

    @RequestMapping("/register")
    public String myRegisterPage(Model model) {
        User emptyUser = new User();
        model.addAttribute("user", emptyUser);
        //List for the default currency dropdown :
        List<FiatCoin> fiatCoinList = fiatCoinService.getFiatCoinList();
        model.addAttribute("fiatCoinList", fiatCoinList);

        FiatCoin fiatCoin = new FiatCoin("Euro","€");
        FiatCoin fiatCoin1 = new FiatCoin("Dollarelul (Bo$$ de Bo$$ ","$");
        FiatCoin fiatCoin2 = new FiatCoin("Leutzul Greu ","RON ");

        fiatCoinService.register(fiatCoin);
        fiatCoinService.register(fiatCoin1);
        fiatCoinService.register(fiatCoin2);

        CryptoCoin cryptoCoin = new CryptoCoin("Dogecoin","Ð");
        CryptoCoin cryptoCoin1 = new CryptoCoin("Bitcoin","₿");
        CryptoCoin cryptoCoin2 = new CryptoCoin("Ether","Ξ");

        cryptoCoinService.register(cryptoCoin);
        cryptoCoinService.register(cryptoCoin1);
        cryptoCoinService.register(cryptoCoin2);

        return "register";



    }

    @RequestMapping("/login")
    public String myLoginPage(Model model) {
        User emptyUser = new User();
        model.addAttribute("user", emptyUser);
        return "login";
    }

    @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
    public ModelAndView loginUser(@ModelAttribute("user") User user, BindingResult errors, Model model) {
        // logic to process input data
        boolean loginResult = userService.login(user);

        if (loginResult) {
            ModelAndView mv = new ModelAndView("redirect:/wallet-details");
            mv.addObject("userEmail", user.getUserEmail());
            return mv;
        } else {
            return new ModelAndView("error");
        }
    }

    @GetMapping({"/hello"})
    public String hello(Model model, @RequestParam(value="name", required=false) String name) {
        // http://localhost:8080/hello?name=maki
        // model = un camp din view/html
        model.addAttribute("name", name);
        return "index";
    }

    @GetMapping({"/test"})
    public String test(Model model, @RequestParam(value="name", required=false) String name) {
        // http://localhost:8080/hello?name=maki
        // model = un camp din view/html

		Date user1Birth =  new java.sql.Date(Calendar.getInstance().getTime().getTime());
        User user1 = new User("iulia12@lol", "Iulia1", "Sugah1", 1234_5678_9012_3456L, "$");
		User user2 = new User("iulia212@lol", "Iulia2", "Sugah2", 1234_5678_9012_3456L, "$");
		User user3 = new User("iulia312@lol","Iulia3", "Sugah3", 1234_5678_9012_3456L, "$");

		userService.register(user1);
        userService.register(user2);
        userService.register(user3);

		List<User> usersList = new ArrayList<>();
		usersList.add(user1);
        usersList.add(user2);
        usersList.add(user3);

        model.addAttribute("myUsersList", usersList);
        return "index";
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") @Validated User user, BindingResult result, Model model) {
        // logic to process input data
        if (result.hasErrors()) {
            return "error";
        }
        userService.register(user);
        return "login";
    }
}
