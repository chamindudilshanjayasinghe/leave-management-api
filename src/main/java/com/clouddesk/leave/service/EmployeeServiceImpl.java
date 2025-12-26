package com.clouddesk.leave.service;

import com.clouddesk.leave.domain.EmployeeBaseRequest;
import com.clouddesk.leave.dto.request.CreateEmployeeRequest;
import com.clouddesk.leave.dto.request.UpdateEmployeeRequest;
import com.clouddesk.leave.model.Employee;
import com.clouddesk.leave.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return this.employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> getAllEmployeeByTenantId(Long tenantId) {
        return this.employeeRepository.findEmployeeByTenant_Id(tenantId);
    }

    @Override
    public Employee createEmployee(CreateEmployeeRequest request) {
        Employee employee = new Employee();
        applyEmployeeData(employee, request);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id,UpdateEmployeeRequest request) {
        Employee employee = employeeRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));
        applyEmployeeData(employee, request);
        return employeeRepository.save(employee);
    }

    private void applyEmployeeData(Employee employee, EmployeeBaseRequest request) {
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setJobTitle(request.getJobTitle());
        employee.setEmail(request.getEmail());
        employee.setAddress(request.getAddress());
        employee.setContactNumber(request.getContactNumber());
        employee.setDob(request.getDob());
        employee.setJoinAt(request.getJoinAt());
    }
}
