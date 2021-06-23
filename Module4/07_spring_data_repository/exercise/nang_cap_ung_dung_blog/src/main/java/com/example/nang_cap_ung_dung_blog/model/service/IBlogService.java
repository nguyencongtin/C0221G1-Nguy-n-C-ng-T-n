package com.example.nang_cap_ung_dung_blog.model.service;

import com.example.nang_cap_ung_dung_blog.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);

    Blog findById(Long id);

    void save(Blog blog);

    void remove(Long id);

    Page<Blog> searchByName(Pageable pageable, String nameSearch);

    Page<Blog> sortByDay(Pageable pageable);
//    void createBlog(String auther, String content);
}