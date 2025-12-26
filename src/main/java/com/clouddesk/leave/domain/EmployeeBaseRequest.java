package com.clouddesk.leave.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public abstract class EmployeeBaseRequest {
    private String firstName;
    private String lastName;
    private String jobTitle;
    private String email;
    private String address;
    private String contactNumber;
    private LocalDate dob;
    private LocalDate joinAt;
}
