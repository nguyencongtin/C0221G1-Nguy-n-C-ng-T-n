package com.hoan_thien_gio_hang.model.service;

import com.hoan_thien_gio_hang.model.entity.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
}