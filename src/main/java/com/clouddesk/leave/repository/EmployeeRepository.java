package com.clouddesk.leave.repository;

import com.clouddesk.leave.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findEmployeeByTenant_Id(Long  tenantId);
}
