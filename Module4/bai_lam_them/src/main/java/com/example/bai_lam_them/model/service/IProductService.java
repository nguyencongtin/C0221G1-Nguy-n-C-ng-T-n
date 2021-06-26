package com.example.bai_lam_them.model.service;


import com.example.bai_lam_them.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IProductService extends IGenericService<Product> {
    Page<Product> searchNameAndDate(@Param("search") String search, Pageable pageable);

    Page<Product> findAllSortDate(Pageable pageable);
}