package com.example.doan.LogWorkActivity.repository;

import com.example.doan.LogWorkActivity.model.LogWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogWorkRepo extends JpaRepository<LogWork, Long> {
}
