package com.lingua.service;

import java.util.List;

import com.lingua.model.TipKursa;

public interface TipKursaService {

	List<TipKursa> getAll();

	TipKursa save(TipKursa tip1);

}
