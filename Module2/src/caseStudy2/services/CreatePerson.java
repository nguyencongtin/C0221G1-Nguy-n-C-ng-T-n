package caseStudy2.services;

import caseStudy2.models.Customer;
import caseStudy2.validations.ValidatePerson;

public class CreatePerson {
    public static Customer createCustomer() {
        String name = ValidatePerson.validateName();
        String birthday = ValidatePerson.validateBirthday();
        String gender = ValidatePerson.validateGender();
        String idCard = ValidatePerson.validateIdCArd();
        String phone = ValidatePerson.validatePhone();
        String email = ValidatePerson.validateEmail();
        String typeGuest = ValidatePerson.validateTypeGuest();
        String address = ValidatePerson.validateAddress();
        return new Customer(name, birthday, gender, idCard, phone, email, typeGuest, address);
    }

}