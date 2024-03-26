package com.example.demo.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Entity
@Table(name ="emp_activity")
public class employee_activity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeActivityId;
    private LocalDateTime datetime;

    @ManyToOne(cascade = CascadeType.ALL)
    private  Emp employee;

    @ManyToOne(cascade = CascadeType.ALL)
    private activity activity;




    public Emp getEmployee() {
        return employee;
    }

    public void setEmployee(Emp employee) {
        this.employee = employee;
    }


    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public int getEmployeeActivityId() {
        return employeeActivityId;
    }

    public void setEmployeeActivityId(int employeeActivityId) {
        this.employeeActivityId = employeeActivityId;
    }

    public com.example.demo.model.activity getActivity() {
        return activity;
    }

    public void setActivity(com.example.demo.model.activity activity) {
        this.activity = activity;
    }
}
