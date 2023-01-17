package com.api.desafio;

public class NewEmployeeRequest {

    String name;
    String office;
    Double salary;

    public NewEmployeeRequest(String name, String office, Double salary) {
        this.name = name;
        this.office = office;
        this.salary = salary;
    }

    public NewEmployeeRequest() {}

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

}
