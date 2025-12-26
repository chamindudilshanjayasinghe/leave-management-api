package com.clouddesk.leave.service;

import com.clouddesk.leave.dto.request.CreateEmployeeRequest;
import com.clouddesk.leave.dto.request.UpdateEmployeeRequest;
import com.clouddesk.leave.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getEmployeeById(Long id);
    List<Employee> getAllEmployeeByTenantId(Long tenantId);
    Employee createEmployee(CreateEmployeeRequest request);
    Employee updateEmployee(Long id,UpdateEmployeeRequest request);
}
