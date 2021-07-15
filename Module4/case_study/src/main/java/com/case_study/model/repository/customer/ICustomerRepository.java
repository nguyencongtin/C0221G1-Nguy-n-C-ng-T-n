package com.case_study.model.repository.customer;

import com.case_study.model.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer,Long> {
    @Query(value = "select * from customer where `name` like %?1% and birthday like %?2% and id_card like %?3% and flag=0 order by id desc ",nativeQuery = true)
    Page<Customer> findAllCustomer(String name,String birthday, String idCard, Pageable pageable);
}
