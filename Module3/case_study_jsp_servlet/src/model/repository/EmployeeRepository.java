package model.repository;

import model.bean.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    BaseRepository baseRepository = new BaseRepository();

    public boolean addNewEmployee(Employee employee) {
        Connection connection = baseRepository.connectDataBase();
        boolean check = false;
        try {
            CallableStatement callableStatement = connection.prepareCall("{call create_employee(?,?,?,?,?,?,?,?,?,?,?)}");
            callableStatement.setString("p_ho_ten", employee.getEmployeeName());
            callableStatement.setString("p_ngay_sinh", employee.getEmployeeBirthday());
            callableStatement.setString("p_so_cmtnd", employee.getEmployeeIdCard());
            callableStatement.setDouble("p_luong", Double.parseDouble(employee.getEmployeeSalary()));
            callableStatement.setString("p_sdt", employee.getEmployeePhone());
            callableStatement.setString("p_email", employee.getEmployeeEmail());
            callableStatement.setString("p_dia_chi", employee.getEmployeeAddress());
            callableStatement.setInt("p_id_vi_tri", employee.getIdPosition());
            callableStatement.setInt("p_id_trinh_do", employee.getIdEducationDegree());
            callableStatement.setInt("p_id_bo_phan", employee.getIdDivision());
            callableStatement.setString("p_user_name", employee.getUserName());
            check = callableStatement.executeUpdate() > 0;
            callableStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    public List<Employee> findByAll() {
        Connection connection = baseRepository.connectDataBase();
        List<Employee> employeeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select* from nhan_vien");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int employeeId = resultSet.getInt("id_nhan_vien");
                String employeeName = resultSet.getString("ho_ten");
                String employeeBirthday = resultSet.getString("ngay_sinh");
                String employeeIdCard = resultSet.getString("so_cmtnd");
                String employeeSalary = resultSet.getString("luong");
                String employeePhone = resultSet.getString("sdt");
                String employeeEmail = resultSet.getString("email");
                String employeeAddress = resultSet.getString("dia_chi");
                int idPosition = resultSet.getInt("id_vi_tri");
                int idEducationDegree = resultSet.getInt("id_trinh_do");
                int idDivision = resultSet.getInt("id_bo_phan");
                String userName = resultSet.getString("user_name");
                Employee employee = new Employee(employeeId, employeeName, employeeBirthday, employeeIdCard, employeeSalary, employeePhone, employeeEmail, employeeAddress, idPosition, idEducationDegree, idDivision, userName);
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public boolean deleteEmployee(int id) {
        boolean check = false;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from nhan_vien where id_nhan_vien=?");
            preparedStatement.setInt(1, id);
            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean updateEmployee(int id, Employee employee) {
        boolean check = false;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update nhan_vien \n" +
                    "set ho_ten=?,id_vi_tri=?,id_trinh_do=?,id_bo_phan=?,ngay_sinh=?,so_cmtnd=?,luong=?,sdt=?,email=?,dia_chi=?,user_name=? where id_nhan_vien=?");
            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setInt(2, employee.getIdPosition());
            preparedStatement.setInt(3, employee.getIdEducationDegree());
            preparedStatement.setInt(4, employee.getIdDivision());
            preparedStatement.setString(5, employee.getEmployeeBirthday());
            preparedStatement.setString(6, employee.getEmployeeIdCard());
            preparedStatement.setString(7, employee.getEmployeeSalary());
            preparedStatement.setString(8, employee.getEmployeePhone());
            preparedStatement.setString(9, employee.getEmployeeEmail());
            preparedStatement.setString(10, employee.getEmployeeAddress());
            preparedStatement.setString(11, employee.getUserName());
            preparedStatement.setInt(12, id);
            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    public Employee getEmployeeById(int id) {
        Connection connection = baseRepository.connectDataBase();
        Employee employee = null;
        try {
            PreparedStatement statement = connection.prepareStatement("select * from nhan_vien where id_nhan_vien=?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int employeeId = resultSet.getInt("id_nhan_vien");
                String employeeName = resultSet.getString("ho_ten");
                String employeeBirthday = resultSet.getString("ngay_sinh");
                String employeeIdCard = resultSet.getString("so_cmtnd");
                String employeeSalary = resultSet.getString("luong");
                String employeePhone = resultSet.getString("sdt");
                String employeeEmail = resultSet.getString("email");
                String employeeAddress = resultSet.getString("dia_chi");
                int idPosition = resultSet.getInt("id_vi_tri");
                int idEducationDegree = resultSet.getInt("id_trinh_do");
                int idDivision = resultSet.getInt("id_bo_phan");
                String userName = resultSet.getString("user_name");
                employee = new Employee(employeeId, employeeName, employeeBirthday, employeeIdCard, employeeSalary, employeePhone, employeeEmail, employeeAddress, idPosition, idEducationDegree, idDivision, userName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    public List<Employee> findByName(String name) {
        Connection connection = baseRepository.connectDataBase();
        List<Employee> employeeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select* from nhan_vien where ho_ten like ?");
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int employeeId = resultSet.getInt("id_nhan_vien");
                String employeeName = resultSet.getString("ho_ten");
                String employeeBirthday = resultSet.getString("ngay_sinh");
                String employeeIdCard = resultSet.getString("so_cmtnd");
                String employeeSalary = resultSet.getString("luong");
                String employeePhone = resultSet.getString("sdt");
                String employeeEmail = resultSet.getString("email");
                String employeeAddress = resultSet.getString("dia_chi");
                int idPosition = resultSet.getInt("id_vi_tri");
                int idEducationDegree = resultSet.getInt("id_trinh_do");
                int idDivision = resultSet.getInt("id_bo_phan");
                String userName = resultSet.getString("user_name");
                Employee employee = new Employee(employeeId, employeeName, employeeBirthday, employeeIdCard, employeeSalary, employeePhone, employeeEmail, employeeAddress, idPosition, idEducationDegree, idDivision, userName);
                employeeList.add(employee);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public List<Position> findByAllPosition() {
        Connection connection = baseRepository.connectDataBase();
        List<Position> positionList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select* from vi_tri");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idPosition = resultSet.getInt("id_vi_tri");
                String positionName = resultSet.getString("ten_vi_tri");
                positionList.add(new Position(idPosition, positionName));
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return positionList;
    }

    public List<EducationDegree> findByAllEducationDegree() {
        Connection connection = baseRepository.connectDataBase();
        List<EducationDegree> educationDegreeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select* from trinh_do");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idEducationDegree = resultSet.getInt("id_trinh_do");
                String educationDegreeName = resultSet.getString("trinh_do");
                educationDegreeList.add(new EducationDegree(idEducationDegree, educationDegreeName));
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return educationDegreeList;
    }

    public List<Division> findByAllDivision() {
        Connection connection = baseRepository.connectDataBase();
        List<Division> divisionList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select* from bo_phan");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idDivision = resultSet.getInt("id_bo_phan");
                String divisionName = resultSet.getString("ten_bo_phan");
                divisionList.add(new Division(idDivision, divisionName));
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return divisionList;
    }

//    public static void main(String[] args) {
//        EmployeeRepository employeeRepository = new EmployeeRepository();
//        System.out.println(employeeRepository.addNewEmployee(new Employee("abc","2000-02-02","2323121","213123123","2000123","455616@@@","vn",1,2,3,"mylinhne")));
//        System.out.println(employeeRepository.findByAllEducationDegree().size());
//        System.out.println(employeeRepository.findByAllDivision().size());
//    }

}


