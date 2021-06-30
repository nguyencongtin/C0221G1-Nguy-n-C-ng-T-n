package com.restful.model.service.impl;

import com.restful.model.entity.Blog;
import com.restful.model.repository.IBlogRepository;
import com.restful.model.service.IBlogService;
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

//    Cách 1: dùng câu query
    @Override
    public Page<Blog> searchByName(Pageable pageable, String nameSearch) {
        return iBlogRepository.searchByName(pageable,nameSearch);
    }

    @Override
    public Page<Blog> sortByDay(Pageable pageable) {
        return iBlogRepository.findAllByOrderByDate(pageable);
    }

    @Override
    public List<Blog> findBlogWithSameCategory(Long id) {
        return iBlogRepository.findBlogWithSameCategory(id);
    }


//    @Override
//    public void createBlog(String auther, String content) {
//        iBlogRepository.createBlog(auther, content);
//    }

}
