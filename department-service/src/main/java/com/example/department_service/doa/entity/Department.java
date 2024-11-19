package com.example.department_service.doa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "department_details")
public class Department {
    @Id
    @Column(name="dept_id")
    private long deptId;

    @Column(name="dept_name")
    private String name;
}
