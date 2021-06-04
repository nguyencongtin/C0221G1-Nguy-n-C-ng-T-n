package model.service;

import model.bean.Employee;

import java.util.List;

public interface IEmployeeService {
    boolean addNewEmployee(Employee employee);
    List<Employee> findByAll();
    boolean deleteEmployee(int id);
    boolean updateEmployee(int id,Employee employee);
    Employee getEmployeeById(int id);
    List<Employee> findByName(String name);
}
