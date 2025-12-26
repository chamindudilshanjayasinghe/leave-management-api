package com.clouddesk.leave.dto.request;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateLeaveTypeRequest {
    @Size(min = 2, max = 100)
    private String name;

    @Size(min = 2, max = 20)
    private String code;

    private Boolean paid;

    private Boolean active;

}
