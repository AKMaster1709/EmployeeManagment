package com.abhi.project.EmployeeManagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.abhi.project.EmployeeManagement.entity.Department;

@Repository
public interface DepartmentRepository extends MongoRepository<Department,String>{

}
