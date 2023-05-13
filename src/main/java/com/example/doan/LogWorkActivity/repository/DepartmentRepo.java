package com.example.doan.LogWorkActivity.repository;

import com.example.doan.LogWorkActivity.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {
}
