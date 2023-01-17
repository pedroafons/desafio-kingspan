package com.api.desafio.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Employee {

    @Id
    @SequenceGenerator(
            name = "employee_id_sequence",
            sequenceName = "employee_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_id_sequence"
    )
    private Integer id;
    private String name;
    private String office;
    private double salary;

    public Employee(Integer id, String name, String office, double salary) {
        this.id = id;
        this.name = name;
        this.office = office;
        this.salary = salary;
    }

    public Employee(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return Double.compare(employee.getSalary(), getSalary()) == 0 && Objects.equals(getId(), employee.getId()) && Objects.equals(getName(), employee.getName()) && Objects.equals(getOffice(), employee.getOffice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getOffice(), getSalary());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", office='" + office + '\'' +
                ", salary=" + salary +
                '}';
    }
}
