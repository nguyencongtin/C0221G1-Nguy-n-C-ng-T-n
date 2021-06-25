package com.example.nang_cap_ung_dung_blog.model.service.impl;

import com.example.nang_cap_ung_dung_blog.model.entity.Category;
import com.example.nang_cap_ung_dung_blog.model.repository.ICategoryRepository;
import com.example.nang_cap_ung_dung_blog.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> findAll() {
        return this.iCategoryRepository.findAll();
    }

    @Override
    public Category findById(Integer id) {
        return this.iCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Category category) {
        this.iCategoryRepository.save(category);
    }

    @Override
    public void remove(Integer id) {
        this.iCategoryRepository.deleteById(id);
    }
}
