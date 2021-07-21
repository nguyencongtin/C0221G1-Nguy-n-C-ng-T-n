package model.service.impl;

import model.bean.Division;
import model.bean.EducationDegree;
import model.bean.Employee;
import model.bean.Position;
import model.repository.EmployeeRepository;
import model.service.IEmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepository();
    @Override
    public boolean addNewEmployee(Employee employee) {
        return employeeRepository.addNewEmployee(employee);

    }

    @Override
    public List<Employee> findByAll() {
        return employeeRepository.findByAll();
    }

    @Override
    public boolean deleteEmployee(int id) {
        return employeeRepository.deleteEmployee(id);
    }

    @Override
    public boolean updateEmployee(int id, Employee employee) {
        return employeeRepository.updateEmployee(id,employee);
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeRepository.getEmployeeById(id);
    }

    @Override
    public List<Employee> findByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public List<Position> findByAllPosition() {
        return employeeRepository.findByAllPosition();
    }

    @Override
    public List<EducationDegree> findByAllEducationDegree() {
        return employeeRepository.findByAllEducationDegree();
    }

    @Override
    public List<Division> findByAllDivision() {
        return employeeRepository.findByAllDivision();
    }
}
