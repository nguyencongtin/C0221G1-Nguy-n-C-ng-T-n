package com.case_study.model.service;

import com.case_study.model.entity.customer.Customer;
import com.case_study.model.entity.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService extends IGeneralService<Customer> {
    List<CustomerType> findAllCustomerType();
    List<Customer> findAll();
    Page<Customer> findAll(String name, String birthday, String idCard, Pageable pageable);
}
