package org.sci.finalproj.controller;

import org.sci.finalproj.model.User;
import org.sci.finalproj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @RequestMapping("/home")
    public String myIndexPage() {
        return "index";
    }

    @RequestMapping("/register")
    public String myRegisterPage() {
        return "register";
    }

    @RequestMapping("/")
    public String myDefaultPage() {
        return this.myIndexPage();
    }

//    @GetMapping({"/hello"})
//    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
//        // http://localhost:8080/hello?name=maki
//        // model = un camp din view/html
//        model.addAttribute("name", name);
//        return "index";
//    }

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
        User user1 = new User("iulia@lol", "Iulia1", "Sugah1", 1234_5678_9012_3456L, 1234_5678_9012_3456L);
		User user2 = new User("iulia@lol", "Iulia2", "Sugah2", 1234_5678_9012_3456L, 1234_5678_9012_3456L);
		User user3 = new User("iulia@lol","Iulia3", "Sugah3", 1234_5678_9012_3456L, 1234_5678_9012_3456L);

		List<User> usersList = new ArrayList<>();
		usersList.add(user1);
        usersList.add(user2);
        usersList.add(user3);

        model.addAttribute("myUsersList", usersList);
        return "index";
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user, BindingResult errors, Model model) {
        // logic to process input data
        userService.register(user);
        return "index";
    }


}
