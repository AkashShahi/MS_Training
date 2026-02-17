package day5;

import java.time.LocalDate;
import java.util.List;

public class Employee1 {

    private int id;
    private String firstName;
    private String lastName;
    private int salary;
    private String dept;
    private LocalDate dob;

    public Employee1() {

    }

    public Employee1(int id, String firstName, String lastName, int salary, String dept, LocalDate dob) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.dept = dept;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", dept='" + dept + '\'' +
                ", dob=" + dob +
                '}';
    }

    public static List<Employee1> getSampleEmployees() {
        return List.of(
                new Employee1(1, "Alice", "Johnson", 7500, "IT", LocalDate.of(1995, 3, 15)),
                new Employee1(2, "Bob", "Smith", 8000, "Sales", LocalDate.of(1989, 7, 22)),
                new Employee1(3, "Charlie", "Brown", 7000, "IT", LocalDate.of(1999, 11, 5)),
                new Employee1(4, "Diana", "Wilson", 900, "HR", LocalDate.of(1982, 1, 30)),
                new Employee1(5, "Ethan", "Davis", 8200, "Sales", LocalDate.of(1993, 6, 18)),
                new Employee1(6, "Fiona", "Miller", 7200, "IT", LocalDate.of(1996, 9, 9)),
                new Employee1(7, "George", "Taylor", 11000, "Finance", LocalDate.of(1979, 4, 12)),
                new Employee1(8, "Hannah", "Anderson", 880, "HR", LocalDate.of(1994, 12, 3)),
                new Employee1(9, "Ian", "Thomas", 6500, "IT", LocalDate.of(2002, 8, 25)),
                new Employee1(10, "Julia", "Moore", 10500, "Finance", LocalDate.of(1986, 5, 14)),
                new Employee1(11, "Ken", "Martin", 8500, "Sales", LocalDate.of(1991, 10, 7)),
                new Employee1(12, "Laura", "Jackson", 710, "IT", LocalDate.of(1998, 2, 20))
        );
    }
}
