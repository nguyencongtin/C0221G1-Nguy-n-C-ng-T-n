package com.example.ung_dung_blog.model.service;

import com.example.ung_dung_blog.model.entity.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    Blog findById(Long id);

    void save(Blog blog);

    void remove(Long id);

    void createBlog(String auther, String content);
}