package com.lingua.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lingua.model.Ucenik;
import com.lingua.model.Uplata;
import com.lingua.repository.UcenikRepository;
import com.lingua.repository.UplataRepository;
import com.lingua.service.UplataService;

@Service
@Transactional
public class JpaUplataService implements UplataService{
	
	@Autowired
	UplataRepository uplataRepo;
	@Autowired
	UcenikRepository ucenikRepo;

	@Override
	public List<Uplata> findAll() {
		return uplataRepo.findAll();
	}

	@Override
	public Uplata findOne(int br) {
		return uplataRepo.findOne(br);
	}

	@Override
	public Uplata save(Uplata newUplata) {
		//Uplata oldUplata = uplataRepo.findOne(newUplata.getUplatnicaBr());
		return uplataRepo.save(newUplata);
	}

	@Override
	public List<Uplata> findByCourseAndStudent(int courseId, String index) {		
		List<Uplata> uplate = uplataRepo.findByKursIdKursaAndUcenikIndeks(courseId,index);
		return uplate;
	}

	@Override
	public Uplata findByCourseAndStudentAndPayment(int courseId, String index,int br) {
		return uplataRepo.findByKursIdKursaAndUcenikIndeksAndUplatnicaBr(courseId,index,br);
	}
	
	
	
}
