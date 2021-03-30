package br.com.indtexbr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.indtexbr.entity.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee, Long> {
  
}
