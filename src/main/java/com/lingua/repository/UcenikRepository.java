package com.lingua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lingua.model.Kurs;
import com.lingua.model.Ucenik;

public interface UcenikRepository extends JpaRepository<Ucenik, String> {

	List<Ucenik> findByKursIdKursa(int courseId);

	Ucenik findByIndeksAndKursIdKursa(String index, int courseId);

	List<Ucenik> findByKurs(Kurs kurs);

	Ucenik findByIndeks(String index);

}
