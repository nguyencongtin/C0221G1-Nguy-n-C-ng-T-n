package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.IConvertService;

@Controller
public class ConvertController {
    @Autowired
    IConvertService iConvertService;
    @GetMapping(value="")
    public String home (){
        return "home";
    }
    @PostMapping(value="/convert")
    public String convert(@RequestParam double number, double typeViet, double typeMy, Model model){
        model.addAttribute("money",iConvertService.convert(number,typeViet,typeMy));
        return "home";
    }
}
