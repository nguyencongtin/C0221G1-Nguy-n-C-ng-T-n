package com.case_study.model.service.impl;

import com.case_study.model.entity.customer.Customer;
import com.case_study.model.entity.customer.CustomerType;
import com.case_study.model.repository.customer.ICustomerRepository;
import com.case_study.model.repository.customer.ICustomerTypeRepository;
import com.case_study.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepository;
    @Autowired
    ICustomerTypeRepository customerTypeRepository;

    @Override
    public Page<Customer> findAll(String name, Pageable pageable) {
        return null;
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Customer> findAll(String name,String birthday,String idCard,Pageable pageable) {
        return customerRepository.findAllCustomer(name,birthday,idCard,pageable);
    }


    @Override
    public void save(Customer o) {
        customerRepository.save(o);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }


    @Override
    public List<CustomerType> findAllCustomerType() {
        return (List<CustomerType>) customerTypeRepository.findAll();
    }

    @Override
    public List<Customer> findAll() {
        return (List<Customer>) customerRepository.findAll();
    }

}
