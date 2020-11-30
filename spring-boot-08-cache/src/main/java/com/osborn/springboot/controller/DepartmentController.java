package com.osborn.springboot.controller;

import com.osborn.springboot.bean.Department;
import com.osborn.springboot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hanqh
 * @version 1.0
 * @createdate 2018-11-16 6:45
 */
@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/dept/{id}")
    public Department getDeptById(@PathVariable("id") Integer Id) {
        Department dept = departmentService.getDeptById(Id);
        return dept;
    }
}
