package com.example.doan.LogWorkActivity.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Department")
@Setter
@Getter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "departmentName")
    private String departmentName;

    public Department() {

    }
    public Department(long id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }
}
