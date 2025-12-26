package com.clouddesk.leave.repository;


import com.clouddesk.leave.model.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {
    List<LeaveRequest> findByTenantId(Long tenantId);
    List<LeaveRequest> findByEmployee_Id(Long employeeId);
}
