package com.case_study.model.dto;

import com.case_study.model.common.Regex;
import com.case_study.model.entity.contract.Contract;
import com.case_study.model.entity.service.RentType;
import com.case_study.model.entity.service.ServiceType;
import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class ServiceDto implements Validator {
    private Long id;
    @NotBlank(message = "Please Input")
    private String code;
    @NotBlank(message = "Please Input")
    private String name;
    @NotNull(message = "Please Input")
    @Min(value = 0, message = "Please input positive integer")
    private Integer area;
    @NotNull(message = "Please Input")
    @Min(value = 0, message = "Please input positive integer")
    private Double cost;
    @NotNull(message = "Please Input")
    @Min(value = 0, message = "Please input positive integer")
    private Integer maxPeople;

    private String standardRoom;
    private String description;
    private Double poolArea;
    private Integer floors;
    private boolean flag;
    private RentType rentType;
    private ServiceType serviceType;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ServiceDto serviceDto = (ServiceDto) target;
        if (!serviceDto.code.matches("^DV-\\d{4}$")) {
            errors.rejectValue("code", "code.valid", "Please input invalid DV-XXXX");
        }
    }
}
