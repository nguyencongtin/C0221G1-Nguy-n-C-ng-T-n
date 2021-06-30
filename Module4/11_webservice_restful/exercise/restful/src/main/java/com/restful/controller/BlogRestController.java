package com.restful.controller;

import com.restful.model.entity.Blog;
import com.restful.model.entity.Category;
import com.restful.model.service.IBlogService;
import com.restful.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value= "/rest")
@RestController
public class BlogRestController {

    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping(value= {"/","/listBlog"})
    public ResponseEntity<List<Blog>> getListBlog(){
        List<Blog> blogList = this.iBlogService.findAll();
        if(blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }
    @GetMapping(value= {"/","/listCategory"})
    public ResponseEntity<List<Category>> getListCategory(){
        List<Category> categoryList = this.iCategoryService.findAll();
        if(categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList,HttpStatus.OK);
    }

    @GetMapping(value = "/blogWithSameCategory")
    public ResponseEntity<List<Blog>> showBlogWithSameCategory(@PathVariable Long id){
        List<Blog> blogList=this.iBlogService.findBlogWithSameCategory(id);
        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }

    @GetMapping(value= "/detail/{id}")
    public ResponseEntity<Blog> showBlogDetail(@PathVariable Long id){
        Blog blog=iBlogService.findById(id);
        if(blog==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }




}
