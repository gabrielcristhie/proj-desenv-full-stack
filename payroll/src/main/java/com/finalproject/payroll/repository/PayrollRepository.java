package com.finalproject.payroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalproject.payroll.entities.PayrollEntity;

@Repository
public interface PayrollRepository extends JpaRepository <PayrollEntity, Long>{

}
