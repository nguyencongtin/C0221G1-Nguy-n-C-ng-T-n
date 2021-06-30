package com.example.bo_sung_aspect_log_cho_ung_dung_quan_ly_danh_sach_khach_hang.repository;

import com.example.bo_sung_aspect_log_cho_ung_dung_quan_ly_danh_sach_khach_hang.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Iterable<Customer> findAllByNameContainsOrEmailContainsOrAddressContains(String name, String email, String address);

    Page<Customer> findAllByNameContainsOrEmailContainsOrAddressContains(String name, String email, String address, Pageable pageInfo);
}