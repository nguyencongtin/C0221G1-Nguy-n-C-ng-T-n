package com.case_study.model.service;

import com.case_study.model.entity.employee.Division;
import com.case_study.model.entity.employee.EducationDegree;
import com.case_study.model.entity.employee.Employee;
import com.case_study.model.entity.employee.Position;

import java.util.List;

public interface IEmployeeService extends IGeneralService<Employee>{
    List<EducationDegree> educationDegreeList();
    List<Division> divisionList();
    List<Position> positionList();
    List<Employee> findAll();
}
