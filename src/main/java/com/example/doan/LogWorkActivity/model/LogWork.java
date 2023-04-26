package com.example.doan.LogWorkActivity.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "LogWork")
@Setter
@Getter
public class LogWork {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name ="employeeID")
    private long employeeID;
    @Column(name ="logWorkTime")
    private Long logWorkTime;

    public LogWork() {

    }
    public LogWork(long id, long employeeID, Long logWorkTime) {
        this.id = id;
        this.employeeID = employeeID;
        this.logWorkTime = logWorkTime;
    }
}
