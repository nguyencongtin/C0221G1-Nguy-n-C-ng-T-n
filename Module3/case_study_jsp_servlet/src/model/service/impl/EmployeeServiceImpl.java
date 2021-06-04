package model.service.impl;

import model.bean.Employee;
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
}
