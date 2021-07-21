package model.service;

import model.bean.Service;
import model.bean.TypeRent;
import model.bean.TypeService;

import java.util.List;

public interface IServiceService {
    boolean addNewService(Service service);
    List<Service> findByAll();
    boolean deleteService(int id);
    boolean updateService(int id,Service service);
    Service getServiceById(int id);
    List<Service> findByName(String name);
    List<TypeRent> findByAllTypeRent();
    List<TypeService> findByAllTypeService();
}
