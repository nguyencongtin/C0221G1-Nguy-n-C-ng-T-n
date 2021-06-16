package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CondimentController {
    @GetMapping
    public String index(){
        return "index";
    }
//    Cách 1
//    @PostMapping(value="/save")
//    public ModelAndView modelAndView (@RequestParam String [] condiment ){
//        ModelAndView modelAndView=new ModelAndView("index","condiment",condiment);
//        return modelAndView;
//    }
//    Cách 2
    @PostMapping(value="/save")
    public String condiment(@RequestParam String [] condiment, Model model){
        model.addAttribute("condiment",condiment);
        return "index";
    }

}
