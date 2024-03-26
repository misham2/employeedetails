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

import java.util.List;


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
    public ResponseEntity<Emp> saveEmp(@RequestBody Emp emp) {
        repo.save(emp);

        return ResponseEntity.status(HttpStatus.CREATED).body(emp);
    }

    @PostMapping("/employee_activity")
    public ResponseEntity<employee_activity> saveEmployee_activity(@RequestBody employee_activity emp_activity,
                                                                   @RequestParam String type) {
        if (type.equals("login")) {
            repo1.save(emp_activity);
            return ResponseEntity.status(HttpStatus.CREATED).body(emp_activity);

        } else if (type.equalsIgnoreCase("logout")) {
            repo1.save(emp_activity);
            return ResponseEntity.status(HttpStatus.CREATED).body(emp_activity);
        } else if (type.equalsIgnoreCase("permission")) {
            repo1.save(emp_activity);
            return ResponseEntity.status(HttpStatus.CREATED).body(emp_activity);
        } else if (type.equalsIgnoreCase("Leave")) {
            repo1.save(emp_activity);
            return ResponseEntity.status(HttpStatus.CREATED).body(emp_activity);
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(emp_activity);
        }


    }

    @PostMapping("/activity")
    public ResponseEntity<activity> saveactivity(@RequestBody activity Activity) {
        repo3.save(Activity);
        return ResponseEntity.status(HttpStatus.CREATED).body(Activity);
    }

    @PostMapping("/assignEmp")
    public ResponseEntity<employee_activity> assignEmpToEmpActivity(@RequestParam int employeeActivityId, @RequestParam int employeeId) {
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
    public ResponseEntity<employee_activity> assignActivityTOEmpActivity(@RequestParam int employeeActivityId, @RequestParam int activityId) {
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

    @GetMapping("/EmployeeActivity")
    public ResponseEntity<employee_activity> getEmployeeActivity(@RequestParam int employeeActivityId) {
        employee_activity employeeActivity = edao.findEmpActivityById(employeeActivityId);
        if (employeeActivity != null) {
            return ResponseEntity.status(HttpStatus.FOUND).body(employeeActivity);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(employeeActivity);
    }

    @GetMapping("/AllEmployeeDetails")
    public ResponseEntity<employee_activity> getAllEmp(@RequestParam String name) {
        List<Emp> employees = dao.getAllEmp();
        List<employee_activity> employeeActivities = repo1.findAll();
        for (Emp employee : employees) {
            if (employee.getName().equals(name)) {
                for (employee_activity employeeActivity : employeeActivities) {
                    if (employeeActivity.getEmployee().getName().equals(employee.getName())) {
                        return ResponseEntity.status(HttpStatus.FOUND).body(employeeActivity);
                    }
                }

            }
        }
        return null;
    }

    @GetMapping("/AllwithActivities")
    public ResponseEntity<List<Emp>> getAllEmp() {
        List<Emp> employees = dao.getAllEmp();
        return ResponseEntity.ok(employees);
    }
}