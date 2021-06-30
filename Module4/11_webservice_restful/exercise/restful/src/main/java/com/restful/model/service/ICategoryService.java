package com.restful.model.service;


import com.restful.model.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category findById(Integer id);

    void save(Category category);

    void remove(Integer id);


}
