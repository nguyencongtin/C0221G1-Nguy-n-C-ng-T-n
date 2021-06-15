package com.controller;

import com.service.ITranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TranslateController {
    @Autowired
    ITranslateService iTranslateService;

    @GetMapping
    public String index() {
        return "index";
    }
    @PostMapping("/translate")
    public String translate(@RequestParam String word, Model model){
        model.addAttribute("word",iTranslateService.translate(word));
        return index();
    }

}
