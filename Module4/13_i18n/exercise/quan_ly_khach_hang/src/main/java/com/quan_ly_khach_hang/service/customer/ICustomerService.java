package com.quan_ly_khach_hang.service.customer;

import com.quan_ly_khach_hang.model.Customer;
import com.quan_ly_khach_hang.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICustomerService {

    Page<Customer> findAll(Pageable pageable);


    Optional<Customer> findById(Long id);


    void save(Customer customer);


    void remove(Long id);

    Iterable<Customer> findAllByProvince(Province province);

    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);

}
