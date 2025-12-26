package com.clouddesk.leave.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateLeaveTypeRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String code;

    private boolean paid;
}