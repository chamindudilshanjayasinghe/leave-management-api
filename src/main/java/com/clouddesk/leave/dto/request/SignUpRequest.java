package com.clouddesk.leave.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class SignUpRequest {
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    @Length(min = 6, max = 8)
    private String password;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String businessName;
}
