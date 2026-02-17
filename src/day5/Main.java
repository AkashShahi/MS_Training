package day5;

import java.util.DoubleSummaryStatistics;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        StreamAssignment assignment = new StreamAssignment();

        List<String> employeeJoin2023 = assignment.printEmployeeJoin2023();

        employeeJoin2023.forEach(employee -> {
            System.out.println(employee);
        });

        List<Employee> employees = assignment.printSortedByFirstName();

        employees.forEach(employee -> {
            System.out.println(employee);
        });

        DoubleSummaryStatistics stats = assignment.print();

        System.out.println(stats);

        assignment.incrementSalaryByDepartment();
        assignment.printOdd();

        List<String> firstNameList = assignment.firstNameByDob();

        firstNameList.forEach(employee -> {
            System.out.println(employee);
        });
    }
}
