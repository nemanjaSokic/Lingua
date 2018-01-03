package com.lingua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lingua.model.Test;

public interface TestRepository extends JpaRepository<Test, Long>{

}
