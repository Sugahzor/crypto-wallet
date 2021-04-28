package org.sci.finalproj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {


    @RequestMapping("/home")
    public String myIndexPage() {
        return "index";
    }

    @RequestMapping("/")
    public String myDefaultPage() {
        return this.myIndexPage();
    }
}
