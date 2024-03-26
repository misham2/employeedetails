package com.example.demo.dao;

import com.example.demo.model.employee_activity;
import com.example.demo.repository.employee_activityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class employee_activityDao
{
    @Autowired
    employee_activityRepository repo1;
    public employee_activity findEmpActivityById(int activityId)
    {
        Optional<employee_activity> opEmpActivity = repo1.findById(activityId);
        if(opEmpActivity.isPresent())
        {
            return opEmpActivity.get();
        }
        return null;
    }
}
