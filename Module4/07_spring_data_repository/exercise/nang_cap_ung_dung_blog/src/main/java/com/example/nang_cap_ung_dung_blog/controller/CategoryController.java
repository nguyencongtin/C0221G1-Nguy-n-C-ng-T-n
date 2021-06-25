package com.example.nang_cap_ung_dung_blog.controller;

import com.example.nang_cap_ung_dung_blog.model.entity.Category;
import com.example.nang_cap_ung_dung_blog.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value= "/category")
public class CategoryController {

    @Autowired
    private ICategoryService iCategoryService;
    @GetMapping(value = "/create")
    public String showFormCreate(Model model){
        model.addAttribute("category",new Category());
        return "/category/create";
    }
    @PostMapping(value = "/create")
    public String createCategory(@ModelAttribute Category category ){
        this.iCategoryService.save(category);
        return "redirect:/";
    }
    @GetMapping(value = "/edit")
    public String showEditForm(@RequestParam Integer id, Model model){
        model.addAttribute("category",this.iCategoryService.findById(id));
        return "/category/edit";
    }
    @PostMapping(value = "/edit")
    public String editCategory(@ModelAttribute Category category,Model model){
        this.iCategoryService.save(category);
        model.addAttribute("category",category);
        model.addAttribute("msg","Edit successfully");
        return "redirect:/";
    }
    @GetMapping(value = "/delete")
    public String showDelete(@RequestParam Integer id,Model model){
        model.addAttribute("category",this.iCategoryService.findById(id));
        return "/category/delete";
    }
    @PostMapping(value = "/delete")
    public String deleteCategory(@RequestParam Integer id, RedirectAttributes redirectAttributes){
        this.iCategoryService.remove(id);
        redirectAttributes.addFlashAttribute("msg","Delete Success");
        return "redirect:/blog/";
    }


}
