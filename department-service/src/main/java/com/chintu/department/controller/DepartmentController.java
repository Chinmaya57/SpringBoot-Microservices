package com.chintu.department.controller;

import com.chintu.department.entity.Department;
import com.chintu.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.misc.Contended;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department){
        log.info("inside saveDepartment method of DepartmentController");
      return  departmentService.saveDepartment(department);
    }
    @GetMapping("/{id}")
    public  Department findDepartmentById(@PathVariable("id") Long departmentId){
        log.info("inside findDepartmentById method of DepartmentController");
        return departmentService.findDepartmentById(departmentId);
    }



}
