package com.example.department_service.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentPojo {
    private long deptId;
    private String name;
    private List<EmployeePojo> allEmployees;
}
