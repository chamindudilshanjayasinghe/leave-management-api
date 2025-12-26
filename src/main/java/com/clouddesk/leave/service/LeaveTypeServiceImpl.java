package com.clouddesk.leave.service;

import com.clouddesk.leave.dto.request.CreateLeaveTypeRequest;
import com.clouddesk.leave.dto.request.UpdateLeaveTypeRequest;
import com.clouddesk.leave.model.LeaveType;

import java.util.List;

public class LeaveTypeServiceImpl implements LeaveTypeService {
    @Override
    public LeaveType createLeaveType(CreateLeaveTypeRequest request) {
        return null;
    }

    @Override
    public LeaveType updateLeaveType(Long id, UpdateLeaveTypeRequest request) {
        return null;
    }

    @Override
    public LeaveType getLeaveTypeById(Long id) {
        return null;
    }

    @Override
    public List<LeaveType> listLeaveTypes() {
        return List.of();
    }

    @Override
    public void deactivateLeaveType(Long id) {

    }
}
