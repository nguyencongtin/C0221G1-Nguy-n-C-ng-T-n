package com.case_study.model.service.impl;

import com.case_study.model.entity.product.Category;
import com.case_study.model.entity.product.Product;
import com.case_study.model.repository.product.ICategoryRepository;
import com.case_study.model.repository.product.IProductRepository;
import com.case_study.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService {

    @Autowired
    IProductRepository iProductRepository;
    @Autowired
    ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> findAllCategory() {
        return (List<Category>) iCategoryRepository.findAll();
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) iProductRepository.findAll();
    }

    @Override
    public Page<Product> findAll(String productName, String productColor, String productDescription, Pageable pageable) {
        return iProductRepository.findAllProduct(productName,productColor,productDescription,pageable);
    }

    @Override
    public Page<Product> findAll(String name, Pageable pageable) {
        return null;
    }

    @Override
    public Product findById(Long id) {
        return iProductRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Product o) {
        iProductRepository.save(o);
    }

    @Override
    public void remove(Long id) {
        iProductRepository.deleteById(id);
    }
}
