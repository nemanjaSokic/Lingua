package com.lingua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lingua.model.Kurs;

public interface KursRepository extends JpaRepository<Kurs, Integer> {

	List<Kurs> findByNastavnikId(int id);

}
