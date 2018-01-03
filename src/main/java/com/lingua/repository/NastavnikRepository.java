package com.lingua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lingua.model.Jezik;
import com.lingua.model.Nastavnik;

public interface NastavnikRepository extends JpaRepository<Nastavnik, String> {

	List<Nastavnik> findByPredaje(Jezik j);

	Nastavnik findById(int id);
	Nastavnik deleteNastavnikById(int id);

}
