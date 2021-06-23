package com.example.nang_cap_ung_dung_blog.model.service.impl;

import com.example.nang_cap_ung_dung_blog.model.entity.Blog;
import com.example.nang_cap_ung_dung_blog.model.repository.IBlogRepository;
import com.example.nang_cap_ung_dung_blog.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository iBlogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
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

//    Cách 1: dùng câu query
    @Override
    public Page<Blog> searchByName(Pageable pageable, String nameSearch) {
        return iBlogRepository.searchByName(pageable,nameSearch);
    }

    @Override
    public Page<Blog> sortByDay(Pageable pageable) {
        return iBlogRepository.findAllByOrderByDate(pageable);
    }

//    @Override
//    public void createBlog(String auther, String content) {
//        iBlogRepository.createBlog(auther, content);
//    }

}
