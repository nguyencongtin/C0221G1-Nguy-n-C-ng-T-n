package model.repository;

import model.bean.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    BaseRepository baseRepository = new BaseRepository();

    public boolean addNewCustomer(Customer customer) {
        Connection connection = baseRepository.connectDataBase();
        boolean check = false;
        try {
            CallableStatement callableStatement = connection.prepareCall("{call create_customer(?,?,?,?,?,?,?,?)}");
            callableStatement.setInt("p_id_loai_khach", customer.getIdTypeCustomer());
            callableStatement.setString("p_ho_ten", customer.getName());
            callableStatement.setString("p_ngay_sinh", customer.getDayOfBirth());
            callableStatement.setString("p_gioi_tinh", customer.getSex());
            callableStatement.setString("p_so_cmnd", customer.getIdCard());
            callableStatement.setString("p_so_dien_thoai", customer.getPhoneNumber());
            callableStatement.setString("p_email", customer.getEmail());
            callableStatement.setString("p_dia_chi", customer.getAddress());
            check = callableStatement.executeUpdate() > 0;
            callableStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    public List<Customer> findByAll() {
        Connection connection = baseRepository.connectDataBase();
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select* from khach_hang");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idCustomer = resultSet.getInt("id_khach_hang");
                int idTypeCustomer = resultSet.getInt("id_loai_khach_hang");
                String name = resultSet.getString("ho_ten");
                String dayOfBirth = resultSet.getString("ngay_sinh");
                String sex = resultSet.getString("gioi_tinh");
                String idCard = resultSet.getString("so_cmtnd");
                String phoneNumber = resultSet.getString("sdt");
                String email = resultSet.getString("email");
                String address = resultSet.getString("dia_chi");
                Customer customer = new Customer(idCustomer, idTypeCustomer, name, dayOfBirth, sex, idCard, phoneNumber, email, address);
                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    public boolean deleteCustomer(int id) {
        boolean check = false;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from khach_hang where id_khach_hang=?");
            preparedStatement.setInt(1, id);
            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean updateCustomer(int id, Customer customer) {
        boolean check = false;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update khach_hang \n" +
                    "set id_loai_khach_hang=?,ho_ten=?,ngay_sinh=?,gioi_tinh=?,so_cmtnd=?,sdt=?,email=?,dia_chi=? where id_khach_hang=?");
            preparedStatement.setInt(1, customer.getIdTypeCustomer());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getDayOfBirth());
            preparedStatement.setString(4, customer.getSex());
            preparedStatement.setString(5, customer.getIdCard());
            preparedStatement.setString(6, customer.getPhoneNumber());
            preparedStatement.setString(7, customer.getEmail());
            preparedStatement.setString(8, customer.getAddress());
            preparedStatement.setInt(9, id);
            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    public Customer getCustomerById(int id) {
        Connection connection = baseRepository.connectDataBase();
        Customer customer = null;
        try {
            PreparedStatement statement = connection.prepareStatement("select * from khach_hang where id_khach_hang=?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idCustomer = resultSet.getInt("id_khach_hang");
                int idTypeCustomer = resultSet.getInt("id_loai_khach_hang");
                String name = resultSet.getString("ho_ten");
                String dayOfBirth = resultSet.getString("ngay_sinh");
                String sex = resultSet.getString("gioi_tinh");
                String idCard = resultSet.getString("so_cmtnd");
                String phoneNumber = resultSet.getString("sdt");
                String email = resultSet.getString("email");
                String address = resultSet.getString("dia_chi");
                customer = new Customer(idCustomer, idTypeCustomer, name, dayOfBirth, sex, idCard, phoneNumber, email, address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public static void main(String[] args) {
//        CustomerRepository customerRepository = new CustomerRepository();
//        Customer customer = new Customer(1, "f","2005/05/16" , "a", "a", "a", "a", "a");
//        System.out.println(customerRepository.deleteCustomer(1));
//        System.out.println(customerRepository.updateCustomer(1, customer));
    }


    public List<Customer> findByName(String name) {
        Connection connection= baseRepository.connectDataBase();
        List<Customer> customerList= new ArrayList<>();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("select* from khach_hang where ho_ten like ?");
            preparedStatement.setString(1,"%"+name+"%");
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idCustomer = resultSet.getInt("id_khach_hang");
                int idTypeCustomer = resultSet.getInt("id_loai_khach_hang");
                String name1 = resultSet.getString("ho_ten");
                String dayOfBirth = resultSet.getString("ngay_sinh");
                String sex = resultSet.getString("gioi_tinh");
                String idCard = resultSet.getString("so_cmtnd");
                String phoneNumber = resultSet.getString("sdt");
                String email = resultSet.getString("email");
                String address = resultSet.getString("dia_chi");
                Customer customer = new Customer(idCustomer, idTypeCustomer, name1, dayOfBirth, sex, idCard, phoneNumber, email, address);
                customerList.add(customer);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return customerList;
    }
}

