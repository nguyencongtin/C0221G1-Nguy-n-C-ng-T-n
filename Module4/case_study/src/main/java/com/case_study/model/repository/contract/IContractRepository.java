package com.case_study.model.repository.contract;

import com.case_study.model.entity.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractRepository extends PagingAndSortingRepository<Contract,Long> {
    @Query(value = "select *" +
            " from contract  " +
            "join customer on contract.customer_id=customer.id " +
            "where (curdate() between start_date and end_date) " +
            "and (customer.name like %?1%) " +
            "and (contract.flag = 0) " +
            "order by contract.id desc",nativeQuery = true)
    Page<Contract> usingService(String name, Pageable pageable);
}
