package model.service.impl;

import model.bean.Contract;
import model.repository.ContractRepository;
import model.service.IContractService;

import java.util.List;

public class ContractServiceImpl implements IContractService {
    ContractRepository contractRepository= new ContractRepository();
    @Override
    public boolean addNewContract(Contract contract) {
        return contractRepository.addNewContract(contract);
    }

    @Override
    public List<Contract> findByAll() {
        return contractRepository.findByAll();
    }

    @Override
    public boolean deleteContract(int id) {
        return false;
    }

    @Override
    public boolean updateContract(int id, Contract contract) {
        return false;
    }

    @Override
    public Contract getContractById(int id) {
        return null;
    }

    @Override
    public List<Contract> findByName(String name) {
        return null;
    }
}
