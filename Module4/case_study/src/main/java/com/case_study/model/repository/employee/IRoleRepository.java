package com.case_study.model.repository.employee;

import com.case_study.model.entity.employee.Role;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends PagingAndSortingRepository<Role,Long> {
}
