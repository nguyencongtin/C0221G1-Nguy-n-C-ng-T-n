package com.case_study.model.service.impl;

import com.case_study.model.entity.contract.AttachService;
import com.case_study.model.entity.contract.Contract;
import com.case_study.model.entity.contract.ContractDetail;
import com.case_study.model.repository.contract.IAttachServiceRepository;
import com.case_study.model.repository.contract.IContractDetailRepository;
import com.case_study.model.repository.contract.IContractRepository;
import com.case_study.model.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    IContractRepository contractRepository;
    @Autowired
    IAttachServiceRepository attachServiceRepository;
    @Autowired
    IContractDetailRepository contractDetailRepository;

    @Override
    public List<AttachService> attachServices() {
        return (List<AttachService>) attachServiceRepository.findAll();
    }

    @Override
    public List<ContractDetail> contractDetails() {
        return (List<ContractDetail>) contractDetailRepository.findAll();
    }

    @Override
    public List<Contract> findAll() {
        return (List<Contract>) contractRepository.findAll();
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public Page<Contract> usingService() {
        return null;
    }

    @Override
    public Page<Contract> findAll(String name, Pageable pageable) {
        return this.contractRepository.usingService(name,pageable);
    }

    @Override
    public Contract findById(Long id) {
        return this.contractRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void remove(Long id) {

    }
}
