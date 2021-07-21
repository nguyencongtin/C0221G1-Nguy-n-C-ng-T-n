package com.case_study.model.repository.product;

import com.case_study.model.entity.product.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICategoryRepository extends PagingAndSortingRepository<Category,Long> {
}
