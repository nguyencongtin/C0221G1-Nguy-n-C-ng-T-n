package model.service;

import model.bean.Contract;

import java.util.List;

public interface IContractService {
    boolean addNewContract(Contract contract);
    List<Contract> findByAll();
    boolean deleteContract(int id);
    boolean updateContract(int id,Contract contract);
    Contract getContractById(int id);
    List<Contract> findByName(String name);
}
