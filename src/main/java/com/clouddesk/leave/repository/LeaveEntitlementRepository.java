package com.clouddesk.leave.repository;

import com.clouddesk.leave.model.LeaveEntitlement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveEntitlementRepository extends CrudRepository<LeaveEntitlement, Long> {
    List<LeaveEntitlement> findByYearAndTenant_Id(int year,long tenantId);
}
