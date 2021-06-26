package com.example.bai_lam_them.model.service.impl;

import com.example.bai_lam_them.model.entity.Product;
import com.example.bai_lam_them.model.repository.IProductRepository;
import com.example.bai_lam_them.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductImpl implements IProductService {
   @Autowired
    IProductRepository productRepository;
    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void remove(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<Product> searchNameAndDate(String search, Pageable pageable) {
        return productRepository.searchNameAndDate('%'+search+'%', pageable);
    }

    @Override
    public Page<Product> findAllSortDate(Pageable pageable) {
        return productRepository.findAllSortDate(pageable);
    }
}
