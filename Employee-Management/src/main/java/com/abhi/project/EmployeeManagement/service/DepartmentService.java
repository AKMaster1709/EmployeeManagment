package com.abhi.project.EmployeeManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.project.EmployeeManagement.entity.Department;
import com.abhi.project.EmployeeManagement.repository.DepartmentRepository;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(String departmentId) {
        Optional<Department> optionalDepartment = departmentRepository.findById(departmentId);
        if (optionalDepartment.isPresent()) {
            return optionalDepartment.get();
        } else {
            throw new DepartmentNotFoundException("Department not found"); // Create a custom exception
        }
    }

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(String departmentId, Department department) {
        Optional<Department> existingDepartment = departmentRepository.findById(departmentId);
        if (existingDepartment.isPresent()) {
            department.setDepartmentId(departmentId);
            return departmentRepository.save(department);
        } else {
            throw new DepartmentNotFoundException("Department not found"); // Create a custom exception
        }
    }

    public boolean deleteDepartment(String departmentId) {
        try {
            departmentRepository.deleteById(departmentId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
