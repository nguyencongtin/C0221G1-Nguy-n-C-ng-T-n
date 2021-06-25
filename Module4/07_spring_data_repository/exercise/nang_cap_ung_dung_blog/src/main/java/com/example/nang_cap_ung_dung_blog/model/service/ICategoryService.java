package com.example.nang_cap_ung_dung_blog.model.service;


import com.example.nang_cap_ung_dung_blog.model.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category findById(Integer id);

    void save(Category category);

    void remove(Integer id);
}
