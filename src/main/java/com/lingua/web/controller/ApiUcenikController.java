package com.lingua.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lingua.model.Kurs;
import com.lingua.model.Ucenik;
import com.lingua.service.KursService;
import com.lingua.service.UcenikService;

@RestController
@RequestMapping(value = "/api/courses/{courseId}/students")
public class ApiUcenikController {
	
	@Autowired
	UcenikService ucenikServ;
	@Autowired
	KursService kursServ;
	
	//----------------------GET--------------------
	
	@RequestMapping(method=RequestMethod.GET)
	ResponseEntity<List<Ucenik>> getAll(@PathVariable int courseId){
		List<Ucenik>ucenici = ucenikServ.findByCourseId(courseId);
		if(ucenici == null || ucenici.isEmpty()){
			return new ResponseEntity<List<Ucenik>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Ucenik>>(ucenici,HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.GET,value="/{index}")
	ResponseEntity<Ucenik> getOne(@PathVariable String index,@PathVariable int courseId){
		Ucenik u = ucenikServ.findByIdAndCourse(index, courseId);
		if(u==null){
			return new ResponseEntity<Ucenik>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Ucenik>(u,HttpStatus.OK);
	}
	
	//---------------------POST-------------------
	
	@RequestMapping(method=RequestMethod.POST,consumes="application/json")
	ResponseEntity<Ucenik> add(@RequestBody Ucenik newUcenik,@PathVariable int courseId){
		Kurs k = kursServ.findOne(courseId);
		k.addUcenik(newUcenik);
		Ucenik presisted = ucenikServ.save(newUcenik);
		return new ResponseEntity<Ucenik>(presisted,HttpStatus.CREATED);
	}
	
	
	//-----------------------DELETE----------------------
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{index}")
	ResponseEntity<Ucenik>delete(@PathVariable int courseId, @PathVariable String index){
		Kurs k = kursServ.findOne(courseId);
		Ucenik u = ucenikServ.findOne(index);
		k.removeUcenik(u);
		ucenikServ.delete(index);
		kursServ.save(k);
		return new ResponseEntity<Ucenik>(HttpStatus.NO_CONTENT);
	}
	
	
	//-------------------UODATE-----------------------
	
	@RequestMapping(method=RequestMethod.PUT,consumes="application/json",value="/{index}")
	ResponseEntity<Ucenik> edit(@PathVariable int courseId,@PathVariable String index,@RequestBody Ucenik ucenik){
		if(index.equals(null) || !index.equals(ucenik)){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Ucenik oldUcenik = ucenikServ.findByIdAndCourse(index, courseId);
		if(oldUcenik==null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Ucenik presisted = ucenikServ.save(ucenik);
		
		return new ResponseEntity<>(presisted,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
}
