package com.case_study.model.dto;

import com.case_study.model.common.Regex;
import com.case_study.model.entity.employee.Division;
import com.case_study.model.entity.employee.EducationDegree;
import com.case_study.model.entity.employee.Position;
import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotNull;

@Data
public class EmployeeDto implements Validator {
    private Long id;
    private String name;
    private String birthday;
    private String idCard;
    @NotNull
    private Double salary;
    private String phone;
    private String email;
    private String address;
    private Position position;
    private EducationDegree educationDegree;
    private Division division;
    private boolean flag;



    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Regex regex=new Regex();
        EmployeeDto employeeDto = (EmployeeDto) target;
        if (employeeDto.name.matches("")) {
            errors.rejectValue("name", "name.valid", "Please input name");
        }else if (!employeeDto.name.matches(regex.VIETNAMESENAME)){
            errors.rejectValue("name", "name.valid", "Please input in valid");
        }
        if (employeeDto.birthday.matches("")) {
            errors.rejectValue("birthday", "birthday.valid", "Please input birthday");
        }else if (!employeeDto.birthday.matches(regex.DATE)){
            errors.rejectValue("birthday", "birthday.valid", "Please input in valid");
        }

        if (employeeDto.idCard.matches("")) {
            errors.rejectValue("idCard", "idCard.valid", "Please input idCard");
        }else if (!employeeDto.idCard.matches("^\\d{9}$")){
            errors.rejectValue("idCard", "idCard.valid", "Please input in valid");

        }
        if (employeeDto.phone.matches("")) {
            errors.rejectValue("phone", "phone.valid", "Please input phone");
        }else if (!employeeDto.phone.matches(regex.PHONENUMBER)){
            errors.rejectValue("phone", "phone.valid", "Please input in valid");

        }

        if (employeeDto.salary <= 0) {
            errors.rejectValue("salary", "salary.valid", "Please input positive integer");
        }


        if (employeeDto.email.matches("")) {
            errors.rejectValue("email", "email.valid", "Please input email");
        }
        if (employeeDto.address.matches("")) {
            errors.rejectValue("address", "address.valid", "Please input address");
        }
    }
}
