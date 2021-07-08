package com.case_study.model.dto;

import com.case_study.model.entity.contract.AttachService;
import com.case_study.model.entity.contract.Contract;
import lombok.Data;

import javax.validation.constraints.NotNull;
public class ContractDetailDto {
    private Long id;
    private Contract contract;
    private AttachService attachService;
    @NotNull
    private Integer quantity;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
