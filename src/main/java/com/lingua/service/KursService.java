package com.lingua.service;

import java.util.List;

import com.lingua.model.Kurs;
import com.lingua.model.Test;
import com.lingua.model.Ucenik;

public interface KursService {

	Kurs findOne(int id);

	List<Kurs> findAll();

	Kurs save(Kurs newKurs);

	Kurs delete(int id);

	List<Kurs> getAllByProfessor(int id);

	List<Ucenik> getStudentsByCourse(int id);

	List<Test> getTestsByCourse(int id);

}
