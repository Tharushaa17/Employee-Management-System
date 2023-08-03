package com.example.employeems.repo;

import com.example.employeems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmplyeeRepo extends JpaRepository<Employee,Integer> {

}
