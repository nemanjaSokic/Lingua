package com.lingua.service;

import java.util.List;

import com.lingua.model.Kurs;
import com.lingua.model.Ucenik;

public interface UcenikService {

	List<Ucenik> findAll();
	
	List<Ucenik> findByCourse(Kurs kurs);

	Ucenik findOne(String index);

	List<Ucenik> findByCourseId(int courseId);

	Ucenik findByIdAndCourse(String index,int courseId);

	Ucenik save(Ucenik newUcenik);

	void delete(Ucenik u);

}
