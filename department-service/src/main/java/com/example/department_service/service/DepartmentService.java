package com.example.department_service.service;

import com.example.department_service.model.DepartmentPojo;
import java.util.*;
public interface DepartmentService {
    List<DepartmentPojo> getAllDepartments();
    DepartmentPojo getDepartment(long deptId);
    DepartmentPojo addDepartment(DepartmentPojo newDepPojo);
    DepartmentPojo updateDepartment(DepartmentPojo editDepPojo);
    void deleteDepartment(long deptId);
}
