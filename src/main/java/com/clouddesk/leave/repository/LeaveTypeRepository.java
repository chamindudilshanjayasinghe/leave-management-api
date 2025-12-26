package com.clouddesk.leave.repository;

import com.clouddesk.leave.model.LeaveType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveTypeRepository extends JpaRepository<LeaveType, Integer> {
    List<LeaveType> findLeaveTypeByEnable(Boolean enable);
}
