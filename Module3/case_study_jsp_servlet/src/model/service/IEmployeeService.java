package model.service;

import model.bean.Division;
import model.bean.EducationDegree;
import model.bean.Employee;
import model.bean.Position;

import java.util.List;

public interface IEmployeeService {
    boolean addNewEmployee(Employee employee);
    List<Employee> findByAll();
    boolean deleteEmployee(int id);
    boolean updateEmployee(int id,Employee employee);
    Employee getEmployeeById(int id);
    List<Employee> findByName(String name);
    List<Position> findByAllPosition();
    List<EducationDegree> findByAllEducationDegree();
    List<Division> findByAllDivision();
}
