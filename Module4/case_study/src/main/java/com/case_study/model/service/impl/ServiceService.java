package com.case_study.model.service.impl;

import com.case_study.model.entity.service.RentType;
import com.case_study.model.entity.service.Service;
import com.case_study.model.entity.service.ServiceType;
import com.case_study.model.repository.service.IRentTypeRepository;
import com.case_study.model.repository.service.IServiceRepository;
import com.case_study.model.repository.service.IServiceTypeRepository;
import com.case_study.model.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
@org.springframework.stereotype.Service
public class ServiceService implements IServiceService {
    @Autowired
    IServiceRepository serviceRepository;
    @Autowired
    IServiceTypeRepository serviceTypeRepository;
    @Autowired
    IRentTypeRepository rentTypeRepository;
    @Override
    public Page findAll(String name, Pageable pageable) {
        return serviceRepository.findAllService(name,pageable);
    }

    @Override
    public Service findById(Long id) {
        return null;
    }

    @Override
    public void save(Service o) {
        serviceRepository.save(o);
    }


    @Override
    public void remove(Long id) {

    }

    @Override
    public List<RentType> findAllRentType() {
        return (List<RentType>) rentTypeRepository.findAll();
    }

    @Override
    public List<ServiceType> findAllServiceType() {
        return (List<ServiceType>) serviceTypeRepository.findAll();
    }

    @Override
    public List<Service> findAll() {
        return (List<Service>) serviceRepository.findAll();
    }
}
