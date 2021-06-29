package com.hoan_thien_gio_hang.controller;

import com.hoan_thien_gio_hang.model.Cart;
import com.hoan_thien_gio_hang.model.entity.Product;
import com.hoan_thien_gio_hang.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }
    @GetMapping("/detail/{id}")
    public String showDetail(Model model) {
        model.addAttribute("products", productService.findAll());
        return "redirect:/showDetail";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("+")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }if (action.equals("-")) {
            cart.decrease(productOptional.get());
            return "redirect:/shopping-cart";
        }if (action.equals("delete")) {
            cart.delete(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }
}