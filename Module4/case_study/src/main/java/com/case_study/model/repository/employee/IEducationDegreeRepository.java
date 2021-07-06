package com.case_study.model.repository.employee;

import com.case_study.model.entity.employee.EducationDegree;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducationDegreeRepository extends PagingAndSortingRepository<EducationDegree,Long> {
}
