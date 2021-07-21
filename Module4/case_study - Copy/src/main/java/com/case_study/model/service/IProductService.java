package com.case_study.model.service;

import com.case_study.model.entity.product.Category;
import com.case_study.model.entity.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService extends IGeneralService<Product>{
    List<Category> findAllCategory();
    List<Product> findAll();
    Page<Product> findAll(String productName, String productColor, String productDescription, Pageable pageable);
}
