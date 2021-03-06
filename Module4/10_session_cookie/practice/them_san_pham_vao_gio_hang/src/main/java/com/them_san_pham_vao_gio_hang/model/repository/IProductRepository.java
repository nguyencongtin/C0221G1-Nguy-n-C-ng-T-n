package com.them_san_pham_vao_gio_hang.model.repository;

import com.them_san_pham_vao_gio_hang.model.entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {
}