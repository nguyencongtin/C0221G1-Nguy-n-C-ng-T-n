package com.hoan_thien_gio_hang.model.service.impl;

import com.hoan_thien_gio_hang.model.entity.Product;
import com.hoan_thien_gio_hang.model.repository.IProductRepository;
import com.hoan_thien_gio_hang.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
}