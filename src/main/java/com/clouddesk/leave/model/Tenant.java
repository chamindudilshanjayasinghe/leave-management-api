package com.clouddesk.leave.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tenant")
@Data
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "enable")
    private boolean enable;
}
