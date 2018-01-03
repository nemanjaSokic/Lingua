package com.lingua.service;

import java.util.List;

import com.lingua.model.Kurs;

public interface KursService {

	Kurs findOne(int id);

	List<Kurs> findAll();

	Kurs save(Kurs newKurs);

	Kurs delete(int id);

	List<Kurs> getAllByProfessor(int id);

}
