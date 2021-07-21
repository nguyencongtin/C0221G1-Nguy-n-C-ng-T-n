package model.service.impl;

import model.bean.Service;
import model.bean.TypeRent;
import model.bean.TypeService;
import model.repository.ServiceRepository;
import model.service.IServiceService;

import java.util.List;

public class ServiceServiceImpl implements IServiceService {
    ServiceRepository serviceRepository= new ServiceRepository();
    @Override
    public boolean addNewService(Service service) {
        return serviceRepository.addNewService(service);
    }

    @Override
    public List<Service> findByAll() {
        return serviceRepository.findByAll();
    }

    @Override
    public boolean deleteService(int id) {
        return serviceRepository.deleteService(id);
    }

    @Override
    public boolean updateService(int id, Service service) {
        return serviceRepository.updateService(id,service);
    }

    @Override
    public Service getServiceById(int id) {
        return serviceRepository.getServiceById(id);
    }

    @Override
    public List<Service> findByName(String name) {
        return serviceRepository.findByName(name);
    }

    @Override
    public List<TypeRent> findByAllTypeRent() {
        return serviceRepository.findByAllTypeRent();
    }

    @Override
    public List<TypeService> findByAllTypeService() {
        return serviceRepository.findByAllTypeService();
    }
}
