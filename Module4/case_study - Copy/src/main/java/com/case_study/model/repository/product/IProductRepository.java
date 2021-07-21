package com.case_study.model.repository.product;

import com.case_study.model.entity.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends PagingAndSortingRepository<Product,Long> {
    @Query(value = "select * from product where product_name like %?1% and product_color like %?2% and product_description like %?3% and flag=0 order by product_id desc ",nativeQuery = true)
    Page<Product> findAllProduct(String productName, String productColor, String productDescription, Pageable pageable);
}
