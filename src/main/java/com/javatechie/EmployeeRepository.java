package com.javatechie;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Component
public class EmployeeRepository {

    public List<Employee> getEmployees() {
        return Stream.of(new Employee(101, "Bikas", "Devops", "Bikas@company.com"),
                        new Employee(102, "Ashok", "Developer", "Ashok@company.com"),
                        new Employee(103, "Prasad", "Devops", "Prasad@company.com"),
                        new Employee(104, "Santosh", "Developer", "Santosh@company.com"),
                        new Employee(105, "Basant", "Developer", "Basant@company.com"),
                        new Employee(106, "Bala", "Manager", "Bala@company.com"),
                        new Employee(107, "Anupama", "HR", "Anupama@company.com"))
                .collect(Collectors.toList());
    }

    public List<String> getEmailIds(String dept) {
        return getEmployees().stream()
                .filter(employee -> dept.equals(employee.getDept()))
                .map(Employee::getEmail)
                .collect(Collectors.toList());
    }
}
