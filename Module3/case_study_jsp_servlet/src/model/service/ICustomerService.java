package model.service;

import model.bean.Customer;
import model.bean.TypeCustomer;

import java.util.List;

public interface ICustomerService {
    boolean addNewCustomer(Customer customer);
    List<Customer> findByAll();
    boolean deleteCustomer(int id);
    boolean updateCustomer(int id,Customer customer);
    Customer getCustomerById(int id);
    List<Customer> findByName(String name);
    List<TypeCustomer> findByAllCustomerType();
}
