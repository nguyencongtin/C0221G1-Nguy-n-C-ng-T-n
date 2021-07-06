package com.case_study.model.repository.service;

import com.case_study.model.entity.customer.Customer;
import com.case_study.model.entity.service.Service;
import com.case_study.model.entity.service.ServiceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceRepository extends PagingAndSortingRepository<Service,Long> {
    @Query(value = "select * from service where name like %?1% && flag = 0 order by id desc ",nativeQuery = true)
    Page<Customer> findAllService(String name, Pageable pageable);
}
