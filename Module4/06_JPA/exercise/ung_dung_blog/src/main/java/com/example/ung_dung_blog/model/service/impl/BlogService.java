package com.example.ung_dung_blog.model.service.impl;

import com.example.ung_dung_blog.model.entity.Blog;
import com.example.ung_dung_blog.model.repository.IBlogRepository;
import com.example.ung_dung_blog.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository iBlogRepository;

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        iBlogRepository.deleteById(id);
    }

//    @Override
//    public void createBlog(String auther, String content) {
//        iBlogRepository.createBlog(auther, content);
//    }

}
