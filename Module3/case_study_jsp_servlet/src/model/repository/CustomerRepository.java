package model.repository;

import model.bean.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    BaseRepository baseRepository= new BaseRepository();
    public boolean addNewCustomer(Customer customer) {
        Connection connection= baseRepository.connectDataBase();
        boolean check=false;
        try{
            CallableStatement callableStatement= connection.prepareCall("{call create_customer(?,?,?,?,?,?,?,?)}");
            callableStatement.setInt("p_id_loai_khach",customer.getIdTypeCustomer() );
            callableStatement.setString("p_ho_ten",customer.getName() );
            callableStatement.setString("p_ngay_sinh",customer.getDateOfBirth() );
            callableStatement.setString("p_gioi_tinh",customer.getSex() );
            callableStatement.setString("p_so_cmnd",customer.getIdCard());
            callableStatement.setString("p_so_dien_thoai",customer.getPhoneNumber() );
            callableStatement.setString("p_email",customer.getEmail() );
            callableStatement.setString("p_dia_chi",customer.getAddress());
            check=callableStatement.executeUpdate()>0;
            callableStatement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return check;
    }

    public List<Customer> findByAll() {
        Connection connection=baseRepository.connectDataBase();
        List<Customer> customerList= new ArrayList<>();
        try{
            PreparedStatement preparedStatement= connection.prepareStatement("select* from khach_hang");
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                 int idCustomer= resultSet.getInt("id_khach_hang");
                 int idTypeCustomer=resultSet.getInt("id_loai_khach_hang");
                 String name=resultSet.getString("ho_ten");
                 String dateOfBirth=resultSet.getString("ngay_sinh");
                 String sex=resultSet.getString("gioi_tinh");
                 String idCard=resultSet.getString("so_cmtnd");
                 String phoneNumber=resultSet.getString("sdt");
                 String email=resultSet.getString("email");
                 String address=resultSet.getString("dia_chi");
                 Customer customer=new Customer(idCustomer,idTypeCustomer,name,dateOfBirth,sex,idCard,phoneNumber,email,address);
                 customerList.add(customer);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return customerList;
    }

    public boolean deleteCustomer(int id) {
        boolean check=false;
        Connection connection= baseRepository.connectDataBase();
        try{
            PreparedStatement preparedStatement=connection.prepareStatement("delete from khach_hang where id_khach_hang=?");
            preparedStatement.setInt(1,id);
            check=preparedStatement.executeUpdate()>0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }


    public static void main(String[] args) {
        CustomerRepository customerRepository= new CustomerRepository();
        System.out.println(customerRepository.addNewCustomer(new Customer(1,"aaaaa","1993-03-03","nu","1323123312","23423421","@@@","vn")));
        System.out.println(customerRepository.addNewCustomer(new Customer(1,"aaaaa","1993-03-03","nu","1323123312","23423421","@@@","vn")));
        System.out.println(customerRepository.addNewCustomer(new Customer(1,"aaaaa","1993-03-03","nu","1323123312","23423421","@@@","vn")));
        System.out.println(customerRepository.addNewCustomer(new Customer(1,"aaaaa","1993-03-03","nu","1323123312","23423421","@@@","vn")));
        System.out.println(customerRepository.addNewCustomer(new Customer(1,"aaaaa","1993-03-03","nu","1323123312","23423421","@@@","vn")));
    }

}

