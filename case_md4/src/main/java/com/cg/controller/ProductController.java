package com.cg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class ProductController {

    @GetMapping("/home")
    public ModelAndView showHomePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/home");
        return modelAndView;
    }

    @GetMapping("/products")
    ModelAndView showListPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product/list");

        return modelAndView;
    }

    @GetMapping("/users")
    public ModelAndView showUserPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/list");
        return modelAndView;
    }

}
