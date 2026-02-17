package day5;

import java.time.LocalDate;
import java.util.List;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int salary;
    private String dept;
    private LocalDate doj;

    public Employee() {

    }

    public Employee(int id, String firstName, String lastName, int salary, String dept, LocalDate doj) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.dept = dept;
        this.doj = doj;
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

    public LocalDate getDoj() {
        return doj;
    }

    public void setDoj(LocalDate doj) {
        this.doj = doj;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", dept='" + dept + '\'' +
                ", doj=" + doj +
                '}';
    }

    public static List<Employee> getSampleEmployees() {
        return List.of(
                new Employee(1, "Alice", "Johnson", 7500, "IT", LocalDate.of(2020, 3, 15)),
                new Employee(2, "Bob", "Smith", 8000, "Sales", LocalDate.of(2018, 7, 22)),
                new Employee(3, "Charlie", "Brown", 7000, "IT", LocalDate.of(2021, 11, 5)),
                new Employee(4, "Diana", "Wilson", 9000, "HR", LocalDate.of(2015, 1, 30)),
                new Employee(5, "Ethan", "Davis", 8200, "Sales", LocalDate.of(2019, 6, 18)),
                new Employee(6, "Fiona", "Miller", 7200, "IT", LocalDate.of(2022, 9, 9)),
                new Employee(7, "George", "Taylor", 11000, "Finance", LocalDate.of(2012, 4, 12)),
                new Employee(8, "Hannah", "Anderson", 8800, "HR", LocalDate.of(2017, 12, 3)),
                new Employee(9, "Ian", "Thomas", 6500, "IT", LocalDate.of(2023, 8, 25)),
                new Employee(10, "Julia", "Moore", 10500, "Finance", LocalDate.of(2016, 5, 14)),
                new Employee(11, "Ken", "Martin", 8500, "Sales", LocalDate.of(2019, 10, 7)),
                new Employee(12, "Laura", "Jackson", 7100, "IT", LocalDate.of(2021, 2, 20)),
                new Employee(13, "Michael", "Clark", 6800, "IT", LocalDate.of(2023, 1, 10)),
                new Employee(14, "Nina", "Lopez", 7600, "Sales", LocalDate.of(2023, 2, 18)),
                new Employee(15, "Oliver", "Hall", 9200, "Finance", LocalDate.of(2023, 3, 22)),
                new Employee(16, "Paula", "Young", 6400, "HR", LocalDate.of(2023, 4, 5)),
                new Employee(17, "Quentin", "King", 7300, "IT", LocalDate.of(2023, 5, 30)),
                new Employee(18, "Rachel", "Wright", 8100, "Sales", LocalDate.of(2023, 6, 14)),
                new Employee(19, "Sam", "Green", 6700, "IT", LocalDate.of(2023, 7, 19)),
                new Employee(20, "Tina", "Baker", 9500, "Finance", LocalDate.of(2023, 9, 1))
        );
    }

}
