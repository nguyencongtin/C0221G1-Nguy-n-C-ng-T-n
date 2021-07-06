package com.case_study.model.service;

import com.case_study.model.entity.service.RentType;
import com.case_study.model.entity.service.Service;
import com.case_study.model.entity.service.ServiceType;

import java.util.List;

public interface IServiceService extends IGeneralService<Service>{
    List<RentType> findAllRentType();
    List<ServiceType> findAllServiceType();
    List<Service> findAll();
}
