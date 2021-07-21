package caseStudy2.controllers;

import caseStudy2.commons.FileUtils;
import caseStudy2.models.Employee;
import caseStudy2.models.Person;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class EmployeeController {
    static String filePerson = "person.csv";

    public static Map<Integer, Person> getAllEmployee() {
        Map<Integer, Person> mapEmployee = new TreeMap<>();
        int i = 1;
        for (Person person : FileUtils.readFilePerson(filePerson)) {
            if (person instanceof Employee) {
                mapEmployee.put(i++, person);
            }
        }
        return mapEmployee;
    }

    public static void showInformationOfEmployee() {
        Map<Integer, Person> mapEmployee = getAllEmployee();
        Set<Integer> setKey = mapEmployee.keySet();
        for (int i : setKey) {
            System.out.println(i + ". " + mapEmployee.get(i).showInfo());
        }
    }
}