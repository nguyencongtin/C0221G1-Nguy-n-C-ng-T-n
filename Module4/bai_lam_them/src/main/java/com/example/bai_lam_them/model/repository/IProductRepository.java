package com.example.bai_lam_them.model.repository;

import com.example.bai_lam_them.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;


public interface IProductRepository extends PagingAndSortingRepository<Product, Integer> {
    @Query(value = "select * from product where concat(`name`, `date`) like :keySearch order by `date` desc", nativeQuery = true)
    Page<Product> searchNameAndDate(@Param("keySearch") String keySearch, Pageable pageable);

    @Query(value = "select * from product order by `date` desc", nativeQuery = true)
    Page<Product> findAllSortDate(Pageable pageable);
}
