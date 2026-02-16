package day3.lambda;

import customfunctionalinterface.UserNameGenerator;
import data.Employee;
import data.User;
import day3.functionalinterface.Q2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CreateUserUsingCustomFunctionalInterface {

    static UserNameGenerator<String, String, LocalDate, Integer, String> userNameGenerator =
            (firstName, lastName , dob, id) -> {

                StringBuilder userNameBuilder = new StringBuilder();
                userNameBuilder.append(firstName);
                userNameBuilder.append(lastName);
                userNameBuilder.append(dob);
                userNameBuilder.append(id);

        return userNameBuilder.toString();
    };

    static Function<Employee, User> userFunction = (employee) -> {
        return new User(
                employee.getId(),
                userNameGenerator.generate(employee.getFirstName(), employee.getLastName(), employee.getDob(), employee.getId()),
                Q2.passwordSupplier.get());
    };


    public static void main(String[] args) {

        List<Employee> employees = Employee.getSampleEmployees();

        List<User> users = new ArrayList<>();

        employees.forEach(employee -> {
            users.add(userFunction.apply(employee));
        });

        users.forEach(Q2.userConsumer);
    }
}
