package com.finalproject.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalproject.sales.entities.Sales;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long>{
}
