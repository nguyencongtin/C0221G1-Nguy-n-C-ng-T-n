package com.example.nang_cap_ung_dung_blog.controller;

import com.example.nang_cap_ung_dung_blog.model.entity.Blog;
import com.example.nang_cap_ung_dung_blog.model.service.IBlogService;
import com.example.nang_cap_ung_dung_blog.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping(value= {"","/blog"})
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping(value="")
    public String goHome(Model model, @RequestParam Optional<String> nameSearch, @RequestParam Optional<Integer> page){
        Page<Blog> blog;
        Pageable pageable= PageRequest.of(page.orElse(0),5, Sort.by("date").descending());
        if (nameSearch.isPresent()) {
            blog= iBlogService.searchByName(pageable,nameSearch.get());
            model.addAttribute("nameSearch",nameSearch.get());
        } else{
            blog=iBlogService.sortByDay(pageable);
        }
        model.addAttribute("blog",blog);
        return "home";
    }
    @GetMapping(value = "/create")
    public String showFormCreate(Model model){
        model.addAttribute("blog",new Blog());
        model.addAttribute("categoryList",this.iCategoryService.findAll());
        return "create";
    }
    @PostMapping(value = "/create")
    public String createBlog(@ModelAttribute Blog blog ){
        this.iBlogService.save(blog);
//        this.iBlogService.createBlog(blog.getAuther(),blog.getContent());
        return "redirect:/";
    }
    @GetMapping(value = "/edit")
    public String showEditForm(@RequestParam Long id, Model model){
        model.addAttribute("blog",this.iBlogService.findById(id));
        model.addAttribute("categoryList",this.iCategoryService.findAll());
        return "edit";
    }
    @PostMapping(value = "/edit")
    public String editBlog(@ModelAttribute Blog blog,Model model){
        this.iBlogService.save(blog);
        model.addAttribute("blog",blog);
        model.addAttribute("msg","Edit successfully");
        return "edit";
    }
    @GetMapping(value = "/show")
    public String showBlog(@RequestParam Long id,Model model){
        model.addAttribute("blog",this.iBlogService.findById(id));
        return "show";
    }
    @GetMapping(value = "/delete")
    public String showDelete(@RequestParam Long id,Model model){
        model.addAttribute("blog",this.iBlogService.findById(id));
        return "delete";
    }
    @PostMapping(value = "/delete")
    public String deleteBlog(@RequestParam Long id, RedirectAttributes redirectAttributes){
        this.iBlogService.remove(id);
        redirectAttributes.addFlashAttribute("msg","Delete Success");
        return "redirect:/blog/";
    }
}
