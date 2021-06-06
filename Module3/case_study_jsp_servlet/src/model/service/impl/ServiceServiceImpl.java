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
        return false;
    }

    @Override
    public boolean updateService(int id, Service service) {
        return false;
    }

    @Override
    public Service getServiceById(int id) {
        return null;
    }

    @Override
    public List<Service> findByName(String name) {
        return null;
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
