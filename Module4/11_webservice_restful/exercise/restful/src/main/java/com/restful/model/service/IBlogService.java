package com.restful.model.service;

import com.restful.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IBlogService {
    List<Blog> findAll();

    Blog findById(Long id);

    void save(Blog blog);

    void remove(Long id);

    Page<Blog> searchByName(Pageable pageable, String nameSearch);

    Page<Blog> sortByDay(Pageable pageable);
//    void createBlog(String auther, String content);
    List<Blog> findBlogWithSameCategory(Long id);
}