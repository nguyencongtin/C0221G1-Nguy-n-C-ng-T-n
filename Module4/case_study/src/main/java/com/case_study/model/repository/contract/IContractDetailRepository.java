package com.case_study.model.repository.contract;

import com.case_study.model.entity.contract.ContractDetail;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractDetailRepository extends PagingAndSortingRepository<ContractDetail,Long> {
}
