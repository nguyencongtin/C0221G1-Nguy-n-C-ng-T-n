package com.case_study.controller;

import com.case_study.model.dto.CustomerDto;
import com.case_study.model.entity.customer.Customer;
import com.case_study.model.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    ICustomerService customerService;
    @GetMapping({"","/search"})
    public ModelAndView showList(@RequestParam("search") Optional<String> search, @PageableDefault(value = 2) Pageable pageable){
        return new ModelAndView("customer/list","customers",customerService.findAll(search.orElse(""),pageable)).
                addObject("search",search.orElse(""));
    }

    @GetMapping("/create")
    public ModelAndView showCreate(){
        return new ModelAndView("customer/create","customerDto",new CustomerDto()).
                addObject("customerTypes",customerService.findAllCustomerType());
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute @Valid CustomerDto customerDto, BindingResult bindingResult){
        new CustomerDto().validate(customerDto,bindingResult);
        if(bindingResult.hasErrors()){
            return new ModelAndView("customer/create","msg","Something wrong!! <br> Try again").
                    addObject("customerTypes",customerService.findAllCustomerType());
        }
        Customer customer=new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        customerService.save(customer);
        return new ModelAndView("customer/create","msg","Create is successful!!").
                addObject("customerTypes",customerService.findAllCustomerType());
    }

    @GetMapping("/edit/{idc}")
    public ModelAndView showEdit(@PathVariable Long idc){
        if (customerService.findById(idc)==null){
            return new ModelAndView("error-404");
        }
        CustomerDto customerDto=new CustomerDto();
        BeanUtils.copyProperties(customerService.findById(idc),customerDto);

        return new ModelAndView("customer/edit","customerDto",customerDto).
                addObject("customerTypes",customerService.findAllCustomerType());
    }

    @PostMapping("/edit")
    public ModelAndView edit(@ModelAttribute @Valid CustomerDto customerDto,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ModelAndView("customer/edit","msg","Something wrong!! <br> Try again").
                    addObject("customerTypes",customerService.findAllCustomerType());
        }
        Customer customer=new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        customerService.save(customer);
        return new ModelAndView("customer/edit","msg","Edit is successful!!").
                addObject("customerTypes",customerService.findAllCustomerType());
    }

    @PostMapping("/delete")
    public ModelAndView delete(@RequestParam Long id){
        Customer customer= customerService.findById(id);
        if (customer==null){
            return new ModelAndView("error-404");
        }
        customer.setFlag(true);
        customerService.save(customer);
        return new ModelAndView("redirect:/customer");
        }
}
