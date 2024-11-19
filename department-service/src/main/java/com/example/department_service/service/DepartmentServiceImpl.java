package com.example.department_service.service;

import com.example.department_service.doa.entity.Department;
import com.example.department_service.model.DepartmentPojo;
import com.example.department_service.repo.DepartmentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    DepartmentRepository deptRepo;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository deptRepo){
        this.deptRepo=deptRepo;
    }


    @Override
    public List<DepartmentPojo> getAllDepartments() {
        List<Department> allDeptEntity=deptRepo.findAll();
        List<DepartmentPojo> allDeptPojo=new ArrayList<>();
        allDeptEntity.stream().forEach((eachDeptEntity)->{
            DepartmentPojo deptPojo=new DepartmentPojo();
            BeanUtils.copyProperties(eachDeptEntity,deptPojo);
            allDeptPojo.add(deptPojo);
        });
        return allDeptPojo;
    }

    @Override
    public DepartmentPojo getDepartment(long deptId) {
        Optional<Department> fetchDeptEntity=deptRepo.findById(deptId);
        DepartmentPojo deptPojo=null;
        if(fetchDeptEntity.isPresent()){
            deptPojo=new DepartmentPojo();
            BeanUtils.copyProperties(fetchDeptEntity.get(),deptPojo);
        }
        return deptPojo;
    }

    @Override
    public DepartmentPojo addDepartment(DepartmentPojo newDepPojo) {
        Department deptEntity=new Department();
        BeanUtils.copyProperties(newDepPojo,deptEntity);
        deptRepo.saveAndFlush(deptEntity);
        return newDepPojo;
    }

    @Override
    public DepartmentPojo updateDepartment(DepartmentPojo editDepPojo) {
        Department deptEntity=new Department();
        BeanUtils.copyProperties(editDepPojo,deptEntity);
        deptRepo.saveAndFlush(deptEntity);
        return editDepPojo;
    }

    @Override
    public void deleteDepartment(long deptId) {
        deptRepo.deleteById(deptId);
    }

}
