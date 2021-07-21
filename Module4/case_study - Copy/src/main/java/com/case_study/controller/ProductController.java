package com.case_study.controller;

import com.case_study.model.dto.ProductDto;
import com.case_study.model.entity.product.Product;
import com.case_study.model.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService iProductService;
    @GetMapping({"","/search"})
    public ModelAndView showList(@RequestParam("productName")Optional<String> productName,
                                 @RequestParam("productColor")Optional<String> productColor,
                                 @RequestParam("productDescription")Optional<String> productDescription,
                                 @PageableDefault(value=2) Pageable pageable){
        return new ModelAndView("product/list","products",iProductService.findAll(productName.orElse(""),productColor.orElse(""),productDescription.orElse(""),pageable)).
                addObject("search",productName.orElse(""))
                .addObject("birthday",productColor.orElse(""))
                .addObject("idCard",productDescription.orElse(""));
    }
    @GetMapping("/create")
    public ModelAndView showCreate(){
        return new ModelAndView("product/create","productDto",new ProductDto()).
                addObject("categorys",iProductService.findAllCategory());
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute @Valid ProductDto productDto, BindingResult bindingResult){
        new ProductDto().validate(productDto,bindingResult);
        if(bindingResult.hasErrors()){
            return new ModelAndView("product/create","msg","Something wrong!! <br> Try again").
                    addObject("categorys",iProductService.findAllCategory());
        }
        Product product=new Product();
        BeanUtils.copyProperties(productDto,product);
        iProductService.save(product);
        return new ModelAndView("product/create","msg","Create is successful!!").
                addObject("categorys",iProductService.findAllCategory());
    }
    @GetMapping("/edit/{idc}")
    public ModelAndView showEdit(@PathVariable Long idc){
        if (iProductService.findById(idc)==null){
            return new ModelAndView("error-404");
        }
        ProductDto productDto=new ProductDto();
        BeanUtils.copyProperties(iProductService.findById(idc),productDto);

        return new ModelAndView("product/edit","productDto",productDto).
                addObject("categorys",iProductService.findAllCategory());
    }
    @PostMapping("/edit")
    public ModelAndView edit(@ModelAttribute @Valid ProductDto productDto,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ModelAndView("product/edit","msg","Something wrong!! <br> Try again").
                    addObject("categorys",iProductService.findAllCategory());
        }
        Product product=new Product();
        BeanUtils.copyProperties(productDto,product);
        iProductService.save(product);
        return new ModelAndView("product/edit","msg","Edit is successful!!").
                addObject("categorys",iProductService.findAllCategory());
    }
    @PostMapping("/delete")
    public ModelAndView delete(@RequestParam Optional<List<Long>> id ){
        if (id.isPresent()){
            for (Long i : id.get()){
                Product product= iProductService.findById(i);
                if (product==null){
                    return new ModelAndView("error-404");
                }
                product.setFlag(true);
                iProductService.save(product);
                return new ModelAndView("redirect:/product");
            }
        }
        return new ModelAndView("redirect:/product");
    }
}
