package day5;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamAssignment {

    public List<String> printEmployeeJoin2023() {

        List<Employee> employees = Employee.getSampleEmployees();

        return employees.stream()
                .filter(employee -> employee.getDoj().getYear() == 2023)
                .map(e -> e.getFirstName())
                .collect(Collectors.toList());
    }

    public DoubleSummaryStatistics print() {

        List<Employee> employees = Employee.getSampleEmployees();

        return employees.stream()
                .filter(employee -> employee.getDept().equals("IT"))
                .collect(Collectors.summarizingDouble(e -> e.getSalary()));
    }

    public List<Employee> printSortedByFirstName() {

        List<Employee> employees = Employee.getSampleEmployees();

        return employees.stream()
                .filter(employee -> !employee.getDept().equals("HR"))
                .sorted(Comparator.comparing(employee -> employee.getFirstName()))
                .collect(Collectors.toList());

    }

    public void incrementSalaryByDepartment() {

        List<Employee> employees = Employee.getSampleEmployees();

        employees.stream()
                .filter(employee -> employee.getDept().equals("Sales"))
                .forEach(e -> e.setSalary((int) (e.getSalary() * 1.10)));


        employees.forEach(employee -> {
            System.out.println(employee);
        });
    }

    public void printOdd() {

        IntStream.rangeClosed(100, Integer.MAX_VALUE)
                .filter(i -> i % 2 != 0)
                .limit(50)
                .forEach(System.out::println);
    }

    public List<String> firstNameByDob() {

        List<Employee1> employee1s = Employee1.getSampleEmployees();

        return employee1s.stream()
                .sorted(Comparator.comparing(e -> e.getDob()))
                .map(employee1 -> employee1.getFirstName())
                .collect(Collectors.toList());


    }



}
