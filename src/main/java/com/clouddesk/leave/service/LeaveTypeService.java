package com.clouddesk.leave.service;

import com.clouddesk.leave.dto.request.CreateLeaveTypeRequest;
import com.clouddesk.leave.dto.request.UpdateLeaveTypeRequest;
import com.clouddesk.leave.model.LeaveType;

import java.util.List;

public interface LeaveTypeService {
    LeaveType createLeaveType(CreateLeaveTypeRequest request);
    LeaveType updateLeaveType(Long id, UpdateLeaveTypeRequest request);
    LeaveType getLeaveTypeById(Long id);
    List<LeaveType> listLeaveTypes();
    void deactivateLeaveType(Long id);
}
