package com.example.department_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePojo {
    private long empId;
    private String name;
    private int age;
    private int deptId;
}