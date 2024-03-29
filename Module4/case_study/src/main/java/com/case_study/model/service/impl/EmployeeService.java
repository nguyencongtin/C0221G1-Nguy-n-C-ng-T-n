package com.case_study.model.service.impl;

import com.case_study.model.entity.employee.Division;
import com.case_study.model.entity.employee.EducationDegree;
import com.case_study.model.entity.employee.Employee;
import com.case_study.model.entity.employee.Position;
import com.case_study.model.repository.employee.IDivisionRepository;
import com.case_study.model.repository.employee.IEducationDegreeRepository;
import com.case_study.model.repository.employee.IEmployeeRepository;
import com.case_study.model.repository.employee.IPositionRepository;
import com.case_study.model.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    IEmployeeRepository employeeRepository;
    @Autowired
    IEducationDegreeRepository educationDegreeRepository;
    @Autowired
    IDivisionRepository divisionRepository;
    @Autowired
    IPositionRepository positionRepository;
    @Override
    public List<EducationDegree> educationDegreeList() {
        return (List<EducationDegree>) educationDegreeRepository.findAll();
    }

    @Override
    public List<Division> divisionList() {
        return (List<Division>) divisionRepository.findAll();
    }

    @Override
    public List<Position> positionList() {
        return (List<Position>) positionRepository.findAll();
    }

    @Override
    public List<Employee> findAll() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public Page<Employee> findAll(String name, Pageable pageable) {
        return employeeRepository.findAllEmployee(name,pageable);
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Employee o) {
        employeeRepository.save(o);
    }

    @Override
    public void remove(Long id) {
        employeeRepository.deleteById(id);
    }
}
