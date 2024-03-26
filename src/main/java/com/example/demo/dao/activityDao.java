package com.example.demo.dao;

import com.example.demo.model.Emp;
import com.example.demo.model.activity;
import com.example.demo.repository.EmpRepository;
import com.example.demo.repository.activityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class activityDao {
    @Autowired
    activityRepository repo1;
    public activity findActivityById(int id)
    {
        Optional<activity> opActivityId = repo1.findById(id);
        if(opActivityId.isPresent())
        {
            return opActivityId.get();
        }
        return null;
    }
}
