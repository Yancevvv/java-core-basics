package org.example.patterns.builder;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Паттерн Билдер ===\n");

        Employee employee = new Employee.EmployeeBuilder("Иван Петров", "ООО Ромашка")
                .hasCar(true)
                .hasBike(false)
                .position("Senior Developer")
                .build();

        Employee employee2 = new Employee.EmployeeBuilder("Мария Иванова", "ООО Василек")
                .hasBike(true)
                .build();

        System.out.println(employee);
        System.out.println(employee2);
    }
}