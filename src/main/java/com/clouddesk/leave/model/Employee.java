package com.clouddesk.leave.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "employee")
@Data
public class Employee extends BaseTenantEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    @NotNull(message = "first name required")
    @NotEmpty(message = "first name required")
    private String firstName;

    @NotNull(message = "last name required")
    @NotEmpty(message = "last name required")
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "address")
    private String address;

    @NotNull(message = "title required")
    @NotEmpty(message = "title required")
    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "email")
    @Email(message = "invalid email address")
    private String email;

    @Column(name = "dob")
    @NotNull(message = "date of birthday is required")
    private LocalDate dob;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "join_at")
    @NotNull(message = "join date is required")
    private LocalDate joinAt;
}
