package com.clouddesk.leave.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "leave_type")
@Data
public class LeaveType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "enable")
    private boolean enable;
}
