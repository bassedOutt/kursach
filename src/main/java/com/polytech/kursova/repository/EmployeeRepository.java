package com.polytech.kursova.repository;

import com.polytech.kursova.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
