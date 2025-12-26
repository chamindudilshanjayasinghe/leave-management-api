package com.clouddesk.leave.dto.response;

import lombok.Data;

@Data
public class AuthResponse {
    private String accessToken;
    private String firstName;
    private String lastName;
    private final String tokenType = "Bearer";
    private Long userId;
    private Long tenantId;
    private String tenantName;
    private String role;
}
