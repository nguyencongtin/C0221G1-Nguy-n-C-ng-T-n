package com.case_study.model.repository.customer;

import com.case_study.model.entity.customer.CustomerType;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICustomerTypeRepository extends PagingAndSortingRepository<CustomerType,Long> {
}
