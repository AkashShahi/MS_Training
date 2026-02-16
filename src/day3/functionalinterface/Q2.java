package day3.functionalinterface;

import data.Employee;
import data.User;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;



/*
Create List of Users from List of Employees.
 */
public class Q2 {

    public static Supplier<String> passwordSupplier = () -> {
        SecureRandom random = new SecureRandom();
        StringBuilder builder = new StringBuilder(16);

        for(int i = 0; i < 16; i++) {
            builder.append(random.nextInt(10));
        }

        return builder.toString();
    };

    static Function<Employee, User> employeeUserFunction = (employee) -> {
        StringBuilder userNameBuilder = new StringBuilder();

        userNameBuilder.append(employee.getFirstName());
        userNameBuilder.append(employee.getLastName());
        userNameBuilder.append(employee.getDob());
        userNameBuilder.append(employee.getId());

        String username = userNameBuilder.toString();

        return new User(employee.getId(),username, passwordSupplier.get());
    };

    public static Consumer<User> userConsumer = (user) -> System.out.println(user);

    public static List<User> createUserList() {
        List<Employee> employees = Employee.getSampleEmployees();
        List<User> users = new ArrayList<>();

        employees.forEach(employee -> {
            users.add(employeeUserFunction.apply(employee));
        });

        return users;
    }

    public static void main(String[] args) {
        List<User> users = createUserList();
        users.forEach(userConsumer);
    }
}
