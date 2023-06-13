package com.example.snapdeal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.snapdeal.entity.DealEntity;

public interface DealRepository extends JpaRepository<DealEntity, Integer> {
	

}
