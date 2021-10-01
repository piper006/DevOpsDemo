package com.guardless.springdocker.employee;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "employee")
public class Employee {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @Id
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private int salary;

    public void setId(UUID id) {
        this.id = id;
    }

    public Employee() {
    }
    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public UUID getId() {
        return id;
    }



}
