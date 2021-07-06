package com.case_study.model.repository.service;

import com.case_study.model.entity.service.ServiceType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceTypeRepository extends PagingAndSortingRepository<ServiceType,Long> {
}
