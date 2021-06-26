package com.example.bai_lam_them.controller;

import com.example.bai_lam_them.model.dto.ProductDto;
import com.example.bai_lam_them.model.entity.Product;
import com.example.bai_lam_them.model.service.IProductService;
import com.example.bai_lam_them.model.service.impl.ProductImpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(value = {"", "/product"})
public class ProductController {
    @Autowired
    IProductService iProductService;

    @GetMapping(value = "")
    public ModelAndView showListForm(@RequestParam("search") Optional<String> search, @PageableDefault(size = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/index");
        Page<Product> products = iProductService.searchNameAndDate(search.orElse(""), pageable);
        modelAndView.addObject("search", search.orElse(""));
        modelAndView.addObject("products", products);
        return modelAndView;
    }


    @GetMapping(value = "/create")
    public ModelAndView showFormCreate(){
        return new ModelAndView("create","productDto",new ProductDto());

    }

    @PostMapping("createProduct")
    public ModelAndView save(@ModelAttribute @Valid ProductDto productDto, BindingResult bindingResult){
        new ProductDto().validate(productDto,bindingResult);
        if(bindingResult.hasErrors()){
            return new ModelAndView("create").addObject("msg","Create is fail something wrong!");
        }
        Product product= new Product();
        BeanUtils.copyProperties(productDto,product);
        iProductService.save(product);
        return new ModelAndView("create","msg","Create is successful");
    }

    @GetMapping(value = "/{id}/show")
    public String showProduct(@PathVariable int id, Model model) {
        Optional product = iProductService.findById(id);
        model.addAttribute("product", product.orElse(null));
        return "show";
    }

    @GetMapping(value = "/{id}/edit")
    public String showEditForm(@PathVariable int id, Model model) {
        Optional findProduct = iProductService.findById(id);
        model.addAttribute("product", findProduct.orElse(null));
        return "edit";
    }

    @PostMapping(value = "update")
    public String updateProduct(Product product, Model model) {
        iProductService.save(product);
        model.addAttribute("product", product);
        return "edit";
    }

    @GetMapping(value = "/{id}/delete")
    public String showDeleteForm(@PathVariable int id, Model model) {
        Optional product = iProductService.findById(id);
        model.addAttribute("product", product.orElse(null));
        return "delete";
    }

    @PostMapping(value = "/delete")
    public String remove(Product product) {
        iProductService.remove(product.getId());
        return "redirect:/";
    }


}
