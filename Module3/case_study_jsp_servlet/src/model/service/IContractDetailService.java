package model.service;

import model.bean.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    boolean addNewContractDetail(ContractDetail contractDetail);
    List<ContractDetail> findByAll();
    boolean deleteContractDetail(int id);
    boolean updateContractDetail(int id, ContractDetail contractDetail);
    ContractDetail getContractDetailById(int id);
    List<ContractDetail> findByName(String name);
}
