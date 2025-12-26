package com.clouddesk.leave.dto.response;

import lombok.Data;

@Data
public class SignUpResponse {
    long id;
    String firstName;
    String lastName;
    String email;
    long tenantId;
    String businessName;

    public SignUpResponse(long id, String firstName, String lastName, String email, long tenantId, String businessName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.tenantId = tenantId;
        this.businessName = businessName;
    }
}
