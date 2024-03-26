package com.example.demo.controller;

import com.example.demo.dao.EmpDao;
import com.example.demo.dao.activityDao;
import com.example.demo.dao.employee_activityDao;
import com.example.demo.model.Emp;
import com.example.demo.model.activity;
import com.example.demo.model.employee_activity;
import com.example.demo.repository.EmpRepository;
import com.example.demo.repository.activityRepository;
import com.example.demo.repository.employee_activityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RequestMapping("/Emp")
@RestController
public class EmpController {
    @Autowired
    EmpRepository repo;
    @Autowired
    employee_activityRepository repo1;

    @Autowired
    activityRepository repo3;
    @Autowired
    EmpDao dao;

    @Autowired
    employee_activityDao edao;

    @Autowired
    activityDao adao;


    @PostMapping("/Employee")
    public ResponseEntity<Emp> saveEmp(@RequestBody Emp emp)
    {
        repo.save(emp);

        return ResponseEntity.status(HttpStatus.CREATED).body(emp);
    }

    @PostMapping("/employee_activity")
    public ResponseEntity<employee_activity> saveEmployee_activity(@RequestBody employee_activity emp_activity)
    {
            repo1.save(emp_activity);

            return ResponseEntity.status(HttpStatus.CREATED).body(emp_activity);
    }
    @PostMapping("/activity")
    public ResponseEntity<activity> saveactivity(@RequestBody activity Activity)
    {
        repo3.save(Activity);

        return ResponseEntity.status(HttpStatus.CREATED).body(Activity);
    }

    @PostMapping("/assignEmp")
    public ResponseEntity<employee_activity> assignEmpToEmpActivity(@RequestParam int employeeActivityId,@RequestParam int employeeId) {
        Emp employee = dao.findEmpById(employeeId);
        employee_activity employeeActivity = edao.findEmpActivityById(employeeActivityId);
        if (employee != null) {
            if (employeeActivity != null) {
                employeeActivity.setEmployee(employee);
                repo1.save(employeeActivity);
                return ResponseEntity.status(HttpStatus.CREATED).body(employeeActivity);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(employeeActivity);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(employeeActivity);
    }

    @PostMapping("/assignActivity")
    public ResponseEntity<employee_activity> assignActivityTOEmpActivity(@RequestParam int employeeActivityId,@RequestParam int activityId) {
        activity activity = adao.findActivityById(activityId);
        employee_activity employeeActivity = edao.findEmpActivityById(employeeActivityId);
        if (activity != null) {
            if (employeeActivity != null) {
                employeeActivity.setActivity(activity);
                repo1.save(employeeActivity);
                return ResponseEntity.status(HttpStatus.CREATED).body(employeeActivity);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(employeeActivity);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(employeeActivity);
    }

    @GetMapping
    public ResponseEntity<employee_activity> getEmployeeActivity(@RequestParam int employeeActivityId)
    {
        employee_activity employeeActivity = edao.findEmpActivityById(employeeActivityId);
        if(employeeActivity != null)
        {
            return ResponseEntity.status(HttpStatus.FOUND).body(employeeActivity);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(employeeActivity);
    }





}
