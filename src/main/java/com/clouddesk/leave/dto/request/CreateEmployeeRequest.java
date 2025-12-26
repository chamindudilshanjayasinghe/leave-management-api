package com.clouddesk.leave.dto.request;

import com.clouddesk.leave.domain.EmployeeBaseRequest;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
public class CreateEmployeeRequest extends EmployeeBaseRequest {
    @NotNull(message = "first name required")
    @NotEmpty(message = "first name required")
    private String firstName;

    @NotNull(message = "last name required")
    @NotEmpty(message = "last name required")
    private String lastName;

    @NotNull(message = "job title required")
    @NotEmpty(message = "job title required")
    private String jobTitle;

    @Email(message = "invalid email address")
    private String email;

    private String address;

    private String contactNumber;

    @NotNull(message = "date of birth is required")
    private LocalDate dob;

    @NotNull(message = "join date is required")
    private LocalDate joinAt;
}
