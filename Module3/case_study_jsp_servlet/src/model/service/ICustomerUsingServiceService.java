package model.service;

        import model.bean.AttachService;
        import model.bean.Contract;
        import model.bean.Customer;

        import java.util.List;

public interface ICustomerUsingServiceService {
    List<Customer> findByAllCustomerUsingService();
    List<AttachService> findByAllAttachService(int id);
    boolean deleteContract(int id);
    boolean updateContract(int id, Contract contract);
}
