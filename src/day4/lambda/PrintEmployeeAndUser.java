package day4.lambda;

import data.Employee;
import data.User;
import day4.functionalinterface.Q1;
import day4.functionalinterface.Q2;

import java.util.List;

public class PrintEmployeeAndUser {

    public static void main(String[] args) {

        List<Employee> employees = Employee.getSampleEmployees();
        List<User> users = Q2.createUserList();

        Runnable printEmployees = () -> {
            employees.forEach(Q1.employeeConsumer);
        };

        Runnable printUsers = () -> {

            users.forEach(Q2.userConsumer);
        };

        new Thread(printEmployees).start();

        new Thread(printUsers).start();
    }
}
