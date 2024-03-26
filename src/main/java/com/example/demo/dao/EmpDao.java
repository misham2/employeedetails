package com.example.demo.dao;

import com.example.demo.model.Emp;
import com.example.demo.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class EmpDao
{
    @Autowired
    EmpRepository repo;
    public Emp findEmpById(int employeeId)
    {
        Optional<Emp> opEmployee = repo.findById(employeeId);
        if(opEmployee.isPresent())
        {
            return opEmployee.get();
        }
        return null;
    }
}
