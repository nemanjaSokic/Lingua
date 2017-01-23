package com.lingua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lingua.model.Jezik;

@Repository
public interface JezikRepository extends JpaRepository<Jezik,String>{

	
}
