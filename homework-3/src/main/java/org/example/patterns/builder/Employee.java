package org.example.patterns.builder;

import java.util.Objects;

public class Employee {
    private final String name;
    private final String company;
    private final boolean hasCar;
    private final boolean hasBike;
    private final String position;

    private Employee(EmployeeBuilder builder) {
        this.name = builder.name;
        this.company = builder.company;
        this.hasCar = builder.hasCar;
        this.hasBike = builder.hasBike;
        this.position = builder.position;
    }

    public String getName() { return name; }
    public String getCompany() { return company; }
    public boolean hasCar() { return hasCar; }
    public boolean hasBike() { return hasBike; }
    public String getPosition() { return position; }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", hasCar=" + hasCar +
                ", hasBike=" + hasBike +
                ", position='" + position + '\'' +
                '}';
    }

    public static class EmployeeBuilder {
        private final String name;
        private final String company;

        private boolean hasCar = false;
        private boolean hasBike = false;
        private String position = "Сотрудник";

        public EmployeeBuilder(String name, String company) {
            this.name = name;
            this.company = company;
        }

        public EmployeeBuilder hasCar(boolean hasCar) {
            this.hasCar = hasCar;
            return this;
        }

        public EmployeeBuilder hasBike(boolean hasBike) {
            this.hasBike = hasBike;
            return this;
        }

        public EmployeeBuilder position(String position) {
            this.position = position;
            return this;
        }

        public Employee build() {
            Objects.requireNonNull(name, "Имя сотрудника не может быть null");
            Objects.requireNonNull(company, "Название компании не может быть null");

            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException("Имя сотрудника не может быть пустым");
            }
            if (hasCar && hasBike) {
                throw new IllegalArgumentException("Сотрудник не может иметь и машину, и велосипед одновременно");
            }

            return new Employee(this);
        }
    }
}