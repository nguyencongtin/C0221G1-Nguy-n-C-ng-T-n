package model.service.impl;

import model.bean.AttachService;
import model.bean.Customer;
import model.repository.CustomerUsingServiceRepository;
import model.service.ICustomerUsingServiceService;

import java.util.List;

public class CustomerUsingServiceServiceImpl implements ICustomerUsingServiceService {
    CustomerUsingServiceRepository customerUsingServiceRepository= new CustomerUsingServiceRepository();
    @Override
    public List<Customer> findByAllCustomerUsingService() {
        return customerUsingServiceRepository.findByAllCustomerUsingService();
    }

    @Override
    public List<AttachService> findByAllAttachService(int id) {
        return customerUsingServiceRepository.findByAllAttachService(id);
    }

    @Override
    public boolean deleteContract(int id) {
        return customerUsingServiceRepository.deleteContract(id);
    }
}
