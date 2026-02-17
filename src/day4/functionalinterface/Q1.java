package day4.functionalinterface;

/*
Create list of employees and print list of employees whose salary is above 2000.
 */

import data.Employee;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Q1 {

    public static Consumer<Employee> employeeConsumer = (employee) -> System.out.println(employee);

    static Predicate<Employee> employeePredicate = (employee) -> employee.getSalary() > 2000;

    static BiPredicate<Employee, Integer> biPredicate = (employee, amount) -> employee.getSalary() > amount;

    public static void employeeWithSalaryGreaterThan() {
        List<Employee> employees = Employee.getSampleEmployees();

        employees.forEach(employee -> {
            if(employeePredicate.test(employee)) {
                employeeConsumer.accept(employee);
            }
        });
    }

    public static void employeeWithSalaryGreaterThanUsingBiPredicate(int amount) {
        List<Employee> employees = Employee.getSampleEmployees();

        employees.forEach(employee -> {
            if(biPredicate.test(employee, amount)) {
                employeeConsumer.accept(employee);
            }
        });
    }


    public static void main(String[] args) {
        employeeWithSalaryGreaterThan();
        employeeWithSalaryGreaterThanUsingBiPredicate(2000);
    }
}
