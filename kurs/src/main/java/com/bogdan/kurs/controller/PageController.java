package com.bogdan.kurs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

    @RequestMapping("/")
    public ModelAndView homePage() {return new ModelAndView("index");}
    @RequestMapping("/about")
    public ModelAndView aboutPage() {
        return new ModelAndView("about");
    }
    @RequestMapping("/contact")
    public ModelAndView contactPage() {
        return new ModelAndView("contact");
    }
}
