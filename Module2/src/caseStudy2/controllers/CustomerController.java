package caseStudy2.controllers;

import caseStudy2.commons.FileUtils;
import caseStudy2.models.Customer;
import caseStudy2.models.Employee;
import caseStudy2.models.Person;
import caseStudy2.services.CreatePerson;

import java.util.*;

public class CustomerController {
    static String filePerson = "person.csv";

    public static void addNewCustomer() {
        FileUtils.writeFileObject(filePerson, CreatePerson.createCustomer(), true);
    }

    public static List<Person> showInformationOfCustomer() {
        List<Person> personList = new ArrayList<>();
        int i = 1;
        for (Person person : FileUtils.readFilePerson(filePerson)) {
            if (person instanceof Customer) {
                personList.add(person);
                System.out.println(i++ + ". " + person.showInfo());
            }
        }
        return personList;
    }

}