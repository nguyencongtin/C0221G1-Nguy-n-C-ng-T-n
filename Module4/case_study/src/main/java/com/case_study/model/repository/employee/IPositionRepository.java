package com.case_study.model.repository.employee;

import com.case_study.model.entity.employee.Position;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPositionRepository extends PagingAndSortingRepository<Position,Long> {
}
