package com.lingua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lingua.model.Uplata;

public interface UplataRepository extends JpaRepository<Uplata, Integer> {

	List<Uplata> findByKursIdKursaAndUcenikIndeks(int courseId, String index);

	Uplata findByKursIdKursaAndUcenikIndeksAndUplatnicaBr(int courseId,
			String index, int br);




}
