package com.example.doan.LogWorkActivity.service;

import com.example.doan.LogWorkActivity.model.Department;
import com.example.doan.LogWorkActivity.model.Employee;
import com.example.doan.LogWorkActivity.model.LogWork;
import com.example.doan.LogWorkActivity.repository.DepartmentRepo;
import com.example.doan.LogWorkActivity.repository.EmployeeRepo;
import com.example.doan.LogWorkActivity.repository.LogWorkRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LogWorkService {
    @Autowired
    private final EmployeeRepo employeeRepo;
    @Autowired
    private final DepartmentRepo departmentRepo;
    @Autowired
    private final LogWorkRepo logWorkRepo;

    public void saveEmployee(Employee employee) {
        employeeRepo.save(employee);
    }

    public void saveDepartment(Department department) {
        departmentRepo.save(department);
    }

    public void saveLogWork(LogWork logWork) {
        logWorkRepo.save(logWork);
    }
    public Page<Employee> getAllEmployee(){
        return (Page<Employee>) employeeRepo.findAll();
    }
    public List<Department> getAllDepartment(){
        return departmentRepo.findAll();
    }
    public List<LogWork> getAllLogWork(){
        return logWorkRepo.findAll();
    }

}
