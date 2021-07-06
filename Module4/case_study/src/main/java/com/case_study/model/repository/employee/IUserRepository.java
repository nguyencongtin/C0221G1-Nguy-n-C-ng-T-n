package com.case_study.model.repository.employee;

import com.case_study.model.entity.employee.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends PagingAndSortingRepository<User,Long> {
}
