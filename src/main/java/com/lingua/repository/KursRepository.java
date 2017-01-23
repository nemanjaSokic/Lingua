package com.lingua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lingua.model.Kurs;

public interface KursRepository extends JpaRepository<Kurs, Integer> {

}
