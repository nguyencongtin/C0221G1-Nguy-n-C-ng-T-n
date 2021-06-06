package model.service.impl;

import model.bean.ContractDetail;
import model.repository.ContractDetailRepository;
import model.service.IContractDetailService;

import java.util.List;

public class ContractDetailServiceImpl implements IContractDetailService {
    ContractDetailRepository contractDetailRepository= new ContractDetailRepository();
    @Override
    public boolean addNewContractDetail(ContractDetail contractDetail) {
        return contractDetailRepository.addNewContractDetail(contractDetail);
    }

    @Override
    public List<ContractDetail> findByAll() {
        return null;
    }

    @Override
    public boolean deleteContractDetail(int id) {
        return false;
    }

    @Override
    public boolean updateContractDetail(int id, ContractDetail contractDetail) {
        return false;
    }

    @Override
    public ContractDetail getContractDetailById(int id) {
        return null;
    }

    @Override
    public List<ContractDetail> findByName(String name) {
        return null;
    }
}
