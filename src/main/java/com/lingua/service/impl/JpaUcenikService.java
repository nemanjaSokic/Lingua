package com.lingua.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lingua.model.Kurs;
import com.lingua.model.Ucenik;
import com.lingua.repository.UcenikRepository;
import com.lingua.service.UcenikService;

@Service
@Transactional
public class JpaUcenikService implements UcenikService{
	
	@Autowired
	UcenikRepository ucenikRepo;

	

	@Override
	public List<Ucenik> findByCourseId(int courseId) {
		return ucenikRepo.findByKursIdKursa(courseId);
	}

	@Override
	public Ucenik findByIdAndCourse(String index, int courseId) {
		return ucenikRepo.findByIndeksAndKursIdKursa(index,courseId);
	}

	@Override
	public Ucenik save(Ucenik newUcenik) {
		return ucenikRepo.saveAndFlush(newUcenik);
	}

	@Override
	public Ucenik findOne(String index) {
		
		return ucenikRepo.findByIndeks(index);
	}

	@Override
	public void delete(Ucenik i) {
		ucenikRepo.delete(i);
	}

	@Override
	public List<Ucenik> findAll() {
		return ucenikRepo.findAll();
	}

	@Override
	public List<Ucenik> findByCourse(Kurs kurs) {
		return ucenikRepo.findByKurs(kurs);
	}

	@Override
	public Ucenik findByIndeks(String index) {
		return ucenikRepo.findByIndeks(index);
	}

	
	
	
	
}
