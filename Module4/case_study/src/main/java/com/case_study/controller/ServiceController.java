package com.case_study.controller;

import com.case_study.model.dto.CustomerDto;
import com.case_study.model.dto.ServiceDto;
import com.case_study.model.entity.customer.Customer;
import com.case_study.model.entity.service.Service;
import com.case_study.model.repository.service.IRentTypeRepository;
import com.case_study.model.repository.service.IServiceRepository;
import com.case_study.model.repository.service.IServiceTypeRepository;
import com.case_study.model.service.IServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    IServiceService serviceService;

    @GetMapping({"/create",""})
    public ModelAndView showCreate(){
        ModelAndView modelAndView=new ModelAndView("service/create");
        modelAndView.addObject("serviceDto",new ServiceDto());
        modelAndView.addObject("rentTypes",serviceService.findAllRentType());
        modelAndView.addObject("serviceTypes",serviceService.findAllServiceType());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute @Valid ServiceDto serviceDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
       new ServiceDto().validate(serviceDto,bindingResult);
       ModelAndView modelAndView;
        if(bindingResult.hasErrors()){
            modelAndView=new ModelAndView("service/create","msg","Something wrong!! Try again");
            modelAndView.addObject("rentTypes",serviceService.findAllRentType());
            modelAndView.addObject("serviceTypes",serviceService.findAllServiceType());
            return modelAndView;
        }
        Service service=new Service();
        BeanUtils.copyProperties(serviceDto,service);
        serviceService.save(service);
        redirectAttributes.addFlashAttribute("msg","Create is successful!!");
        return new ModelAndView("redirect:/service");
    }
}
