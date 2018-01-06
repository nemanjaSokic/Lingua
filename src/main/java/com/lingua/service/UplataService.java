package com.lingua.service;

import java.util.List;

import com.lingua.model.Uplata;

public interface UplataService {

	List<Uplata> findAll();

	Uplata findOne(int br);

	Uplata save(Uplata newUplata);

}
