package com.controller;

import com.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    ICalculatorService iCalculatorService;
    @GetMapping
    public String index(){
        return "index";
    }
    @PostMapping("/calculator")
    public String calculator(@RequestParam String calculator, int num1, int num2, Model model){
        model.addAttribute("result",iCalculatorService.calculator(calculator,num1,num2));
        model.addAttribute("num1",num1);
        model.addAttribute("num2",num2);
        return "index";
    }
}
