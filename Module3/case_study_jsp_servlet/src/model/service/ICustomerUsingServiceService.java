package model.service;

import model.bean.AttachService;
import model.bean.Customer;

import java.util.List;

public interface ICustomerUsingServiceService {
    List<Customer> findByAllCustomerUsingService();
    List<AttachService> findByAllAttachService(int id);
    boolean deleteContract(int id);

}
