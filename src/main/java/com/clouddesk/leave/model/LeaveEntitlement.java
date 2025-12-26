package com.clouddesk.leave.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "leave_entitlement")
@Data
public class LeaveEntitlement extends BaseTenantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "leave_type_id")
    private LeaveType leaveType;

    @Column(name = "year")
    private Integer year;

    @Column(name = "total_days")
    private Integer totalDays;

    @Column(name = "used_days")
    private Integer usedDays;

    @Column(name = "carry_forward_days")
    private Integer carryForwardDays;

}
