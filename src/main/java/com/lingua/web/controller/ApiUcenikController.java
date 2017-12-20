package com.lingua.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lingua.model.Korisnik;
import com.lingua.model.Kurs;
import com.lingua.model.Ucenik;
import com.lingua.service.KorisnikService;
import com.lingua.service.KursService;
import com.lingua.service.UcenikService;

@RestController
@RequestMapping(value = "/api/students")
public class ApiUcenikController {
	
	@Autowired
	UcenikService ucenikServ;
	@Autowired
	KursService kursServ;
	@Autowired
	KorisnikService korisnikServ;
	
	//----------------------GET--------------------
	
	@RequestMapping(method=RequestMethod.GET)
	ResponseEntity<List<Ucenik>> getAllActive(){
		List<Ucenik> ucenici = ucenikServ.findAll();
		if(ucenici == null || ucenici.isEmpty()){
			return new ResponseEntity<List<Ucenik>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Ucenik>>(ucenici,HttpStatus.OK);
	}
	
	
	/*@RequestMapping(method=RequestMethod.GET)
	ResponseEntity<List<Ucenik>> getAll(@PathVariable int courseId){
		List<Ucenik>ucenici = ucenikServ.findByCourseId(courseId);
		if(ucenici == null || ucenici.isEmpty()){
			return new ResponseEntity<List<Ucenik>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Ucenik>>(ucenici,HttpStatus.OK);
	}*/

	@RequestMapping(method=RequestMethod.GET,value="/{index}")
	ResponseEntity<Ucenik> getOne(@PathVariable String index){
		Ucenik u = ucenikServ.findOne(index);
		if(u==null){
			return new ResponseEntity<Ucenik>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Ucenik>(u,HttpStatus.OK);
	}
	
	//---------------------POST-------------------
	
	@RequestMapping(method=RequestMethod.POST,consumes="application/json")
	ResponseEntity<Ucenik> add(@RequestBody Ucenik newUcenik){
		Kurs k = newUcenik.getKurs();
		k.addUcenik(newUcenik);
		Ucenik presisted = ucenikServ.save(newUcenik);
		if(presisted == null){
			return new ResponseEntity<Ucenik>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Ucenik>(presisted,HttpStatus.CREATED);
	}
	
	
	//-----------------------DELETE----------------------
	
	@Transactional
	@RequestMapping(method=RequestMethod.DELETE, value="/{index}")
	ResponseEntity<Ucenik>delete(@PathVariable String index){
		Ucenik u = ucenikServ.findOne(index);
		if(u == null){
			return new ResponseEntity<Ucenik>(HttpStatus.NOT_FOUND);
		}
		if(u.getKurs() != null){
			Kurs k = kursServ.findOne(u.getKurs().getId());
			k.removeUcenik(u);
			kursServ.save(k);
		}
		Korisnik kor = (Korisnik)u;
		korisnikServ.delete(kor);
		
		return new ResponseEntity<Ucenik>(HttpStatus.NO_CONTENT);
	}
	
	
	//-------------------UPDATE-----------------------
	
	@RequestMapping(method=RequestMethod.PUT,consumes="application/json",value="/{index}")
	ResponseEntity<Ucenik> edit(@PathVariable String index,@RequestBody Ucenik ucenik){
		Ucenik u = ucenikServ.findOne(index);
		if(index.equals(null) || !index.equals(u.getIndeks())){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		u.setIme(ucenik.getIme());
		u.setPrezime(ucenik.getPrezime());
		u.setStatus(ucenik.getStatus());
		u.setRegistrovan(ucenik.getRegistrovan());
		if(u.getKurs() == null && ucenik.getKurs() != null){
			Kurs k = kursServ.findOne(ucenik.getKurs().getId());
			k.addUcenik(u);
			kursServ.save(u.getKurs());
		}
		Ucenik presisted = ucenikServ.save(u);
		return new ResponseEntity<>(presisted,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
}
