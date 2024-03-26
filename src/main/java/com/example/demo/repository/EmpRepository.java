package com.example.demo.repository;

import com.example.demo.model.Emp;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmpRepository extends JpaRepository<Emp, Integer>
{

}