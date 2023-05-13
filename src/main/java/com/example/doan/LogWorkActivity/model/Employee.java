package com.example.doan.LogWorkActivity.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name ="Employee")
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "departmentID")
    private long departmentID;

    public Employee(String name, String address, long departmentID) {
        this.name = name;
        this.address = address;
        this.departmentID = departmentID;
    }

    public Employee() {

    }
}
