package com.example.doan.LogWorkActivity.repository;

import com.example.doan.LogWorkActivity.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
