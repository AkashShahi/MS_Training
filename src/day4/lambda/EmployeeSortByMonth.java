package day4.lambda;

/*

Write a program to Sort the list of employees by month in dateOfBirth.
in Sort method use Lambda in comparator.

 */

import data.Employee;
import day4.functionalinterface.Q1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeeSortByMonth {

    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>(Employee.getSampleEmployees());

        Comparator<Employee> byMonth = (a, b) -> Integer.compare(a.getDob().getMonthValue(), b.getDob().getMonthValue());

        employeeList.sort(byMonth);

        employeeList.forEach(Q1.employeeConsumer);


    }
}
