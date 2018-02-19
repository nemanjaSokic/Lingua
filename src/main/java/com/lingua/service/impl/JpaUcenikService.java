package com.lingua.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lingua.model.Kurs;
import com.lingua.model.Ocena;
import com.lingua.model.Ucenik;
import com.lingua.model.Uplata;
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

	@Override
	public List<Ocena> getMarks(String index) {
		Ucenik u = findOne(index);
		List<Ocena> ocene = u.getOcene();
		if(ocene == null){
			return null;
		}
		return ocene;
	}

	@Override
	public List<Uplata> getPayments(String index) {
		Ucenik u = findOne(index);
		List<Uplata> uplate = u.getUplate();
		if(uplate == null){
			return null;
		}
		return uplate;
	}

	@Override
	public List<Ucenik> findWithAssignedCourse() {
		return ucenikRepo.findByKursNotNull();
	}

	@Override
	public List<Ucenik> findByProfessor(String prof) {
		return ucenikRepo.findByKursNastavnikKorisnickoIme(prof);
	}

	

	
	
	
	
}
