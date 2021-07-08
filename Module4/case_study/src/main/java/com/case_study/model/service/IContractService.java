package com.case_study.model.service;

import com.case_study.model.entity.contract.AttachService;
import com.case_study.model.entity.contract.Contract;
import com.case_study.model.entity.contract.ContractDetail;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IContractService extends IGeneralService<Contract> {
    List<AttachService> attachServices();
    List<ContractDetail> contractDetails();
    List<Contract> findAll();
    void save(ContractDetail contractDetail);
    Page<Contract> usingService();
}
