package com.them_san_pham_vao_gio_hang.model.service;

import com.them_san_pham_vao_gio_hang.model.entity.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
}