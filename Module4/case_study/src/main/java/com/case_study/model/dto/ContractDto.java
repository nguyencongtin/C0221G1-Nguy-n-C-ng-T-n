package com.case_study.model.dto;

import com.case_study.model.common.Regex;
import com.case_study.model.entity.customer.Customer;
import com.case_study.model.entity.employee.Employee;
import com.case_study.model.entity.service.Service;
import lombok.Data;
import lombok.SneakyThrows;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ContractDto implements Validator {
    private Long id;

    private String startDate;
    private String endDate;
    @Min(value=0)
    private Double deposit;
    private Double totalMoney;

    private Customer customer;

    private Employee employee;

    private Service service;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
    @Override
    public void validate(Object target, Errors errors) {
        ContractDto contractDto= (ContractDto) target;
        try {
            Date sDate = new SimpleDateFormat("yyyy-MM-dd").parse(contractDto.startDate);
            Date eDate= new SimpleDateFormat("yyyy-MM-dd").parse(contractDto.endDate);
            if (eDate.getTime()<sDate.getTime()){
                errors.rejectValue("endDate", "endDate.valid", "End date must be more start date");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
