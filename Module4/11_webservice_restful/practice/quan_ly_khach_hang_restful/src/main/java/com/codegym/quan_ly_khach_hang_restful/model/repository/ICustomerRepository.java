package com.codegym.quan_ly_khach_hang_restful.model.repository;

import com.codegym.quan_ly_khach_hang_restful.model.entity.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer,Long> {
}
