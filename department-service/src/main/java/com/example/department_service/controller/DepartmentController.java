package com.example.department_service.controller;

import com.example.department_service.model.DepartmentPojo;
import com.example.department_service.model.EmployeePojo;
import com.example.department_service.service.DepartmentService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
@RequestMapping("/api/dept")
public class DepartmentController {
    DepartmentService deptService;

    public  static  final Logger LOG= LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    public DepartmentController(DepartmentService deptService){
        this.deptService=deptService;
    }

    @GetMapping
    public List<DepartmentPojo> getAllDepartments(){
        LOG.info("in getAllDepartment");
        return deptService.getAllDepartments();
    }

    @GetMapping("/{deptId}")
    @CircuitBreaker(name = "ciremp",fallbackMethod = "fallbackMethod")
    public  DepartmentPojo getDepartment(@PathVariable("deptId") long deptId){
        LOG.info("in getDepartment");
        DepartmentPojo deptPojo = deptService.getDepartment(deptId);
        RestClient restClient=RestClient.create();
        List<EmployeePojo> allEmps=restClient.get().uri("http://localhost:8082/api/emps/dept/"+deptId).retrieve().body(List.class);
        deptPojo.setAllEmployees(allEmps);
        return deptPojo;
    }

    @PostMapping
    public DepartmentPojo addDepartment(@RequestBody DepartmentPojo newDept){
        LOG.info("in addDepartment");
        return deptService.addDepartment(newDept);
    }

    @PutMapping
    public DepartmentPojo updateDepartment(@RequestBody DepartmentPojo editDept){
        LOG.info("in updateDepartment");
        return deptService.updateDepartment(editDept);
    }

    @DeleteMapping("/{deptId}")
    public void removeDepartment(@PathVariable("deptId") long deptId){
        LOG.info("in deleteDepartment");
        deptService.deleteDepartment(deptId);
    }

    public DepartmentPojo fallbackMethod(){
        return  new DepartmentPojo(0,"fallback",null);
    }
}
