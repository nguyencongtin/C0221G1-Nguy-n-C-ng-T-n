package com.case_study.model.repository.contract;

import com.case_study.model.entity.contract.AttachService;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAttachServiceRepository extends PagingAndSortingRepository<AttachService,Long> {
}
