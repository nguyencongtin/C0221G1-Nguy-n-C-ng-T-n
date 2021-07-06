package com.case_study.model.service;

import com.case_study.model.entity.customer.Customer;
import com.case_study.model.entity.customer.CustomerType;

import java.util.List;

public interface ICustomerService extends IGeneralService<Customer> {
    List<CustomerType> findAllCustomerType();
}
