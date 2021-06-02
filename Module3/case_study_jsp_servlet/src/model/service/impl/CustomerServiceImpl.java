package model.service.impl;

import model.bean.Customer;
import model.repository.CustomerRepository;
import model.service.ICustomerService;

import java.util.List;

public class CustomerServiceImpl implements ICustomerService {
    CustomerRepository customerRepository = new CustomerRepository();
    @Override
    public boolean addNewCustomer(Customer customer) {
        return customerRepository.addNewCustomer(customer);
    }

    @Override
    public List<Customer> findByAll() {
        return customerRepository.findByAll();
    }

    @Override
    public boolean deleteCustomer(int id) {
        return customerRepository.deleteCustomer(id);
    }
}
