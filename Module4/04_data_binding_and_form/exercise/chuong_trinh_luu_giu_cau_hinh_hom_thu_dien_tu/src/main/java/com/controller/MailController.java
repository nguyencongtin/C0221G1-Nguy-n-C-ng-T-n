package com.controller;

import com.model.Mail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MailController {
    @GetMapping(value = {"","/mail"})
    public String goFormMail(Model model){
        model.addAttribute("mail",new Mail());
        return "home";
    }

    @PostMapping(value = "/update")
    public ModelAndView update(@ModelAttribute Mail mail){
        return  new ModelAndView("show","mail",mail);
    }
}